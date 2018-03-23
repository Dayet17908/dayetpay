package com.sevenpay.bms.basemanager.trade.mapper;

import java.util.List;

import com.sevenpay.bms.basemanager.trade.bean.TdTradeBillMainVO;
import com.sevenpay.bms.basemanager.trade.bean.TradeExcel;
import com.sevenpay.bms.basemanager.trade.bean.TradeSummaryExcel;
import com.sevenpay.bms.common.annotation.MapperScanSub;

/**
 * 交易信息
 * 
 * @project sevenpay-bms-web
 * @fileName TdTradeBillMainMapper
 * @author Dayet
 * @date 2015年6月26日
 * @memo 
 */

@MapperScanSub
public interface TdTradeBillMainMapper {
	
	public List<TdTradeBillMainVO> selectTdradeBillMainSummary(TdTradeBillMainVO tdTradeBillMainVo);
	
	public List<TradeSummaryExcel> selectTradeSummaryExcel(TdTradeBillMainVO tdTradeBillMainVo);
	
	public List<TdTradeBillMainVO> selectConsume(TdTradeBillMainVO tdTradeBillMainVo);
	
	public List<TradeExcel> selectTradeConsumeExcel(TdTradeBillMainVO tdTradeBillMainVo);
	
	public TdTradeBillMainVO selectTdradeBillMainByOrderId(String orderId);
	
	/**
	 * 红包支付
	 * @param orderId
	 * @return
	 */
	public TdTradeBillMainVO selectRedpacketPaymentByOrderId(String orderId);
	
}
