package com.zr.nas.pojo;

import java.util.Date;

public class Car {
	private int id;
	private int u_id;
	private int old;
	private String brand;
	private String type;
	private String series;
	private String model;
	private double mileage;
	private String license_plate;
	private String engine_model;
	private String driving_license;
	private double guide_price;
	private Date insurance_expiry_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public String getLicense_plate() {
		return license_plate;
	}
	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}
	public String getEngine_model() {
		return engine_model;
	}
	public void setEngine_model(String engine_model) {
		this.engine_model = engine_model;
	}
	public String getDriving_license() {
		return driving_license;
	}
	public void setDriving_license(String driving_license) {
		this.driving_license = driving_license;
	}
	public double getGuide_price() {
		return guide_price;
	}
	public void setGuide_price(double guide_price) {
		this.guide_price = guide_price;
	}
	public Date getInsurance_expiry_date() {
		return insurance_expiry_date;
	}
	public void setInsurance_expiry_date(Date insurance_expiry_date) {
		this.insurance_expiry_date = insurance_expiry_date;
	}
	public Car(int id, int u_id, int old, String brand, String type, String series, String model, double mileage,
			String license_plate, String engine_model, String driving_license, double guide_price,
			Date insurance_expiry_date) {
		super();
		this.id = id;
		this.u_id = u_id;
		this.old = old;
		this.brand = brand;
		this.type = type;
		this.series = series;
		this.model = model;
		this.mileage = mileage;
		this.license_plate = license_plate;
		this.engine_model = engine_model;
		this.driving_license = driving_license;
		this.guide_price = guide_price;
		this.insurance_expiry_date = insurance_expiry_date;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", u_id=" + u_id + ", old=" + old + ", brand=" + brand + ", type=" + type + ", series="
				+ series + ", model=" + model + ", mileage=" + mileage + ", license_plate=" + license_plate
				+ ", engine_model=" + engine_model + ", driving_license=" + driving_license + ", guide_price="
				+ guide_price + ", insurance_expiry_date=" + insurance_expiry_date + "]";
	}
	
	
	
	
}
