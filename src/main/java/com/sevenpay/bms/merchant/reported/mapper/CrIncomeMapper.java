package com.sevenpay.bms.merchant.reported.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.basemanager.merchant.bean.CategoryCodeInfo;
import com.sevenpay.bms.merchant.reported.bean.CategoryCodeKftInfo;
import com.sevenpay.bms.merchant.reported.bean.ChannlInfo;
import com.sevenpay.bms.merchant.reported.bean.CrInComeBean;
import com.sevenpay.bms.merchant.reported.bean.MerchantFilingInfo;
import com.sevenpay.bms.merchant.reported.bean.MerchantProdInfo;

@MapperScan
public interface CrIncomeMapper {

	public   List<CrInComeBean> getInComeInfo(@Param("merchantCode") String merchantCode);
	
	public void updateInComeInfo(List<CrInComeBean> beans);
	
	public void insertFilingInfo(List<CrInComeBean> list);
	
	public MerchantProdInfo getMerchantProdInfo(@Param("merchantCode") String merchantCode);

	public List<ChannlInfo> getChannlInfoList();
	
	public List<MerchantFilingInfo> getInComeInfoList(MerchantFilingInfo merchantCode);
	
	public List<MerchantFilingInfo> getfilingInfoList(MerchantFilingInfo merchantCode);
	
	public List<MerchantFilingInfo> verifyFiling(MerchantFilingInfo merchantCode);
	
	/**
	 * 获取合利宝的省份ID
	 * @param provinceId
	 * @return
	 */
	public String getProvinceId(@Param("provinceId")String provinceId);
	
	/**
	 * 获取合利宝的城市ID
	 * @param cityId
	 * @return
	 */
	public String getCityId(@Param("cityId")String cityId);
	
	/**
	 * 获取合利宝的地区ID
	 * @param cityId
	 * @return
	 */
	public String getAreaId(@Param("areaId")String areaId);
	
	/**
	 * 获取快付通地区ID
	 * @param areaId
	 * @return
	 */
	public String getKftAreaId(@Param("areaId")String areaId);
	
	public CategoryCodeInfo getCategoryTypeInfo(@Param("merchantId")String merchantId);
	
	public CategoryCodeInfo getCategoryInfoHelipay(@Param("categoryId")String categoryId);
	
	/**
	 * 获取快付通一级类目
	 * @return
	 */
	public List<CategoryCodeKftInfo> getCategoryInfoFirstLvList();
	
	/**
	 * 获取快付通二级类目
	 * @param firstLvCode
	 * @return
	 */
	public List<CategoryCodeKftInfo> getCategoryInfoSecondLvList(@Param("firstLvCode") String firstLvCode);
	
	/**
	 * 获取快付通三级类目
	 * @param firstLvCode
	 * @return
	 */
	public List<CategoryCodeKftInfo> getCategoryInfoThirdLvList(@Param("secondLvCode") String secondLvCode);
	
	/**
	 * 根据联行号查找快付通银行行号
	 * @param bankCnps
	 * @return
	 */
	public String getBankInfoByBankCode(@Param("bankCnps")String bankCnps);
	
	/**
	 * 修改报备文件信息
	 * @param merchantCode
	 */
	public void updateFilingInfo(MerchantFilingInfo merchantCode);
	
	/**
	 * 根据省份ID ，区域ID 查找合利宝区域编号
	 * @param provinceId
	 * @param areaId
	 * @return
	 */
	public String getAreaIdByProvidAndAreaId(@Param("provinceId")String provinceId, @Param("areaId")String areaId);
}
