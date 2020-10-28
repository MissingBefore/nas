package com.zr.nas.service;


import java.util.List;

import com.zr.nas.pojo.Goods;

public interface IGoodsService {
	// 展示所有商品
	List<Goods> showGoodsList();

	// 设置商品的状态
	int goodsGaiState(Integer id, Integer state);

	// 添加商品
	void tianJiaGoods(String name, Integer price, Integer ticheng, Integer digits, Integer state, Integer classify,
			String detail, String date);

	// 展示商品种类
	List showGoodsLeiList();

	// 添加商品种类
	void tianGoodsLei(String classify);

	// 修改商品类型的类型
	void gaiGoodsLei(Integer id, String editclass);

	// 修改商品
	void gaiGoods(Integer id, String name, Double price, Double tc, Integer cun, Integer state,  Integer xz, String ms,
			String date);

	// 删除商品
	void shanGoods(Integer id);

	// 删除商品类型
	void shanGoodsLei(int id);

	

	
}
