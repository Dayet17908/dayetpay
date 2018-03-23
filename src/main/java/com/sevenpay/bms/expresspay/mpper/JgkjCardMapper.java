package com.sevenpay.bms.expresspay.mpper;

import org.apache.ibatis.annotations.Param;

import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface JgkjCardMapper {

	String selectCardNo(@Param("custId") String custId);

}
