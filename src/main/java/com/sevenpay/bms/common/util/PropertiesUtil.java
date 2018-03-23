package com.sevenpay.bms.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 配置文件单例
 */

public class PropertiesUtil {

	private static Properties properties = null;
	
	public static Properties  getProperties(){
		
		if(properties == null){
			synchronized(PropertiesUtil.class){
				if(properties == null){
				InputStream	inputStream = PropertiesUtil.class.getResourceAsStream("/uploadFileConfig.properties");
				try {
					properties = new Properties();
					properties.load(inputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(inputStream!= null){
						try {
							inputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
					
				}
			}
		}
		
		return properties;
	}
}
