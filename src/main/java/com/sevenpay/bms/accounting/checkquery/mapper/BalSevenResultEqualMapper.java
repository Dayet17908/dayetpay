package com.sevenpay.bms.accounting.checkquery.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.checkquery.bean.BalSevenResultEqual;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface BalSevenResultEqualMapper {
	/**
	 * 交广科技对账一致报表
	 * @param resultEqual
	 * @return
	 */
	 List<BalSevenResultEqual> selectFitList(BalSevenResultEqual resultEqual);
}
