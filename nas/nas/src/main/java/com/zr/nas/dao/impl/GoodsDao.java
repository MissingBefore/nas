package com.zr.nas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zr.nas.dao.IGoodsDao;
import com.zr.nas.pojo.Goods;
import com.zr.nas.pojo.GoodsAll;
import com.zr.nas.pojo.GoodsClass;
import com.zr.nas.utils.TxDBUtils;

public class GoodsDao implements IGoodsDao {

	// 实现查看商品
	public List showGoodsList() {
		QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		String sql = "select id,goods_name,class_name,goods_price,goods_stock,goods_state, goods_addtime from nas_goods,nas_goods_class where  nas_goods.class_id=nas_goods_class.class_id";
		List  allGoods;

		try {
			allGoods = q.query(sql, new BeanListHandler<GoodsAll>(GoodsAll.class));

			return allGoods;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// 修改商品状态

	public int goodsGaiState(Integer id, Integer state) {
		Integer select;
		if (state == 1) {
			select = 0;
		} else {
			select = 1;
		}
		QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		String sql = "update nas_goods set goods_state=" + select + " where id=" + id + "";
		try {
			return q.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	// 添加商品
	public void tianJiaGoods(String name, Integer price, Integer ticheng, Integer digits, Integer state,
		Integer classfiy, String detail, String date) {
		QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		String sql = "insert into nas_goods values (?,?,?,?,?,?,?,?,?)";
		try {
			q.update(sql,null,classfiy,name,price,ticheng,digits,state,detail,date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//展示商品类型
	public List showGoodsLeiList() {
		QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		String sql = "select* from nas_goods_class";
		try {
			List<GoodsClass> query = q.query(sql, new BeanListHandler<GoodsClass>(GoodsClass.class));
			return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//添加商品类型
	public void tianGoodsLei(String classify) {
		QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		String sql = "insert into nas_goods_class value(?,?)";
		try {
			q.update(sql,null,classify);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//修改商品类型
	public void gaiGoodsLei(Integer id, String editclass) {
		QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		String sql = "update nas_goods_class set class_name=? where class_id=?";
		try {
			q.update(sql,editclass,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//修改商品
	public void gaiGoods(Integer id, String name, Double price, Double tc, Integer cun, Integer state, Integer xz,
			String ms, String date) {
		QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		String sql = "update nas_goods set goods_name=?,goods_price=?,goods_commission=?,goods_stock=?,goods_state=?,class_id=?,goods_description=?,goods_addtime=? where id=?";
		try {
			q.update(sql,name,price,tc,cun,state,xz,ms,date,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//删除商品
	public void shanGoods(Integer id) {
		QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		String sql="delete from nas_goods where id="+id+" ";
		try {
			q.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//删除商品类型
	public void shanGoodsLei(int id) {
		QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		String sql="delete from nas_goods_class where class_id="+id+" ";
		try {
			q.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
