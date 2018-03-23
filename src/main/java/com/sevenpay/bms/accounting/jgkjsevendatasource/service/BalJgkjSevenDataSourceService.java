package com.sevenpay.bms.accounting.jgkjsevendatasource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.jgkjsevendatasource.bean.BalJgkjSevenDataSource;
import com.sevenpay.bms.accounting.jgkjsevendatasource.dao.BalJgkjSevenDataSourceDao;

@Service
public class BalJgkjSevenDataSourceService {
	@Autowired
	private BalJgkjSevenDataSourceDao dao;

	public List<BalJgkjSevenDataSource> selectSevenDataSourceList(BalJgkjSevenDataSource sevenDataSource) {
		return dao.selectSevenDataSourceList(sevenDataSource);
	}

}
