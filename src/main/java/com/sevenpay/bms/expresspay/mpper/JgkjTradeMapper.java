package com.sevenpay.bms.expresspay.mpper;

import java.util.List;

import com.sevenpay.bms.common.annotation.MapperScanCore;
import com.sevenpay.bms.expresspay.tradeResult.bean.JgkjTrade;

@MapperScanCore
public interface JgkjTradeMapper {

	List<JgkjTrade> queryJgkjTradeList(JgkjTrade queryBean);
}
