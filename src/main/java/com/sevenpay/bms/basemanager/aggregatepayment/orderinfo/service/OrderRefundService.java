package com.sevenpay.bms.basemanager.aggregatepayment.orderinfo.service;

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
import com.sevenpay.bms.basemanager.aggregatepayment.orderinfo.bean.RefundBean;
import com.sevenpay.bms.basemanager.aggregatepayment.orderinfo.bean.RefundQueryBean;
import com.sevenpay.bms.basemanager.aggregatepayment.orderinfo.dao.OrderRefundDAO;
import com.sevenpay.bms.common.util.PropertiesUtil;


@Service
public class OrderRefundService {
	@Autowired
	private OrderRefundDAO orderRefundDAO;

	/** 查询所有交易 */
	public List<RefundBean> getOrderRefundList(RefundQueryBean queryBean) {

		return orderRefundDAO.getOrderRefundList(queryBean);
	}

	public List<RefundBean> getOrderRefundListExport(RefundQueryBean queryBean) {

		return orderRefundDAO.getOrderRefundListExport(queryBean);
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

	/**
	 * 查询退款详细信息
	 * 
	 * @param refundId
	 * @return
	 */
	public RefundBean getRefundDetail(String refundId) {
		return orderRefundDAO.getRefundDetail(refundId);
	}

	/**
	 * 导出自己权限的退款订单
	 * 
	 * @param queryBean
	 * @return
	 */
	public List<RefundBean> getMyOrderRefundListExport(RefundQueryBean queryBean) {
		return orderRefundDAO.getMyOrderRefundListExport(queryBean);
	}
}