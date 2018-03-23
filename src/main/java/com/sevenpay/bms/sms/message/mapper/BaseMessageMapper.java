package com.sevenpay.bms.sms.message.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.sms.message.bean.BaseMessage;

/**
 * 
 * @author shen
 * 
 */
@MapperScan
public interface BaseMessageMapper {

	/**
	 * 查询
	 * 
	 * @param queryBean
	 * @return
	 */
	List<BaseMessage> selectBaseMessageList(BaseMessage queryBean);

	/**
	 * 新增
	 * 
	 * @param insertBean
	 * @return
	 */
	int insertBaseMessage(BaseMessage insertBean);

	/**
	 * 修改
	 * 
	 * @param insertBean
	 * @return
	 */
	int updateBaseMessage(BaseMessage updateBean);

	/**
	 * 删除
	 * @param deleteBean
	 * @return
	 */
	int deleteBaseMessage(BaseMessage deleteBean);
	
	/****
	 *修改单个 
	 * @param baseMessageBean
	 * @return
	 */
	int updateSingleMessage(BaseMessage baseMessageBean);
	
	/**
	 * 根据ID查询
	 * @param queryBean
	 * @return
	 */
	BaseMessage selectBaseMessageById(BaseMessage queryBean);

}
