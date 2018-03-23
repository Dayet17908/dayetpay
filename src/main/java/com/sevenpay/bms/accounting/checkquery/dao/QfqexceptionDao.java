package com.sevenpay.bms.accounting.checkquery.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.checkquery.bean.Qfqexception;
import com.sevenpay.bms.accounting.checkquery.mapper.QfqexceptionMapper;
@Repository
public class QfqexceptionDao {
	@Autowired
	private QfqexceptionMapper mapper;
	@Page
	public List<Qfqexception> selectQfqResultExceptionList(Qfqexception exception){
		return mapper.selectQfqResultExceptionList(exception);
	}
}
