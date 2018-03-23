package com.sevenpay.bms.accounting.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author wujian
 * 加载config.properties工具类
 */
public class CommonConfig {

	private Logger logger=LoggerFactory.getLogger(CommonConfig.class);
	private static Map<String,String> config=new HashMap<String,String>();
	private static CommonConfig common=null;
	
	public synchronized static CommonConfig getInstance(){
		if(null==common){
			common=new CommonConfig();
		}
		return common;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private CommonConfig(){

		Properties properties = new Properties();
		try {
			properties.load(CommonConfig.class.getResourceAsStream("/config.properties"));
			config = new HashMap<String, String>((Map)properties);
			logger.info("--------init message done !config map size is ---------"+config.size());
		} catch (IOException e) {
			logger.error("初始化配置文件config.properties异常", e);
			throw new RuntimeException("初始化配置文件config.properties异常");
		}
		
		
	}
	
	public String getValue(String key){
		logger.debug("the key is "+"--------"+key+"--------");
		return config.get(key);
	}
	
	
	public static void main(String args[]){
		System.err.println(CommonConfig.getInstance().getValue("VERSION"));
	}
}
