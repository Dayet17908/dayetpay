package com.sevenpay.bms.accounting.withdraw.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.withdraw.bean.Withdraw;
import com.sevenpay.bms.accounting.withdraw.bean.WithdrawRequestBean;
import com.sevenpay.bms.accounting.withdraw.mapper.WithdrawMapper;

@Repository
public class WithdrawDAO {
	
	@Autowired
	private WithdrawMapper withdrawMapper;
	
	/**
	 * 查询消费者提现信息
	 * @param withdrawRequestBean
	 * @return
	 */
	@Page
	public List<Withdraw> selectCustomerWithdrawList(WithdrawRequestBean withdrawRequestBean){
		return withdrawMapper.selectCustomerWithdrawList(withdrawRequestBean);
	}
	
}