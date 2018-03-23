package com.sevenpay.bms.accounting.balunionpayuniondatasource.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.balunionpayuniondatasource.bean.BalUnionpaySevenDataSource;
import com.sevenpay.bms.accounting.balunionpayuniondatasource.mapper.BalUnionpaySevenDataSourceMapper;

@Repository
public class BalUnionpaySevenDataSourceDao {
	@Autowired
	private BalUnionpaySevenDataSourceMapper mapper;
	
	@Page
	public List<BalUnionpaySevenDataSource> selectUnionpaySevenDataSourceList(BalUnionpaySevenDataSource source){
		return mapper.selectUnionpaySevenDataSourceList(source);
	}
}
