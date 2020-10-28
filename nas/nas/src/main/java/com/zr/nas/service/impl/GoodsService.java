package com.zr.nas.service.impl;
import java.util.List;

import com.zr.nas.dao.IGoodsDao;
import com.zr.nas.dao.impl.GoodsDao;
import com.zr.nas.pojo.Goods;
import com.zr.nas.service.IGoodsService;

public class GoodsService implements IGoodsService {
//设置goods中dao接口对象id
	IGoodsDao igd=new GoodsDao();

	//查看商品信息	
	public List<Goods> showGoodsList() {
		// TODO Auto-generated method stub
		return igd.showGoodsList();
	}

	public int goodsGaiState(Integer id, Integer state) {
		return igd.goodsGaiState( id, state);
	}

	

	public void tianJiaGoods(String name, Integer price, Integer ticheng, Integer digits, Integer state,
			Integer classfiy, String detail, String date) {
		igd.tianJiaGoods(name,  price, ticheng,  digits,  state,
				 classfiy, detail, date);
	}

	public List showGoodsLeiList() {
		// TODO Auto-generated method stub
		return igd.showGoodsLeiList();
	}

	public void tianGoodsLei(String classify) {
		igd.tianGoodsLei(classify);		
	}

	public void gaiGoodsLei(Integer id, String editclass) {
		igd.gaiGoodsLei(id,editclass);
	}

	public void gaiGoods(Integer id, String name, Double price, Double tc, Integer cun, Integer state,  Integer xz,
			String ms, String date) {
		igd.gaiGoods(id, name,price,tc,cun,state,xz,ms,date);
		
	}

	public void shanGoods(Integer id) {
		igd.shanGoods(id);
	}

	public void shanGoodsLei(int id) {
		igd.shanGoodsLei(id);
		
	}

	
}
