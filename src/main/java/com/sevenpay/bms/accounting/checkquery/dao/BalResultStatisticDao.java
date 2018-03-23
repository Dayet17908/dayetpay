package com.sevenpay.bms.accounting.checkquery.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.checkquery.bean.BalResultStatistic;
import com.sevenpay.bms.accounting.checkquery.mapper.BalResultStatisticMapper;

/**
 * @project sevenpay-bms-web
 * @fileName BalResultStatisticDao.java
 * @author huiquan.ma
 * @date 2015年10月16日
 * @memo 
 */
@Repository
public class BalResultStatisticDao {

	@Autowired
	private BalResultStatisticMapper balResultStatisticMapper;
	
	@Page
	public List<BalResultStatistic> selectListByPage(BalResultStatistic selectBean) {
		return balResultStatisticMapper.selectList(selectBean);
	}
}


