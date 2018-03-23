package com.sevenpay.bms.accounting.exception.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.exception.base.bean.Operation;
import com.sevenpay.bms.accounting.exception.dao.operdeal.mapper.OperationExceptionMapper;
import com.sevenpay.bms.accounting.exception.dao.operdealflow.bean.OperationExceptionFlow;

/**
 * @project sevenpay-bms-web
 * @fileName OperationExceptionDao.java
 * @author huiquan.ma
 * @date 2015年10月29日
 * @memo 
 */
@Repository
public class OperationExceptionDao {

	@Autowired
	private OperationExceptionMapper operationExceptionMapper;
	
	@Page
	public List<Operation> selectOperationExceptionListByPage(Operation selectBean) {
		return operationExceptionMapper.selectExceptionList(selectBean);
	}
	
	
	@Page
	public List<OperationExceptionFlow> queryOperationRecord(String operId) {
		return operationExceptionMapper.queryOperationRecord(operId);
	}
}


