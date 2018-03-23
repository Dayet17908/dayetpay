package com.sevenpay.bms.bal.accountResult.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sevenpay.bms.bal.accountResult.bean.BalInternalData;
import com.sevenpay.bms.bal.accountResult.bean.BalInternalDataExample;
import com.sevenpay.bms.common.annotation.MapperScanCombinedmaster;

@MapperScanCombinedmaster
public interface BalInternalDataMapper {
    int countByExample(BalInternalDataExample example);

    int deleteByExample(BalInternalDataExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(BalInternalData record);

    int insertSelective(BalInternalData record);

    List<BalInternalData> selectByExample(BalInternalDataExample example);

    BalInternalData selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") BalInternalData record, @Param("example") BalInternalDataExample example);

    int updateByExample(@Param("record") BalInternalData record, @Param("example") BalInternalDataExample example);

    int updateByPrimaryKeySelective(BalInternalData record);

    int updateByPrimaryKey(BalInternalData record);

	List<BalInternalData> selectList(BalInternalData balInternalData);
}