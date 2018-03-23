package UserStatus;

import java.lang.reflect.Field;

import org.gyzb.platform.common.annotation.Description;

public enum ProductCodeState {
	
	/**
	 * H5支付
	 */
	@Description("h5.gateway.pay")
	H5支付,
	
	/**
	 * APP支付
	 */
	@Description("mobile.plugin.pay")
	APP支付,
	
	/**
	 * 扫码支付
	 */
	@Description("onecode.coll.pay")
	扫码支付,
	
	/**
	 * 网关支付
	 */
	@Description("pc.gateway.pay")
	网关支付,
	
	/**
	 * 原生H5支付
	 */
	@Description("h5_t.gateway.pay")
	原生H5支付;
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
