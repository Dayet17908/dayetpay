package com.sevenpay.bms.accounting.jgkjsevendatasource.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.jgkjsevendatasource.bean.BalJgkjSevenDataSource;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface BalJgkjSevenDataSourceMapper {	
	public List<BalJgkjSevenDataSource> selectSevenDataSourceList(BalJgkjSevenDataSource sevenDataSource);
}
