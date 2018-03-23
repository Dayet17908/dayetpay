package com.sevenpay.bms.paymentmanager.topay.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.paymentmanager.bean.TdPaymentBatDetail;
import com.sevenpay.bms.paymentmanager.bean.TdPaymentBatInfo;
import com.sevenpay.bms.paymentmanager.topay.mapper.PaymentQueryMapper;


@Repository
public class PaymentQueryDao {
	@Autowired
	private PaymentQueryMapper paymentQueryMapper ;
	@Page
    public List<TdPaymentBatInfo> getPaymetList(TdPaymentBatInfo paymentBatInfo) {
		
		return paymentQueryMapper.getPaymetList(paymentBatInfo);
	}
	
  @Page	
  public List<TdPaymentBatDetail> getPaymetbatNoList(String batNo) {
		
		return paymentQueryMapper.getPaymetbatNoList(batNo);
	}
  
  public List<TdPaymentBatInfo> exportPaymentList(TdPaymentBatInfo paymentBatInfo) {
		
		return paymentQueryMapper.exportPaymentList(paymentBatInfo);
	}
  
  public List<TdPaymentBatDetail> exportPaymentInfoList(TdPaymentBatDetail paymentBatDetail) {
		
		return paymentQueryMapper.exportPaymentInfoList(paymentBatDetail);
	}
  @Page
  public List<TdPaymentBatDetail> selectPaymetbatNoList(TdPaymentBatDetail paymentBatDetail) {
		
		return paymentQueryMapper.selectPaymetbatNoList(paymentBatDetail);
	}
}
