package com.sevenpay.bms.basemanager.aggregatepayment.agent.service;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.utils.ExportExcel;
import com.sevenpay.bms.basemanager.aggregatepayment.agent.bean.AgentSettleBean;
import com.sevenpay.bms.basemanager.aggregatepayment.agent.bean.AgentSettleDetailBean;
import com.sevenpay.bms.basemanager.aggregatepayment.agent.dao.AgentSettleDAO;
import com.sevenpay.bms.common.util.PropertiesUtil;

@Service
public class AgentSettleService {
	
	@Autowired
	private AgentSettleDAO agentSettleDAO;

	public List<AgentSettleBean> getAgentSettleList(AgentSettleBean queryBean) {

		return agentSettleDAO.getAgentSettleList(queryBean);
	}

	public AgentSettleDetailBean getDetailBySettleId(String settleId) {
		return agentSettleDAO.getDetailBySettleId(settleId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, String> exportExcel(List excels, String[] headers, String fileName, String title,
			HttpServletRequest request) {
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
		}
		
		return fileInfo;

	}

	public List<AgentSettleBean> getAgentSettleListExport(AgentSettleBean queryBean) {
		// TODO Auto-generated method stub
		return agentSettleDAO.getAgentSettleListExport(queryBean);
	}
}