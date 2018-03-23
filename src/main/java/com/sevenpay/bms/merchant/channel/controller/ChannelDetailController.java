package com.sevenpay.bms.merchant.channel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sevenpay.bms.merchant.channel.bean.ChannelDetailBean;
import com.sevenpay.bms.merchant.channel.bean.UpdateChannelDetailBean;
import com.sevenpay.bms.merchant.channel.service.ChannelDetailService;
/**
 * 网关通道，商户详情管理Controller
 * @author hongjiagui
 *
 */
@Controller
@RequestMapping(ChannelDetailPath.BASE)
public class ChannelDetailController {

	@Autowired
	private ChannelDetailService channelDetailService;
	
	/**
	 * 根据查询条件获取商户详情列表
	 */
	@RequestMapping(ChannelDetailPath.LIST)
	public ModelAndView list(ChannelDetailBean queryBean) {
		ModelAndView mv = new ModelAndView(ChannelDetailPath.BASE + ChannelDetailPath.LIST);
		List<ChannelDetailBean> channelList = channelDetailService.listChannelDetail(queryBean);
		mv.addObject("channelList", JSONObject.toJSON(channelList));
		mv.addObject("queryBean", queryBean);
		return mv;
	}
	
	/**
	 * 保存商户详情信息
	 */
	@RequestMapping(ChannelDetailPath.ADD)
	@ResponseBody
	public String saveChannelDetail(ChannelDetailBean channelDetailBean) {
		String result = channelDetailService.saveChannelDetail(channelDetailBean);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	/**
	 * 修改商户详情信息
	 */
	@RequestMapping(ChannelDetailPath.UPDATE)
	@ResponseBody
	public String updateChannelDetail(UpdateChannelDetailBean channelDetailBean) {
		String result = channelDetailService.updateChannelDetail(channelDetailBean);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	/**
	 *删除商户详情信息,为逻辑删除,将status置为'99',表示删除
	 */
	@RequestMapping(ChannelDetailPath.DELETE)
	@ResponseBody
	public String deleteChannelDetail(ChannelDetailBean channelBean) {
		String result = channelDetailService.deleteChannelDetail(channelBean);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
}
