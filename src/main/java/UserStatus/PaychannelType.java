package UserStatus;

import java.lang.reflect.Field;

import org.gyzb.platform.common.annotation.Description;

public enum PaychannelType {
	/**
	 * 工商银行
	 */
	@Description("工商银行")
	ICBC,
	/**
	 * 农业银行
	 */
	@Description("农业银行")
	ABC,
	/**
	 * 中信-威富通
	 */
	@Description("中信-威富通")
	CNCB_SWIFT,
	/**
	 * 浦发-威富通
	 */
	@Description("浦发-前海万融")
	SPD_QHWR;
	/**	获取描述性内容	*/
	public String getDesc() {
		Class<?> clazz = this.getClass();
		Field filed = null;
		try {
			filed = clazz.getField(this.name());
		} catch (Exception e) {
		}
		Description description = filed.getAnnotation(Description.class);
		if (description == null) {
			return null;
		} else {
			return description.value();
		}
	}
	
}
