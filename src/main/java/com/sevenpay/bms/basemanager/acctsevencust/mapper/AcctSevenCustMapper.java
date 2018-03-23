package com.sevenpay.bms.basemanager.acctsevencust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sevenpay.bms.basemanager.acctsevencust.bean.AcctSevenCust;
import com.sevenpay.bms.common.annotation.MapperScanSub;

@MapperScanSub
public interface AcctSevenCustMapper {

	List<AcctSevenCust> getAcctSevenCust(AcctSevenCust queryBean);
	
	public String getAccountByCustId(@Param("custId") String custId);

}
