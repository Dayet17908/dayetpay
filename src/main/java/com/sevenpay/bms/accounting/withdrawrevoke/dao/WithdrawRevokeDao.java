package com.sevenpay.bms.accounting.withdrawrevoke.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.withdraw.bean.Withdraw;
import com.sevenpay.bms.accounting.withdraw.bean.WithdrawRequestBean;
import com.sevenpay.bms.accounting.withdrawrevoke.mapper.WithdrawRevokeMapper;

@Repository
public class WithdrawRevokeDao {
	
	@Autowired
	private WithdrawRevokeMapper withdrawMapper;
	
	/**
	 * 查询消费者提现信息
	 * @param withdrawRequestBean
	 * @return
	 */
	@Page
	public List<Withdraw> selectWithdrawRevokeList(WithdrawRequestBean withdrawRequestBean){
		return withdrawMapper.selectWithdrawRevokeList(withdrawRequestBean);
	}
	
}