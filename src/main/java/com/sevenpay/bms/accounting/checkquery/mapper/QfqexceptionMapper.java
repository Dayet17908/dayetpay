package com.sevenpay.bms.accounting.checkquery.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.checkquery.bean.Qfqexception;
import com.sevenpay.bms.common.annotation.MapperScanCore;
@MapperScanCore
public interface QfqexceptionMapper {	
	/**
	 * 交广科技对账七分钱存疑报表
	 * @param exception
	 * @return
	 */
	public List<Qfqexception> selectQfqResultExceptionList(Qfqexception exception);
}
