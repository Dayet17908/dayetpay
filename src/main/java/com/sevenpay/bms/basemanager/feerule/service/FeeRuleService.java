package com.sevenpay.bms.basemanager.feerule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.basemanager.feerule.bean.FeeRule;
import com.sevenpay.bms.basemanager.feerule.mapper.FeeRuleMapper;

@Service
public class FeeRuleService {
	@Autowired 
	private FeeRuleMapper mapper;
	public void updateFeeRule(FeeRule feeRule){		
			if(null == feeRule){
				throw new IllegalArgumentException("手续费对象为空");
			}
			mapper.updateFeeRule(feeRule);			
	}
	
	public FeeRule selectFeeRule(FeeRule feeRule){
		if(null == feeRule){
			throw new IllegalArgumentException("手续费对象为空");
		}
		return mapper.selectFeeRule(feeRule);
	}

}
