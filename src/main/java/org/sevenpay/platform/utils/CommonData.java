package org.sevenpay.platform.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class CommonData {
	private static Logger log = Logger.getLogger(CommonData.class);

	private static String testFlag = null;

	private static Map<String, String> configMessage = null;

	static {
		try {
			Properties configProperties = new Properties();
			configProperties.load(CommonData.class.getResourceAsStream("/config.properties"));
			configMessage = new HashMap<String, String>((Map) configProperties);
		} catch (Exception e) {
			log.error("处理配置文件config.properties失败！" + e);
		}
	}

	public CommonData() {

	}

	public String getTestFlag() {
		if (null == testFlag) {
			testFlag = configMessage.get("IS_TEST");
		}
		return testFlag;
	}

	public Map<String, String> getConfigMessage() {
		return configMessage;
	}

}
