package com.sevenpay.bms.accounting.balunionpayuniondatasource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.balunionpayuniondatasource.bean.BalUnionpaySevenDataSource;
import com.sevenpay.bms.accounting.balunionpayuniondatasource.dao.BalUnionpaySevenDataSourceDao;

@Service
public class BalUnionpaySevenDataSourceService {
	@Autowired
	private BalUnionpaySevenDataSourceDao dao;

	public List<BalUnionpaySevenDataSource> selectUnionpaySevenDataSourceList(BalUnionpaySevenDataSource source) {
		return dao.selectUnionpaySevenDataSourceList(source);
	}

}
