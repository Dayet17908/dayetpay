package com.sevenpay.bms.accounting.reconciliationSummary.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.reconciliationSummary.bean.ReconDetail;
import com.sevenpay.bms.accounting.reconciliationSummary.bean.ReconDiff;
import com.sevenpay.bms.accounting.reconciliationSummary.bean.Summary;
import com.sevenpay.bms.accounting.reconciliationSummary.mapper.ReconciliationSummaryMapper;

@Repository
public class ReconciliationSummaryDao {
	
	@Autowired
	private ReconciliationSummaryMapper reconciliationSummaryMapper;
	
	
	//对账汇总
	@Page
	public List<Summary> selectSummary(ReconDetail reconDetail){
		return reconciliationSummaryMapper.selectSummary(reconDetail);
	}
	
	//交易明细
	@Page
	public List<ReconDetail> selectByReconResult(ReconDetail reconDetail){
		return reconciliationSummaryMapper.selectByReconResult(reconDetail);
	}
	
	//差错列表
	@Page
	public List<ReconDiff> selectByErrorDisposal(ReconDiff reconDiff){
		return reconciliationSummaryMapper.selectByErrorDisposal(reconDiff);
	} 
}
