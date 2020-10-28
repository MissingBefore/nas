package com.zr.nas.dao;

import java.util.List;

import com.zr.nas.pojo.Myint;
import com.zr.nas.pojo.Order;
import com.zr.nas.pojo.OrderBillingDO;
import com.zr.nas.pojo.OrderBillingDO2;

/**
 * 订单的dao接口
 */
public interface IOrderDao {
	//新增订单
	boolean insert(OrderBillingDO2 orderBillingDO2);
	//显示所有订单
	List<Order> showOrderList();
	//获取id
	Myint findByNum(String order_num);
	//按学号或者手机号查询订单信息
	List<Order> queryOrderList(String number);

	//按时间查询订单信息
	List<Order> queryOrderListByTime(String start_date, String end_date);
	
	//显示订单详细信息(商品)
	List<Order> showOrderDetailList(String order_id);

	//显示订单详细信息(服务)
	List<Order> showOrderDetailList1(String order_id);

	//退单
	int deleteOrder(String order_id);

	//删除商品
	int deleteGoods(String order_id);

	//删除服务
	int deleteService(String order_id);

	int confirmSave(String order_id, String remarks);
	//查询订单id
	Myint findByCreateTime(String create_time);

}
