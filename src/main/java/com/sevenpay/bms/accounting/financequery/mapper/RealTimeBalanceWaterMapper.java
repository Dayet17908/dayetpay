package com.sevenpay.bms.accounting.financequery.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.financequery.bean.RealTimeBussBalanceWater;
import com.sevenpay.bms.accounting.financequery.bean.RealTimeCustBalanceWater;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface RealTimeBalanceWaterMapper {
	List<RealTimeCustBalanceWater> selectCustBalanceWaterList(RealTimeCustBalanceWater queryBean);

	List<RealTimeBussBalanceWater> selectBussBalanceWaterList(RealTimeBussBalanceWater queryBean);

}
