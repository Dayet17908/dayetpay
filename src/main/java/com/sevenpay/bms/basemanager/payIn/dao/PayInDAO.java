package com.sevenpay.bms.basemanager.payIn.dao;

import java.util.List;

import javax.annotation.Resource;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.payIn.bean.PayIn;
import com.sevenpay.bms.basemanager.payIn.mapper.PayInMapper;
import com.sevenpay.bms.basemanager.payIn.service.PayInService;

/**
 * dao层，一般分页需要
 * 
 * @project sevenpay-bms-web
 * @fileName PayInDAO.java
 * @author Dayet
 * @date 2017年11月28日日
 * @memo 
 */
@Repository
public class PayInDAO{

	@Autowired
	private PayInMapper payInMapper;
	@Resource
	private PayInService payInService;
	
	/**
	 * 分页查询代付垫资费率信息列表
	 * @return
	 */
	@Page
	public List<PayIn> selectPayIn(PayIn payIn) {
		return payInMapper.selectPayIns(payIn);
	}
}


