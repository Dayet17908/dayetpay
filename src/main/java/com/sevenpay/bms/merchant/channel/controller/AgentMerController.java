package com.sevenpay.bms.merchant.channel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sevenpay.bms.merchant.channel.bean.AgentMerInfo;
import com.sevenpay.bms.merchant.channel.dao.AgentMerDao;
import com.sevenpay.bms.merchant.channel.service.AgentMerService;

@Controller
@RequestMapping(AgentMerControllerPath.BASE)
public class AgentMerController {

	@Autowired
	private AgentMerService agentMerService;

	@Autowired
	private AgentMerDao agentMerDao;
	
	private static Logger logger = LoggerFactory.getLogger(AgentMerController.class);

	/**
	 * 显示信息列表
	 * 
	 * @param bank
	 * @return
	 */
	@RequestMapping(AgentMerControllerPath.LIST)
	public ModelAndView list(AgentMerInfo agentMerInfo) {
		logger.info("查询代理商户渠道信息");
		//条件查询
		ModelAndView model = new ModelAndView(AgentMerControllerPath.BASE + AgentMerControllerPath.LIST);
		List<AgentMerInfo> agentMerInfos = agentMerDao.selectChannleAgentMerInfoByPrimaryKey(agentMerInfo);
		model.addObject("allAgentMerInfolist", JSONObject.toJSON(agentMerInfos));
		model.addObject("agentMerInfo",agentMerInfo);
		return model;
	}

	/**
	 * 删除信息
	 * 
	 * @param bankCode
	 * @return
	 */
	@RequestMapping(AgentMerControllerPath.DELETE)
	@ResponseBody
	public String delete(AgentMerInfo agentMerInfo) {
		logger.info("删除代理商户渠道信息");
		JSONObject jsonObject = new JSONObject();
		agentMerInfo.setStatus("01");
		try {
			agentMerService.deleteAgentMerInfoByCustId(agentMerInfo);
			jsonObject.put("result", "success");
		} catch (Exception e) {
			jsonObject.put("result", "fail");
			jsonObject.put("message", e.getMessage());
		}
		return jsonObject.toJSONString();
	}

	/**
	 * 增加商户通道
	 * 
	 * @param
	 * 
	 */
	@RequestMapping(AgentMerControllerPath.ADD)
	@ResponseBody
	public String addAgentMerInfo(AgentMerInfo agentMerInfo) {
		logger.info("添加代理商户渠道信息");
		JSONObject jsonObject = new JSONObject();
		try {
			// 通过输入的通道id查出对象
			AgentMerInfo checkAgentMerInfo = agentMerService.selectAllChannleAgentMerInfoBychannelcode(agentMerInfo.getChannelCode());
			// 判断要添加的对象是否存在
			if (null != checkAgentMerInfo) {
				jsonObject.put("result", "fail");
				jsonObject.put("message", "该通道号已经占用");
			} else {
				Date date = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String format = simpleDateFormat.format(date);
				agentMerInfo.setCreateTime(format);
				agentMerInfo.setModifyTime(format);
				agentMerService.insertAgentMerInfo(agentMerInfo);
				jsonObject.put("result", "success");
			}
		} catch (Exception e) {
			jsonObject.put("result", "fail");
			jsonObject.put("message", e.getMessage());
		}
		return jsonObject.toJSONString();
	}

	/**
	 * 更新操作
	 * 
	 * @param bank
	 * @return
	 */
	@RequestMapping(AgentMerControllerPath.UPDATE)
	@ResponseBody
	public String updateBank(AgentMerInfo agentMerInfo) {
		logger.info("更新代理商户渠道信息");
		JSONObject jsonObject = new JSONObject();
		try {
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format = simpleDateFormat.format(date);
			agentMerInfo.setModifyTime(format);//设置最新修改时间
			agentMerService.updatechannleAgentMerInfo(agentMerInfo);
			jsonObject.put("result", "success");
		} catch (Exception e) {
			jsonObject.put("result", "fail");
			jsonObject.put("message", e.getMessage());
		}
		return jsonObject.toJSONString();
	}
}
