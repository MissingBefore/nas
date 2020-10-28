package com.zr.nas.pojo;

import java.util.Date;

public class Reservation {
	Integer id;
	String service_name;
	String yuyue_user;
	String phone;
	String yuyue_che;
	String detail;
	Date addtime;
	String state;
	Date finishtime;
	String beizhu;
	public Reservation(Integer id, String service_name, String yuyue_user, String phone, String yuyue_che,
			String detail, Date addtime, String state, Date finishtime, String beizhu) {
		super();
		this.id = id;
		this.service_name = service_name;
		this.yuyue_user = yuyue_user;
		this.phone = phone;
		this.yuyue_che = yuyue_che;
		this.detail = detail;
		this.addtime = addtime;
		this.state = state;
		this.finishtime = finishtime;
		this.beizhu = beizhu;
	}
	public Reservation() {
		super();
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
	public String getYuyue_user() {
		return yuyue_user;
	}
	public void setYuyue_user(String yuyue_user) {
		this.yuyue_user = yuyue_user;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getYuyue_che() {
		return yuyue_che;
	}
	public void setYuyue_che(String yuyue_che) {
		this.yuyue_che = yuyue_che;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addtime == null) ? 0 : addtime.hashCode());
		result = prime * result + ((beizhu == null) ? 0 : beizhu.hashCode());
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result + ((finishtime == null) ? 0 : finishtime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((service_name == null) ? 0 : service_name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((yuyue_che == null) ? 0 : yuyue_che.hashCode());
		result = prime * result + ((yuyue_user == null) ? 0 : yuyue_user.hashCode());
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
		Reservation other = (Reservation) obj;
		if (addtime == null) {
			if (other.addtime != null)
				return false;
		} else if (!addtime.equals(other.addtime))
			return false;
		if (beizhu == null) {
			if (other.beizhu != null)
				return false;
		} else if (!beizhu.equals(other.beizhu))
			return false;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		if (finishtime == null) {
			if (other.finishtime != null)
				return false;
		} else if (!finishtime.equals(other.finishtime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (service_name == null) {
			if (other.service_name != null)
				return false;
		} else if (!service_name.equals(other.service_name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (yuyue_che == null) {
			if (other.yuyue_che != null)
				return false;
		} else if (!yuyue_che.equals(other.yuyue_che))
			return false;
		if (yuyue_user == null) {
			if (other.yuyue_user != null)
				return false;
		} else if (!yuyue_user.equals(other.yuyue_user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", service_name=" + service_name + ", yuyue_user=" + yuyue_user + ", phone="
				+ phone + ", yuyue_che=" + yuyue_che + ", detail=" + detail + ", addtime=" + addtime + ", state="
				+ state + ", finishtime=" + finishtime + ", beizhu=" + beizhu + "]";
	}

	

}
