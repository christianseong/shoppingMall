package com.hipstercompany.hipster.vo;

public class ItemList {
	String pd_brand;
	String pd_name;
	int pd_price;
	String pd_sex;
	
	
	public String getPd_brand() {
		return pd_brand;
	}
	public void setPd_brand(String pd_brand) {
		this.pd_brand = pd_brand;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public int getPd_price() {
		return pd_price;
	}
	public void setPd_price(int pd_price) {
		this.pd_price = pd_price;
	}
	public String getPd_sex() {
		return pd_sex;
	}
	public void setPd_sex(String pd_sex) {
		this.pd_sex = pd_sex;
	}
	
	public ItemList(String pd_brand, String pd_name, int pd_price, String pd_sex) {
		super();
		this.pd_brand = pd_brand;
		this.pd_name = pd_name;
		this.pd_price = pd_price;
		this.pd_sex = pd_sex;
	}
	
	
}
