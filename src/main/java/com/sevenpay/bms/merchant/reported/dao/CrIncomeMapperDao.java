package com.sevenpay.bms.merchant.reported.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.merchant.bean.CategoryCodeInfo;
import com.sevenpay.bms.merchant.reported.bean.CategoryCodeKftInfo;
import com.sevenpay.bms.merchant.reported.bean.ChannlInfo;
import com.sevenpay.bms.merchant.reported.bean.CrInComeBean;
import com.sevenpay.bms.merchant.reported.bean.MerchantFilingInfo;
import com.sevenpay.bms.merchant.reported.bean.MerchantProdInfo;
import com.sevenpay.bms.merchant.reported.mapper.CrIncomeMapper;


@Repository
public class CrIncomeMapperDao {
	@Autowired
	private CrIncomeMapper crIncomeMapper;
	
  public List<CrInComeBean> getInComeInfo(@Param("merchantCode") String merchantCode){
	
	   return crIncomeMapper.getInComeInfo(merchantCode);
  }
	
	public void updateInComeInfo(List<CrInComeBean> beans){
        crIncomeMapper.updateInComeInfo(beans);
	}
	
	public void insertFilingInfo(List<CrInComeBean> list){
		crIncomeMapper.insertFilingInfo(list);
	}
	
	public MerchantProdInfo getMerchantProdInfo(@Param("merchantCode") String merchantCode){
		return crIncomeMapper.getMerchantProdInfo(merchantCode);
	}
	
	public List<ChannlInfo> getChannlInfoList(){
		return crIncomeMapper.getChannlInfoList();
	}
	
	@Page
	public List<MerchantFilingInfo> getfilingInfoList(MerchantFilingInfo merchantCode){
		return crIncomeMapper.getfilingInfoList(merchantCode);
	}
	
	/**
	 * 校验商户是否报备
	 * @param merchantCode
	 * @return
	 */
	public List<MerchantFilingInfo> verifyFiling(MerchantFilingInfo merchantCode){
		return crIncomeMapper.verifyFiling(merchantCode);
	}
	
	/**
	 * 获取合利宝的省份ID
	 * @param provinceId
	 * @return
	 */
	public String getProvinceId(String provinceId){
		return crIncomeMapper.getProvinceId(provinceId);
	}
	
	/**
	 * 获取合利宝的城市ID
	 * @param cityId
	 * @return
	 */
	public String getCityId(String cityId){
		return crIncomeMapper.getCityId(cityId);
	}
	
	/**
	 * 获取合利宝的地区ID
	 * @param cityId
	 * @return
	 */
	public String getAreaId(String areaId){
		return crIncomeMapper.getAreaId(areaId);
	}
	
	public String getAreaIdByProvidAndAreaId(String provinceId,String areaId){
		return crIncomeMapper.getAreaIdByProvidAndAreaId(provinceId,areaId);
	}
	
	/**
	 * 获取快付通地区ID
	 * @param areaId
	 * @return
	 */
	public String getKftAreaId(String areaId){
		return crIncomeMapper.getKftAreaId(areaId);
	}
	public CategoryCodeInfo getCategoryTypeInfo(String merchantId){
		return crIncomeMapper.getCategoryTypeInfo(merchantId);
	}
	
	/**
	 * 获取合利宝行业信息
	 * @param categoryId
	 * @return
	 */
	public CategoryCodeInfo getCategoryInfoHelipay(String categoryId){
		return crIncomeMapper.getCategoryInfoHelipay(categoryId);
	}
	
	/**
	 * 获取快付通一级类目
	 * @return
	 */
	public List<CategoryCodeKftInfo> getCategoryInfoFirstLvList(){
		return crIncomeMapper.getCategoryInfoFirstLvList();
	}
	
	/**
	 * 获取快付通二级类目
	 * @param firstLvCode
	 * @return
	 */
	public List<CategoryCodeKftInfo> getCategoryInfoSecondLvList(String firstLvCode){
		return crIncomeMapper.getCategoryInfoSecondLvList(firstLvCode);
	}
	
	/**
	 * 获取快付通三级类目
	 * @param firstLvCode
	 * @return
	 */
	public List<CategoryCodeKftInfo> getCategoryInfoThirdLvList(String secondLvCode){
		return crIncomeMapper.getCategoryInfoThirdLvList(secondLvCode);
	}
	
	/**
	 * 根据联行号查找快付通银行行号
	 * @param bankCnps
	 * @return
	 */
	public String getBankInfoByBankCode(String bankCnps){
		return crIncomeMapper.getBankInfoByBankCode(bankCnps);
	}
	
	/**
	 * 修改报备文件信息
	 * @param merchantCode
	 */
	public void updateFilingInfo(MerchantFilingInfo merchantCode){
		 crIncomeMapper.updateFilingInfo(merchantCode);
	}
}
