package com.sevenpay.bms.basemanager.merchant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sevenpay.bms.basemanager.merchant.bean.Merchant;
import com.sevenpay.bms.basemanager.merchant.bean.StoreManage;
import com.sevenpay.bms.basemanager.merchant.mapper.MerchantMapper;
import com.sevenpay.bms.basemanager.merchant.service.StoreManageService;


@Controller
@RequestMapping(StoreManagePath.BASE)
public class StoreManageController {

	private Logger logger = LoggerFactory.getLogger(StoreManageController.class);
	
	@Autowired
	private StoreManageService storeManageService;
	
	@Autowired
	private MerchantMapper merchantMapper;
	
	/** 门店管理*/
	@RequestMapping(StoreManagePath.LIST)
	public ModelAndView list(StoreManage queryBean){
		ModelAndView mv = new ModelAndView(StoreManagePath.BASE + StoreManagePath.LIST); 
		
		mv.addObject("storeManageInfoList",JSONObject.toJSON(storeManageService.getStoreList(queryBean)));
		List<Merchant> merchantList = merchantMapper.selectMerchant();
		mv.addObject("queryBean", queryBean);
		mv.addObject("merchantList",merchantList);
		return mv;
		
	}
	
	//添加门店
	@RequestMapping(StoreManagePath.ADD)
	@ResponseBody
	public String add(StoreManage storeManage) {
		logger.info("增加门店");		
		JSONObject jsonObject = new JSONObject();			
		try {			
			storeManageService.insert(storeManage);
			jsonObject.put("result", "success");
		} catch (Exception e) {
			logger.error("增加门店：",e);
			jsonObject.put("result", "fail");
			jsonObject.put("message", e.getMessage());
		}	
		return jsonObject.toJSONString();
	}
	
	//编辑门店
	@RequestMapping(StoreManagePath.EDIT)
	@ResponseBody
	public String update(StoreManage storeManage) {
		logger.info("编辑门店");		
		JSONObject jsonObject = new JSONObject();			
		try {
			logger.info("++++++++++++++"+JSONObject.toJSONString(storeManage));
			storeManageService.update(storeManage);
			jsonObject.put("result", "success");
		} catch (Exception e) {
			logger.error("编辑门店：",e);
			jsonObject.put("result", "fail");
			jsonObject.put("message", e.getMessage());
		}	
		return jsonObject.toJSONString();
	}
	
	//删除门店
	@RequestMapping(StoreManagePath.DELETE)
	@ResponseBody
	public String delete(String shopId) {
		logger.info("删除门店");		
		JSONObject jsonObject = new JSONObject();			
		try {
			logger.info("++++++++++++++"+JSONObject.toJSONString(shopId));
			StoreManage storeManage=new StoreManage();
			storeManage.setShopId(shopId);
			storeManageService.delete(storeManage);
			jsonObject.put("result", "success");
		} catch (Exception e) {
			logger.error("删除门店：",e);
			jsonObject.put("result", "fail");
			jsonObject.put("message", e.getMessage());
		}	
		return jsonObject.toJSONString();
	}
	
	
	@RequestMapping(StoreManagePath.VALIDATE)
	@ResponseBody
	public String verify(StoreManage storeManage){
		logger.info("校验商户是否存在");		
		JSONObject jsonObject = new JSONObject();			
		try {	
			if(storeManageService.exists(storeManage)<1){
				jsonObject.put("result", "fail");
				jsonObject.put("message", "商户在系统中不存在");
			}else{
				jsonObject.put("result", "success");
				jsonObject.put("message", "商户在系统中存在");
			}
				
		} catch (Exception e) {
			logger.error("商家账号：",e);
			jsonObject.put("result", "fail");
			jsonObject.put("message", e.getMessage());
		}	
		return jsonObject.toJSONString();
	}
	
	@RequestMapping(StoreManagePath.REPEAT)
	@ResponseBody
	public String repeat(StoreManage storeManage){
		logger.info("校验商户门店编号是否重复");		
		JSONObject jsonObject = new JSONObject();			
		try {	
			if(storeManageService.repeats(storeManage)>0){
				jsonObject.put("result", "fail");
				jsonObject.put("message", "商户门店编号在系统中已存在");
			}else{
				jsonObject.put("result", "success");
				jsonObject.put("message", "商户在系统中存在");
			}
				
		} catch (Exception e) {
			logger.error("商家账号：",e);
			jsonObject.put("result", "fail");
			jsonObject.put("message", e.getMessage());
		}	
		return jsonObject.toJSONString();
	}
}
