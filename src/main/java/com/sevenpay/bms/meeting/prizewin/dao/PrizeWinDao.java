package com.sevenpay.bms.meeting.prizewin.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.meeting.prizewin.bean.PrizeWinBean;
import com.sevenpay.bms.meeting.prizewin.mapper.PrizeWinMapper;

@Repository
public class PrizeWinDao {
	
	@Autowired
	private PrizeWinMapper prizeWinMapper;

	@Page
	public List<PrizeWinBean> selectLotteryUserList(PrizeWinBean queryBean) {
		return prizeWinMapper.selectPrizeWinList(queryBean);
	}

}
