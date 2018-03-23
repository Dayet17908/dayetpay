package com.sevenpay.bms.basemanager.agent.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.agent.bean.AgentSignBean;
import com.sevenpay.bms.basemanager.agent.bean.AgentSignVO;
import com.sevenpay.bms.basemanager.agent.bean.CustVo;
import com.sevenpay.bms.basemanager.agent.mapper.AgentSignMapper;

@Repository
public class AgentSignDAO {
	
	@Autowired
	private AgentSignMapper mapper;
	//获取代理商申请信息
	@Page
	public List<AgentSignBean> getSignList(AgentSignBean signBean) {
		return mapper.getSignList(signBean);
	}

	//根据custId查找客户信息
	public CustVo findCustInfo(String custId){
		return mapper.findCustInfo(custId);
	}
	
	//签约申请审核不通过
	public void auditNotPass(String custId,String memo,String auditUserId) {
		mapper.auditNotPass(custId,memo,auditUserId);
		/*mapper.updateCustInfoAgentFlag(custId,"1");*/
	}
	
	//签约申请审核通过
	public void auditPass(String custId,String auditUserId) {
		
		mapper.auditPass(custId,auditUserId);
		/*mapper.updateCustInfoAgentFlag(custId,"0");*/
	}

	public AgentSignVO findSignInfo(String custId) {
		
		return mapper.findSignInfo(custId);
	}

	//查找域名证书扫描件
	public String findScanPath(String custId) {
		// TODO Auto-generated method stub
		return mapper.findScanPath(custId);
	}
}
