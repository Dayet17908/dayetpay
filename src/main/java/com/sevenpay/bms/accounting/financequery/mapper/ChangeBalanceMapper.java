package com.sevenpay.bms.accounting.financequery.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.financequery.bean.ChangeBalance;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface ChangeBalanceMapper {
	public List<ChangeBalance>changeBalanceList(ChangeBalance changeBalance);
	public List<ChangeBalance>changeBalanceSum(ChangeBalance changeBalance);
	
}
