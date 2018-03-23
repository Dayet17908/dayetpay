package com.sevenpay.bms.bal.accountResult.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.bal.accountResult.bean.BalInternalResultEqual;
import com.sevenpay.bms.bal.accountResult.mapper.BalInternalResultEqualMapper;



@Repository
public class BalInternalResultEqualDAO {
	
	@Autowired
	private BalInternalResultEqualMapper balInternalResultEqualMapper;
	
	@Page
	public  List<BalInternalResultEqual> selectList(BalInternalResultEqual record){
		return balInternalResultEqualMapper.selectList(record);
	}
}
