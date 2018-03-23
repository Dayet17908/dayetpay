package com.sevenpay.bms.basemanager.privilegeControl.map;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.basemanager.privilegeControl.bean.Privilege;

@MapperScan
public interface PrivilegeMapper {
	public void insertPrivilege(Privilege privilege);

	public void deletePrivilege(Privilege privilege);
}
