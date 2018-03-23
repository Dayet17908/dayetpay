package com.sevenpay.bms.basemanager.merchantwithdraw.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.merchantwithdraw.bean.MerchantWithdraw;
import com.sevenpay.bms.basemanager.merchantwithdraw.mapper.MerchantWithdrawMapper;

@Repository
public class MerchantWithdrawDao {
	
	@Autowired
	private MerchantWithdrawMapper merchantWithdrawMapper;
	@Page
	public List<MerchantWithdraw> selectMerchantWithdrawList(MerchantWithdraw withdrawBean) {
		return merchantWithdrawMapper.selectMerchantWithdrawList(withdrawBean);
	}

}
