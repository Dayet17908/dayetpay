package com.sevenpay.bms.expresspay.tradeDetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenpay.bms.expresspay.CommonService;
import com.sevenpay.bms.expresspay.tradeDetail.service.TradeDetailService;

@Controller
@RequestMapping(TradeDetailPath.BASE)
public class TradeDetailController {

	@Autowired
	private TradeDetailService tradeDetailService;

	@Autowired
	private CommonService commonService;

	

}
