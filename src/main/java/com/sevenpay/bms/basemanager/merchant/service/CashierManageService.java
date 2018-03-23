package com.sevenpay.bms.basemanager.merchant.service;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.basemanager.merchant.bean.CashierInfo;
import com.sevenpay.bms.basemanager.merchant.bean.StoreManage;
import com.sevenpay.bms.basemanager.merchant.bean.TdLoginUserInfo;
import com.sevenpay.bms.basemanager.merchant.mapper.CashierManageMapper;

/**
 * 商户注册服务类
 * 
 * @author dayet
 * @data 2015-06-8
 * 
 */
@Service
public class CashierManageService {
	@Autowired
	CashierManageMapper cashierManageMapper;
	
	/**收银员管理 */
	@Page
	public List<CashierInfo> getCashierList(CashierInfo cashierInfo) {
		return cashierManageMapper.getCashierList(cashierInfo);
		
	}
	@Page
	public List<CashierInfo> getMyCashierList(CashierInfo cashierInfo){
		return cashierManageMapper.getMyCashierList(cashierInfo);
	}

	public void addCashier(CashierInfo cashierInfo) {
		cashierManageMapper.addCashier(cashierInfo);
		
	}

	public void deleteCashier(String onlyId) {
		cashierManageMapper.deleteCashier(onlyId);
	}

	public TdLoginUserInfo getCustInfoByMobile(String mobile) {
		// TODO Auto-generated method stub
		return cashierManageMapper.getCustInfoByMobile(mobile);
	}

	public void updateCashier(CashierInfo cashierInfo) {
		// TODO Auto-generated method stub
		cashierManageMapper.updateCashier(cashierInfo);
	}
	
	public CashierInfo getMyCashierRef(String onlyId){
		return cashierManageMapper.getMyCashierRef(onlyId);
	}
	public List<CashierInfo> getCashierListExcept(CashierInfo cashierInfo) {
		// TODO Auto-generated method stub
		return cashierManageMapper.getCashierListExcept(cashierInfo);
	}
	
	public List<StoreManage> selectStore(String custId){
		return cashierManageMapper.selectStore(custId);
	}
	
	
}
