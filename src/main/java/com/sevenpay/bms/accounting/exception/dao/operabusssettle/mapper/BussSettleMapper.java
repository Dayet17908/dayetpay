package com.sevenpay.bms.accounting.exception.dao.operabusssettle.mapper;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.accounting.exception.dao.operabusssettle.bean.BussSettleBean;
import com.sevenpay.bms.merchant.settle.bean.MerchantSettle;
/**
 * 
 * @author shen
 *
 */
@MapperScan
public interface BussSettleMapper {
	/**
	 * 查询商户结算订单
	 * @param id
	 * @return
	 */
	BussSettleBean selectBussSettleApplyById(String id);
	
	/**
	 * 修改商户结算订单
	 * @param settleBean
	 * @return
	 */
	int updateMerchantSettleStatus(MerchantSettle settleBean);
}
