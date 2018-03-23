package com.sevenpay.bms.accounting.calendar.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.accounting.calendar.bean.CalendarVo;

@MapperScan
public interface CalendarVoMapper {

	List<CalendarVo> selectCalendarList(CalendarVo queryBean);

	int updateCalendar(CalendarVo updateBean);
}
