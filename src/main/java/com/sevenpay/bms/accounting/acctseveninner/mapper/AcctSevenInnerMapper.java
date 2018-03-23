package com.sevenpay.bms.accounting.acctseveninner.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.acctseveninner.bean.AcctSevenInner;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface AcctSevenInnerMapper {

	List<AcctSevenInner> queryAcctSevenInnerList(AcctSevenInner queryBean);

}
