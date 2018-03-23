package com.sevenpay.bms.accounting.reconciliationSummary.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.reconciliationSummary.bean.ReconDetail;
import com.sevenpay.bms.accounting.reconciliationSummary.bean.ReconDiff;
import com.sevenpay.bms.accounting.reconciliationSummary.bean.Summary;
import com.sevenpay.bms.common.annotation.MapperScanCombinedmaster;

@MapperScanCombinedmaster
public interface ReconciliationSummaryMapper {
	
	
	//对账汇总列表
	public List<Summary> selectSummary(ReconDetail reconDetail); 
	
	//交易明细列表
	public List<ReconDetail> selectByReconResult(ReconDetail reconDetail); 
	
	//差错列表
	public List<ReconDiff> selectByErrorDisposal(ReconDiff reconDiff);
	
	//差错列表
	void updateByErrorDisposal(ReconDiff reconDiff);
}
