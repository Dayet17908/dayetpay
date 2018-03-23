package com.sevenpay.bms.accounting.unnamedProcessing.clearjgkjtrade.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.unnamedProcessing.clearjgkjtrade.bean.ClearJgkjTrade;
import com.sevenpay.bms.common.annotation.MapperScanCore;
@MapperScanCore
public interface ClearJgkjTradeMapper {
	List<ClearJgkjTrade> selectClearJgkjTradeList(ClearJgkjTrade clearJgkjTrade);
	
}
