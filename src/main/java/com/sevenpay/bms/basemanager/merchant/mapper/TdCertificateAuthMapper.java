package com.sevenpay.bms.basemanager.merchant.mapper;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.basemanager.merchant.bean.TdCertificateAuth;


@MapperScan
public interface TdCertificateAuthMapper {

    int deleteByPrimaryKey(Integer authId);

    int insert(TdCertificateAuth record);

    int insertSelective(TdCertificateAuth record);

    int updateByPrimaryKeySelective(TdCertificateAuth record);

    int updateByPrimaryKey(TdCertificateAuth record);
}
