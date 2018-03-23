package com.sevenpay.bms.accounting.kingdee.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.accounting.kingdee.bean.BmsClearKingdeePayInfo;

@MapperScan
public interface BmsClearKingdeePayMapper {
    
    /**
     * 
     * @param bmsClearKingdeePayInfo
     * @return
     */
    List<BmsClearKingdeePayInfo> selectList(BmsClearKingdeePayInfo bmsClearKingdeePayInfo);
}