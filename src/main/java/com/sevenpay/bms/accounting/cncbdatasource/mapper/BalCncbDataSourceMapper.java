package com.sevenpay.bms.accounting.cncbdatasource.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.cncbdatasource.bean.BalCncbDataSource;
import com.sevenpay.bms.common.annotation.MapperScanCombinedmaster;
@MapperScanCombinedmaster
public interface BalCncbDataSourceMapper {	
	public List<BalCncbDataSource> selectCncbDataSourceList(BalCncbDataSource cncbDataSource);
}
