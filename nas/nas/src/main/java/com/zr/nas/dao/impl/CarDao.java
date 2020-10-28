package com.zr.nas.dao.impl;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zr.nas.pojo.Myint;
import com.zr.nas.utils.TxDBUtils;

public class CarDao {
	QueryRunner queryRunner = new QueryRunner(TxDBUtils.getSource());
	public Myint findByPlate(String license_plate) {
		String sql = "select id from nas_user_car where license_plate=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Myint>(Myint.class) ,license_plate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
