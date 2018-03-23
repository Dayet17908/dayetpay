package com.sevenpay.bms.basemanager.city.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sevenpay.bms.basemanager.city.bean.City;
import com.sevenpay.bms.basemanager.city.bean.CityNew;
import com.sevenpay.bms.basemanager.city.bean.ProvinceCityBean;
import com.sevenpay.bms.basemanager.city.bean.RegionsBean;

/**
 * 城市持久层
 * 
 * @project sevenpay-bms-web
 * @fileName CityMapper.java
 * @author Dayet
 * @date 2015年5月12日
 * @memo 
 */

@MapperScan
public interface CityMapper {
	
	public List<City> selectCitys(City city);
	
	public List<City> selectAllProvince();
	
	public List<RegionsBean> selectSpProvince();
	
	public List<City> getCityByProvinceId(String provinceId);

	public List<RegionsBean> getSpCityByProvinceId(String provinceId);
	
	public List<City> getAreaByCityId(String cityId);
	
	public List<RegionsBean> getSpAreaByCityId(String cityId);

	public List<City> getAreaByAreaId(String areaId);
	
	public int addProvince(City proninceBean);
	
	public int addCity(City cityBean);

	public int addArea(City areaBean);

	public int updateProvince(City provinceBean);

	public int updateCity(City cityBean);

	public int updateArea(City areaBean);
	
	public ProvinceCityBean findProvineAndCity(String provinceId, String cityId);

	public String findProvineNameById(Integer provinceId);

	public String findCityName(City city);

	public int deleteArea(City deleteBean);

	public int deleteCity(City deleteBean);

	public int deleteProvince(City deleteBean);
	
	public int getProvinceList(City deleteBean);
	
	
	/**
	 * 账户信息-查询省份列表
	 * @return
	 */
	public List<City> getProvinceLists();
	
	/**
	 * 账户信息-查询城市列表
	 * @return
	 */
	public List<City> getCityList(CityNew city);
	
	/**
	 * 账户信息-查询区域列表
	 * @return
	 */
	public List<City> getAreaList(CityNew city);
		
}
