package com.sevenpay.bms.basemanager.aggregatepayment.merchant.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.aggregatepayment.merchant.bean.TdMerchantChannel;
import com.sevenpay.bms.basemanager.aggregatepayment.merchant.mapper.TdMerchantChannelOperationMapper;
import com.sevenpay.bms.basemanager.aggregatepayment.merchant.mapper.TdMerchantChannelSelectMapper;

@Repository
public class TdMerchantChannelDAO {

	@Autowired
	private TdMerchantChannelSelectMapper tdMerchantChannelSelectMapper;
	
	@Autowired
	private TdMerchantChannelOperationMapper tdMerchantChannelOperationMapper;
	
	/**
	 * 查询商户渠道金额限制列表
	 * @param channel
	 * @return
	 */
	@Page
	public List<TdMerchantChannel> selectMerchantChannel(TdMerchantChannel channel){
		return tdMerchantChannelSelectMapper.selectMerchantChannel(channel);
	}
	
	/**
	 * 增加商户渠道金额限制
	 * @param channel
	 */
	public void insertMerchantChannel(TdMerchantChannel channel){
			tdMerchantChannelOperationMapper.insertMerchantChannel(channel);
	}
	
	/**
	 * 修改商户渠道金额限制
	 * @param channel
	 * @return
	 */
	public int  updateMerchantChannel(TdMerchantChannel channel){
		return tdMerchantChannelOperationMapper.updateMerchantChannel(channel);
	}
	
	/**
	 * 删除商户渠道金额限制
	 * @param channel
	 * @return
	 */
	public int deleteMerchantChannel(TdMerchantChannel channel){
		return tdMerchantChannelOperationMapper.deleteMerchantChannel(channel);
	}
}
