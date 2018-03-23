package com.sevenpay.bms.basemanager.aggregatepayment.merchant.mapper;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.aggregatepayment.merchant.bean.TdRefund;
import com.sevenpay.bms.common.annotation.MapperScanPayment;


@Repository
@MapperScanPayment
public interface RefundMapper {

	@Page
	List<TdRefund> getRefundList(TdRefund bean);
	
	List<TdRefund> getRefundExport(TdRefund bean);
}
