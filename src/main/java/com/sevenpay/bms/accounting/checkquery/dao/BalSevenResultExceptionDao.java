package com.sevenpay.bms.accounting.checkquery.dao;

import java.util.List;

import javax.annotation.Resource;

import org.gyzb.platform.web.page.Page;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.checkquery.bean.BalSevenResultEqual;
import com.sevenpay.bms.accounting.checkquery.bean.BalSevenResultException;
import com.sevenpay.bms.accounting.checkquery.mapper.BalSevenResultEqualMapper;
import com.sevenpay.bms.accounting.checkquery.mapper.BalSevenResultExceptionMapper;

@Repository
public class BalSevenResultExceptionDao {
	@Resource
	private BalSevenResultExceptionMapper mapper;
	@Resource
	private BalSevenResultEqualMapper equalMapper;
	
	@Page
	public List<BalSevenResultException> selectErrorList(BalSevenResultException resultException){
		return mapper.selectErrorList(resultException);
	}
	
	@Page
	public List<BalSevenResultEqual> selectFitList(BalSevenResultEqual resultEqual){
		return equalMapper.selectFitList(resultEqual);
	}
	
}
