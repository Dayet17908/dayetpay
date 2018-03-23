package com.sevenpay.bms.basemanager.tradesummary.mapper;

import java.util.List;

import com.sevenpay.bms.basemanager.tradesummary.bean.TransSummaryBean;
import com.sevenpay.bms.common.annotation.MapperScanSub;

@MapperScanSub
public interface TransSummaryMapper {

	List<TransSummaryBean> selectTradeSummary(TransSummaryBean queryBean);
	
	
	List<TransSummaryBean> selectTradeSummaryExcel(TransSummaryBean queryBean);

}
