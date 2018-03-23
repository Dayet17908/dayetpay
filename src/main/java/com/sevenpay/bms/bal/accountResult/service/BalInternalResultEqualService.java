package com.sevenpay.bms.bal.accountResult.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.bal.accountResult.bean.BalInternalResultEqual;
import com.sevenpay.bms.bal.accountResult.dao.BalInternalResultEqualDAO;

@Service
public class BalInternalResultEqualService {
	
	@Autowired
	private BalInternalResultEqualDAO balInternalResultEqualDAO;
	
	public  List<BalInternalResultEqual> selectList(BalInternalResultEqual balInternalResultEqual){
		return balInternalResultEqualDAO.selectList(balInternalResultEqual);
	}
}
