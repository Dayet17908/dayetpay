package com.sevenpay.bms.unionPay.tradedoc.mapper;

import java.util.List;

import com.sevenpay.bms.common.annotation.MapperScanCore;
import com.sevenpay.bms.unionPay.tradedoc.bean.TradeDoc;

@MapperScanCore
public interface TradeDocMapper {
	List<TradeDoc> selectDocList(TradeDoc tradeDoc);
}
