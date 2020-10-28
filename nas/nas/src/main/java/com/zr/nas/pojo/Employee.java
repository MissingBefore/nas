package com.zr.nas.pojo;

import java.util.Date;

public class Employee {
	private int id;
	private String emp_name;
	private String emp_phone;
	private String emp_gender;
	private String emp_post;
	private int emp_state;
	private Date emp_createdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
	public String getEmp_post() {
		return emp_post;
	}
	public void setEmp_post(String emp_post) {
		this.emp_post = emp_post;
	}
	public int getEmp_state() {
		return emp_state;
	}
	public void setEmp_state(int emp_state) {
		this.emp_state = emp_state;
	}
	public Date getEmp_createdate() {
		return emp_createdate;
	}
	public void setEmp_createdate(Date emp_createdate) {
		this.emp_createdate = emp_createdate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", emp_name=" + emp_name + ", emp_phone=" + emp_phone + ", emp_gender="
				+ emp_gender + ", emp_post=" + emp_post + ", emp_state=" + emp_state + ", emp_createdate="
				+ emp_createdate + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String emp_name, String emp_phone, String emp_gender, String emp_post, int emp_state,
			Date emp_createdate) {
		super();
		this.id = id;
		this.emp_name = emp_name;
		this.emp_phone = emp_phone;
		this.emp_gender = emp_gender;
		this.emp_post = emp_post;
		this.emp_state = emp_state;
		this.emp_createdate = emp_createdate;
	}
	
	
}
