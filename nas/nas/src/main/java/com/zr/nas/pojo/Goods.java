package com.zr.nas.pojo;

import java.util.Date;

public class Goods {
Integer id;
String goods_name;
double  goods_price;
double goods_commission;
double goods_stock;
String goods_state;
String goods_classification;
String goods_description;
Date  goods_addtime;
public Goods(Integer id, String goods_name, double goods_price, double goods_commission, double goods_stock,
		String goods_state, String goods_classification, String goods_description, Date goods_addtime) {
	super();
	this.id = id;
	this.goods_name = goods_name;
	this.goods_price = goods_price;
	this.goods_commission = goods_commission;
	this.goods_stock = goods_stock;
	this.goods_state = goods_state;
	this.goods_classification = goods_classification;
	this.goods_description = goods_description;
	this.goods_addtime = goods_addtime;
}
public Goods() {
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
public double getGoods_price() {
	return goods_price;
}
public void setGoods_price(double goods_price) {
	this.goods_price = goods_price;
}
public double getGoods_commission() {
	return goods_commission;
}
public void setGoods_commission(double goods_commission) {
	this.goods_commission = goods_commission;
}
public double getGoods_stock() {
	return goods_stock;
}
public void setGoods_stock(double goods_stock) {
	this.goods_stock = goods_stock;
}
public String getGoods_state() {
	return goods_state;
}
public void setGoods_state(String goods_state) {
	this.goods_state = goods_state;
}
public String getGoods_classification() {
	return goods_classification;
}
public void setGoods_classification(String goods_classification) {
	this.goods_classification = goods_classification;
}
public String getGoods_description() {
	return goods_description;
}
public void setGoods_description(String goods_description) {
	this.goods_description = goods_description;
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
	result = prime * result + ((goods_addtime == null) ? 0 : goods_addtime.hashCode());
	result = prime * result + ((goods_classification == null) ? 0 : goods_classification.hashCode());
	long temp;
	temp = Double.doubleToLongBits(goods_commission);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((goods_description == null) ? 0 : goods_description.hashCode());
	result = prime * result + ((goods_name == null) ? 0 : goods_name.hashCode());
	temp = Double.doubleToLongBits(goods_price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((goods_state == null) ? 0 : goods_state.hashCode());
	temp = Double.doubleToLongBits(goods_stock);
	result = prime * result + (int) (temp ^ (temp >>> 32));
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
	Goods other = (Goods) obj;
	if (goods_addtime == null) {
		if (other.goods_addtime != null)
			return false;
	} else if (!goods_addtime.equals(other.goods_addtime))
		return false;
	if (goods_classification == null) {
		if (other.goods_classification != null)
			return false;
	} else if (!goods_classification.equals(other.goods_classification))
		return false;
	if (Double.doubleToLongBits(goods_commission) != Double.doubleToLongBits(other.goods_commission))
		return false;
	if (goods_description == null) {
		if (other.goods_description != null)
			return false;
	} else if (!goods_description.equals(other.goods_description))
		return false;
	if (goods_name == null) {
		if (other.goods_name != null)
			return false;
	} else if (!goods_name.equals(other.goods_name))
		return false;
	if (Double.doubleToLongBits(goods_price) != Double.doubleToLongBits(other.goods_price))
		return false;
	if (goods_state == null) {
		if (other.goods_state != null)
			return false;
	} else if (!goods_state.equals(other.goods_state))
		return false;
	if (Double.doubleToLongBits(goods_stock) != Double.doubleToLongBits(other.goods_stock))
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
	return "Goods [id=" + id + ", goods_name=" + goods_name + ", goods_price=" + goods_price + ", goods_commission="
			+ goods_commission + ", goods_stock=" + goods_stock + ", goods_state=" + goods_state
			+ ", goods_classification=" + goods_classification + ", goods_description=" + goods_description
			+ ", goods_addtime=" + goods_addtime + "]";
}

}
