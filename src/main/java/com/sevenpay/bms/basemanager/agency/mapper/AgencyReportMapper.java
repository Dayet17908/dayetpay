package com.sevenpay.bms.basemanager.agency.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.basemanager.agency.bean.AgenReport;
import com.sevenpay.bms.basemanager.agency.bean.AgentMerchantReport;

@MapperScan
public interface AgencyReportMapper {

	public List<AgenReport> getAgenReportList(AgenReport bean);
	
	public List<AgentMerchantReport> getAgentMerchantReport(AgentMerchantReport bean);
}
