package com.sevenpay.bms.basemanager.aggregatepayment.agent.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.aggregatepayment.agent.bean.AgentCollectDailyBean;
import com.sevenpay.bms.basemanager.aggregatepayment.agent.mapper.AgentMapper;

@Repository
public class AgentCollectDAO {

	@Autowired AgentMapper agentMapper;

	@Page
	public List<AgentCollectDailyBean> getAgentCollectDailyList(
			AgentCollectDailyBean queryBean) {
		// TODO Auto-generated method stub
		return agentMapper.getAgentCollectDailyList(queryBean);
	}

	public List<AgentCollectDailyBean> getAgentCollectDailyListExport(
			AgentCollectDailyBean queryBean) {
		// TODO Auto-generated method stub
		return agentMapper.getAgentCollectDailyListExport(queryBean);
	}

}
