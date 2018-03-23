package com.sevenpay.bms.basemanager.custInfo.bean;

/**
 * 客户管理
 */
import java.math.BigDecimal;

public class TdCustInfo implements java.io.Serializable {

	

	/************************************************************************************/

	/** 客户编号 **/
	private String custId;

	/** 客户名称 **/
	private String custName;

	/** 客户密码 **/
	private String tradePwd;
	
	/** 附加串**/
	private String attachStr;

	/** 证件类型 **/
	private String certifyType;

	private String certifyName;

	/** 证件号 **/
	private String certifyNo;

	/** 客户类型 0 个人 1 企业 **/
	private String custType;

	/** 商户标志：0 商户，1 非商户 **/
	private String merchantFlag;

	/** 客户积分 **/
	private BigDecimal custScore;

	/** 客户等级 **/
	private String custLvl;

	/** 实名认证等级：0：未认证；1：1级认证；2：2级认证；3：3级认证。 **/
	private String trustCertifyLvl;

	/** 实名认证审核状态：00：0级审核通过；01：0级审核中；02：0级审核不通过 **/
	private String trustCertifyAuditState;

	/** 客户信息完整度，分几级：0、1 **/
	private String custInfoLvl;

	/** 客户地址 **/
	private String custAdd;

	/** 邮编 **/
	private String custPostCode;

	/** 营业执照编号 **/
	private String businessLicense;

	/** 税务登记号 **/
	private String taxRegCert;

	/** 法人证件类型 **/
	private String representativeCertType;

	/** 法人证件号码 **/
	private String representativeCertNo;

	/** 法人姓名 **/
	private String representativeName;

	/** 注册资本 **/
	private BigDecimal regCapital;

	/** 企业类型 国企：01 外企：00民企:02 **/
	private String entType;

	/** 所属行业 **/
	private String industryBelong;

	/** 年营业额 **/
	private BigDecimal yearTurnover;

	/** 商户网址 **/
	private String merchantWebSite;

	/** 客户状态：00 有效；01 待审核；02 注销；03 冻结；04 审核不通过 **/
	private String state;

	/** 是否证书认证：如开启证书认证，则只能在安装了证书的电脑上进行支付 **/
	private String isUseCertification;

	/** 是否短信认证：如开启短信认证，则账户相关设置或资金变动都需要输入手机验证码 **/
	private String isUseMsg;

	/** 创建人 **/
	private String createId;

	/** 注册时间 **/
	private String createTime;

	/** 最后更新人 **/
	private String modifyId;

	/** 最后更新时间 **/
	private String modifyTime;

	/** 七分钱账号 **/
	private String qfqAccId;

	/** 描述信息 **/
	private String desc;

	/** 手机号码 **/
	private String mobile;
	
	/**
	 * 邮箱
	 */
	private String email;
	

	/** 搜索开始时间 **/
	private String startTime;
	
	/** 搜索结束时间 **/
	private String endTime;
	
	private String authId;
	
	/** 七分钱余额 **/
	private String qfqTotalAmt;

	/** 来往单位编号*/
	private String fcontactunitNumber;
	private String isClear;
	
	/**
	 * 备注
	 */
	private String comment;

	private String blackAndWhiter;
	private String createBlackAndWhiterTime;
	
	private String blackAdnWhiteCode;
	
	private String compMainAcct;
	
	private String compAcctBank;
	
	private String representativeMobile;
	
	private String merchantCode;
	
	private static final long serialVersionUID = 1L;
	
	
	
	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getRepresentativeMobile() {
		return representativeMobile;
	}

	public void setRepresentativeMobile(String representativeMobile) {
		this.representativeMobile = representativeMobile;
	}

	public String getCompAcctBank() {
		return compAcctBank;
	}

	public void setCompAcctBank(String compAcctBank) {
		this.compAcctBank = compAcctBank;
	}

	public String getCompMainAcct() {
		return compMainAcct;
	}

	public void setCompMainAcct(String compMainAcct) {
		this.compMainAcct = compMainAcct;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getFcontactunitNumber() {
		return fcontactunitNumber;
	}

	public void setFcontactunitNumber(String fcontactunitNumber) {
		this.fcontactunitNumber = fcontactunitNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	public String getBlackAndWhiter() {
		return blackAndWhiter;
	}

	public void setBlackAndWhiter(String blackAndWhiter) {
		this.blackAndWhiter = blackAndWhiter;
	}

	public String getCustName() {
		return custName;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getTradePwd() {
		return tradePwd;
	}

	public void setTradePwd(String tradePwd) {
		this.tradePwd = tradePwd;
	}

	public String getCertifyType() {
		return certifyType;
	}

	public void setCertifyType(String certifyType) {
		this.certifyType = certifyType;
	}

	public String getCertifyNo() {
		return certifyNo;
	}

	public void setCertifyNo(String certifyNo) {
		this.certifyNo = certifyNo;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getMerchantFlag() {
		return merchantFlag;
	}

	public void setMerchantFlag(String merchantFlag) {
		this.merchantFlag = merchantFlag;
	}

	public BigDecimal getCustScore() {
		return custScore;
	}

	public void setCustScore(BigDecimal custScore) {
		this.custScore = custScore;
	}

	public String getCustLvl() {
		return custLvl;
	}

	public void setCustLvl(String custLvl) {
		this.custLvl = custLvl;
	}

	public String getTrustCertifyLvl() {
		return trustCertifyLvl;
	}

	public void setTrustCertifyLvl(String trustCertifyLvl) {
		this.trustCertifyLvl = trustCertifyLvl;
	}

	public String getTrustCertifyAuditState() {
		return trustCertifyAuditState;
	}

	public void setTrustCertifyAuditState(String trustCertifyAuditState) {
		this.trustCertifyAuditState = trustCertifyAuditState;
	}

	public String getCustInfoLvl() {
		return custInfoLvl;
	}

	public void setCustInfoLvl(String custInfoLvl) {
		this.custInfoLvl = custInfoLvl;
	}

	public String getCustAdd() {
		return custAdd;
	}

	public void setCustAdd(String custAdd) {
		this.custAdd = custAdd;
	}

	public String getCustPostCode() {
		return custPostCode;
	}

	public void setCustPostCode(String custPostCode) {
		this.custPostCode = custPostCode;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getTaxRegCert() {
		return taxRegCert;
	}

	public void setTaxRegCert(String taxRegCert) {
		this.taxRegCert = taxRegCert;
	}

	public String getRepresentativeCertType() {
		return representativeCertType;
	}

	public void setRepresentativeCertType(String representativeCertType) {
		this.representativeCertType = representativeCertType;
	}

	public String getRepresentativeCertNo() {
		return representativeCertNo;
	}

	public void setRepresentativeCertNo(String representativeCertNo) {
		this.representativeCertNo = representativeCertNo;
	}

	public String getRepresentativeName() {
		return representativeName;
	}

	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}

	public BigDecimal getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(BigDecimal regCapital) {
		this.regCapital = regCapital;
	}

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getIndustryBelong() {
		return industryBelong;
	}

	public void setIndustryBelong(String industryBelong) {
		this.industryBelong = industryBelong;
	}

	public BigDecimal getYearTurnover() {
		return yearTurnover;
	}

	public void setYearTurnover(BigDecimal yearTurnover) {
		this.yearTurnover = yearTurnover;
	}

	public String getMerchantWebSite() {
		return merchantWebSite;
	}

	public void setMerchantWebSite(String merchantWebSite) {
		this.merchantWebSite = merchantWebSite;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIsUseCertification() {
		return isUseCertification;
	}

	public void setIsUseCertification(String isUseCertification) {
		this.isUseCertification = isUseCertification;
	}

	public String getIsUseMsg() {
		return isUseMsg;
	}

	public void setIsUseMsg(String isUseMsg) {
		this.isUseMsg = isUseMsg;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getModifyId() {
		return modifyId;
	}

	public void setModifyId(String modifyId) {
		this.modifyId = modifyId;
	}


	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getQfqAccId() {
		return qfqAccId;
	}

	public void setQfqAccId(String qfqAccId) {
		this.qfqAccId = qfqAccId;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCertifyName() {
		return certifyName;
	}

	public void setCertifyName(String certifyName) {
		this.certifyName = certifyName;
	}

	public String getQfqTotalAmt() {
		return qfqTotalAmt;
	}

	public void setQfqTotalAmt(String qfqTotalAmt) {
		this.qfqTotalAmt = qfqTotalAmt;
	}


	public String getCreateBlackAndWhiterTime() {
		return createBlackAndWhiterTime;
	}

	public void setCreateBlackAndWhiterTime(String createBlackAndWhiterTime) {
		this.createBlackAndWhiterTime = createBlackAndWhiterTime;
	}

	public String getBlackAdnWhiteCode() {
		return blackAdnWhiteCode;
	}

	public void setBlackAdnWhiteCode(String blackAdnWhiteCode) {
		this.blackAdnWhiteCode = blackAdnWhiteCode;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAttachStr() {
		return attachStr;
	}

	public void setAttachStr(String attachStr) {
		this.attachStr = attachStr;
	}

	public String getIsClear() {
		return isClear;
	}

	public void setIsClear(String isClear) {
		this.isClear = isClear;
	}
	
}