package com.sevenpay.bms.basemanager.transferRevoke.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.basemanager.transferRevoke.bean.TransferRevoke;

@MapperScan
public interface TransferRevokeMapper {

	public List<TransferRevoke> selectTransferRevokeList(TransferRevoke queryBean);

	int insertTransferRevoke(TransferRevoke insertBean);

	int updateByRevoke(TransferRevoke updateBean);

	int updateByAudit(TransferRevoke updateBean);
}
