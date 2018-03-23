package com.sevenpay.bms.basemanager.advertisement.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.advertisement.bean.Ad;
import com.sevenpay.bms.basemanager.advertisement.mapper.AdMapper;

@Repository
public class AdDao {
	@Autowired
	private AdMapper adMapper;
	
	@Page
	public List<Ad> selectAdList(Ad queryBean){
		return adMapper.selectAdList(queryBean);
	}
}
