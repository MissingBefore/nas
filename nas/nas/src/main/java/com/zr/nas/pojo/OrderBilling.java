package com.zr.nas.pojo;



public class OrderBilling {
	private String u_id;
	private String order_num;
	private String order_price;
	private String order_paymethod;
	private String order_state;
	private String order_createdate;
	private String remarks;
	public OrderBilling(String u_id, String order_num, String order_price, String order_paymethod, String order_state,
			String order_createdate, String remarks) {
		super();
		this.u_id = u_id;
		this.order_num = order_num;
		this.order_price = order_price;
		this.order_paymethod = order_paymethod;
		this.order_state = order_state;
		this.order_createdate = order_createdate;
		this.remarks = remarks;
	}
	public OrderBilling() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getOrder_price() {
		return order_price;
	}
	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}
	public String getOrder_paymethod() {
		return order_paymethod;
	}
	public void setOrder_paymethod(String order_paymethod) {
		this.order_paymethod = order_paymethod;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public String getOrder_createdate() {
		return order_createdate;
	}
	public void setOrder_createdate(String order_createdate) {
		this.order_createdate = order_createdate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "OrderBilling [u_id=" + u_id + ", order_num=" + order_num + ", order_price=" + order_price
				+ ", order_paymethod=" + order_paymethod + ", order_state=" + order_state + ", order_createdate="
				+ order_createdate + ", remarks=" + remarks + "]";
	}
	
}
