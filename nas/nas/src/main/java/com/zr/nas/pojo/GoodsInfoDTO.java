package com.zr.nas.pojo;

public class GoodsInfoDTO {
	private String goodsId;
	private String staffId;
	
	public GoodsInfoDTO() {
		super();
	}

	public GoodsInfoDTO(String goodsId, String staffId) {
		super();
		this.goodsId = goodsId;
		this.staffId = staffId;
	}

	public String getgoodsId() {
		return goodsId;
	}
	public void setgoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	@Override
	public String toString() {
		return "goodsIdInfoDTO [goodsId=" + goodsId + ", staffId=" + staffId + "]";
	}
	
}
