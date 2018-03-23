package com.sevenpay.bms.merchant.reported.bean;

import java.io.Serializable;

public class CategoryCodeKftInfo implements Serializable{

	private static final long serialVersionUID = 6673823426948167551L;
	
	private String firstLvCode;
	
	private String firstLvName;
	
	private String secondLvCode;
	
	private String secondLvName;
	
	private String thirdLvCode;
	
	private String thirdLvName;

	public String getFirstLvCode() {
		return firstLvCode;
	}

	public void setFirstLvCode(String firstLvCode) {
		this.firstLvCode = firstLvCode;
	}

	public String getFirstLvName() {
		return firstLvName;
	}

	public void setFirstLvName(String firstLvName) {
		this.firstLvName = firstLvName;
	}

	public String getSecondLvCode() {
		return secondLvCode;
	}

	public void setSecondLvCode(String secondLvCode) {
		this.secondLvCode = secondLvCode;
	}

	public String getSecondLvName() {
		return secondLvName;
	}

	public void setSecondLvName(String secondLvName) {
		this.secondLvName = secondLvName;
	}

	public String getThirdLvCode() {
		return thirdLvCode;
	}

	public void setThirdLvCode(String thirdLvCode) {
		this.thirdLvCode = thirdLvCode;
	}

	public String getThirdLvName() {
		return thirdLvName;
	}

	public void setThirdLvName(String thirdLvName) {
		this.thirdLvName = thirdLvName;
	}
}
