package com.sevenpay.bms.bal.accountResult.service;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.bal.accountResult.bean.BalExternalResultEqual;
import com.sevenpay.bms.bal.accountResult.dao.BalExternalResultEqualDAO;


@Service
public class BalExternalResultEqualService {
	
	@Autowired
	private BalExternalResultEqualDAO balExternalResultEqualDAO;
	
	@Page
	public List<BalExternalResultEqual>  selectList(BalExternalResultEqual balExternalResultEqual){
		return balExternalResultEqualDAO.selectList(balExternalResultEqual);
		
	}
	
	
}
