package com.sevenpay.bms.meeting.redPacket.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.meeting.redPacket.bean.MeetRedPacketBill;
import com.sevenpay.bms.meeting.redPacket.bean.MeetRedPacketBillConditionBean;

@MapperScan
public interface MeetRedPacketBillMapper {
  
    List<MeetRedPacketBill> selectRedPacket(MeetRedPacketBillConditionBean record);
}