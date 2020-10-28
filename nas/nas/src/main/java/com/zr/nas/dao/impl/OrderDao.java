package com.zr.nas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zr.nas.dao.IOrderDao;
import com.zr.nas.pojo.Myint;
import com.zr.nas.pojo.Order;
import com.zr.nas.pojo.OrderBillingDO;
import com.zr.nas.pojo.OrderBillingDO2;
import com.zr.nas.utils.TxDBUtils;
/**
 * 订单的dao的实现类
 */
public class OrderDao implements IOrderDao{
	QueryRunner queryRunner = new QueryRunner(TxDBUtils.getSource());

	@Override
	public boolean insert(OrderBillingDO2 orderBillingDO) {
		//String sql = "insert into nas_order value(null,?,?,?,?,?,?,?,?)";
		String sql="INSERT INTO `nas`.`nas_order`(`u_id`, `car_id`, `order_price`, `order_paymethod`, `order_state`, `order_createdate`, `remarks`) VALUES (?,?,?,?,?,?,?);";
		
		try {
			int execute = queryRunner.execute(sql, orderBillingDO.getU_id(), orderBillingDO.getCar_id(), orderBillingDO.getOrder_price(), orderBillingDO.getOrder_paymethod(),
					orderBillingDO.getOrder_state(), orderBillingDO.getOrder_createdate(), orderBillingDO.getRemarks());
			if(execute==1)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//根据num查询id
	@Override
	public Myint findByNum(String num) {
		String sql = "select id from nas_order where order_num=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Myint>(Myint.class), num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//根据创建时间查询id
	@Override
	public Myint findByCreateTime(String time) {
		String sql = "select order_id as id from nas_order where order_createDate=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Myint>(Myint.class), time);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//显示所有的订单信息
	@Override
	public List<Order> showOrderList() {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="select o.order_id,o.order_price,o.order_state,u.name user_name,u.phone user_phone,o.order_payMethod,o.order_createdate,o.remarks from nas_order o, nas_user u where u.id=o.u_id";
		try {
			List<Order> list = runner.query(sql, new BeanListHandler<Order>(Order.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//按学号或者手机号查询信息
	@Override
	public List<Order> queryOrderList(String number) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="select o.order_id,o.order_price,o.order_state,u.name user_name,u.phone user_phone,o.order_payMethod,o.order_createdate,o.remarks from nas_order o, nas_user u where (o.order_id like ? or u.phone like ?) and u.id=o.u_id";
		String number1="%"+ number +"%";
		try {
			List<Order> list = runner.query(sql, new BeanListHandler<Order>(Order.class),number1,number1);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//按时间查询订单信息
	@Override
	public List<Order> queryOrderListByTime(String start_date, String end_date) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		try {
			String sql="select o.order_id,o.order_price,o.order_state,u.name user_name,u.phone user_phone,o.order_payMethod,o.order_createdate,o.remarks from nas_order o, nas_user u where o.order_createdate between ? and ? and u.id=o.u_id";
			List<Order> list = runner.query(sql, new BeanListHandler<Order>(Order.class),start_date,end_date);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//显示订单的详情信息
	@Override
	public List<Order> showOrderDetailList(String order_id) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="SELECT\r\n" + 
				"	nas_goods.goods_name,\r\n" + 
				"	nas_goods.goods_price,\r\n" + 
				"	nas_order.remarks,\r\n" + 
				"	nas_employee.emp_name \r\n" + 
				"FROM\r\n" + 
				"	nas_goods\r\n" + 
				"	INNER JOIN nas_order_goods ON nas_goods.id = nas_order_goods.goods_id\r\n" + 
				"	INNER JOIN nas_order ON nas_order_goods.order_id = nas_order.order_id\r\n" + 
				"	INNER JOIN nas_employee ON nas_order_goods.emp_id = nas_employee.id \r\n" + 
				"WHERE\r\n" + 
				"	nas_goods.id = nas_order_goods.goods_id \r\n" + 
				"	AND nas_employee.id = nas_order_goods.emp_id \r\n" + 
				"	AND nas_order.order_id = nas_order_goods.order_id \r\n" + 
				"	AND nas_order.order_id = ?";
		try {
			List<Order> list = runner.query(sql, new BeanListHandler<Order>(Order.class),order_id);
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//显示详细订单信息(服务)
	@Override
	public List<Order> showOrderDetailList1(String order_id) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="SELECT\r\n" + 
				"	nas_employee.emp_name,\r\n" + 
				"	nas_service.service_name,\r\n" + 
				"	nas_order.remarks,\r\n" + 
				"	nas_service.service_price \r\n" + 
				"FROM\r\n" + 
				"	nas_employee\r\n" + 
				"	INNER JOIN nas_order_service ON nas_employee.id = nas_order_service.emp_constructor_id\r\n" + 
				"	INNER JOIN nas_service ON nas_order_service.service_id = nas_service.id\r\n" + 
				"	INNER JOIN nas_order ON nas_order_service.order_id = nas_order.order_id \r\n" + 
				"WHERE\r\n" + 
				"	nas_order_service.order_id = nas_order.order_id \r\n" + 
				"	AND nas_employee.id = nas_order_service.emp_constructor_id \r\n" + 
				"	AND nas_order_service.service_id = nas_service.id \r\n" + 
				"	AND nas_order.order_id = ?";
		try {
			List<Order> list = runner.query(sql, new BeanListHandler<Order>(Order.class),order_id);
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//退单
	@Override
	public int deleteOrder(String order_id) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		System.out.println(order_id);
		String sql1="delete from nas_order where order_id=?";
		String sql2="delete from nas_order_goods where order_id=?";
		String sql3="delete from nas_order_service where order_id=?";
		
		try {
			TxDBUtils.startTX();
			runner.update(sql2,Integer.parseInt(order_id));
			runner.update(sql3,Integer.parseInt(order_id));
			runner.update(sql1,Integer.parseInt(order_id));
			TxDBUtils.rollback();
			TxDBUtils.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	//删除商品
	@Override
	public int deleteGoods(String order_id) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="delete from nas_order_goods where order_id=?";
		try {
			runner.update(sql,order_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	//删除服务
	@Override
	public int deleteService(String order_id) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="delete from nas_order_service where order_id=?";
		try {
			runner.update(sql,order_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int confirmSave(String order_id,String remarks) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="update nas_order set remarks=? where order_id=?";
		try {
			runner.update(sql,remarks,order_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
