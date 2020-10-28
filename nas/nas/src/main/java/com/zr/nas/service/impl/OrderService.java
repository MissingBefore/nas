package com.zr.nas.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import com.zr.nas.dao.CarDao;
import com.zr.nas.dao.IOrderDao;
import com.zr.nas.dao.impl.ConstructorsDao;
import com.zr.nas.dao.impl.OrderDao;
import com.zr.nas.dao.impl.OrderGoodsDao;
import com.zr.nas.dao.impl.OrderServeDao;
import com.zr.nas.pojo.GoodsInfoDTO;
import com.zr.nas.pojo.Myint;
import com.zr.nas.pojo.Order;
import com.zr.nas.pojo.OrderBillingDO;
import com.zr.nas.pojo.OrderBillingDO2;
import com.zr.nas.pojo.OrderBillingDTO;
import com.zr.nas.pojo.ServeInfoDTO;
import com.zr.nas.service.IOrderService;

/**
 * 订单的service实现类
 */
public class OrderService implements IOrderService {
	IOrderDao orderDao = new OrderDao();
	IOrderDao dao = new OrderDao();
	//插入订单
	CarDao carDao = new CarDao();
	
	@Override
	public boolean insert(OrderBillingDTO orderBillingDTO) {
		boolean flag=true;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_time = simpleDateFormat.format(System.currentTimeMillis());
		
		Myint myint = carDao.findByPlate(orderBillingDTO.getLicense_plate());
		String car_id = String.valueOf(myint.getId());
		//插入订单
//		String order_num = UUID.randomUUID().toString().split("-")[1];
//		OrderBillingDO orderBillingDO = new OrderBillingDO(orderBillingDTO.getU_id(), car_id,
//				order_num, orderBillingDTO.getOrder_price(), orderBillingDTO.getOrder_paymethod(),
//				"0", create_time, orderBillingDTO.getOrder_remark());
		OrderBillingDO2 orderBillingDO2 = new OrderBillingDO2(orderBillingDTO.getU_id(), car_id, orderBillingDTO.getOrder_price(), orderBillingDTO.getOrder_paymethod(),"0", create_time, orderBillingDTO.getOrder_remark());
		flag = orderDao.insert(orderBillingDO2);
		
		if(flag) {
			Myint order_id=orderDao.findByCreateTime(create_time);
			//Myint order_id=orderDao.findByNum(order_num);
			//插入订单商品列表
			List<GoodsInfoDTO> goodsInfo = orderBillingDTO.getGoodsInfo();
			OrderGoodsDao orderGoodsDao = new OrderGoodsDao();
			for (GoodsInfoDTO goodsInfoDTO : goodsInfo) {
				flag= orderGoodsDao.insert(goodsInfoDTO, order_id.getId());
				if(flag==false)return false;
			}
			//插入订单服务列表
			List<ServeInfoDTO> serveInfo = orderBillingDTO.getServeInfo();
			OrderServeDao orderServeDao = new OrderServeDao();
			ConstructorsDao constructorsDao = new ConstructorsDao();
			for (ServeInfoDTO serveInfoDTO : serveInfo) {
				boolean insert = constructorsDao.insert(serveInfoDTO.getWorkersId());
				if(insert==false)return false;
				Myint constructorsId = constructorsDao.findByNum(serveInfoDTO.getWorkersId().get(0));
				flag=orderServeDao.insert(serveInfoDTO, order_id.getId(),constructorsId.getId());
				if(flag==false)return false;
			}
		}else {
			return false;
		}
		
		return true;
		 
	}
	
	// 显示订单信息
	@Override
	public List<Order> showOrderList() {

		return dao.showOrderList();
	}

	// 按学号或者手机号查询订单信息
	@Override
	public List<Order> queryOrderList(String number) {

		return dao.queryOrderList(number);
	}

	// 按时间查询信息
	@Override
	public List<Order> queryOrderListByTime(String start_date, String end_date) {

		return dao.queryOrderListByTime(start_date, end_date);
	}

	// 显示订单详细信息(商品)
	@Override
	public List<Order> showOrderDetailList(String order_id) {

		return dao.showOrderDetailList(order_id);
	}

	// 显示订单详细信息(服务)
	@Override
	public List<Order> showOrderDetailList1(String order_id) {

		return dao.showOrderDetailList1(order_id);
	}

	// 退单
	@Override
	public int deleteOrder(String order_id) {
		return dao.deleteOrder(order_id);
	}

	// 删除商品
	@Override
	public int deleteGoods(String order_id) {

		return dao.deleteGoods(order_id);
	}

	// 删除服务
	@Override
	public int deleteService(String order_id) {

		return dao.deleteService(order_id);
	}

	// 确认保存
	@Override
	public int confirmSave(String order_id, String remarks) {

		return dao.confirmSave(order_id, remarks);
	}

}
