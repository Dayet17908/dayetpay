package com.sevenpay.bms.basemanager.transferRevoke.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.transferRevoke.bean.TransferRevoke;
import com.sevenpay.bms.basemanager.transferRevoke.mapper.TransferRevokeMapper;

@Repository
public class TransferRevokeDao {
	
	@Autowired
	private TransferRevokeMapper transferRevokeMapper;

	@Page
	public List<TransferRevoke> selectTransferRevokeList(TransferRevoke queryBean) {
		return transferRevokeMapper.selectTransferRevokeList(queryBean);
	}
}
