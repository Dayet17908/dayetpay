package com.sevenpay.bms.basemanager.merchantincontrol.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.merchantincontrol.bean.MerchantInControl;
import com.sevenpay.bms.basemanager.merchantincontrol.mapper.TdMerchantInControlMapper;
@Repository
public class TdMerchantInControlDao {
	@Autowired
	private TdMerchantInControlMapper mapper;
	@Page
	public List<MerchantInControl> selectMerchantInControlList(MerchantInControl merchantInControl){
		return mapper.selectMerchantInControlList(merchantInControl);
	}
}
