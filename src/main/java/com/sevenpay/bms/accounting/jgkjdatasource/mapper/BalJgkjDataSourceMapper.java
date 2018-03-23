package com.sevenpay.bms.accounting.jgkjdatasource.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.jgkjdatasource.bean.BalJgkjDataSource;
import com.sevenpay.bms.common.annotation.MapperScanCore;
@MapperScanCore
public interface BalJgkjDataSourceMapper {	
	public List<BalJgkjDataSource> selectZytDataSourceList(BalJgkjDataSource zytDataSource);
}
