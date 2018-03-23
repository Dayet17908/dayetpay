package com.sevenpay.bms.bal.accountResult.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.bal.accountResult.bean.BalInternalResultException;
import com.sevenpay.bms.bal.accountResult.dao.BalInternalResultExceptionDAO;





@Service
public class BalInternalResultExceptionService {
	
	@Autowired
	private BalInternalResultExceptionDAO balInternalResultExceptionDAO;
	
	public  List<BalInternalResultException> selectList(BalInternalResultException balInternalResultException){
		return balInternalResultExceptionDAO.selectList(balInternalResultException);
	}
}
