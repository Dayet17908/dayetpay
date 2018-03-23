package com.sevenpay.bms.basemanager.router.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.router.bean.Servicechannel;
import com.sevenpay.bms.basemanager.router.mapper.RouterMapper;


@Repository
public class RouterDao {
	
	@Autowired
	public RouterMapper routerMapper;
	
	@Page
	public List<Servicechannel> selectRouters(Servicechannel servicechannel){
		
		return routerMapper.selectRouters(servicechannel);
	}
	
	public int addRouters(Servicechannel queryBean){
		return routerMapper.addRouters(queryBean);
	}
	
	public int updateRouter(Servicechannel servicechannel){
		return routerMapper.updateRouter(servicechannel);
	}
	
}
