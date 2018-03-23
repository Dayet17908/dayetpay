package com.sevenpay.bms.basemanager.messagelog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.basemanager.messagelog.bean.BmsMessageLog;
import com.sevenpay.bms.basemanager.messagelog.dao.BmsMessageLogDao;
@Service
public class BmsMessageLogService {
	@Autowired
	private BmsMessageLogDao dao;
	public List<BmsMessageLog> selectMessageLogList(BmsMessageLog bmsMessageLog){
		return dao.selectMessageLogList(bmsMessageLog);
	}
}
