package com.zr.nas.pojo;

import java.util.Date;

public class Order {
	
	private String id;
	private int u_id;
	private String order_id;
	private double order_price;
	private String user_name;
	private String user_phone;
	private String goods_name;
	private String goods_price;
	private String service_name;
	private String service_price;
	private String emp_name;
	private String order_payMethod;
	private String order_state;
	private Date order_createdate;
	private String remarks;
	private String location;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public double getOrder_price() {
		return order_price;
	}
	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getService_price() {
		return service_price;
	}
	public void setService_price(String service_price) {
		this.service_price = service_price;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getOrder_payMethod() {
		return order_payMethod;
	}
	public void setOrder_payMethod(String order_payMethod) {
		this.order_payMethod = order_payMethod;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public Date getOrder_createdate() {
		return order_createdate;
	}
	public void setOrder_createdate(Date order_createdate) {
		this.order_createdate = order_createdate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, int u_id, String order_id, double order_price, String user_name, String user_phone,
			String goods_name, String goods_price, String service_name, String service_price, String emp_name,
			String order_payMethod, String order_state, Date order_createdate, String remarks, String location) {
		super();
		this.id = id;
		this.u_id = u_id;
		this.order_id = order_id;
		this.order_price = order_price;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.service_name = service_name;
		this.service_price = service_price;
		this.emp_name = emp_name;
		this.order_payMethod = order_payMethod;
		this.order_state = order_state;
		this.order_createdate = order_createdate;
		this.remarks = remarks;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", u_id=" + u_id + ", order_id=" + order_id + ", order_price=" + order_price
				+ ", user_name=" + user_name + ", user_phone=" + user_phone + ", goods_name=" + goods_name
				+ ", goods_price=" + goods_price + ", service_name=" + service_name + ", service_price=" + service_price
				+ ", emp_name=" + emp_name + ", order_payMethod=" + order_payMethod + ", order_state=" + order_state
				+ ", order_createdate=" + order_createdate + ", remarks=" + remarks + ", location=" + location + "]";
	}
	
	
	
	
}
