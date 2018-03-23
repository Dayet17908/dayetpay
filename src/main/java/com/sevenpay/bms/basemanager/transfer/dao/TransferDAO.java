package com.sevenpay.bms.basemanager.transfer.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.transfer.bean.TransferBean;
import com.sevenpay.bms.basemanager.transfer.mapper.TransferMapper;

@Repository
public class TransferDAO {
	
	@Autowired
	private TransferMapper transferMapper;
	
	@Page
	public List<TransferBean> selectTransfer(TransferBean transferBean){
		return transferMapper.selectTransfer(transferBean);
	}
	
}
