package com.sevenpay.bms.basemanager.withdrawControl.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.withdrawControl.bean.WithdrawControl;
import com.sevenpay.bms.basemanager.withdrawControl.mapper.WithdrawControlMapper;

@Repository
public class WithdrawControlDAO {
	
	@Autowired
	private WithdrawControlMapper withdrawControlMapper;
	
	@Page
	public List<WithdrawControl> selectAll(WithdrawControl withdrawControl){
		return withdrawControlMapper.selectAll(withdrawControl);
	}
}
