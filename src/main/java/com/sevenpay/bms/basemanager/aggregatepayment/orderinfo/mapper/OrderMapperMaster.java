package com.sevenpay.bms.basemanager.aggregatepayment.orderinfo.mapper;

import com.sevenpay.bms.basemanager.aggregatepayment.orderinfo.bean.OrderInfoBean;
import com.sevenpay.bms.basemanager.aggregatepayment.orderinfo.bean.RefundBean;
import com.sevenpay.bms.common.annotation.MapperScanCombinedmaster;


@MapperScanCombinedmaster
public interface OrderMapperMaster {
	
	public void updateOrder(OrderInfoBean infoBean);
	
	public int updateRefundRecode(RefundBean refundBean);
}
