package UserStatus;

import java.lang.reflect.Field;

import org.gyzb.platform.common.annotation.Description;

public enum tradeType {
	/**
	 * 支付
	 */
	@Description("支付")
	OUT,
	
	/**
	 * 小额支付
	 */
	@Description("退款")
	IN;
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
