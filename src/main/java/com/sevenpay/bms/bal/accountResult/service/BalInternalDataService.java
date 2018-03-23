package com.sevenpay.bms.bal.accountResult.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.bal.accountResult.bean.BalInternalData;
import com.sevenpay.bms.bal.accountResult.dao.BalInternalDataDAO;


@Service
public class BalInternalDataService {
	
	@Autowired
	private BalInternalDataDAO balInternalDataDAO;
	
	public  List<BalInternalData> selectList(BalInternalData balInternalData){
		return balInternalDataDAO.selectList(balInternalData);
	}
}
