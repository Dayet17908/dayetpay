package com.sevenpay.bms.accounting.bmsexception.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.bmsexception.bean.BmsException;
import com.sevenpay.bms.accounting.bmsexception.mapper.BmsExceptionMapper;

@Repository
public class BmsExceptionDao {
	@Autowired
	private BmsExceptionMapper bmsExceptionMapper;

	@Page
	public List<BmsException> selectBmsExceptionList(BmsException queryBean) {
		return bmsExceptionMapper.selectBmsExceptionList(queryBean);
	}
}
