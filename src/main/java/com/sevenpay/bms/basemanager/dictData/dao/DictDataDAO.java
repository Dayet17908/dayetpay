package com.sevenpay.bms.basemanager.dictData.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.dictData.bean.DictData;
import com.sevenpay.bms.basemanager.dictData.mapper.DictDataMapper;

@Repository
public class DictDataDAO {
	
	@Autowired
	private DictDataMapper dictDataMapper;
	
	@Page
	public List<DictData> selectDictDataList(DictData data){
		return dictDataMapper.selectListDict(data);
	}
	
	@Page
	public List<DictData> selectDictionaryBeanByRestrict(DictData queryBean) {
		return dictDataMapper.selectDictionaryBeanByRestrict(queryBean);
	}
}
