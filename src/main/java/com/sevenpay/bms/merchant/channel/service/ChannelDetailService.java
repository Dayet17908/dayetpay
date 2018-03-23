package com.sevenpay.bms.merchant.channel.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.basemanager.utils.GenSN;
import com.sevenpay.bms.merchant.channel.bean.ChannelDetailBean;
import com.sevenpay.bms.merchant.channel.bean.UpdateChannelDetailBean;
import com.sevenpay.bms.merchant.channel.dao.ChannelDetailDao;

/**
 * 网关通道，商户详情管理Service
 * @author hongjiagui
 *
 */
@Service
public class ChannelDetailService {

	@Autowired
	private ChannelDetailDao channelDetailDao;
	
	/**
	 * 根据查询条件获取商户详情列表
	 */
	public List<ChannelDetailBean> listChannelDetail(ChannelDetailBean queryBean){
		return channelDetailDao.listChannelDetail(queryBean);
	}
	
	/**
	 * 保存商户详情信息
	 */
	public String saveChannelDetail(ChannelDetailBean channelDetailBean) {
		//设置创建时间
		channelDetailBean.setCreateTime(new Date());
		//新增商户，默认初始化时状态为00-可用
		channelDetailBean.setStatus("1");
		try {
			channelDetailDao.saveChannelDetail(channelDetailBean);
			return "SUCCESS";
		}catch(Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		
	}
	
	/**
	 * 修改商户详情信息
	 */
	public String updateChannelDetail(UpdateChannelDetailBean channelDetailBean) {
		channelDetailBean.setModifyTime(new Date());	
		try {
			channelDetailDao.updateChannelDetail(channelDetailBean);
			return "SUCCESS";
		}catch(Exception e) {
			e.printStackTrace();
			return e.toString();
		}
	}
	
	/**
	 * 删除商户详情信息,为逻辑删除,将status置为'99',表示删除
	 */
	public String deleteChannelDetail(ChannelDetailBean chnannelBean) {
		try {
			chnannelBean.setStatus("99");
			channelDetailDao.deleteChannelDetail(chnannelBean);
			return "SUCCESS";
		}catch(Exception e) {
			e.printStackTrace();
			return e.toString();
		}
	}
}
