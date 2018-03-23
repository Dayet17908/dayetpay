package com.sevenpay.bms.accounting.jgkjdatasource.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.jgkjdatasource.bean.BalJgkjDataSource;
import com.sevenpay.bms.accounting.jgkjdatasource.mapper.BalJgkjDataSourceMapper;
@Repository
public class BalJgkjDataSourceDao {
	
	@Autowired
	private BalJgkjDataSourceMapper mapper;
	
	@Page
	public List<BalJgkjDataSource> selectZytDataSourceList(BalJgkjDataSource zytDataSource){
		return mapper.selectZytDataSourceList(zytDataSource);
	}
}
