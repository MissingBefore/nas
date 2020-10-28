package com.zr.nas.dao.impl;



import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zr.nas.dao.IUserDao;
import com.zr.nas.pojo.Car;
import com.zr.nas.pojo.DebitCard;
import com.zr.nas.pojo.GiftPack;
import com.zr.nas.pojo.Myint;
import com.zr.nas.pojo.User;
import com.zr.nas.pojo.UserVO;
import com.zr.nas.pojo.YearCard;
import com.zr.nas.pojo.UserBilling;
import com.zr.nas.utils.TxDBUtils;



public class UserDao implements IUserDao {
	QueryRunner queryRunner = new QueryRunner(TxDBUtils.getSource());
	@Override
	public List<UserBilling> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Insert(UserVO userVO) {
		//
		QueryRunner queryRunner = new QueryRunner(TxDBUtils.getSource());
		//
		String usersql = "INSERT INTO nas_user(name, phone, remarks) VALUES (?,?,?)";
		String user_id_sql = "SELECT id,phone  FROM nas_user  WHERE NAME = ? AND phone = ?";
		String user_car_sql = "INSERT INTO "
				+ "nas_user_car(u_id, brand, type, series, model, mileage, license_plate,  insurance_expiry_date) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try {
			queryRunner.update(usersql, userVO.getName(), userVO.getPhone(), userVO.getRemark());
			Myint query = queryRunner.query(user_id_sql, new BeanHandler<Myint>(Myint.class), userVO.getName(),
					userVO.getPhone());
			queryRunner.update(user_car_sql, query.getId(), userVO.getBrand(), userVO.getType(), userVO.getSeries(),
					userVO.getModel(), userVO.getMileage(), userVO.getLicense_plate(), userVO.getInserance_expiry_date());

			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public UserVO findByKeywords(String keywords) {
		String sql="SELECT\r\n" + 
				"	nas_user.id \r\n" + 
				"FROM\r\n" + 
				"	nas_user\r\n" + 
				"	INNER JOIN nas_user_car ON nas_user.id = nas_user_car.u_id\r\n" + 
				"	INNER JOIN nas_year_card ON nas_user.id = nas_year_card.u_id\r\n" + 
				"	INNER JOIN nas_debit_card ON nas_user.id = nas_debit_card.u_id \r\n" + 
				"WHERE\r\n" + 
				"	nas_user.`name` = ? \r\n" + 
				"	OR nas_user.phone = ?\r\n" + 
				"	OR nas_user_car.license_plate = ?\r\n" + 
				"	OR nas_year_card.yc_num = ?\r\n" + 
				"	OR nas_debit_card.id =?";
		try {
			return queryRunner.query(sql, new BeanHandler<UserVO>(UserVO.class), keywords,keywords,keywords,keywords);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new UserVO();
	}

	//显示所有的会员信息
	@Override
	public List<User> showUserList() {
		
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql1="select id,name,phone from nas_user";
		String sql2="select count(*) as order_count from nas_order where u_id=?";
		String sql3="select count(*) as car_count from nas_user_car where u_id=?";
		String sql4="select count(*) as debit_count from nas_debit_card where u_id=?";
		String sql5="select count(*) as yc_count from nas_year_card where u_id=?";
		String sql6="select count(*) as gift_count from nas_user_giftpack where u_id=?";
		try {
			List<User> list = runner.query(sql1, new BeanListHandler<User>(User.class));
			for(int i=0;i<list.size();i++) {
				User user = runner.query(sql2, new BeanHandler<User>(User.class),list.get(i).getId());
				list.get(i).setOrder_count(user.getOrder_count());
				
				User user1 = runner.query(sql3, new BeanHandler<User>(User.class),list.get(i).getId());
				list.get(i).setCar_count(user1.getCar_count());
				
				User user2 = runner.query(sql4, new BeanHandler<User>(User.class),list.get(i).getId());
				list.get(i).setDebit_count(user2.getDebit_count());
				
				User user3 = runner.query(sql5, new BeanHandler<User>(User.class),list.get(i).getId());
				list.get(i).setYc_count(user3.getYc_count());
				
				User user4 = runner.query(sql6, new BeanHandler<User>(User.class),list.get(i).getId());
				list.get(i).setGift_count(user4.getGift_count());
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	//按手机号姓名或者车牌号查询会员信息
	@Override
	public List<User> searchUserInfo(String input) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		if(input.length()==11) {
			String sql="select id,name,phone,location from nas_user where phone=?";
			try {
				List<User> list = runner.query(sql, new BeanListHandler<User>(User.class),input);
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(input.length()==7) {
			String sql="select u.id,u.name,u.phone,u.location from nas_user_car uc,nas_user u where uc.u_id=u.id and uc.license_plate=?";
			try {
				List<User> list = runner.query(sql, new BeanListHandler<User>(User.class),input);
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			String sql="select id,name,phone,location from nas_user where name=?";
			try {
				List<User> list = runner.query(sql, new BeanListHandler<User>(User.class),input);
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	//修孤会员信息
	public static void updateUser(User user) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="update nas_user set name=?,phone=? where id=?";
		try {
			int i = runner.update(sql, user.getName(),user.getPhone(),user.getId());
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//查询会员的车辆信息
	@Override
	public List<Car> searchUserCarInfo(String id) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="SELECT\r\n" + 
				"	nas_user_car.* \r\n" + 
				"FROM\r\n" + 
				"	nas_user_car \r\n" + 
				"WHERE\r\n" + 
				"	nas_user_car.u_id = ?";
		
		try {
			List<Car> list = runner.query(sql, new BeanListHandler<Car>(Car.class),Integer.parseInt(id));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//查询会员的储值卡信息
	@Override
	public List<DebitCard> searchDebitCardInfo(String id) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="SELECT\r\n" + 
				"	nas_debit_card.id,\r\n" + 
				"	nas_debit_card.emp_id,\r\n" + 
				"	nas_debit_card.card_species,\r\n" + 
				"	nas_debit_card.card_amount,\r\n" + 
				"	nas_debit_card.card_deduction,\r\n" + 
				"	nas_user.phone \r\n" + 
				"FROM\r\n" + 
				"	nas_debit_card\r\n" + 
				"	INNER JOIN nas_user ON nas_debit_card.u_id = nas_user.id \r\n" + 
				"WHERE\r\n" + 
				"	nas_debit_card.u_id = ?";
		try {
			List<DebitCard> list = runner.query(sql, new BeanListHandler<DebitCard>(DebitCard.class),Integer.parseInt(id));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<YearCard> searchYearCardInfo(String id) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="SELECT\r\n" + 
				"	nas_user.phone,\r\n" + 
				"	nas_user.`name`,\r\n" + 
				"	nas_year_card.yc_amount,\r\n" + 
				"	nas_user_car.license_plate,\r\n" + 
				"	nas_year_card.yc_fromtime,\r\n" + 
				"	nas_year_card.yc_totime,\r\n" + 
				"	nas_year_card.yc_state \r\n" + 
				"FROM\r\n" + 
				"	nas_user\r\n" + 
				"	INNER JOIN nas_user_car ON nas_user.id = nas_user_car.u_id\r\n" + 
				"	INNER JOIN nas_year_card ON nas_user_car.id = nas_year_card.car_id \r\n" + 
				"	AND nas_user.id = nas_year_card.u_id \r\n" + 
				"WHERE\r\n" + 
				"	nas_user.id = ?";
		try {
			List<YearCard> list = runner.query(sql, new BeanListHandler<YearCard>(YearCard.class),Integer.parseInt(id));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//查询会员的大礼包信息
	@Override
	public List<GiftPack> searchGiftPackInfo(String id) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="SELECT\r\n" + 
				"	nas_user.`name`,\r\n" + 
				"	nas_user.phone,\r\n" + 
				"	nas_user_giftpack.gift_price,\r\n" + 
				"	nas_user_giftpack.gift_fromtime,\r\n" + 
				"	nas_user_giftpack.gift_totime,\r\n" + 
				"	nas_user_giftpack.gift_details \r\n" + 
				"FROM\r\n" + 
				"	nas_user_giftpack\r\n" + 
				"	INNER JOIN nas_user ON nas_user_giftpack.u_id = nas_user.id \r\n" + 
				"WHERE\r\n" + 
				"	nas_user.id = ?";
		try {
			List<GiftPack> list = runner.query(sql, new BeanListHandler<GiftPack>(GiftPack.class),Integer.parseInt(id));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
