package com.sevenpay.bms.basemanager.acctsevenbuss.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.acctsevenbuss.bean.AcctSevenBuss;
import com.sevenpay.bms.basemanager.acctsevenbuss.mapper.AcctSevenBussMapper;

@Repository
public class AcctSevenBussDao {
	@Autowired
	private AcctSevenBussMapper acctSevenBussMapper;

	@Page
	public List<AcctSevenBuss> queryAcctSevenBuss(AcctSevenBuss queryBean) {
		return acctSevenBussMapper.queryAcctSevenBuss(queryBean);
	}

}
