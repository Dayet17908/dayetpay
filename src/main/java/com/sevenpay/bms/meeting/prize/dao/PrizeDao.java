package com.sevenpay.bms.meeting.prize.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.meeting.prize.bean.PrizeBean;
import com.sevenpay.bms.meeting.prize.mapper.PrizeMapper;
@Repository
public class PrizeDao {
	@Autowired
	private PrizeMapper prizeMapper;
	@Page
	public List<PrizeBean> selectPrizeBeanList(PrizeBean queryBean) {
		return prizeMapper.selectPrizeBeanList(queryBean);
	}
	
}
