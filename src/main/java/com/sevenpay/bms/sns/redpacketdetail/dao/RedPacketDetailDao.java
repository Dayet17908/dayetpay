package com.sevenpay.bms.sns.redpacketdetail.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.sns.redpacketdetail.bean.RedPacketDetail;
import com.sevenpay.bms.sns.redpacketdetail.mapper.RedPacketDetailMapper;

@Repository
public class RedPacketDetailDao {
	
	@Autowired
	private RedPacketDetailMapper redPacketDetailMapper;
	@Page
	public List<RedPacketDetail> selectRedPacketDetailList(RedPacketDetail queryBean) {
		return redPacketDetailMapper.selectRedPacketDetailList(queryBean);
	}
	
}
