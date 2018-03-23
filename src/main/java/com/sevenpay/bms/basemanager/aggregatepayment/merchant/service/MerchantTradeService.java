package com.sevenpay.bms.basemanager.aggregatepayment.merchant.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.record.formula.functions.T;
import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.utils.ExportExcel;
import com.sevenpay.bms.basemanager.aggregatepayment.merchant.bean.MerchantTradeQueryBean;
import com.sevenpay.bms.basemanager.aggregatepayment.merchant.bean.OrderSummaryBean;
import com.sevenpay.bms.basemanager.aggregatepayment.merchant.mapper.MerchantTradeMapper;
import com.sevenpay.bms.common.util.PropertiesUtil;

@Service
public class MerchantTradeService {
	@Autowired
	private MerchantTradeMapper mapper;

	@Page
	public List<OrderSummaryBean> getMerchantTradeList(
			MerchantTradeQueryBean queryBean) {
		return mapper.getMerchantTradeList(queryBean);
	}
	
	@Page
	public List<OrderSummaryBean> getMerchantRefundList(
			MerchantTradeQueryBean queryBean) {
		// TODO Auto-generated method stub
		return mapper.getMerchantRefundList(queryBean);
	}
	
	public List<OrderSummaryBean> getMerchantExportList(
			MerchantTradeQueryBean queryBean) {
		return mapper.getMerchantTradeList(queryBean);
	}
	
	public List<OrderSummaryBean> getMerchantRefundExportList(
			MerchantTradeQueryBean queryBean) {
		
		return mapper.getMerchantRefundList(queryBean);
	}
	
	@SuppressWarnings("finally")
	public Map<String, String> exportExcel(List excels, String[] headers, String fileName, String title, HttpServletRequest request) {
		Map<String, String> fileInfo = new HashMap<String, String>();
		OutputStream out = null;
		try {

			Properties p = PropertiesUtil.getProperties();
			String exportPath = p.getProperty("EXPORT_EXCEL");
			File saveFile = new File(exportPath);
			if (!saveFile.exists()) {
				saveFile.mkdirs();
			}
			String filePath = saveFile + File.separator + fileName;
			fileInfo.put("fileName", fileName);
			fileInfo.put("filePath", filePath);
			out = new FileOutputStream(filePath);

			ExportExcel<T> ex = new ExportExcel<T>();

			ex.exportExcel(title, headers, excels, out);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return fileInfo;
		}

	}

	public List<BigDecimal> getTotal(List<OrderSummaryBean> tradeBills) {
		BigDecimal allCount=new BigDecimal(0.00);
		BigDecimal allSum=new BigDecimal(0.00);
		BigDecimal allSettle=new BigDecimal(0.00);
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		for (OrderSummaryBean orderSummaryBean : tradeBills) {
			if(orderSummaryBean.getCountTrade()!=null&&!"".equals(orderSummaryBean.getCountTrade())){
				allCount = allCount.add(new BigDecimal(orderSummaryBean.getCountTrade()));
			}
			if(orderSummaryBean.getSumTrade()!=null&&!"".equals(orderSummaryBean.getSumTrade())){
				allSum = allSum.add(new BigDecimal(orderSummaryBean.getSumTrade()));
			}
			if(orderSummaryBean.getSettleAmt()!=null&&!"".equals(orderSummaryBean.getSettleAmt())){
				allSettle = allSettle.add(new BigDecimal(orderSummaryBean.getSettleAmt()));
			}
		}
		list.add(allCount);
		list.add(allSum);
		list.add(allSettle);
		return list;
	}

}
