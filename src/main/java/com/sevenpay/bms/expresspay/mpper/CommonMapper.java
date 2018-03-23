package com.sevenpay.bms.expresspay.mpper;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.expresspay.cardholderInfo.bean.Cardholder;

@MapperScan
public interface CommonMapper {

	String getCustId(Cardholder queryBean);

}
