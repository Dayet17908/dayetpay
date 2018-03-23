package com.sevenpay.bms.basemanager.acctsevencust.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.basemanager.acctsevencust.bean.AcctSevenCust;
import com.sevenpay.bms.basemanager.acctsevencust.dao.AcctSevenCustDao;
import com.sevenpay.bms.expresspay.CommonService;

@Service
public class AcctSevenCustService {
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private AcctSevenCustDao acctSevenCustDao;
	
	public List<AcctSevenCust> getAcctSevenCust(AcctSevenCust queryBean) {
		
		return acctSevenCustDao.getAcctSevenCust(queryBean);
	}


}
