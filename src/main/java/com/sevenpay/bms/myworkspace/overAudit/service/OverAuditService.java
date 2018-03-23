package com.sevenpay.bms.myworkspace.overAudit.service;

import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.myworkspace.overAudit.bean.OverAuditBean;
import com.sevenpay.bms.myworkspace.overAudit.mapper.OverAuditMapper;


@Service
public class OverAuditService {

	@Resource
	private HistoryService historyService;
	
	@Autowired
	private OverAuditMapper overAuditMapper;
	
	
	/**
	 * 我的已审核
	 * @param userId
	 * @return
	 */
	@Page
	public List<OverAuditBean> getOverAudit(OverAuditBean bean){
	
		return overAuditMapper.getOverAudit(bean);
	}
}
