package com.sevenpay.bms.accounting.accountMaintain.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.accountMaintain.bean.BmsBaseBankAccount;
import com.sevenpay.bms.accounting.accountMaintain.mapper.BmsBaseBankAccountMapper;

@Repository
public class BmsBaseBankAccountDAO {

	@Autowired
	private BmsBaseBankAccountMapper bmsBaseBankAccountMapper;
	
	@Page
	public List<BmsBaseBankAccount> selectBaseBankAccountList(BmsBaseBankAccount record){
		return bmsBaseBankAccountMapper.selectBaseBankAccountList(record);
	}
}
