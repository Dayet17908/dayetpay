package org.sevenpay.platform.web.schedulerLog;

import java.util.List;

import org.sevenpay.platform.web.schedulerLog.bean.SchedulerLog;
import org.sevenpay.platform.web.schedulerLog.serive.SchedulerLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(SchedulerLogPath.BASE)
public class SchedulerLogController {
	private Logger logger = LoggerFactory.getLogger(SchedulerLogController.class);
	@Autowired
	private SchedulerLogService service;
	
	@RequestMapping(SchedulerLogPath.LIST)
	public ModelAndView SchedulerLogList(SchedulerLog schedulerLog) {
		logger.info("任务调度日志查询对象:{}"+JSONObject.toJSONString(schedulerLog,true));
		ModelAndView mv = new ModelAndView(SchedulerLogPath.BASE + SchedulerLogPath.LIST);
		List<SchedulerLog> list =service.selectSchedulerLogList(schedulerLog);
		mv.addObject("queryBean",schedulerLog);
		mv.addObject("schedulerLogList", JSONObject.toJSON(list));
		return mv;
	}
}
