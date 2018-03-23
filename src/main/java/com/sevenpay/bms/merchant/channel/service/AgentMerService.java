package com.sevenpay.bms.merchant.channel.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.merchant.channel.bean.AgentMerInfo;
import com.sevenpay.bms.merchant.channel.dao.AgentMerDao;
import com.sevenpay.bms.merchant.channel.mapper.AgentMerMapper;

/**
 * 服务层
 * 
 * @project sevenpay-bms-web
 * @date 2018年1月29日
 * @memo 
 */
@Service
public class AgentMerService {
	

	@Autowired
	private AgentMerMapper agentMerMapper;
	
	@Autowired
	private AgentMerDao agentMerDao;
	
	/**
	 * 增加代理商户渠道
	 * @return
	 */
	public int insertAgentMerInfo(AgentMerInfo channleAgentMerInfo){
		
		if(null == channleAgentMerInfo){
			throw new IllegalArgumentException("对象为空");
		}
		
		return agentMerMapper.insertAgentMerInfo(channleAgentMerInfo);
	}
	
	/**
	 * 更新代理渠道信息
	 * @param role
	 */
	public void updatechannleAgentMerInfo(AgentMerInfo channleAgentMerInfo){
		
		if(null == channleAgentMerInfo){
			throw new IllegalArgumentException("对象为空");
		}
		
		if(StringUtils.isEmpty(channleAgentMerInfo.getChannelCode())){
			throw new IllegalArgumentException("代理编号为空");
		}
		
		if(StringUtils.isEmpty(channleAgentMerInfo.getMerCustId())){
			throw new IllegalArgumentException("商户ID为空");
		}
		
		if(StringUtils.isEmpty(channleAgentMerInfo.getMerNo())){
			throw new IllegalArgumentException("商户号为空");
		}
	
		agentMerMapper.updateChannleAgentMerInfo(channleAgentMerInfo);
		
	}
	
	/**
	 * 删除代理渠道详情
	 * @param bankCode
	 */
	public void deleteAgentMerInfoByCustId(AgentMerInfo agentMerInfo){
		if(StringUtils.isEmpty(agentMerInfo.getMerCustId())){
			throw new IllegalArgumentException("商户编号为空");
		}
		agentMerMapper.deleteChannleAgentMerInfoBymerCustId(agentMerInfo);
	}
   
	/**
     * 查询所有代理渠道类别
     * @return
     */
	public List<AgentMerInfo> selectAllChannleAgentMerInfo() {
		
		return agentMerMapper.selectAllChannleAgentMerInfo();
	}
	
	public AgentMerInfo selectAllChannleAgentMerInfoBychannelcode(String channlCode) {
		
		return agentMerMapper.selectAgentMerInfoByChannlCode(channlCode);
	}
	/**
	 * 条件查询
	 * @param agentMerInfo
	 * @return
	 */
	public List<AgentMerInfo> selectChannleAgentMerInfoByPrimaryKey(AgentMerInfo agentMerInfo) {
		return agentMerMapper.selectChannleAgentMerInfoByPrimaryKey(agentMerInfo);
	}

}
