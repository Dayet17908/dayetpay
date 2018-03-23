package com.sevenpay.bms.merchant.reported.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.gyzb.platform.web.page.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.seven.micropay.base.domain.ChannelResult;
import com.seven.micropay.channel.domain.TdCustInfo;
import com.seven.micropay.channel.domain.merchant.CrMerCategoryList;
import com.seven.micropay.channel.domain.merchant.CrMerChantDataReq;
import com.seven.micropay.channel.domain.merchant.KftCertInfo;
import com.seven.micropay.channel.domain.merchant.KftMerChantDataReq;
import com.seven.micropay.channel.domain.merchant.KftProductFeeInfo;
import com.seven.micropay.channel.domain.merchant.KftSettleBankInfo;
import com.seven.micropay.channel.domain.merchant.KftUploadFileBean;
import com.seven.micropay.channel.domain.merchant.MerRegistParamReq;
import com.seven.micropay.channel.domain.merchant.TdMerFilePatch;
import com.seven.micropay.channel.domain.merchant.TdMerFilePatchList;
import com.seven.micropay.channel.enums.ChannelMerRegist;
import com.seven.micropay.channel.service.IMerChantIntoService;
import com.sevenpay.bms.basemanager.Constant;
import com.sevenpay.bms.basemanager.merchant.bean.CategoryCodeInfo;
import com.sevenpay.bms.basemanager.utils.GenSN;
import com.sevenpay.bms.merchant.reported.bean.CategoryCodeKftInfo;
import com.sevenpay.bms.merchant.reported.bean.ChannlInfo;
import com.sevenpay.bms.merchant.reported.bean.CrInComeBean;
import com.sevenpay.bms.merchant.reported.bean.MerchantFilingInfo;
import com.sevenpay.bms.merchant.reported.bean.MerchantProdInfo;
import com.sevenpay.bms.merchant.reported.dao.CrIncomeMapperDao;
import com.sevenpay.bms.merchant.reported.mapper.CrIncomeMapper;

@Service
public class CrIncomeService {
	private Logger logger = LoggerFactory.getLogger(CrIncomeService.class);
	
	@Autowired 
	private  IMerChantIntoService iMerChantIntoService;
	
	@Autowired
	private CrIncomeMapperDao crIncomeMapperDao;
	
    @Autowired
	private CrIncomeMapper crIncomeMapper;

	
	
	public static final String EXECUTE_SUCCESS = "SUCCESS";
	public static final String EXECUTE_FAILURE = "FAILURE";
	public static final String EXECUTE_FLAG = "EXECUTEFLAG";
	public static final String EXECUTE_DESC = "EXECUTEDESC";
	
	/**
	 * 调用进件接口 和 资料上传接口
	 */
	@Transactional
	public void excuteCr(Map<String,Object> inMap,Map<String,Object> fileMap,List<CrInComeBean> beans){
		
		try {
			//调用商户进件接口
			iMerChantIntoService.merchatAdd(inMap);
			
			//调用商户资料上传接口
			iMerChantIntoService.fileUpload(fileMap);
			
			//修改商户报备状态
			crIncomeMapperDao.updateInComeInfo(beans);
		} catch (Exception e) {
			logger.error("执行进件接口、资料上传接口异常"+e);
			throw e;
		}
		
	}
	
	@Page
	public List<MerchantFilingInfo> selectReportList(MerchantFilingInfo selectBean) {
		List<MerchantFilingInfo> reportList = crIncomeMapper.getInComeInfoList(selectBean);
		return reportList;
	}
	
	/**
	 * 校验商户是线上线下
	 * @return 
	 */
	public String validOnOrOff(String merchantCode){
		MerchantProdInfo info  = this.getMerchantProdInfo(merchantCode);
		int n = 0;
		if(info != null){
			if(!StringUtils.isEmpty(info.getH5())|| !StringUtils.isEmpty(info.getPc())||!StringUtils.isEmpty(info.getOnecode())){
				n= n+1;
			}
			if(!StringUtils.isEmpty(info.getH5t())||!StringUtils.isEmpty(info.getMobile())){
				n= n+2;
			}
			if(n == 0){
				return null;
			}
			if(n == 1){
				return "1";
			}
			if(n == 2){
				return "0";
			}
			if(n == 3){
				return "2";
			}
		 }
		return null;
	 }
	
		
	@SuppressWarnings("unchecked")
	public String doReported(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			String merchantCode = request.getParameter("merchantCode");
			
			//查询需要报备的商户
			List<CrInComeBean> inComeInfos = crIncomeMapperDao.getInComeInfo(merchantCode);
			
			List<CrMerChantDataReq> uplistReq = new ArrayList<CrMerChantDataReq>();//线上
			List<CrMerChantDataReq> downlistReq = new ArrayList<CrMerChantDataReq>();//线下
			List<CrMerCategoryList> listReq =new ArrayList<CrMerCategoryList>();//返回的数据
			CrMerCategoryList upcrMerCategoryList = new CrMerCategoryList();//线上实体类
			CrMerCategoryList downcrMerCategoryList = new CrMerCategoryList();//线下实体类
			
			List<TdMerFilePatch> uplistFile = new ArrayList<TdMerFilePatch>();
			List<TdMerFilePatch> downlistFile = new ArrayList<TdMerFilePatch>();
			List<TdMerFilePatchList> listFile = new ArrayList<TdMerFilePatchList>();
			TdMerFilePatchList uptdMerFilePatchList = new TdMerFilePatchList();
			TdMerFilePatchList downtdMerFilePatchList = new TdMerFilePatchList();
			
			List<CrInComeBean> addComeBean = new ArrayList<CrInComeBean>();
			String patchNo = GenSN.getSysTime();
			String upPatchNo =  "ON"+ patchNo; // 线上批次
			String downPatchNo = "OFF" + patchNo; // 线下批次
			
			if(inComeInfos != null && inComeInfos.size() >0){
				logger.debug("crIncomingServlet------组装商户进件数据-------");
				for(CrInComeBean bean :   inComeInfos){
					//进件数据
					CrMerChantDataReq crReq = new CrMerChantDataReq();
					crReq.setMerCustId(bean.getCustId());
//					crReq.setOuterMchNo(bean.getMerchantCode());		//外部商户编号
					crReq.setMchName(bean.getMchName());				//商户名称
					crReq.setMchShortName(bean.getMchShortName());		//商户简称
					crReq.setCategoryType(bean.getCategoryType());		//类目
					crReq.setProvince(bean.getProvince());				//省份代码
					crReq.setCity(bean.getCity());						//城市代码
					crReq.setCountry(bean.getCountry());				//区县码
					crReq.setAddress(bean.getAddress());				//详细地址
					crReq.setCustomerPhone(bean.getCustomerPhone());  	//客户电话
					crReq.setLinkman(bean.getLinkman());				//联系人
					crReq.setPhone("13632849522"); 						//联系电话
					crReq.setEmail("bank@szgyzb.com");  				//联系邮箱
					crReq.setOperator(bean.getOperator()); 				//负责人姓名
					crReq.setMchRole(bean.getMchRole()); 				//商户角色
					crReq.setOperatorIdno(bean.getOperatorIdno()); 		//负责人身份证号码
					crReq.setLinenceNo(bean.getLinenceNo()); 			//商户证件编号
					crReq.setCertifcateType(bean.getCertifcateType());	//商户证件类型
					crReq.setContractsType(bean.getContractsType()); 	//联系人类型
					
					//判断该商户是否线上 或者线下 
					String onOrOff =this.validOnOrOff(bean.getMerchantCode());
					if(onOrOff != null){
						//报备角色
						String merchantRole = request.getParameter("role");
						if("00".equals(merchantRole)){//线上线下
							crReq.setPatchNo(upPatchNo);		//线上批次	
							crReq.setOuterMchNo(bean.getCustId());
							uplistReq.add(crReq);
							
							CrMerChantDataReq downDataReq = new CrMerChantDataReq();
							BeanUtils.copyProperties(downDataReq, crReq);
							downDataReq.setPatchNo(downPatchNo);
							downDataReq.setOuterMchNo(bean.getMerchantCode());
							downlistReq.add(downDataReq);
							
							bean.setPatchNo(upPatchNo);			//报备表记录线上批次信息
							bean.setMchRole(Constant.ON_LINE);
							bean.setOutMerchantCode(bean.getCustId());
							//增加一条线下记录
							CrInComeBean newBean = new CrInComeBean();
							BeanUtils.copyProperties(newBean, bean);
							newBean.setPatchNo(downPatchNo);
							newBean.setChannelNo(Constant.HUARUN);
							newBean.setFilingStatus(Constant.YES_FILING);//设置报备状态
							newBean.setMchRole(Constant.OFF_LINE);
							newBean.setId(GenSN.getSN());
							newBean.setOutMerchantCode(bean.getMerchantCode());
							addComeBean.add(newBean);			//报备增加线下批次信息
						}else if ("01".equals(merchantRole)){//线上
							crReq.setPatchNo(upPatchNo);
							crReq.setOuterMchNo(bean.getCustId());
							uplistReq.add(crReq);
							bean.setPatchNo(upPatchNo);
							bean.setMchRole(Constant.ON_LINE);
							bean.setOutMerchantCode(bean.getCustId());
						}else if ("02".equals(merchantRole)){//线下
							crReq.setPatchNo(downPatchNo);
							crReq.setOuterMchNo(bean.getMerchantCode());
							downlistReq.add(crReq);
							bean.setPatchNo(downPatchNo);
							bean.setMchRole(Constant.OFF_LINE);
							bean.setOutMerchantCode(bean.getMerchantCode());
						}
						bean.setChannelNo(Constant.HUARUN);//设置渠道编号
						bean.setFilingStatus(Constant.YES_FILING);//设置报备状态
						bean.setId(GenSN.getSN());
						
					  }
				   }
				upcrMerCategoryList.setMchRole(Constant.ON_LINE);
				upcrMerCategoryList.setDetail(uplistReq);
				downcrMerCategoryList.setMchRole(Constant.OFF_LINE);
				downcrMerCategoryList.setDetail(downlistReq);
				if(downlistReq.size()>0){
					listReq.add(downcrMerCategoryList);
				}
				if(uplistReq.size()>0){
					listReq.add(upcrMerCategoryList);
				 }
				//更改已经报备商户的报备状态   0 已报备 1未报备
//				crIncomeMapper.updateInComeInfo(inComeInfos);
				inComeInfos.addAll(addComeBean);
				//进件成功 写数据
				logger.debug("报备商户数据[{}]", JSONObject.toJSONString(inComeInfos, true));
				crIncomeMapperDao.insertFilingInfo(inComeInfos);
			}
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("merList", listReq);
			map.put("channelType", ChannelMerRegist.CR_ULOPAY);
			//调用商户进件接口
			logger.debug("crIncomingServlet-------调用商户进件接口-------");
			ChannelResult channelResult = iMerChantIntoService.merchatAdd(map);
			
			Map<String,Object> resultmap = (Map<String,Object>) channelResult.getData();
			List<TdCustInfo>  successCustList = (List<TdCustInfo>)resultmap.get("custInfoStatus");
			logger.debug("报备成功文件返回数据[{}]", JSONObject.toJSONString(successCustList, true));
			if (inComeInfos != null && inComeInfos.size() >0){
				//存在数据的商户     提交资料
				if( successCustList != null && successCustList.size() >0){
					//当前批次进件成功商户 
					for(CrInComeBean bean:  inComeInfos){
						for(TdCustInfo data: successCustList){
							
							logger.debug("crIncomingServlet-------组装商户文件进件接口数据-------");
							//线下报备文件信息
							if(bean.getMerchantCode().equals(data.getMerchantCode())){
								//上传资料数据
								TdMerFilePatch filepatch = new TdMerFilePatch();
								filepatch.setOuterMchNo(bean.getMerchantCode());
								filepatch.setLinenceImg(bean.getBusinessPath().split(";")[0]);
								filepatch.setIndentityImg(bean.getIdCardPath().split(";")[0]);
								filepatch.setIndentityBackImg(bean.getIdCardPath().split(";")[1]);
								filepatch.setPatchNo(downPatchNo);
								downlistFile.add(filepatch);
								continue;
							//线上报备文件信息
							}else if(bean.getCustId().equals(data.getMerchantCode())){
								TdMerFilePatch filepatch = new TdMerFilePatch();
								filepatch.setOuterMchNo(bean.getCustId());
								filepatch.setLinenceImg(bean.getBusinessPath().split(";")[0]);
								filepatch.setIndentityImg(bean.getIdCardPath().split(";")[0]);
								filepatch.setIndentityBackImg(bean.getIdCardPath().split(";")[1]);
								filepatch.setPatchNo(upPatchNo);
								uplistFile.add(filepatch);
								continue;
							}
							
						}
					}
					
					uptdMerFilePatchList.setMchRole(Constant.ON_LINE);
					uptdMerFilePatchList.setDetail(uplistFile);
					downtdMerFilePatchList.setMchRole(Constant.OFF_LINE);
					downtdMerFilePatchList.setDetail(downlistFile);
					if(uplistFile.size()>0){
						listFile.add(uptdMerFilePatchList);
					}
					if(downlistFile.size()>0){
						listFile.add(downtdMerFilePatchList);
					}
					
					//进件成功商户 调用上传资料接口
					HashMap<String,Object> filemap = new HashMap<String,Object>();
					filemap.put("filePatch", listFile);
					//调用商户资料上传接口
					logger.debug("crIncomingServlet-------调用商户文件进件接口数据-------");
					iMerChantIntoService.fileUpload(filemap);
				}
			}
		} catch (Exception e) {
			logger.error("CrIncomingServlet execute exception",e);
			return EXECUTE_FAILURE;
		}
		
		return EXECUTE_SUCCESS;
	
	}

		/**
		 * 合利宝报备
		 * @param request
		 * @return
		 */
		public String helipayReport(HttpServletRequest request){
			
			//查询商户信息
			String merchantCode = request.getParameter("merchantCode");
			try {
				List<CrInComeBean> inComeInfos = crIncomeMapperDao.getInComeInfo(merchantCode);
				HashMap<String , Object> map = new HashMap<String , Object>();
				//拼装接口信息
				if(inComeInfos != null && inComeInfos.size() >0){
					//查询行业类型信息
					String industryTypeCode = request.getParameter("categoryId");
					CategoryCodeInfo codeInfo = crIncomeMapperDao.getCategoryInfoHelipay(industryTypeCode);
					MerRegistParamReq paramReq = new MerRegistParamReq();
					paramReq.setLegalPerson(inComeInfos.get(0).getOperator());//法人名字
					paramReq.setLegalPersonID(inComeInfos.get(0).getOperatorIdno());//法人身份证号码
					paramReq.setBusinessLicense(inComeInfos.get(0).getLinenceNo());//营业执照
					paramReq.setOrgNum(inComeInfos.get(0).getLinenceNo());//组织机构代码
					paramReq.setAddress(inComeInfos.get(0).getAddress());//通讯地址
					paramReq.setLinkman(inComeInfos.get(0).getLinkman());//联系人
					paramReq.setLinkPhone(inComeInfos.get(0).getPhone());//联系电话
					paramReq.setEmail(inComeInfos.get(0).getEmail());//联系邮箱
					paramReq.setBindMobile(inComeInfos.get(0).getPhone()); //绑定手机
					paramReq.setBankCode(inComeInfos.get(0).getCNAPS());  //联行号
					paramReq.setAccountName(inComeInfos.get(0).getAccountName()); //结算户名
					paramReq.setAccountNo(inComeInfos.get(0).getAccountNo()); //结算卡号
					paramReq.setSettleBankType("TOPUBLIC");//结算卡类型
					paramReq.setSettlementMode("SELF");//结算方式
					paramReq.setSettlementPeriod("T1");//结算类型
					paramReq.setIndustryTypeCode(industryTypeCode);//行业类型编号
					paramReq.setMerchantCategory(codeInfo.getMerchantCategory());//经营类别
					paramReq.setMerchantType(codeInfo.getMerchantType());
					paramReq.setAuthorizationFlag(true);
					paramReq.setShowName(inComeInfos.get(0).getMchShortName());
					paramReq.setSignName(inComeInfos.get(0).getMchShortName());
					paramReq.setRegionCode(crIncomeMapperDao.getAreaIdByProvidAndAreaId(inComeInfos.get(0).getProvince(),inComeInfos.get(0).getCountry()));//区县编码
					String sn = GenSN.getSN();
					paramReq.setOrderNo(sn);
					paramReq.setMerCustId(inComeInfos.get(0).getCustId());
					String patchNo = "heliPay"+GenSN.getSysTime();
					paramReq.setPatchNo(patchNo);
					//报备接口参数数据
					map.put("merList", paramReq);
					map.put("channelType", ChannelMerRegist.HELIPAY);
					
					//进件成功 写数据
				
					inComeInfos.get(0).setPatchNo(patchNo);
					inComeInfos.get(0).setChannelNo(Constant.HELIPAY);
					inComeInfos.get(0).setOutMerchantCode(sn);
					inComeInfos.get(0).setId(GenSN.getSN());
					inComeInfos.get(0).setFilingStatus(Constant.YES_FILING);
					logger.debug("报备商户数据[{}]", JSONObject.toJSONString(inComeInfos, true));
					crIncomeMapperDao.insertFilingInfo(inComeInfos);
					
					//调用合利宝报备接口
					ChannelResult channelResult = iMerChantIntoService.merchatAdd(map);
					if(channelResult != null ){
						if(!"00".equals(channelResult.getReCode())){
							return "FAIL";
						}
					}
				}
				
			} catch (Exception e) {
				logger.error("合利宝报备异常 ",e);
				return "FAIL";
			}
			
			return "SUCCESS";
		}
		
		/**
		 * 快付通报备
		 * @param request
		 * @return
		 */
		public String kftReport(HttpServletRequest request){
			
			//查询商户信息
			String merchantCode = request.getParameter("merchantCode");
			logger.info(">>>>>>>>>>>>>>>>>>>>>快付通商户[{}]报备<<<<<<<<<<<<<<<<<<",merchantCode);
			try {
				List<CrInComeBean> inComeInfos = crIncomeMapperDao.getInComeInfo(merchantCode);
				HashMap<String , Object> map = new HashMap<String , Object>();
				//拼装接口信息
				if(inComeInfos != null && inComeInfos.size() >0){
					//文件上传
					List<KftUploadFileBean> list = new ArrayList<KftUploadFileBean>();
					List<KftCertInfo> certInfo = new ArrayList<KftCertInfo>();
					String custType = inComeInfos.get(0).getCustType();
					String merchantType =""; //商户类型
					//个体户
					if(Constant.CUST_TYPE_PERSON.equals(custType)){
						merchantType = Constant.KFT_PERSON;
						KftCertInfo certInfo0 = new KftCertInfo();
						certInfo0.setCertNo(inComeInfos.get(0).getOperatorIdno());//证件号码
						certInfo0.setCertType(Constant.KFT_PERSON_CARD);								//身份证
						certInfo0.setCertValidDate(inComeInfos.get(0).getIdCardValidTime()); 	//期限
						KftCertInfo certInfoY = new KftCertInfo();
						certInfoY.setCertNo(inComeInfos.get(0).getLinenceNo());//证件号码
						certInfoY.setCertType(Constant.KFT_BUSINESS);								//营业执照
						certInfoY.setCertValidDate(inComeInfos.get(0).getBusinessValidTime()); 	//期限
						certInfo.add(certInfo0);
						certInfo.add(certInfoY);
						
						KftUploadFileBean filebean10= new KftUploadFileBean();
						filebean10.setCertNo(Constant.KFT_FILE_TYPE_PER_CARD_BEFOR);
						filebean10.setFilePath(inComeInfos.get(0).getIdCardPath().split(";")[0]);
						filebean10.setMerchantType(Constant.KFT_FILE_PERSON);
						filebean10.setNo("1");
						
						KftUploadFileBean filebean11= new KftUploadFileBean();
						filebean11.setCertNo(Constant.KFT_FILE_TYPE_PER_CARD_BACK);
						filebean11.setFilePath(inComeInfos.get(0).getIdCardPath().split(";")[1]);
						filebean11.setMerchantType(Constant.KFT_FILE_PERSON);
						filebean11.setNo("2");
						
						KftUploadFileBean filebean12= new KftUploadFileBean();
						filebean12.setCertNo(Constant.KFT_FILE_TYPE_PER_HAND);
						filebean12.setFilePath("");
						filebean12.setMerchantType(Constant.KFT_FILE_PERSON);
						filebean12.setNo("3");
						
						KftUploadFileBean filebean13= new KftUploadFileBean();
						filebean13.setCertNo(Constant.KFT_FILE_TYPE_PER_BANKCARD_BEFOR);
						filebean13.setFilePath("");
						filebean13.setMerchantType(Constant.KFT_FILE_PERSON);
						filebean13.setNo("4");
						
						KftUploadFileBean filebean14= new KftUploadFileBean();
						filebean14.setCertNo(Constant.KFT_FILE_TYPE_PER_BANKCARD_BACK);
						filebean14.setFilePath("");
						filebean14.setMerchantType(Constant.KFT_FILE_PERSON);
						filebean14.setNo("5");
						
						KftUploadFileBean filebean16= new KftUploadFileBean();
						filebean16.setCertNo(Constant.KFT_FILE_TYPE_PER_DOOR);
						filebean16.setFilePath("");
						filebean16.setMerchantType(Constant.KFT_FILE_PERSON);
						filebean16.setNo("6");
						
						list.add(filebean10);
						list.add(filebean11);
						list.add(filebean12);
						list.add(filebean13);
						list.add(filebean14);
						list.add(filebean16);
					}
					
					//企业客户
					if(Constant.CUST_TYPE_COMPANY.equals(custType)){
						merchantType = Constant.KFT_MERCHANT;
						KftCertInfo certInfo0 = new KftCertInfo();
						certInfo0.setCertNo(inComeInfos.get(0).getOperatorIdno());//证件号码
						certInfo0.setCertType(Constant.KFT_PERSON_CARD);								//身份证
						certInfo0.setCertValidDate(inComeInfos.get(0).getIdCardValidTime()); 	//期限
						KftCertInfo certInfoY = new KftCertInfo();
						certInfoY.setCertNo(inComeInfos.get(0).getLinenceNo());//证件号码
						certInfoY.setCertType(Constant.KFT_BUSINESS);								//营业执照
						certInfoY.setCertValidDate(inComeInfos.get(0).getBusinessValidTime()); 	//期限
						certInfo.add(certInfo0);
						certInfo.add(certInfoY);
						
						KftUploadFileBean filebean21= new KftUploadFileBean();
						filebean21.setCertNo(Constant.KFT_FILE_TYPE_MER_BUSINESS);
						filebean21.setFilePath(inComeInfos.get(0).getBusinessPath().split(";")[0]);
						filebean21.setMerchantType(Constant.KFT_FILE_MERCHANT);
						filebean21.setNo("1");
						
						KftUploadFileBean filebean25= new KftUploadFileBean();
						filebean25.setCertNo(Constant.KFT_FILE_TYPE_MER_CARD_BEFOR);
						filebean25.setFilePath(inComeInfos.get(0).getIdCardPath().split(";")[0]);
						filebean25.setMerchantType(Constant.KFT_FILE_MERCHANT);
						filebean25.setNo("2");
						
						KftUploadFileBean filebean26= new KftUploadFileBean();
						filebean21.setCertNo(Constant.KFT_FILE_TYPE_MER_CARD_BACK);
						filebean21.setFilePath(inComeInfos.get(0).getIdCardPath().split(";")[1]);
						filebean21.setMerchantType(Constant.KFT_FILE_MERCHANT);
						filebean21.setNo("3");
						
						KftUploadFileBean filebean27= new KftUploadFileBean();
						filebean27.setCertNo(Constant.KFT_FILE_TYPE_MER_LICENCE);
						filebean27.setFilePath(inComeInfos.get(0).getOpenAccountPath().split(";")[0]);
						filebean27.setMerchantType(Constant.KFT_FILE_MERCHANT);
						filebean27.setNo("4");
						
						KftUploadFileBean filebean29= new KftUploadFileBean();
						filebean29.setCertNo(Constant.KFT_FILE_TYPE_MER_DOOR);
						filebean29.setFilePath(inComeInfos.get(0).getDoorPath().split(";")[0]);
						filebean29.setMerchantType(Constant.KFT_FILE_MERCHANT);
						filebean29.setNo("5");
						
						list.add(filebean21);
						list.add(filebean25);
						list.add(filebean26);
						list.add(filebean27);
						list.add(filebean29);
					}
					Map<String, Object> fileUpload = new HashMap<String, Object>();
					//进件成功 写数据
					String patchNo = GenSN.getSysTime();
					fileUpload.put("patchNo", patchNo);
					fileUpload.put("filePatch", list);
					fileUpload.put("channelType",ChannelMerRegist.KFT_PAY);
					//文件上传接口
					ChannelResult fileResult = iMerChantIntoService.fileUpload(fileUpload);
					Map<String, Object> fileMap = new HashMap<String, Object>();
					if(fileResult != null ){
						if("04".equals(fileResult.getReCode())){
							logger.error(">>>>>>>>>>>>>>>>>>>>>快付通商户[{}]报备文件上传失败<<<<<<<<<<<<<<<<<<",merchantCode);
							//修改文件状态
							MerchantFilingInfo filingInfo = new MerchantFilingInfo();
							filingInfo.setMerchantCode(merchantCode);
							filingInfo.setFileStatus("99");
							crIncomeMapperDao.updateFilingInfo(filingInfo);
							return "FAIL";
						}else{
							fileMap = fileResult.getData();
							//修改文件状态
							MerchantFilingInfo filingInfo = new MerchantFilingInfo();
							filingInfo.setMerchantCode(merchantCode);
							filingInfo.setFileStatus("00");
							crIncomeMapperDao.updateFilingInfo(filingInfo);
						}
					}else{
						logger.error(">>>>>>>>>>>>>>>>>>>>>快付通商户[{}]报备文件上传失败<<<<<<<<<<<<<<<<<<",merchantCode);
						MerchantFilingInfo filingInfo = new MerchantFilingInfo();
						filingInfo.setMerchantCode(merchantCode);
						filingInfo.setFileStatus("99");
						crIncomeMapperDao.updateFilingInfo(filingInfo);
						return "FAIL";
					}
					
					//查询行业类型信息  准备进件
					String categoryCode = request.getParameter("categoryId");
					KftMerChantDataReq paramReq = new KftMerChantDataReq();
					paramReq.setSignName(inComeInfos.get(0).getMchName());//二级商户名称
					paramReq.setShowName(inComeInfos.get(0).getMchName());//收银台展示名
					paramReq.setOrderNo(merchantCode); //进件订单号
					paramReq.setDistrict(crIncomeMapperDao.getKftAreaId(inComeInfos.get(0).getCountry()));//区县编码
					paramReq.setLegalPerson(inComeInfos.get(0).getOperator());//法人名字
					paramReq.setAddress(inComeInfos.get(0).getAddress());//通讯地址
					paramReq.setLinkman(inComeInfos.get(0).getLinkman()); //联系人
					paramReq.setLinkPhone(inComeInfos.get(0).getPhone()); //联系电话
					paramReq.setEmail(inComeInfos.get(0).getEmail());	//联系邮箱
					paramReq.setMerchantType(merchantType);				//商户类型
					paramReq.setCategory(categoryCode);					//经营类别
					paramReq.setMerchantAttribute("1");					//商户属性
					paramReq.setBusinessScene("支付");					//业务场景说明
					paramReq.setCertPath((String)fileMap.get("certPath"));	//证件扫描件路径
					paramReq.setCertDigest((String)fileMap.get("certDigest"));	//证件扫描件文件签名
					paramReq.setCorpCertInfo(certInfo);
					paramReq.setPersonCertInfo(certInfo);
					
					//银行账号信息
					KftSettleBankInfo settleBankAccount = new KftSettleBankInfo();
					settleBankAccount.setSettleBankNo(crIncomeMapperDao.getBankInfoByBankCode(inComeInfos.get(0).getCNAPS()));
					settleBankAccount.setSettleBankAccountNo(inComeInfos.get(0).getAccountNo());
					settleBankAccount.setSettleName(inComeInfos.get(0).getAccountName());
					settleBankAccount.setSettleBankAcctType(merchantType);
					settleBankAccount.setSettleAccountCreditOrDebit("1");
					paramReq.setSettleBankAccount(settleBankAccount);
					
					//产品费率信息
					MerchantProdInfo prodInfo = crIncomeMapperDao.getMerchantProdInfo(merchantCode);
					List<KftProductFeeInfo> productFees = new ArrayList<KftProductFeeInfo>();
					if(prodInfo != null){
						if(prodInfo.getOnecode() != null){
							KftProductFeeInfo productInfoOnecode1 = new KftProductFeeInfo();
							productInfoOnecode1.setProductId(Constant.KFT_PRO_WX_H5_PUB);//微信公众号
							productInfoOnecode1.setFeeOfRate(prodInfo.getOnecode());
							productInfoOnecode1.setFeeType("2");
							
							KftProductFeeInfo productInfoOnecode2 = new KftProductFeeInfo();
							productInfoOnecode2.setProductId(Constant.KFT_PRO_AIPAY_QR); //支付宝扫码
							productInfoOnecode2.setFeeOfRate(prodInfo.getOnecode());
							productInfoOnecode2.setFeeType("2");
							
							KftProductFeeInfo productInfoOnecode3 = new KftProductFeeInfo();
							productInfoOnecode3.setProductId(Constant.KFT_PRO_WX_QR); //微信扫码
							productInfoOnecode3.setFeeOfRate(prodInfo.getOnecode());
							productInfoOnecode3.setFeeType("2");
							productFees.add(productInfoOnecode1);
							productFees.add(productInfoOnecode2);
							productFees.add(productInfoOnecode3);
						}
						
					}
					paramReq.setProductFees(productFees);
					//报备接口参数数据
					map.put("patchNo", patchNo);
					map.put("merList", paramReq);
					map.put("channelType", ChannelMerRegist.KFT_PAY);
					
					inComeInfos.get(0).setPatchNo(patchNo);
					inComeInfos.get(0).setChannelNo(Constant.KFTPAY);
					inComeInfos.get(0).setOutMerchantCode(merchantCode);
					inComeInfos.get(0).setId(GenSN.getSN());
					inComeInfos.get(0).setFilingStatus(Constant.YES_FILING);
					logger.debug("报备商户数据[{}]", JSONObject.toJSONString(inComeInfos, true));
					crIncomeMapperDao.insertFilingInfo(inComeInfos);
					
					//调用快付通接口
					ChannelResult channelResult = iMerChantIntoService.merchatAdd(map);
					if(channelResult != null ){
						if("04".equals(channelResult.getReCode())){
							logger.error(">>>>>>>>>>>>>>>>>>>>>快付通商户[{}]进件失败<<<<<<<<<<<<<<<<<<",merchantCode);
							return "FAIL";
						}
					}
				}
				
			} catch (Exception e) {
				logger.error("快付通报备异常 ",e);
				return "FAIL";
			}
			
			return "SUCCESS";
		}
		
		public List<CrInComeBean> getInComeInfo(@Param("merchantCode") String merchantCode){
			
			   return crIncomeMapperDao.getInComeInfo(merchantCode);
		    }
			public void updateInComeInfo(List<CrInComeBean> beans){
				crIncomeMapperDao.updateInComeInfo(beans);
			}
			public void insertFilingInfo(List<CrInComeBean> beans){
				crIncomeMapperDao.insertFilingInfo(beans);
			}
			public MerchantProdInfo getMerchantProdInfo(@Param("merchantCode") String merchantCode){
				return crIncomeMapperDao.getMerchantProdInfo(merchantCode);
			}
			
			public List<ChannlInfo> getChannlInfoList(){
				return crIncomeMapperDao.getChannlInfoList();
			}
			public List<MerchantFilingInfo> getfilingInfoList(MerchantFilingInfo merchantCode){
				
				return crIncomeMapperDao.getfilingInfoList(merchantCode);
			}
			
			/**
			 * 查询行业信息
			 * @param merchantId
			 * @return
			 */
			public CategoryCodeInfo getCategoryTypeInfo(String merchantId){
				return crIncomeMapperDao.getCategoryTypeInfo(merchantId);
			}
			
			/**
			 * 校验商户是否报备
			 * @param merchantCode
			 * @return
			 */
			public List<MerchantFilingInfo> verifyFiling(MerchantFilingInfo merchantCode){
				return crIncomeMapperDao.verifyFiling(merchantCode);
			}
			
			/**
			 * 获取快付通一级类目
			 * @return
			 */
			public List<CategoryCodeKftInfo> getCategoryInfoFirstLvList(){
				return crIncomeMapperDao.getCategoryInfoFirstLvList();
			}
			
			/**
			 * 获取快付通二级类目
			 * @param firstLvCode
			 * @return
			 */
			public List<CategoryCodeKftInfo> getCategoryInfoSecondLvList(String firstLvCode){
				return crIncomeMapperDao.getCategoryInfoSecondLvList(firstLvCode);
			}
			
			/**
			 * 获取快付通三级类目
			 * @param firstLvCode
			 * @return
			 */
			public List<CategoryCodeKftInfo> getCategoryInfoThirdLvList(String secondLvCode){
				return crIncomeMapperDao.getCategoryInfoThirdLvList(secondLvCode);
			}
	}


