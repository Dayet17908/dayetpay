package com.sevenpay.bms.basemanager.transfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.basemanager.transfer.bean.TransferBean;
import com.sevenpay.bms.basemanager.transfer.bean.TransferExcel;
import com.sevenpay.bms.basemanager.transfer.dao.TransferDAO;
import com.sevenpay.bms.basemanager.transfer.mapper.TransferMapper;


@Service
public class TransferService {

	@Autowired
	private TransferDAO transferDao;
	
	@Autowired
	private TransferMapper transferMapper;
	
	/**
	 * 查询转账信息
	 * @param transferBean
	 * @return
	 */
	
	public List<TransferBean> selectTransfer(TransferBean transferBean){
		return transferDao.selectTransfer(transferBean);
	}
	
	/**
	 * 查询转账列表信息
	 * @param transferBean
	 * @return
	 */
	public List<TransferExcel> selectTransferExcel(TransferBean transferBean){
		
		return transferMapper.selectTransferExcel(transferBean);
	}
}
