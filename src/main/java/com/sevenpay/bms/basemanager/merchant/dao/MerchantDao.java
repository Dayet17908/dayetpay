package com.sevenpay.bms.basemanager.merchant.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.merchant.bean.CustScan;
import com.sevenpay.bms.basemanager.merchant.bean.Merchant;
import com.sevenpay.bms.basemanager.merchant.bean.MerchantVo;
import com.sevenpay.bms.basemanager.merchant.mapper.CashierManageMapper;
import com.sevenpay.bms.basemanager.merchant.mapper.MerchantMapper;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantMapper mapper;
	
	@Autowired
	CashierManageMapper cashierManageMapper;
	
	public List<Merchant> getAllMerchant(){
		return mapper.getAllMerchant();
	}
	
	@Page
	public List<MerchantVo> list(MerchantVo merchantVo){
		return mapper.list(merchantVo);
	}
	
	
	@Page
	public List<MerchantVo> listAuditor(MerchantVo merchantVo){
		return mapper.listAuditor(merchantVo);
	}

	@Page
	public List<MerchantVo> backList(MerchantVo merchantVo){
		return mapper.backList(merchantVo);
	}
	
	@Page
	public List<MerchantVo> auditList(MerchantVo merchantVo){
		return mapper.auditList(merchantVo);
	}

	/** 微商户列表查询 **/
	@Page
	public List<MerchantVo> tinyMerchantsList(MerchantVo merchantVo) {
		return mapper.tinyMerchantsList(merchantVo);
	}
	
	/** 自己权限微商户列表查询  **/
	@Page
	public List<MerchantVo> tinyMyMerchantsList(MerchantVo merchantVo){
		return mapper.tinyMyMerchantsList(merchantVo);
	}
	/** 微商户图片 */
	public String findPath(CustScan custScan){
		return mapper.findPath(custScan);
	}
	
}
