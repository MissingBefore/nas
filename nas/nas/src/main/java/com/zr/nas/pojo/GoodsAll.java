package com.zr.nas.pojo;

import java.util.Date;

public class GoodsAll {
	Integer  id;
	String goods_name;
	String class_name;
	Double goods_price;
	Double goods_stock;
	Integer goods_state;
	Date    goods_addtime;
	public GoodsAll(Integer id, String goods_name, String class_name, Double goods_price, Double goods_stock,
			Integer goods_state, Date goods_addtime) {
		super();
		this.id = id;
		this.goods_name = goods_name;
		this.class_name = class_name;
		this.goods_price = goods_price;
		this.goods_stock = goods_stock;
		this.goods_state = goods_state;
		this.goods_addtime = goods_addtime;
	}
	public GoodsAll() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}
	public Double getGoods_stock() {
		return goods_stock;
	}
	public void setGoods_stock(Double goods_stock) {
		this.goods_stock = goods_stock;
	}
	public Integer getGoods_state() {
		return goods_state;
	}
	public void setGoods_state(Integer goods_state) {
		this.goods_state = goods_state;
	}
	public Date getGoods_addtime() {
		return goods_addtime;
	}
	public void setGoods_addtime(Date goods_addtime) {
		this.goods_addtime = goods_addtime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((class_name == null) ? 0 : class_name.hashCode());
		result = prime * result + ((goods_addtime == null) ? 0 : goods_addtime.hashCode());
		result = prime * result + ((goods_name == null) ? 0 : goods_name.hashCode());
		result = prime * result + ((goods_price == null) ? 0 : goods_price.hashCode());
		result = prime * result + ((goods_state == null) ? 0 : goods_state.hashCode());
		result = prime * result + ((goods_stock == null) ? 0 : goods_stock.hashCode());
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
		GoodsAll other = (GoodsAll) obj;
		if (class_name == null) {
			if (other.class_name != null)
				return false;
		} else if (!class_name.equals(other.class_name))
			return false;
		if (goods_addtime == null) {
			if (other.goods_addtime != null)
				return false;
		} else if (!goods_addtime.equals(other.goods_addtime))
			return false;
		if (goods_name == null) {
			if (other.goods_name != null)
				return false;
		} else if (!goods_name.equals(other.goods_name))
			return false;
		if (goods_price == null) {
			if (other.goods_price != null)
				return false;
		} else if (!goods_price.equals(other.goods_price))
			return false;
		if (goods_state == null) {
			if (other.goods_state != null)
				return false;
		} else if (!goods_state.equals(other.goods_state))
			return false;
		if (goods_stock == null) {
			if (other.goods_stock != null)
				return false;
		} else if (!goods_stock.equals(other.goods_stock))
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
		return "GoodsAll [id=" + id + ", goods_name=" + goods_name + ", class_name=" + class_name + ", goods_price="
				+ goods_price + ", goods_stock=" + goods_stock + ", goods_state=" + goods_state + ", goods_addtime="
				+ goods_addtime + "]";
	}
	

}
