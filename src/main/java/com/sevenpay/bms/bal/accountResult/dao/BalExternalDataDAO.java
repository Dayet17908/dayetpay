package com.sevenpay.bms.bal.accountResult.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.bal.accountResult.bean.BalExternalData;
import com.sevenpay.bms.bal.accountResult.mapper.BalExternalDataMapper;


@Repository
public class BalExternalDataDAO {

	
	@Autowired
	private BalExternalDataMapper balExternalDataMapper;
	
	@Page
	public List<BalExternalData> selectList(BalExternalData balExternalData) {
		
		return balExternalDataMapper.selectList(balExternalData);
	}

}
