package com.sevenpay.bms.basemanager.merchant.mapper;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.basemanager.merchant.bean.ActWorkflowMerchantAudit;

@MapperScan
public interface ActWorkflowMerchantAuditHistoryMapper {
	 int insert(ActWorkflowMerchantAudit record);
}
