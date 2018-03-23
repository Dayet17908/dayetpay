package com.sevenpay.bms.accounting.exception.dao.kingdeeclear.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.exception.dao.kingdeeclear.bean.KingdeePayEntry;
import com.sevenpay.bms.accounting.exception.dao.kingdeeclear.mapper.KingdeeClearMapper;

@Repository
public class KingdeeClearDao {

	@Autowired
	private KingdeeClearMapper kingdeeClearMapper;

	@Page
	public List<KingdeePayEntry> queryKingdeeEntryList(String clearId) {
		return kingdeeClearMapper.queryKingdeeEntryList(clearId);
	}

}
