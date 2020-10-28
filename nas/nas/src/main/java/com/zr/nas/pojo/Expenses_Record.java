package com.zr.nas.pojo;

import java.util.Date;

public class Expenses_Record {

	private Integer id;// 编号
	private Integer status;// 出入库记录
	private Date ware_date;// 出入库时间
	private String con_name;// 消耗品名称
	private Integer ware_number;// 出入库数量
	private String ware_id;// 出入库编号
	private Integer c_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getWare_date() {
		return ware_date;
	}

	public void setWare_date(Date ware_date) {
		this.ware_date = ware_date;
	}

	public String getCon_name() {
		return con_name;
	}

	public void setCon_name(String con_name) {
		this.con_name = con_name;
	}

	public Integer getWare_number() {
		return ware_number;
	}

	public void setWare_number(Integer ware_number) {
		this.ware_number = ware_number;
	}

	public String getWare_id() {
		return ware_id;
	}

	public void setWare_id(String ware_id) {
		this.ware_id = ware_id;
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_id == null) ? 0 : c_id.hashCode());
		result = prime * result + ((con_name == null) ? 0 : con_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((ware_date == null) ? 0 : ware_date.hashCode());
		result = prime * result + ((ware_id == null) ? 0 : ware_id.hashCode());
		result = prime * result + ((ware_number == null) ? 0 : ware_number.hashCode());
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
		Expenses_Record other = (Expenses_Record) obj;
		if (c_id == null) {
			if (other.c_id != null)
				return false;
		} else if (!c_id.equals(other.c_id))
			return false;
		if (con_name == null) {
			if (other.con_name != null)
				return false;
		} else if (!con_name.equals(other.con_name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (ware_date == null) {
			if (other.ware_date != null)
				return false;
		} else if (!ware_date.equals(other.ware_date))
			return false;
		if (ware_id == null) {
			if (other.ware_id != null)
				return false;
		} else if (!ware_id.equals(other.ware_id))
			return false;
		if (ware_number == null) {
			if (other.ware_number != null)
				return false;
		} else if (!ware_number.equals(other.ware_number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expenses_Record [id=" + id + ", status=" + status + ", ware_date=" + ware_date + ", con_name="
				+ con_name + ", ware_number=" + ware_number + ", ware_id=" + ware_id + ", c_id=" + c_id + "]";
	}

	public Expenses_Record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expenses_Record(Integer id, Integer status, Date ware_date, Integer ware_number, String ware_id,
			Integer c_id) {
		super();
		this.id = id;
		this.status = status;
		this.ware_date = ware_date;
		this.ware_number = ware_number;
		this.ware_id = ware_id;
		this.c_id = c_id;
	}

	public Expenses_Record(Integer id, Integer status, Date ware_date, String con_name, Integer ware_number,
			String ware_id, Integer c_id) {
		super();
		this.id = id;
		this.status = status;
		this.ware_date = ware_date;
		this.con_name = con_name;
		this.ware_number = ware_number;
		this.ware_id = ware_id;
		this.c_id = c_id;
	}

}
