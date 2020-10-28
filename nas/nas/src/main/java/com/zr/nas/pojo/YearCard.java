package com.zr.nas.pojo;

import java.util.Date;

public class YearCard {
	private String phone;
	private String name;
	private String yc_amount;
	private String license_plate;
	private Date yc_fromtime;
	private Date yc_totime;
	private int yc_state;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYc_amount() {
		return yc_amount;
	}
	public void setYc_amount(String yc_amount) {
		this.yc_amount = yc_amount;
	}
	public String getLicense_plate() {
		return license_plate;
	}
	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}
	public Date getYc_fromtime() {
		return yc_fromtime;
	}
	public void setYc_fromtime(Date yc_fromtime) {
		this.yc_fromtime = yc_fromtime;
	}
	public Date getYc_totime() {
		return yc_totime;
	}
	public void setYc_totime(Date yc_totime) {
		this.yc_totime = yc_totime;
	}
	public int getYc_state() {
		return yc_state;
	}
	public void setYc_state(int yc_state) {
		this.yc_state = yc_state;
	}
	public YearCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public YearCard(String phone, String name, String yc_amount, String license_plate, Date yc_fromtime, Date yc_totime,
			int yc_state) {
		super();
		this.phone = phone;
		this.name = name;
		this.yc_amount = yc_amount;
		this.license_plate = license_plate;
		this.yc_fromtime = yc_fromtime;
		this.yc_totime = yc_totime;
		this.yc_state = yc_state;
	}
	@Override
	public String toString() {
		return "YearCard [phone=" + phone + ", name=" + name + ", yc_amount=" + yc_amount + ", license_plate="
				+ license_plate + ", yc_fromtime=" + yc_fromtime + ", yc_totime=" + yc_totime + ", yc_state=" + yc_state
				+ "]";
	}
	
	
	
}
