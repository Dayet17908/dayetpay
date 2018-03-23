package com.sevenpay.bms.merchant.channel.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.merchant.channel.bean.AgentMerInfo;
import com.sevenpay.bms.merchant.channel.mapper.AgentMerMapper;

/**
 * dao层，一般分页需要
 * 
 * @project sevenpay-bms-web
 * @memo 
 */
@Repository
public class AgentMerDao{

	@Autowired
	private AgentMerMapper channleAgentMerMapperDao;
	
	/**
	 * 分页查询银行列表
	 * @return
	 */
	@Page
	public List<AgentMerInfo> selectAllChannleAgentMerInfo() {
		return channleAgentMerMapperDao.selectAllChannleAgentMerInfo();
	}
	@Page
	public List<AgentMerInfo> selectChannleAgentMerInfoByPrimaryKey(AgentMerInfo agentMerInfo) {
		return channleAgentMerMapperDao.selectChannleAgentMerInfoByPrimaryKey(agentMerInfo);
	}
}


