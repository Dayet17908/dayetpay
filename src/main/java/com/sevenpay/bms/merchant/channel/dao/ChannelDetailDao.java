package com.sevenpay.bms.merchant.channel.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.merchant.channel.bean.ChannelDetailBean;
import com.sevenpay.bms.merchant.channel.bean.UpdateChannelDetailBean;
import com.sevenpay.bms.merchant.channel.mapper.ChannelDetailMapper;
/**
 * 网关通道-商户详情管理dao
 * @author hongjiagui
 *
 */
@Repository
public class ChannelDetailDao {

	@Autowired
	private ChannelDetailMapper channelDetailMapper;
	
	/**
	 * 根据查询条件获取商户详情列表
	 */
	@Page
	public List<ChannelDetailBean> listChannelDetail(ChannelDetailBean queryBean){
		return channelDetailMapper.listChannelDetail(queryBean);		
	}
	
	/**
	 * 保存商户详情信息
	 */
	public void saveChannelDetail(ChannelDetailBean channelDetailBean) {
		channelDetailMapper.saveChannelDetail(channelDetailBean);
	}
	
	/**
	 * 修改商户详情信息
	 */
	public void updateChannelDetail(UpdateChannelDetailBean channelDetailBean) {
		channelDetailMapper.updateChannelDetail(channelDetailBean);
	}
	
	/**
	 * 根据商户id删除商户详情信息
	 */
	public void deleteChannelDetail(ChannelDetailBean channelBean) {
		channelDetailMapper.deleteChannelDetail(channelBean);
	}
	
}
