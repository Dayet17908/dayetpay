package com.sevenpay.bms.bal.accountResult.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.bal.accountResult.bean.BalExternalResultEqual;
import com.sevenpay.bms.bal.accountResult.mapper.BalExternalResultEqualMapper;


@Repository
public class BalExternalResultEqualDAO {
	
	
	@Autowired
	private BalExternalResultEqualMapper balExternalResultEqualMapper;
	
	@Page
	public List<BalExternalResultEqual> selectList(BalExternalResultEqual record){
		return balExternalResultEqualMapper.selectList(record);
		
	}
	
	

}
