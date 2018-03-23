package com.sevenpay.bms.accounting.unnamedProcessing.clearJgkjregister.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.unnamedProcessing.clearJgkjregister.bean.ClearJgkjRegister;
import com.sevenpay.bms.accounting.unnamedProcessing.clearJgkjregister.mapper.ClearJgkjRegisterMapper;

@Repository
public class ClearJgkjRegisterDao {
	
	@Autowired
	private ClearJgkjRegisterMapper mapper;
	
	@Page
	public List<ClearJgkjRegister> selectClearJgkjRegisterByList(ClearJgkjRegister clearJgkjRegister){
		return mapper.selectClearJgkjRegisterByList(clearJgkjRegister);
	}
}
