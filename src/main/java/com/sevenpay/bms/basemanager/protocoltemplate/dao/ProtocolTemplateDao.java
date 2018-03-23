package com.sevenpay.bms.basemanager.protocoltemplate.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.protocoltemplate.bean.ProtocolTemplate;
import com.sevenpay.bms.basemanager.protocoltemplate.mapper.ProtocolTemplateMapper;

@Repository
public class ProtocolTemplateDao {
	@Autowired
	private ProtocolTemplateMapper protocolTemplateMapper;

	/**
	 * 
	 * @param queryBean
	 * @return
	 */
	@Page
	public List<ProtocolTemplate> select(ProtocolTemplate queryBean) {
		return protocolTemplateMapper.select(queryBean);
	}
}
