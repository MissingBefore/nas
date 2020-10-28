package com.zr.nas.service;

import java.util.List;

import com.zr.nas.pojo.Order;
import com.zr.nas.pojo.OrderBillingDTO;
import com.zr.nas.pojo.OrderDO;
/**
 * 订单的Service接口
 */
public interface IOrderService {
	//开单
	boolean insert(OrderBillingDTO orderBillingDO);
	//显示订单信息
	List<Order> showOrderList();
	
	//按学号或者手机号查询订单信息
	List<Order> queryOrderList(String number);
	
	//按时间查询订单信息
	List<Order> queryOrderListByTime(String start_date, String end_date);

	//显示订单详细信息(商品)
	List<Order> showOrderDetailList(String order_id);

	//显示订单详细信息(服务)
	List<Order> showOrderDetailList1(String order_id);

	//删除订单
	int deleteOrder(String order_id);
	
	//删除商品
	int deleteGoods(String order_id);

	//删除服务
	int deleteService(String order_id);

	//确认保存
	int confirmSave(String order_id, String remarks);

	
}
