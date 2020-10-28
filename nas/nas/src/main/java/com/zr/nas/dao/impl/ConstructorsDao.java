package com.zr.nas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zr.nas.pojo.Myint;
import com.zr.nas.utils.TxDBUtils;

public class ConstructorsDao {
	QueryRunner queryRunner = new QueryRunner(TxDBUtils.getSource());
	public boolean insert(List<String> list) {
		String[] constructors=new String[3];
		for (int i = 0; i < list.size(); i++) {
			constructors[i]=list.get(i);
		}
		String sql ="insert into nas_service_constructors values(null,?,?,?)";
		try {
			int execute = queryRunner.execute(sql,constructors[0],constructors[1],constructors[2]);
			if(execute==1)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public Myint findByNum(String num) {
		String sql = "select id from nas_service_constructors where constructor01_id=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Myint>(Myint.class), num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
