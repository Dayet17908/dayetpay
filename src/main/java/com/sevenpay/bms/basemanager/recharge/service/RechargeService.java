package com.sevenpay.bms.basemanager.recharge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.basemanager.recharge.bean.RechargeBean;
import com.sevenpay.bms.basemanager.recharge.bean.RechargeExcel;
import com.sevenpay.bms.basemanager.recharge.dao.RechargeDAO;
import com.sevenpay.bms.basemanager.recharge.mapper.RechargeMapper;

@Service
public class RechargeService {
	
	@Autowired
	private RechargeMapper rechargeMapper;
	
	/**
	 * 充值查询
	 */
	@Autowired
	private RechargeDAO  rechargeDao;
	public List<RechargeBean> selectRecharge(RechargeBean recharge){
		return rechargeDao.selectRecharge(recharge);
	}
	
	/**
	 * 查询充值excel信息
	 * @param recharge
	 * @return
	 */
	public List<RechargeExcel> selectRechargeExcel(RechargeBean recharge){
		List<RechargeExcel>  excels = rechargeMapper.selectRechargeExcel(recharge);
		return excels;
		
	}
	
	
}
