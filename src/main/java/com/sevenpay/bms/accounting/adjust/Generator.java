package com.sevenpay.bms.accounting.adjust;

import org.gyzb.platform.third.mybatis.generator.MyBatisMapperGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mybatis辅助类生成
 */
public class Generator {

	private static final Logger logger = LoggerFactory.getLogger(Generator.class);

	public static void main(String[] args) throws Exception {
		
		MyBatisMapperGenerator myBatisMapperGenerator = new MyBatisMapperGenerator();
		
		myBatisMapperGenerator.setConfigFileName(MyBatisMapperGenerator.XML_CONFIG_FILE);
//		myBatisMapperGenerator.generate();

		logger.info("生成完毕");

	}

}
