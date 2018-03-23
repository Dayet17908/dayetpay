package com.sevenpay.bms.basemanager.messagelog.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.messagelog.bean.BmsMessageLog;
import com.sevenpay.bms.basemanager.messagelog.mapper.BmsMessageLogMapper;

@Repository
public class BmsMessageLogDao {
	@Autowired
	private BmsMessageLogMapper mapper;
	@Page
	public List<BmsMessageLog> selectMessageLogList(BmsMessageLog bmsMessageLog){
		return mapper.selectMessageLogList(bmsMessageLog);
	}
}
