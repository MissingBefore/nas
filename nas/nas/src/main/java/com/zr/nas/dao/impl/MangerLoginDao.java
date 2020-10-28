package com.zr.nas.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zr.nas.dao.IMangerLoginDao;
import com.zr.nas.pojo.Manger;
import com.zr.nas.utils.TxDBUtils;

public class MangerLoginDao implements IMangerLoginDao{
//老板登陆
	public Manger mangerLogin(String zhanghao, String mima) {
		QueryRunner q = new QueryRunner(TxDBUtils.getSource()); 
		String sql="select userlogin_zhanghao,userlogin_password from userlogin where userlogin_zhanghao='"+ zhanghao+"' and userlogin_password='"+ mima+"'";
		try {
			Manger query = q.query(sql, new BeanHandler<Manger>(Manger.class));
			return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
