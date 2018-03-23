package com.sevenpay.bms.basemanager.aggregatepayment.merchant.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.aggregatepayment.merchant.bean.TdRefund;
import com.sevenpay.bms.basemanager.aggregatepayment.merchant.mapper.RefundMapper;

@Repository
public class RefundDAO {

	@Autowired
	private RefundMapper refundMapper;
	
	
	/**
	 * 查询商户渠道金额限制列表
	 * @param channel
	 * @return
	 */
	@Page
	public List<TdRefund> getRefundList(TdRefund bean){
		return refundMapper.getRefundList(bean);
	}
	public List<TdRefund> getRefundExport(TdRefund bean){
		return refundMapper.getRefundExport(bean);
	}
	
}
