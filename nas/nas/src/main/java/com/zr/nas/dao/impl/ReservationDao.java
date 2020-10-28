package com.zr.nas.dao.impl;



import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zr.nas.pojo.ReservationToday;
import com.zr.nas.utils.TxDBUtils;


public class ReservationDao {
	

	public List<ReservationToday> findTodayReservation() {
		String sql="select * from v_today_reservation";
		QueryRunner queryRunner = new QueryRunner(TxDBUtils.getSource());
		
		try {
			return queryRunner.query(sql, new BeanListHandler<ReservationToday>(ReservationToday.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
