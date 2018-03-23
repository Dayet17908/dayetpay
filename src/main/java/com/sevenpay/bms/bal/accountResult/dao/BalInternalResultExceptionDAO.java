package com.sevenpay.bms.bal.accountResult.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.bal.accountResult.bean.BalInternalResultException;
import com.sevenpay.bms.bal.accountResult.mapper.BalInternalResultExceptionMapper;


@Repository
public class BalInternalResultExceptionDAO {
	
	@Autowired
	private BalInternalResultExceptionMapper balInternalResultExceptionMapper;
	
	@Page
	public  List<BalInternalResultException>  selectList(BalInternalResultException balInternalResultException){
		return balInternalResultExceptionMapper.selectList(balInternalResultException);
	}
}
