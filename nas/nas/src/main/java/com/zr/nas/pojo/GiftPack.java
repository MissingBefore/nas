package com.zr.nas.pojo;

import java.util.Date;

public class GiftPack {
	private String phone;
	private String name;
	private double giftPrice;
	private Date gift_fromtime;
	private Date gift_totime;
	private String gift_details;
	public GiftPack() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GiftPack(String phone, String name, double giftPrice, Date gift_fromtime, Date gift_totime,
			String gift_details) {
		super();
		this.phone = phone;
		this.name = name;
		this.giftPrice = giftPrice;
		this.gift_fromtime = gift_fromtime;
		this.gift_totime = gift_totime;
		this.gift_details = gift_details;
	}
	@Override
	public String toString() {
		return "GiftPack [phone=" + phone + ", name=" + name + ", giftPrice=" + giftPrice + ", gift_fromtime="
				+ gift_fromtime + ", gift_totime=" + gift_totime + ", gift_details=" + gift_details + "]";
	}
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
	public double getGiftPrice() {
		return giftPrice;
	}
	public void setGiftPrice(double giftPrice) {
		this.giftPrice = giftPrice;
	}
	public Date getGift_fromtime() {
		return gift_fromtime;
	}
	public void setGift_fromtime(Date gift_fromtime) {
		this.gift_fromtime = gift_fromtime;
	}
	public Date getGift_totime() {
		return gift_totime;
	}
	public void setGift_totime(Date gift_totime) {
		this.gift_totime = gift_totime;
	}
	public String getGift_details() {
		return gift_details;
	}
	public void setGift_details(String gift_details) {
		this.gift_details = gift_details;
	}
	
}
