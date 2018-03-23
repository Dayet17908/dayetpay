package com.sevenpay.bms.meeting.redPacket.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.meeting.redPacket.bean.MeetRedPacketBill;
import com.sevenpay.bms.meeting.redPacket.bean.MeetRedPacketBillConditionBean;
import com.sevenpay.bms.meeting.redPacket.mapper.MeetRedPacketBillMapper;

@Repository
public class RedPacketDAO {
	
	@Autowired
	private MeetRedPacketBillMapper meetRedPacketBillMapper;
	
	@Page
	public  List<MeetRedPacketBill> selectRedPacket(MeetRedPacketBillConditionBean record){
		  return meetRedPacketBillMapper.selectRedPacket(record);
	}
}
