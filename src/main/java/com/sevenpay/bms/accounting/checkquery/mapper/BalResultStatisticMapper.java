package com.sevenpay.bms.accounting.checkquery.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.checkquery.bean.BalResultStatistic;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface BalResultStatisticMapper {
	/**
	 * 交广科技对账结果统计报表
	 * @param selectBean
	 * @return
	 */
	List<BalResultStatistic> selectList(BalResultStatistic selectBean);
}
