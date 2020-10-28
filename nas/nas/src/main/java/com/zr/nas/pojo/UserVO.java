package com.zr.nas.pojo;

/**
 * user 基本信息类
 * 
 * @author 仙缘一梦
 *
 */
public class UserVO {
	private String id;
	private String name;
	private String phone;
	private String license_plate;// 车牌号
	private String mileage;// 里程
	private String inserance_expiry_date;// 保险到期日
	private String brand;// 品牌
	private String model;// 型号
	private String type;// 类型
	private String series;// 系列
	private String remark;// 备注
	
	public UserVO(String id, String name, String phone, String license_plate, String mileage,
			String inserance_expiry_date, String brand, String model, String type, String series, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.license_plate = license_plate;
		this.mileage = mileage;
		this.inserance_expiry_date = inserance_expiry_date;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.series = series;
		this.remark = remark;
	}

	public UserVO(String name, String phone, String license_plate, String mileage, String inserance_expiry_date,
			String brand, String model, String type, String series, String remark) {
		super();
		this.name = name;
		this.phone = phone;
		this.license_plate = license_plate;
		this.mileage = mileage;
		this.inserance_expiry_date = inserance_expiry_date;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.series = series;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserVO() {
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

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getInserance_expiry_date() {
		return inserance_expiry_date;
	}

	public void setInserance_expiry_date(String inserance_expiry_date) {
		this.inserance_expiry_date = inserance_expiry_date;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", phone=" + phone + ", license_plate=" + license_plate
				+ ", mileage=" + mileage + ", inserance_expiry_date=" + inserance_expiry_date + ", brand=" + brand
				+ ", model=" + model + ", type=" + type + ", series=" + series + ", remark=" + remark + "]";
	}

}
