package com.sevenpay.bms.accounting.balunionpayuniondatasource.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.balunionpayuniondatasource.bean.BalUnionpayUnionDataSource;
import com.sevenpay.bms.accounting.balunionpayuniondatasource.mapper.BalUnionpayUnionDataSourceMapper;

@Repository
public class BalUnionpayUnionDataSourceDao {
	@Autowired
	private BalUnionpayUnionDataSourceMapper mapper;
	
	@Page
	public List<BalUnionpayUnionDataSource> selectUnionpayUnionDataSourceList(BalUnionpayUnionDataSource source){
		return mapper.selectUnionpayUnionDataSourceList(source);
	}
}
