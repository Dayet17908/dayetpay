package com.sevenpay.bms.accounting.balunionpayuniondatasource.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.balunionpayuniondatasource.bean.BalUnionpayUnionDataSource;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface BalUnionpayUnionDataSourceMapper {
	public List<BalUnionpayUnionDataSource> selectUnionpayUnionDataSourceList(BalUnionpayUnionDataSource source);
	
}
