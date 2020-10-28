package com.zr.nas.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zr.nas.dao.IReservationCardDao;
import com.zr.nas.pojo.Employee;
import com.zr.nas.utils.TxDBUtils;

public class ReservationCardDao implements IReservationCardDao {
	// 查看销售人员
	public List chaXiaoShou() {
		QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		String sql = "select *from nas_employee";
		try {
			return q.query(sql, new BeanListHandler<Employee>(Employee.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// 添加预售卡

	public void tianYuShouKa(Integer yushouka, Integer chuka, Integer nianka, Integer kahao, Integer chongzhi,
			String pay, String xiaoshou) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String adddate = df.format(new Date());
		Integer ka;
		if (chuka == null) {
			ka = nianka;
		} else {
			ka = chuka;
		}
		QueryRunner q = new QueryRunner(TxDBUtils.getSource());
		String sql = "insert into nas_reservation_card values(?,?,?,?,?,?,?,?)";
		try {
			q.update(sql, null, yushouka, ka, kahao, chongzhi, pay, xiaoshou,adddate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
