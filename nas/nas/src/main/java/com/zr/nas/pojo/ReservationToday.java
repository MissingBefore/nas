package com.zr.nas.pojo;

public class ReservationToday {
	String name;
	String phone;
	String brand;//品牌
	String model;//车牌号
	String appoint_time;//预约时间
	String service_name;//服务名称
	String reservation_remark;//预约备注
	
	public ReservationToday(String name, String phone, String brand, String model, String appoint_time,
			String service_name, String reservation_remark) {
		super();
		this.name = name;
		this.phone = phone;
		this.brand = brand;
		this.model = model;
		this.appoint_time = appoint_time;
		this.service_name = service_name;
		this.reservation_remark = reservation_remark;
	}
	
	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getReservation_remark() {
		return reservation_remark;
	}

	public void setReservation_remark(String reservation_remark) {
		this.reservation_remark = reservation_remark;
	}

	public ReservationToday() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getAppoint_time() {
		return appoint_time;
	}
	public void setAppoint_time(String appoint_time) {
		this.appoint_time = appoint_time;
	}
	public String getDetail() {
		return service_name;
	}
	public void setDetail(String service_name) {
		this.service_name = service_name;
	}

	@Override
	public String toString() {
		return "ReservationToday [name=" + name + ", phone=" + phone + ", brand=" + brand + ", model=" + model
				+ ", appoint_time=" + appoint_time + ", service_name=" + service_name + ", reservation_remark="
				+ reservation_remark + "]";
	}
	
	
}
