package UserStatus;

import java.lang.reflect.Field;

import org.gyzb.platform.common.annotation.Description;

public enum BusiTypeState {
	
	/**
	 * H5
	 */
	@Description("H5")
	H5,
	
	/**
	 * PC
	 */
	@Description("PC支付")
	PC,
	
	/**
	 * APP支付
	 */
	@Description("APP支付")
	APP,
	
	/**
	 * 小额支付
	 */
	@Description("小额支付")
	MICROPAY;
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
