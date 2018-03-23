package com.sevenpay.bms.basemanager.merchant;

import java.util.List;

import org.gyzb.platform.web.admin.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSONObject;
import com.sevenpay.bms.basemanager.custInfo.service.TdCustInfoService;
import com.sevenpay.bms.basemanager.merchant.bean.CashierInfo;
import com.sevenpay.bms.basemanager.merchant.bean.Merchant;
import com.sevenpay.bms.basemanager.merchant.bean.StoreManage;
import com.sevenpay.bms.basemanager.merchant.bean.TdLoginUserInfo;
import com.sevenpay.bms.basemanager.merchant.mapper.MerchantMapper;
import com.sevenpay.bms.basemanager.merchant.service.CashierManageService;
import com.sevenpay.bms.basemanager.utils.GenSN;
import com.sevenpay.bms.common.util.RedisUtil;

@Controller
@RequestMapping(CashierManagePath.BASE)
public class CashierManageController {
	
	@Autowired
	private CashierManageService cashierManageService;
	@Autowired
	private MerchantMapper merchantMapper;
	
	@Autowired
	private TdCustInfoService tdCustInfoService;
	
	@RequestMapping(CashierManagePath.LIST)
	public ModelAndView list(CashierInfo queryBean) {
		ModelAndView mv = new ModelAndView(CashierManagePath.BASE + CashierManagePath.LIST);
		String userId  = String.valueOf(WebUtils.getUserInfo().getUserId());
		//是否有权限查看所有订单
		boolean isAllList = tdCustInfoService.isAllList(userId);
		List<CashierInfo> list = null;
		if(isAllList){
			list = cashierManageService.getCashierList(queryBean);
		}else{
			queryBean.setUserId(userId);
			queryBean.setUserName(WebUtils.getUserInfo().getUserName());
			list = cashierManageService.getMyCashierList(queryBean);
		}
		List<Merchant> merchantList = merchantMapper.selectMerchant();
		mv.addObject("cashierInfoList", JSONObject.toJSON(list));
		mv.addObject("queryBean", queryBean);
		mv.addObject("merchantList", merchantList);
		return mv;
	}
	
	@RequestMapping(CashierManagePath.CHECK)
	@ResponseBody
	public String list(String custId) {	
		JSONObject jo = new JSONObject();
		List<StoreManage> storeManageList= cashierManageService.selectStore(custId);
		if (storeManageList ==null) {
			jo.put("result", "FAIL");
		}else {
			jo.put("result","SUCCESS");
			jo.put("storeManageList", storeManageList);
		}
		return jo.toJSONString();
	}
	
	@RequestMapping(CashierManagePath.ADD)
	@ResponseBody
	public String add(CashierInfo cashierInfo) {
		JSONObject jo = new JSONObject();
		TdLoginUserInfo loginUserInfo = cashierManageService.getCustInfoByMobile(cashierInfo.getCashierMobile());
		if(loginUserInfo==null){
			jo.put("result", "FAIL");
			jo.put("message", "该手机号未注册为七分钱用户！");
			return jo.toString();
		}
		List<CashierInfo> list = cashierManageService.getCashierList(cashierInfo);
		if(list!=null&&list.size()!=0){
			jo.put("result", "FAIL");
			jo.put("message", "该手机号已注册成该商户的收银员！");
			return jo.toString();
		}
		cashierInfo.setCashierCustId(loginUserInfo.getCustId());
		cashierInfo.setOnlyId(GenSN.getSN());
		cashierInfo.setCreateId(WebUtils.getUserInfo().getUserId()+"");
		try {
			cashierManageService.addCashier(cashierInfo);
			//merchantCustId  商户编号
			this.delKey(cashierInfo.getMerchantCustId(), RedisUtil.MERCHANT_CASHIER_REF_DB);
			jo.put("result", "SUCCESS");
			jo.put("message", "添加成功");
		} catch (Exception e) {
			jo.put("result", "FAIL");
			jo.put("message", e.getMessage());
		}
		return jo.toString();
	}
	
	@RequestMapping(CashierManagePath.DELETE)
	@ResponseBody
	public String delete(String onlyId) {
		JSONObject jo = new JSONObject();
		try {
			
			CashierInfo cashierInfo = cashierManageService.getMyCashierRef(onlyId);
			if(cashierInfo!=null){
			
				cashierManageService.deleteCashier(onlyId);		
				this.delKey(cashierInfo.getMerchantCustId(), RedisUtil.MERCHANT_CASHIER_REF_DB);
				jo.put("result", "SUCCESS");
				jo.put("message", "删除成功！");
			}else{
				jo.put("result", "FAIL");
				jo.put("message", "收银员不存在！");
			}
			return jo.toString();
		} catch (Exception e) {
			jo.put("result", "FAIL");
			jo.put("message", e.getMessage());
		}
		return jo.toString();
	}
	
	@RequestMapping(CashierManagePath.UPDATE)
	@ResponseBody
	public String update(CashierInfo cashierInfo) {
		JSONObject jo = new JSONObject();
		cashierInfo.setModifyId(WebUtils.getUserInfo().getUserId()+"");
		try {
			TdLoginUserInfo loginUserInfo = cashierManageService.getCustInfoByMobile(cashierInfo.getCashierMobile());
			if(loginUserInfo==null){
				jo.put("result", "FAIL");
				jo.put("message", "该手机号未注册为七分钱用户！");
				return jo.toString();
			}
			cashierInfo.setCashierCustId(loginUserInfo.getCustId());
			List<CashierInfo> list = cashierManageService.getCashierListExcept(cashierInfo);
			if(list!=null&&list.size()!=0){
				jo.put("result", "FAIL");
				jo.put("message", "该手机号已注册成该商户的收银员！");
				return jo.toString();
			}
			cashierManageService.updateCashier(cashierInfo);
			if(cashierInfo!=null)
			this.delKey(cashierInfo.getMerchantCustId(), RedisUtil.MERCHANT_CASHIER_REF_DB);
			jo.put("result", "SUCCESS");
			jo.put("message", "修改成功！");
			return jo.toString();
		} catch (Exception e) {
			jo.put("result", "FAIL");
			jo.put("message", e.getMessage());
		}
		return jo.toString();
	}
	//XXXX.delkey(merchantId+"_cashier_ref",RedisUtil.MERCHANT_CASHIER_REF_DB)
	public void delKey(String key, int db) {
		Jedis jedis = RedisUtil.getJedis();
		try {
			
			
			jedis.select(db);
			/*Set<String> str = jedis.keys(key+"_cashier_ref");
			System.out.println(key+"_cashier_ref-------------str:"+str);*/
			jedis.del(key+"_cashier_ref"); //删除key
			/*Set<String> strs = jedis.keys(key+"_cashier_ref");
			System.out.println(key+"_cashier_ref-------------str:"+"strs:"+strs);*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			RedisUtil.returnResource(jedis);
		}
	}
}
