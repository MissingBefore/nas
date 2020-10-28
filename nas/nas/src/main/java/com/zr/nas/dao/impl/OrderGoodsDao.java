package com.zr.nas.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.zr.nas.pojo.GoodsInfoDTO;
import com.zr.nas.utils.TxDBUtils;

public class OrderGoodsDao {
	QueryRunner queryRunner = new QueryRunner(TxDBUtils.getSource());

	public boolean insert(GoodsInfoDTO goodsInfoDTO,int order_id) {
		String sql ="insert into nas_order_goods(order_id,goods_id,emp_id) values(?,?,?)";
		try {
			int execute = queryRunner.execute(sql, order_id,goodsInfoDTO.getgoodsId(),goodsInfoDTO.getStaffId());
			if(execute==1)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
