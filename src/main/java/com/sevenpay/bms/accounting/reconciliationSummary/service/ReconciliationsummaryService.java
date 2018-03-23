package com.sevenpay.bms.accounting.reconciliationSummary.service;

import java.util.List;

import com.sevenpay.bms.accounting.reconciliationSummary.bean.ReconDetail;
import com.sevenpay.bms.accounting.reconciliationSummary.bean.ReconDiff;
import com.sevenpay.bms.accounting.reconciliationSummary.bean.Summary;


public interface ReconciliationsummaryService {

	//对账列表
	public List<Summary> selectSummary(ReconDetail reconDetail);
	
	
	//交易明细列表
	public List<ReconDetail> selectByReconResult(ReconDetail reconDetail);

	//差错列表
	public List<ReconDiff> selectByErrorDisposal(ReconDiff reconDiff);
}
