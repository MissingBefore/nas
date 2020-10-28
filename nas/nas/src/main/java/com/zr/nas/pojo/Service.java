package com.zr.nas.pojo;

public class Service {
	Integer id;
	String service_name;
	Double service_price;
	Double emp_commission;
	public Service() {
		super();
	}
	public Service(Integer id, String service_name, Double service_price, Double emp_commission) {
		super();
		this.id = id;
		this.service_name = service_name;
		this.service_price = service_price;
		this.emp_commission = emp_commission;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public Double getService_price() {
		return service_price;
	}
	public void setService_price(Double service_price) {
		this.service_price = service_price;
	}
	public Double getEmp_commission() {
		return emp_commission;
	}
	public void setEmp_commission(Double emp_commission) {
		this.emp_commission = emp_commission;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emp_commission == null) ? 0 : emp_commission.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((service_name == null) ? 0 : service_name.hashCode());
		result = prime * result + ((service_price == null) ? 0 : service_price.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		if (emp_commission == null) {
			if (other.emp_commission != null)
				return false;
		} else if (!emp_commission.equals(other.emp_commission))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (service_name == null) {
			if (other.service_name != null)
				return false;
		} else if (!service_name.equals(other.service_name))
			return false;
		if (service_price == null) {
			if (other.service_price != null)
				return false;
		} else if (!service_price.equals(other.service_price))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Service [id=" + id + ", service_name=" + service_name + ", service_price=" + service_price
				+ ", emp_commission=" + emp_commission + "]";
	}

}
