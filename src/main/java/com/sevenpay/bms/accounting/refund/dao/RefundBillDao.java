package com.sevenpay.bms.accounting.refund.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.refund.bean.RefundBill;
import com.sevenpay.bms.accounting.refund.mapper.RefundBillMapper;

@Repository
public class RefundBillDao {
	@Autowired
	private RefundBillMapper refundBillMapper;

	@Page
	public List<RefundBill> select(RefundBill queryBean) {
		return refundBillMapper.select(queryBean);
	}
}
