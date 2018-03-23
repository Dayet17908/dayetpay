package com.sevenpay.bms.bal.accountResult.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.bal.accountResult.bean.BalInternalData;
import com.sevenpay.bms.bal.accountResult.mapper.BalInternalDataMapper;



@Repository
public class BalInternalDataDAO {
	
	@Autowired
	private BalInternalDataMapper balInternalDataMapper;
	
	@Page
	public  List<BalInternalData>  selectList(BalInternalData balInternalData){
		return balInternalDataMapper.selectList(balInternalData);
	}
}
