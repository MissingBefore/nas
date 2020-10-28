package com.zr.nas.dao;

import java.util.List;

import com.zr.nas.pojo.Goods;

public interface IGoodsDao {

	List<Goods> showGoodsList();

	int goodsGaiState(Integer id, Integer state);

	void tianJiaGoods(String name, Integer price, Integer ticheng, Integer digits, Integer state, Integer classfiy,
			String detail, String date);

	List showGoodsLeiList();

	void tianGoodsLei(String classify);

	void gaiGoodsLei(Integer id, String editclass);

	void gaiGoods(Integer id, String name, Double price, Double tc, Integer cun, Integer state,  Integer xz, String ms,
			String date);

	void shanGoods(Integer id);

	void shanGoodsLei(int id);

}
