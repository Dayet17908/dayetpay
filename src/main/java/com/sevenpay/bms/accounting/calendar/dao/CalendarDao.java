package com.sevenpay.bms.accounting.calendar.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.calendar.bean.CalendarVo;
import com.sevenpay.bms.accounting.calendar.mapper.CalendarVoMapper;

@Repository
public class CalendarDao {
	
	@Autowired
	private CalendarVoMapper calendarVoMapper;

	@Page
	public List<CalendarVo> selectCalendarList(CalendarVo queryBean) {
		return calendarVoMapper.selectCalendarList(queryBean);
	}
}
