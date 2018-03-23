package com.sevenpay.bms.bal.accountResult.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.bal.accountResult.bean.BalExternalResultException;
import com.sevenpay.bms.bal.accountResult.mapper.BalExternalResultExceptionMapper;


@Repository
public class BalExternalResultExceptionDAO {
	
	
	@Autowired
	private BalExternalResultExceptionMapper balExternalResultExceptionMapper;
	
	@Page
	public  List<BalExternalResultException>  selectList(BalExternalResultException balExternalResultException){
		return balExternalResultExceptionMapper.selectList(balExternalResultException);
	}
	
}
