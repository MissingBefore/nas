package com.zr.nas.pojo;
public class GoodsClass {
Integer class_id;
String  class_name;
public GoodsClass(Integer class_id, String class_name) {
	super();
	this.class_id = class_id;
	this.class_name = class_name;
}
public GoodsClass() {
	super();
}
public Integer getClass_id() {
	return class_id;
}
public void setClass_id(Integer class_id) {
	this.class_id = class_id;
}
public String getClass_name() {
	return class_name;
}
public void setClass_name(String class_name) {
	this.class_name = class_name;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((class_id == null) ? 0 : class_id.hashCode());
	result = prime * result + ((class_name == null) ? 0 : class_name.hashCode());
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
	GoodsClass other = (GoodsClass) obj;
	if (class_id == null) {
		if (other.class_id != null)
			return false;
	} else if (!class_id.equals(other.class_id))
		return false;
	if (class_name == null) {
		if (other.class_name != null)
			return false;
	} else if (!class_name.equals(other.class_name))
		return false;
	return true;
}
@Override
public String toString() {
	return "GoodsClass [class_id=" + class_id + ", class_name=" + class_name + "]";
}

}
