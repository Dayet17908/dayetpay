package com.sevenpay.bms.basemanager.acctsevencust.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.acctsevencust.bean.AcctSevenCust;
import com.sevenpay.bms.basemanager.acctsevencust.mapper.AcctSevenCustMapper;

@Repository
public class AcctSevenCustDao {
	@Autowired
	private AcctSevenCustMapper acctSevenCustMapper;
	@Page
	public List<AcctSevenCust> getAcctSevenCust(AcctSevenCust queryBean) {
		
		return acctSevenCustMapper.getAcctSevenCust(queryBean);
	}
}
