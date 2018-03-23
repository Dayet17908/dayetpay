package com.sevenpay.bms.basemanager.messagelog.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.basemanager.messagelog.bean.BmsMessageLog;
@MapperScan
public interface BmsMessageLogMapper {	
	public List<BmsMessageLog> selectMessageLogList(BmsMessageLog bmsMessageLog);
}
