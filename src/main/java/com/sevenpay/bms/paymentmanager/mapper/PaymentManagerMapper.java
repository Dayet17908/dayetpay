package com.sevenpay.bms.paymentmanager.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.paymentmanager.bean.TdBankCardBin;
import com.sevenpay.bms.paymentmanager.bean.TdPaymentBatDetail;
import com.sevenpay.bms.paymentmanager.bean.TdPaymentBatInfo;

/**
 * @project sevenpay-bms-web
 * @fileName MerchantSettleMapper.java
 * @author huiquan.ma
 * @date 2015年10月10日
 * @memo
 */
@MapperScan
public interface PaymentManagerMapper {

	/**
	 * 查询代付明细
	 * @param selectBean
	 * @return
	 */
	List<TdPaymentBatDetail> selecPaymentList(String batNo);
	
	/**
	 * 批量插入
	 * @param selectBean
	 * @return
	 */
	int insertPaymentList(List<TdPaymentBatDetail> bean);
	
	/**
	 * 查询银行号
	 * @param selectBean
	 * @return
	 */
	List<TdBankCardBin> selectCardBinList();

	int upPaymentBatDetail(TdPaymentBatDetail updateBean);

	int insertBatInfo(TdPaymentBatInfo bean);
	
	int upPaymentBatInfo(TdPaymentBatInfo bean);
	
	int updateDetailBatch(List<TdPaymentBatDetail> bean);
	
	List<TdPaymentBatDetail> getBatchFailPaymentList(String batNo);
}
