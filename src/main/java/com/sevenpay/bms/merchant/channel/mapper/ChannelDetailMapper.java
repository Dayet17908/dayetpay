package com.sevenpay.bms.merchant.channel.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.merchant.channel.bean.ChannelDetailBean;
import com.sevenpay.bms.merchant.channel.bean.UpdateChannelDetailBean;
/**
 * 网关通道-商户详情Mapper
 * @author hongjiagui
 *
 */
@MapperScan
public interface ChannelDetailMapper {
	/**
	 * 根据查询条件获取商户详情列表
	 */
	public List<ChannelDetailBean> listChannelDetail(ChannelDetailBean queryBean);
	
	/**
	 * 保存商户详情信息
	 */
	public void saveChannelDetail(ChannelDetailBean channelDetailBean);
	
	/**
	 * 修改商户详情信息
	 */
	public void updateChannelDetail(UpdateChannelDetailBean channelDetailBean);
	
	/**
	 * 根据商户id删除商户详情信息
	 */
	public void deleteChannelDetail(ChannelDetailBean channelBean);
}
