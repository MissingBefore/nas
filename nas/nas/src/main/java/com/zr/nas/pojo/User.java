package com.zr.nas.pojo;

public class User {
	private Integer id;
	private String name;
	private String phone;
	private String location;
	private String remarks;
	private int car_count;  //车数量
	private int debit_count;  //储值卡数量
	private int yc_count; //年卡数量
	private int gift_count;  //大礼包数量 
	private int order_count; //订单数量
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", location=" + location + ", remarks="
				+ remarks + ", car_count=" + car_count + ", debit_count=" + debit_count + ", yc_count=" + yc_count
				+ ", gift_count=" + gift_count + ", order_count=" + order_count + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String phone, String location, String remarks, int car_count, int debit_count,
			int yc_count, int gift_count, int order_count) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.location = location;
		this.remarks = remarks;
		this.car_count = car_count;
		this.debit_count = debit_count;
		this.yc_count = yc_count;
		this.gift_count = gift_count;
		this.order_count = order_count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getCar_count() {
		return car_count;
	}
	public void setCar_count(int car_count) {
		this.car_count = car_count;
	}
	public int getDebit_count() {
		return debit_count;
	}
	public void setDebit_count(int debit_count) {
		this.debit_count = debit_count;
	}
	public int getYc_count() {
		return yc_count;
	}
	public void setYc_count(int yc_count) {
		this.yc_count = yc_count;
	}
	public int getGift_count() {
		return gift_count;
	}
	public void setGift_count(int gift_count) {
		this.gift_count = gift_count;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

}
