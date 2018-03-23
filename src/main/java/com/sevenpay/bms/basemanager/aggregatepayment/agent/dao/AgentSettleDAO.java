package com.sevenpay.bms.basemanager.aggregatepayment.agent.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.aggregatepayment.agent.bean.AgentSettleBean;
import com.sevenpay.bms.basemanager.aggregatepayment.agent.bean.AgentSettleDetailBean;
import com.sevenpay.bms.basemanager.aggregatepayment.agent.mapper.AgentMapper;

@Repository
public class AgentSettleDAO {

	@Autowired AgentMapper agentMapper;
	@Page
	public List<AgentSettleBean> getAgentSettleList(AgentSettleBean queryBean) {
		// TODO Auto-generated method stub
		return agentMapper.getAgentSettleList(queryBean);
	}

	public AgentSettleDetailBean getDetailBySettleId(String settleId) {
		// TODO Auto-generated method stub
		return agentMapper.getDetailBySettleId(settleId);
	}

	public List<AgentSettleBean> getAgentSettleListExport(
			AgentSettleBean queryBean) {
		// TODO Auto-generated method stub
		return agentMapper.getAgentSettleList(queryBean);
	}
	

}
