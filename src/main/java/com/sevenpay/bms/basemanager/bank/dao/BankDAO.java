package com.sevenpay.bms.basemanager.bank.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.bank.bean.Bank;
import com.sevenpay.bms.basemanager.bank.mapper.BankMapper;

/**
 * dao层，一般分页需要
 * 
 * @project sevenpay-bms-web
 * @fileName BankDAO.java
 * @author Dayet
 * @date 2015年5月13日
 * @memo 
 */
@Repository
public class BankDAO{

	@Autowired
	private BankMapper BankMapper;
	
	/**
	 * 分页查询银行列表
	 * @return
	 */
	@Page
	public List<Bank> selectBanks(Bank bank) {
		return BankMapper.selectBanks(bank);
	}
}


