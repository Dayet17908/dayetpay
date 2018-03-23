package com.sevenpay.bms.basemanager.merchant.service;



import java.util.List;

import org.gyzb.platform.web.admin.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.basemanager.merchant.bean.StoreManage;
import com.sevenpay.bms.basemanager.merchant.dao.StoreManageDao;
import com.sevenpay.bms.basemanager.merchant.mapper.StoreManageMapper;
import com.sevenpay.bms.basemanager.utils.GenSN;




@Service
public class StoreManageService {

	@Autowired
	StoreManageDao storeManageDao;
	
	@Autowired
	StoreManageMapper storeManageMapper;
	
	//门店列表
	public List<StoreManage> getStoreList(StoreManage storeManage) {
		return storeManageDao.getStoreList(storeManage) ;
	}

	
	public void insert(StoreManage storeManage){
		
		storeManage.setShopId(GenSN.getOperateID());
		storeManage.setCreateId(String.valueOf(WebUtils.getUserInfo().getUserId()));
		storeManageMapper.insert(storeManage);
	}
	

	public void update(StoreManage storeManage){
		
		storeManage.setModifyId(String.valueOf(WebUtils.getUserInfo().getUserId()));
		storeManageMapper.update(storeManage);
	}
	
	
	public void delete(StoreManage storeManage){
	
		storeManageMapper.delete(storeManage);
	}
	//校验商户是否存在
	public Integer exists(StoreManage storeManage){
		return storeManageMapper.exists(storeManage);
	}
	
	//校验商户门店是否存在
	public Integer repeats(StoreManage storeManage){
		return storeManageMapper.repeats(storeManage);
	}
}
