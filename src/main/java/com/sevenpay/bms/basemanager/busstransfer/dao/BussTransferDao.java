package com.sevenpay.bms.basemanager.busstransfer.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.busstransfer.bean.BussTransferBean;
import com.sevenpay.bms.basemanager.busstransfer.mapper.BussTransferMapper;

@Repository
public class BussTransferDao {
	
	@Autowired
	private BussTransferMapper bussTransferMapper;
	
	@Page
	public List<BussTransferBean> selectTransfer(BussTransferBean bussTransferBean){
		return bussTransferMapper.selectTransfer(bussTransferBean);
	}
	
}
