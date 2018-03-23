package com.sevenpay.bms.paymentmanager.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.paymentmanager.bean.TdBankCardBin;
import com.sevenpay.bms.paymentmanager.bean.TdPaymentBatDetail;
import com.sevenpay.bms.paymentmanager.bean.TdPaymentBatInfo;
import com.sevenpay.bms.paymentmanager.mapper.PaymentManagerMapper;

@Repository
public class PaymentManagerDao {

	@Autowired
	private PaymentManagerMapper mapper;

	public int insertPaymentList(List<TdPaymentBatDetail> bean) {
		
		return mapper.insertPaymentList(bean);
	}

	/**
	 * 查询银行号
	 * 
	 * @param selectBean
	 * @return
	 */
	public List<TdBankCardBin> selectCardBinList() {
		return mapper.selectCardBinList();
	}

	public int upPaymentBatDetail(TdPaymentBatDetail updateBean) {
		return mapper.upPaymentBatDetail(updateBean);
	}
	
	public int insertBatInfo(TdPaymentBatInfo bean){
		return mapper.insertBatInfo(bean);
	}
	
	public List<TdPaymentBatDetail> selecPaymentList(String batNo){
		return mapper.selecPaymentList(batNo);
	}
	
	@Page
	public List<TdPaymentBatDetail> getBatchFailPaymentList(String batNo){
		return mapper.getBatchFailPaymentList(batNo);
	}
}
