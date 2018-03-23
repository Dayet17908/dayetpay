package com.sevenpay.bms.paymentmanager.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.gyzb.platform.web.admin.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.seven.micropay.base.domain.ChannelResp;
import com.seven.micropay.base.domain.ChannelResult;
import com.seven.micropay.base.enums.ReStatus;
import com.seven.micropay.channel.domain.api.b2e.B2eQueryReq;
import com.seven.micropay.channel.domain.api.b2e.BatchTransferApiReq;
import com.seven.micropay.channel.domain.api.b2e.TransferApiReq;
import com.seven.micropay.channel.enums.ChannelCode;
import com.seven.micropay.channel.enums.PaychannelType;
import com.seven.micropay.channel.service.api.IB2eApiService;
import com.sevenpay.bms.common.util.PropertiesUtil;
import com.sevenpay.bms.paymentmanager.PaymentManagerController;
import com.sevenpay.bms.paymentmanager.bean.TdPaymentBatDetail;
import com.sevenpay.bms.paymentmanager.bean.TdPaymentBatInfo;
import com.sevenpay.bms.paymentmanager.dao.PaymentManagerDao;
import com.sevenpay.bms.paymentmanager.mapper.PaymentManagerMapper;

@Service
public class PaymentService {
	private static Logger logger = LoggerFactory.getLogger(PaymentManagerController.class);

	@Autowired
	private PaymentManagerDao dao;

	@Autowired
	private PaymentManagerMapper mapper;

	@Autowired
	private IB2eApiService iB2eService;

	/** 文件上传 **/
	public Map<String, Object> tinyMerchantFileUpload(HttpServletRequest request, String batchNo) {
		logger.info("*********微商户文件上传开始*********");
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 创建一个DiskFileItemFactory工厂
			ServletFileUpload upload = new ServletFileUpload(factory); // 创建一个文件上传解析器
			upload.setHeaderEncoding("UTF-8"); // 解决上传文件名的中文乱码
			List<FileItem> list = upload.parseRequest(request);
			InputStream inputStream = null;
			Properties properties = PropertiesUtil.getProperties();
			boolean isExcel2003 = true;
			for (FileItem item : list) {
				String filename = null; //
				if (!item.isFormField()) { // 是否是表单项
					filename = item.getName();
					// String filedName = item.getFieldName();
					if (StringUtils.isEmpty(filename)) {
						continue;
					}
					/** 验证后缀名 **/
					String type = filename.substring(filename.lastIndexOf("."));
					String[] photoTypes = { ".xls", ".xlsx" };
					boolean isType = false;
					/*for (int i = 0; i < photoTypes.length; i++) {
						if (photoTypes[i].equalsIgnoreCase(type)) {
							isType = true;
							break;
						}
					}*/
					
					if (photoTypes[0].equalsIgnoreCase(type)) {
						isType = true;
					} else if (photoTypes[1].equalsIgnoreCase(type)) {
						isType = true;
						isExcel2003 = false;
					}
					if (!isType) {
						result.put("result", "FAIL");
						result.put("message", "文件类型不匹配");
						return result;
					}
					inputStream = item.getInputStream();
					String fileUploadPath = properties.getProperty("EXCEL_FILE_SAVE_PATH"); // 服务器上传路径
					/** 根据文件名生成路径规则 **/

					filename = batchNo + type;
					fileUploadPath = fileUploadPath + File.separator + new SimpleDateFormat("yyyy-MM-dd").format(new Date());

					File saveFile = new File(fileUploadPath);
					if (!saveFile.exists()) {
						saveFile.mkdirs();
					}
					// renameFile( filename,filename+".bak"); // 如果已经存在重命名
					FileOutputStream fileOutputStream = new FileOutputStream(
							fileUploadPath + File.separator + filename);
					byte buffer[] = new byte[1024];
					int len = 0;
					while ((len = inputStream.read(buffer)) > 0) {
						fileOutputStream.write(buffer, 0, len);
					}
					/** 刷新此输出流并强制写出所有缓冲的输出字节 **/
					fileOutputStream.flush();
					inputStream.close();
					fileOutputStream.close();
					item.delete();
					result.put("filePath", fileUploadPath + File.separator + filename);
				}
			}
			result.put("isExcel2003", isExcel2003);
			result.put("result", "SUCCESS");
			result.put("message", "上传成功");

			logger.info("文件上传成功");
		} catch (Exception e) {
			logger.error("上传失败", e.getMessage());
			result.put("result", "FAIL");
			result.put("message", e.getMessage());
		}
		return result;
	}

	public Map<String, Object> fileUpload(@RequestParam(value = "filename") MultipartFile mFile,
			HttpServletRequest request, String batchNo) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		CommonsMultipartFile cf = (CommonsMultipartFile) mFile;

		// 获取文件名
		String filename = mFile.getOriginalFilename();
		/** 验证后缀名 **/
		String type = filename.substring(filename.lastIndexOf("."));
		String[] photoTypes = { ".xls", ".xlsx" };
		boolean isType = false;
		boolean isExcel2003 = true;
		if (photoTypes[0].equalsIgnoreCase(type)) {
			isType = true;
		} else if (photoTypes[1].equalsIgnoreCase(type)) {
			isType = true;
			isExcel2003 = false;
		}
		
		if (!isType) {
			result.put("result", "FAIL");
			result.put("message", "文件类型不匹配");
			return result;
		}
		// 绝对路径
		Properties properties = PropertiesUtil.getProperties();
		try {
			String fileUploadPath = properties.getProperty("EXCEL_FILE_SAVE_PATH"); // 服务器上传路径
			File file = new File(fileUploadPath);

			if (!file.exists()) {
				file.mkdirs();
			}
			filename = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "_" + batchNo + type;
			File file1 = new File(fileUploadPath + File.separator + filename);
			cf.getFileItem().write(file1);

			result.put("filePath", fileUploadPath + File.separator + filename);
			result.put("result", "SUCCESS");
			result.put("isExcel2003", isExcel2003);
			result.put("message", "上传成功");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("上传失败", e.getMessage());
			result.put("result", "FAIL");
			result.put("message", e.getMessage());
		}
		return result;
	}

	/**
	 * 根据excel里面的内容读取客户信息
	 * 
	 * @param is
	 *            输入流
	 * @param isExcel2003
	 *            excel是2003还是2007版本
	 * @return
	 * @throws IOException
	 */
	public List<TdPaymentBatDetail> ReadExcel(String filPath, String batchNo, boolean type) throws IOException {
		int totalRows = 0;
		int totalCells = 0;
		List<TdPaymentBatDetail> paymentCustomerList = null;
		InputStream is = null;
		try {
			is = new FileInputStream(filPath);
			Workbook wb = null;
			// 当excel是2003时
			if (type) {
				wb = new HSSFWorkbook(is);
			} else {// 当excel是2007时
				wb = new XSSFWorkbook(is);
			}
			// 得到第一个shell
			Sheet sheet = wb.getSheetAt(0);

			// 得到Excel的行数
			totalRows = sheet.getPhysicalNumberOfRows();
			logger.info(">>>>>>>Excel的行数:{}",totalRows);
			// 得到Excel的列数(前提是有行数)
			if (totalRows >= 1 && sheet.getRow(0) != null) {
				totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
			}
			paymentCustomerList = new ArrayList<TdPaymentBatDetail>();
			TdPaymentBatDetail tdPaymentBatDetail = null;
			// 循环Excel行数,从第二行开始。标题不入库
			for (int r = 1; r < totalRows; r++) {
				Row row = sheet.getRow(r);
				if (row == null||null==row.getCell(0)||row.getCell(0).getCellType()==Cell.CELL_TYPE_BLANK)
					continue;
				tdPaymentBatDetail = new TdPaymentBatDetail();

				// 循环Excel的列
				for (int c = 0; c < totalCells; c++) {
					Cell cell = row.getCell(c);
					if (null != cell && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						
						if (c == 0) {
							tdPaymentBatDetail.setRecAccountName(cell.getStringCellValue().trim());// 客户名称
						} else if (c == 1){
							tdPaymentBatDetail.setPayeeAcctBankName(cell.getStringCellValue().trim());
							tdPaymentBatDetail.setRecBankCode(cell.getStringCellValue().trim());
						} else if (c == 2) {
							tdPaymentBatDetail.setRecAccountNo(cell.getStringCellValue().trim());// 客户卡号
						} else if (c == 3) {
							if(null!=cell.getStringCellValue()&&!"".equals(cell.getStringCellValue())){
							tdPaymentBatDetail.setTransAmt(new BigDecimal(cell.getStringCellValue()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());// 金额
							}
							
						}
					}
				}
				logger.info("外部循环Excel行["+r+"]");
				/**
				 * 批次号，序列号
				 */
				tdPaymentBatDetail.setBatNo(batchNo);
				tdPaymentBatDetail.setRowNo(batchNo + String.format("%05d", r));
				tdPaymentBatDetail.setStatus("01");
				tdPaymentBatDetail.setCreateId(String.valueOf(WebUtils.getUserInfo().getUserId()));
				paymentCustomerList.add(tdPaymentBatDetail);

				// 数据入库

			}
		} catch (Exception e) {
			logger.error("解析Excel异常：" + e.getMessage(), e);

		} finally {
			is.close();
		}
		return paymentCustomerList;
	}

	/**
	 * 添加银行号 入库
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unused")
	@Transactional
	public List<TdPaymentBatDetail> addPaymentList(List<TdPaymentBatDetail> list) {
		List<TdPaymentBatDetail> result = null;
		int transAmt = 0;
	//	List<TdBankCardBin> binList = dao.selectCardBinList();
		BigDecimal transAmtCount = BigDecimal.ZERO;
		for (int i = 0; i < list.size(); i++) {
			/*for (int j = 0; j < binList.size(); j++) {
				String no = null;
				try{
					no = list.get(i).getRecAccountNo().substring(0, binList.get(j).getCardBin().length());
				}catch(Exception e){
					logger.error(">>>>>卡号错误，继续执行");
				}
				if(binList.get(j).getCardBin().equals(no)){
					list.get(i).setRecBankCode(binList.get(j).getBankCode());
					list.get(i).setPayeeAcctBankName(binList.get(j).getBankName());
					logger.info(">>>>>银行号"+JSONObject.toJSONString(list.get(i).getRecBankCode()));
					break;
				}
			}*/
			// transAmt +=Integer.valueOf(list.get(i).getTransAmt());
			transAmtCount = transAmtCount.add(new BigDecimal(list.get(i).getTransAmt()));
		}
		logger.info(">>>>>>>>>>>>>>>>>>总金额："+transAmtCount.toString());
		list.get(0).setTransAmtCount(transAmtCount);
		return list;
	}

	@Transactional
	public Map<String, String> paymentManage(List<TdPaymentBatDetail> list, String paerAcctNo) {
		Map<String, String> result = new HashMap<String, String>();

		BatchTransferApiReq req = new BatchTransferApiReq();
		req.setPaychannelType(PaychannelType.CR);
		req.setBatchNo(list.get(0).getBatNo());
		req.setCount(list.size());

		List<TransferApiReq> reqs = new ArrayList<TransferApiReq>();
		BigDecimal transAmt = BigDecimal.ZERO;
		for (int i = 0; i < list.size(); i++) {
			TransferApiReq req1 = new TransferApiReq();
			req1.setPaychannelType(PaychannelType.CR);
			req1.setOrderId(list.get(i).getRowNo());
			req1.setPayeeAcct(list.get(i).getRecAccountNo());
			req1.setPayeeName(list.get(i).getRecAccountName());
			req1.setPayeeAcctBankName(list.get(i).getPayeeAcctBankName());
			req1.setChannelCode(ChannelCode.CCB);
			//req1.setPayeeAcctBank(list.get(i).getRecBankCode());
			req1.setAmount(new BigDecimal(list.get(i).getTransAmt()));
			req1.setRemark("结算款");
			transAmt = transAmt.add(new BigDecimal(list.get(i).getTransAmt()));
			
			list.get(i).setStatus("02");
			list.get(i).setModifyId(String.valueOf(WebUtils.getUserInfo().getUserId()));
			reqs.add(req1);
		}
		req.setTotalAmount(transAmt);
		req.setReqs(reqs);
		try{
			ChannelResult succ = iB2eService.batchTransfer(req);
			logger.info(">>>>>>>>>>>>>批量交易返回响应状态：["+succ.getReCode()+"]"+succ.getReMsg());
				dao.insertPaymentList(list);
				TdPaymentBatInfo bean = new TdPaymentBatInfo();
				bean.setBatNo(list.get(0).getBatNo());

				bean.setCreateId(String.valueOf(WebUtils.getUserInfo().getUserId()));
				bean.setBatStatus("02");
				bean.setSumAmt(String.valueOf(transAmt));
				bean.setSumCount(String.valueOf(list.size()));
				bean.setPaerAcctNo(paerAcctNo);
				bean.setModifyId(String.valueOf(WebUtils.getUserInfo().getUserId()));

				mapper.insertBatInfo(bean);
				if (ReStatus.PROCESSING == succ.getStatus() && "00".equals(succ.getReCode())) {
				result.put("result", "SUCCESS");
				result.put("message", "提交银行处理成功");
			} else {
				result.put("result", "FAIL");
				result.put("message", "提交银行处理失败,请稍候进行查询");
			}
		} catch (Exception e) {
			dao.insertPaymentList(list);
			TdPaymentBatInfo bean = new TdPaymentBatInfo();
			bean.setBatNo(list.get(0).getBatNo());

			bean.setCreateId(String.valueOf(WebUtils.getUserInfo().getUserId()));
			bean.setBatStatus("02");
			bean.setSumAmt(String.valueOf(transAmt));
			bean.setSumCount(String.valueOf(list.size()));
			bean.setPaerAcctNo(paerAcctNo);
			bean.setModifyId(String.valueOf(WebUtils.getUserInfo().getUserId()));

			mapper.insertBatInfo(bean);
			result.put("result", "FAIL");
			result.put("message", "提交银行处理异常,请稍候进行查询");
			logger.error(">>>>>>>>>请求异常--入库失败：" + e.getMessage(), e);
		//	throw new RuntimeException(e);
		}
			
		return result;
	}

	@Transactional
	public String updateDetail(TdPaymentBatDetail bean) {
		String result = "FAIL";
		int tatol = dao.upPaymentBatDetail(bean);
		if (tatol > 0) {
			result = "SUCCESS";
		}
		return result;
	}

	/**
	 * 查询批次商户信息
	 * 
	 * @param batNo
	 * @return
	 */
	public List<TdPaymentBatDetail> selecPaymentList(String batNo) {
		return dao.selecPaymentList(batNo);
	}

	/**
	 * 查询批次商户信息
	 * 
	 * @param batNo
	 * @return
	 */
	@Transactional
	public Map<String, String> selectPaymentTrans(TdPaymentBatDetail bean) {
		Map<String, String> result = new HashMap<String, String>();
		B2eQueryReq req = new B2eQueryReq();
		ChannelResult resMsg = null;
		List<TdPaymentBatDetail> detail = null;
	//	List<TransferApiReq> apiRes = null;
		try {
			if (StringUtils.isNotBlank(bean.getRowNo())) {
				req.setOrderId(bean.getRowNo());
				resMsg = iB2eService.query(req);
				String reStatus =resMsg.getStatus().name();
				if("SUCCESS".equals(reStatus)){
					bean.setStatus("00");
				} else if("PROCESSING".equals(reStatus)){
					bean.setStatus("03");
				} else{
					bean.setStatus("04");
				}
				bean.setModifyId(String.valueOf(WebUtils.getUserInfo().getUserId()));
				dao.upPaymentBatDetail(bean);
			} else {
				req.setBatchNo(bean.getBatNo());
				resMsg = iB2eService.query(req);
				detail = dao.selecPaymentList(bean.getBatNo());
				TdPaymentBatInfo batInfo = new TdPaymentBatInfo();
				batInfo.setBatNo(bean.getBatNo());
				batInfo.setModifyId(String.valueOf(WebUtils.getUserInfo().getUserId()));
				batInfo.setSuccAmt((String)resMsg.getData().get("succAmt"));
				batInfo.setSuccCount((String)resMsg.getData().get("succCount"));
				// 成功、部分成功、失败
				int succCount = Integer.valueOf((String)resMsg.getData().get("succCount"));
				int failCount = Integer.valueOf((String)resMsg.getData().get("failCount"));
			//	batInfo.setBatStatus(succCount == detail.size() ? "00" : succCount == 0 ? "04" : "03");
				batInfo.setBatStatus(succCount == detail.size() ? "00" : succCount == 0 ? "04" : succCount + failCount == detail.size() ? "00" : "03");
				batInfo.setFailAmt((String)resMsg.getData().get("failAmt"));
				batInfo.setFailCount((String)resMsg.getData().get("failCount"));
				batInfo.setPaerAcctNo((String)resMsg.getData().get("paerAcctNo"));
				List<ChannelResp> respList = (List<ChannelResp>)resMsg.getData().get("respList");
				for (int i = 0; i < detail.size(); i++) {
					for (int j = 0; j < respList.size(); j++) {
						ChannelResp resp = respList.get(i);
						if(detail.get(i).getRowNo().equals(resp.getOrderId())){
							
							detail.get(i).setStatus(resp.getCode());
							detail.get(i).setProcMemo(resp.getFailMsg());
							detail.get(i).setModifyId(String.valueOf(WebUtils.getUserInfo().getUserId()));
							break;
						}
					}
				}
				mapper.updateDetailBatch(detail);
				logger.info(">>>>>>>>>查询交易>>>>>>>>>>>>>>>>>>");
				mapper.upPaymentBatInfo(batInfo);
			}
			logger.info(">>>>>>>>>查询交易响应状态:["+resMsg.getStatus().name()+"],响应信息"+resMsg.getReMsg());
			} catch (Exception e) {
				/*result.put("result", "SUCCESS");
				result.put("message", "查询成功");*/
				throw new RuntimeException(e);
			}
			
			if(!"00".equals(resMsg.getReCode())){
				result.put("result", "FAIL");
				result.put("message", "查询失败");
			} else{
				result.put("result", "SUCCESS");
				result.put("message", "查询成功");
			}
		return result;
	}
	
	public List<TdPaymentBatDetail> getBatchFailPaymentList(String batNo){
		List<TdPaymentBatDetail> list = dao.getBatchFailPaymentList(batNo);
		return list;
	}
}
