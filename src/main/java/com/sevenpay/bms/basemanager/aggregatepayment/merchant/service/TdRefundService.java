package com.sevenpay.bms.basemanager.aggregatepayment.merchant.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.record.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.utils.ExportExcel;
import com.sevenpay.bms.basemanager.aggregatepayment.merchant.bean.TdRefund;
import com.sevenpay.bms.basemanager.aggregatepayment.merchant.dao.RefundDAO;
import com.sevenpay.bms.common.util.PropertiesUtil;

@Service
public class TdRefundService {
	
	private static Logger logger = LoggerFactory.getLogger(TdRefundService.class);
	
	@Autowired
	private RefundDAO refundDAO;
	
	
	public List<TdRefund> getRefundList(TdRefund bean){
		return refundDAO.getRefundList(bean);
	}
	
	public List<TdRefund> getRefundExport(TdRefund bean){
		return refundDAO.getRefundExport(bean);
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

}
