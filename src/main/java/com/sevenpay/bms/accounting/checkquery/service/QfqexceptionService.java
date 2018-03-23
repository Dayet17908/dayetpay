package com.sevenpay.bms.accounting.checkquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.checkquery.bean.Qfqexception;
import com.sevenpay.bms.accounting.checkquery.dao.QfqexceptionDao;

@Service
public class QfqexceptionService {
	@Autowired
	private QfqexceptionDao dao;
	/**
	 * 交广科技对账七分钱存疑报表
	 * @param exception
	 * @return
	 */
	public List<Qfqexception> selectQfqResultExceptionList(Qfqexception exception){
		return dao.selectQfqResultExceptionList(exception);
	}
	
	
}
