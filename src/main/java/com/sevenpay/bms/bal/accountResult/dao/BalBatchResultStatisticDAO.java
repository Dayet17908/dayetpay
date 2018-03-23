package com.sevenpay.bms.bal.accountResult.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.bal.accountResult.bean.BalBatchResultStatistic;
import com.sevenpay.bms.bal.accountResult.bean.BaseChannel;
import com.sevenpay.bms.bal.accountResult.mapper.BalBatchResultStatisticMapper;

@Repository
public class BalBatchResultStatisticDAO {
	
	@Autowired
	private BalBatchResultStatisticMapper BalBatchResultStatisticMapper;
	
	@Page
	public List<BalBatchResultStatistic> selectList(BalBatchResultStatistic balBatchResultStatistic) {
			
		return BalBatchResultStatisticMapper.selectList(balBatchResultStatistic);
	}

	public List<BaseChannel> queryBalBaseChannel() {
		
		return BalBatchResultStatisticMapper.queryBalBaseChannel();
	}

}
