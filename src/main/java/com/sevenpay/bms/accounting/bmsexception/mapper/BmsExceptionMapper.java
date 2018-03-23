package com.sevenpay.bms.accounting.bmsexception.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.accounting.bmsexception.bean.BmsException;

@MapperScan
public interface BmsExceptionMapper {
	
	List<BmsException> selectBmsExceptionList(BmsException queryBean);

}
