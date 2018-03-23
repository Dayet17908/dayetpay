package com.sevenpay.bms.accounting.withdrawrevoke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.withdraw.bean.Withdraw;
import com.sevenpay.bms.accounting.withdraw.bean.WithdrawExcel;
import com.sevenpay.bms.accounting.withdraw.bean.WithdrawRequestBean;
import com.sevenpay.bms.accounting.withdrawrevoke.dao.WithdrawRevokeDao;
import com.sevenpay.bms.accounting.withdrawrevoke.mapper.WithdrawRevokeMapper;
@Service
public class WithdrawRevokeService {
	
	@Autowired
	private WithdrawRevokeDao withdrawRevokeDao;
	
	@Autowired
	private WithdrawRevokeMapper withdrawRevokeMapper;

	/**
	 * 提现撤销列表
	 * 
	 * @param withdrawRequestBean
	 * @return
	 */
	public List<Withdraw> selectWithdrawRevokeList(WithdrawRequestBean withdrawRequestBean) {
		return withdrawRevokeDao.selectWithdrawRevokeList(withdrawRequestBean);
	}

	/**
	 * 提现撤销信息
	 * 
	 * @param withdrawRequestBean
	 * @return
	 */
	public List<WithdrawExcel> selectWithdrawRevokeExcel(WithdrawRequestBean withdrawRequestBean) {
		return withdrawRevokeMapper.selectWithdrawRevokeExcel(withdrawRequestBean);
	}
}
