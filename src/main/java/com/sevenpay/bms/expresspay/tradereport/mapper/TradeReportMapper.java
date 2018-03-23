package com.sevenpay.bms.expresspay.tradereport.mapper;

import java.util.List;

import com.sevenpay.bms.common.annotation.MapperScanCore;
import com.sevenpay.bms.expresspay.tradereport.bean.TradeReport;

@MapperScanCore
public interface TradeReportMapper {

	List<TradeReport> selectReportList(TradeReport tradeReport);
}
