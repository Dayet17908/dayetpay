package com.sevenpay.bms.sns.redpacket.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.sns.redpacket.bean.RedEnvelopeInfo;
import com.sevenpay.bms.sns.redpacket.mapper.RedEnvelopeInfoMapper;

@Repository
public class RedPacketInfoDao {

	@Autowired
	private RedEnvelopeInfoMapper redEnvelopeInfoMapper;
	
	@Page
	public List<RedEnvelopeInfo> selectList(RedEnvelopeInfo queryBean) {
		return redEnvelopeInfoMapper.selectList(queryBean);
	}
}
