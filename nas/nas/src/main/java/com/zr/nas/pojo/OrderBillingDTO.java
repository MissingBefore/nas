package com.zr.nas.pojo;

import java.util.List;

public class OrderBillingDTO {
	private String u_id;
	private String license_plate;//车牌号
	private String yc_totime;//年卡到期日
	private List<GoodsInfoDTO> goodsInfo;
	private List<ServeInfoDTO> serveInfo;
	private String order_price;//订单原价
	private String order_discount_price;//折后价
	private String user_remark;//会员备注
	private String order_remark;//订单备注
	private String order_paymethod;//支付方式
	private String message;//短信提示
	public OrderBillingDTO(String u_id, String license_plate, String yc_totime, List<GoodsInfoDTO> goodsInfo, List<ServeInfoDTO> serveInfo,
			String order_price, String order_discount_price, String user_remark, String order_remark,
			String order_paymethod, String message) {
		super();
		this.u_id = u_id;
		this.license_plate = license_plate;
		this.yc_totime = yc_totime;
		this.goodsInfo = goodsInfo;
		this.serveInfo = serveInfo;
		this.order_price = order_price;
		this.order_discount_price = order_discount_price;
		this.user_remark = user_remark;
		this.order_remark = order_remark;
		this.order_paymethod = order_paymethod;
		this.message = message;
	}
	public OrderBillingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getLicense_plate() {
		return license_plate;
	}
	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}
	public String getYc_totime() {
		return yc_totime;
	}
	public void setYc_totime(String yc_totime) {
		this.yc_totime = yc_totime;
	}
	public List<GoodsInfoDTO> getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(List<GoodsInfoDTO> goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public List<ServeInfoDTO> getServeInfo() {
		return serveInfo;
	}
	public void setServeInfo(List<ServeInfoDTO> serveInfo) {
		this.serveInfo = serveInfo;
	}
	public String getOrder_price() {
		return order_price;
	}
	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}
	public String getOrder_discount_price() {
		return order_discount_price;
	}
	public void setOrder_discount_price(String order_discount_price) {
		this.order_discount_price = order_discount_price;
	}
	public String getUser_remark() {
		return user_remark;
	}
	public void setUser_remark(String user_remark) {
		this.user_remark = user_remark;
	}
	public String getOrder_remark() {
		return order_remark;
	}
	public void setOrder_remark(String order_remark) {
		this.order_remark = order_remark;
	}
	public String getOrder_paymethod() {
		return order_paymethod;
	}
	public void setOrder_paymethod(String order_paymethod) {
		this.order_paymethod = order_paymethod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "OrderBillingDTO [u_id=" + u_id + ", license_plate=" + license_plate + ", yc_totime=" + yc_totime
				+ ", goodsInfo=" + goodsInfo + ", serveInfo=" + serveInfo + ", order_price=" + order_price
				+ ", order_discount_price=" + order_discount_price + ", user_remark=" + user_remark + ", order_remark="
				+ order_remark + ", order_paymethod=" + order_paymethod + ", message=" + message + "]";
	}
	
	
}
