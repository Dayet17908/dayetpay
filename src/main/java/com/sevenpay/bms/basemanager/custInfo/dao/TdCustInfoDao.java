package com.sevenpay.bms.basemanager.custInfo.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.custInfo.bean.TdCustInfo;
import com.sevenpay.bms.basemanager.custInfo.mapper.TdCustInfoMapper;

/**
 * dao层，一般分页需要
 * 
 * @project sevenpay-bms-web
 * @fileName TdCustInfoDao.java
 * @memo 
 */
@Repository
public class TdCustInfoDao{

	@Autowired
	private TdCustInfoMapper custInfoMapper;
	
	/**
	 * 分页查询消费者列表
	 * @return
	 */
	@Page
	public List<TdCustInfo> selectCustInfos(TdCustInfo custInfo) {
		return custInfoMapper.selectCustInfos(custInfo);
	}
	
	/**
	 * 是否有权限查看所有订单
	 * @param userId
	 * @return
	 */
	public String isAllList(String userId){
		return custInfoMapper.isAllList(userId);
	}
}


