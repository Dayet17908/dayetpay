package com.sevenpay.bms.accounting.unnamedProcessing.clearJgkjregister.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.unnamedProcessing.clearJgkjregister.bean.ClearJgkjRegister;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface ClearJgkjRegisterMapper {
	
	List<ClearJgkjRegister> selectClearJgkjRegisterByList(ClearJgkjRegister clearJgkjRegister);
}
