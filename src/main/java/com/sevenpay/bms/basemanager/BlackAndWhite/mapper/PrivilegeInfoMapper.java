package com.sevenpay.bms.basemanager.BlackAndWhite.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.basemanager.BlackAndWhite.bean.PrivilegeInfo;

@MapperScan
public interface PrivilegeInfoMapper {
 public List<PrivilegeInfo> list();
}
