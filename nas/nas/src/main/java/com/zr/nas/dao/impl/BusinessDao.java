package com.zr.nas.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zr.nas.dao.IBusinessDao;
import com.zr.nas.pojo.Business;
import com.zr.nas.pojo.Myint;
import com.zr.nas.utils.TxDBUtils;
import com.zr.nas.pojo.Performance_report;

public class BusinessDao implements IBusinessDao {

	@Override
	public Business search(String start_date, String end_date) {
		Business business = null;
		try {
			String sql1 = "SELECT SUM(nas.nas_reservation_card.amount) AS id FROM nas.nas_reservation_card WHERE nas.nas_reservation_card.addtime BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' ) AND date_format( ?, '%Y-%m-%d %H:%i:%S' )";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			Myint Recharge_income = runner.query(sql1, new BeanHandler<Myint>(Myint.class), start_date, end_date);

			String sql2 = "SELECT SUM(nas.nas_user_giftpack.gift_price) AS id FROM nas.nas_user_giftpack WHERE nas.nas_user_giftpack.gift_fromtime BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' ) AND date_format( ?, '%Y-%m-%d %H:%i:%S' )";
			Myint Package_income = runner.query(sql2, new BeanHandler<Myint>(Myint.class), start_date, end_date);

			String sql3 = "SELECT SUM(nas.nas_order.order_price) AS id FROM nas.nas_order WHERE nas.nas_order.order_paymethod = '现金' AND nas.nas_order.order_createdate BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' ) AND date_format( ?, '%Y-%m-%d %H:%i:%S' ) ";
			Myint Cash_income = runner.query(sql3, new BeanHandler<Myint>(Myint.class), start_date, end_date);

			String sql4 = "SELECT SUM(nas.nas_order.order_price) AS id FROM nas.nas_order WHERE nas.nas_order.order_paymethod = '微信' AND nas.nas_order.order_createdate BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' ) AND date_format( ?, '%Y-%m-%d %H:%i:%S' ) ";
			Myint Wechat_income = runner.query(sql4, new BeanHandler<Myint>(Myint.class), start_date, end_date);

			String sql5 = "SELECT SUM(nas.nas_order.order_price) AS id FROM nas.nas_order WHERE nas.nas_order.order_paymethod = '刷卡' AND nas.nas_order.order_createdate BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' ) AND date_format( ?, '%Y-%m-%d %H:%i:%S' ) ";
			Myint Card_income = runner.query(sql5, new BeanHandler<Myint>(Myint.class), start_date, end_date);

			String sql6 = "SELECT SUM(nas.nas_order.order_price) AS id FROM nas.nas_order WHERE nas.nas_order.order_paymethod = '体验卡' AND nas.nas_order.order_createdate BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' ) AND date_format( ?, '%Y-%m-%d %H:%i:%S' ) ";
			Myint ExperienceCard_income = runner.query(sql6, new BeanHandler<Myint>(Myint.class), start_date, end_date);

			String sql7 = "SELECT COUNT(nas.nas_reservation_card.id) AS id FROM nas.nas_reservation_card WHERE nas.nas_reservation_card.species = 1 AND nas.nas_reservation_card.addtime BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' ) AND date_format(?,'%Y-%m-%d %H:%i:%S')";
			Myint Urban_card = runner.query(sql7, new BeanHandler<Myint>(Myint.class), start_date, end_date);

			String sql8 = "SELECT COUNT(nas.nas_reservation_card.id) AS id FROM nas.nas_reservation_card WHERE nas.nas_reservation_card.species = 2 AND nas.nas_reservation_card.addtime BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' ) AND date_format(?,'%Y-%m-%d %H:%i:%S')";
			Myint Platinum_card = runner.query(sql8, new BeanHandler<Myint>(Myint.class), start_date, end_date);
			String sql9 = "SELECT COUNT(nas.nas_reservation_card.id) AS id FROM nas.nas_reservation_card WHERE nas.nas_reservation_card.species = 3 AND nas.nas_reservation_card.addtime BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' ) AND date_format(?,'%Y-%m-%d %H:%i:%S')";
			Myint RedDiamond_card = runner.query(sql9, new BeanHandler<Myint>(Myint.class), start_date, end_date);

			business = new Business(Double.valueOf(Recharge_income.getId()), Double.valueOf(Package_income.getId()), Double.valueOf(Cash_income.getId()), Double.valueOf(Wechat_income.getId()), Double.valueOf(Card_income.getId()), Double.valueOf(ExperienceCard_income.getId()), Urban_card.getId(), Platinum_card.getId(), RedDiamond_card.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return business;
	}

	@Override
	public ArrayList<Performance_report> Performance_report(Integer i) {
		ArrayList<Performance_report> list = null;
		QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
		String sql;
		if(i == 1) {
			sql = "SELECT DATE_FORMAT( order_createdate, '%m%d' ) report_date,sum(order_price) income FROM( SELECT * FROM nas_order WHERE DATE_SUB( CURDATE( ), INTERVAL 7 DAY ) <= date( order_createdate) ) as order1 GROUP BY report_date";
		}else {
			sql = "SELECT DATE_FORMAT( order_createdate, '%m%d' ) report_date,sum(order_price) income FROM( SELECT * FROM nas_order WHERE DATE_SUB( CURDATE( ), INTERVAL 1 MONTH ) <= date( order_createdate) ) as order1 GROUP BY report_date";
		}
		try {
			list = (ArrayList<Performance_report>) runner.query(sql, new BeanListHandler<Performance_report>(Performance_report.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
