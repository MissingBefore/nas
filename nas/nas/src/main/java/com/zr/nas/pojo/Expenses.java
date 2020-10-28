package com.zr.nas.pojo;

public class Expenses {

	private Integer id;// 消耗品编号
	private String con_id;
	private String con_name;// 消耗品名称
	private Integer con_number;// 消耗品数量
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCon_id() {
		return con_id;
	}
	public void setCon_id(String con_id) {
		this.con_id = con_id;
	}
	public String getCon_name() {
		return con_name;
	}
	public void setCon_name(String con_name) {
		this.con_name = con_name;
	}
	public Integer getCon_number() {
		return con_number;
	}
	public void setCon_number(Integer con_number) {
		this.con_number = con_number;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((con_id == null) ? 0 : con_id.hashCode());
		result = prime * result + ((con_name == null) ? 0 : con_name.hashCode());
		result = prime * result + ((con_number == null) ? 0 : con_number.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Expenses other = (Expenses) obj;
		if (con_id == null) {
			if (other.con_id != null)
				return false;
		} else if (!con_id.equals(other.con_id))
			return false;
		if (con_name == null) {
			if (other.con_name != null)
				return false;
		} else if (!con_name.equals(other.con_name))
			return false;
		if (con_number == null) {
			if (other.con_number != null)
				return false;
		} else if (!con_number.equals(other.con_number))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Expenses [id=" + id + ", con_id=" + con_id + ", con_name=" + con_name + ", con_number=" + con_number
				+ "]";
	}
	public Expenses(Integer id, String con_id, String con_name, Integer con_number) {
		super();
		this.id = id;
		this.con_id = con_id;
		this.con_name = con_name;
		this.con_number = con_number;
	}
	public Expenses() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
