package com.sevenpay.bms.accounting.balunionpayuniondatasource.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.balunionpayuniondatasource.bean.BalUnionpaySevenDataSource;
import com.sevenpay.bms.common.annotation.MapperScanCore;
@MapperScanCore
public interface BalUnionpaySevenDataSourceMapper {
	
	public List<BalUnionpaySevenDataSource> selectUnionpaySevenDataSourceList(BalUnionpaySevenDataSource source);
}
