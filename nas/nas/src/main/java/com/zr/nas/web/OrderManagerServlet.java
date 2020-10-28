package com.zr.nas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zr.nas.pojo.OrderBillingDTO;
import com.zr.nas.service.IOrderService;
import com.zr.nas.service.impl.OrderService;

/**
 * Servlet implementation class UserManagerServlet
 */
@WebServlet("/orderManage")
public class OrderManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	IOrderService orderService = new OrderService();
	public OrderManagerServlet() {
		super();
	}
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.err.println("manage:载入订单");
		String parameter = request.getParameter("order");
		System.err.println("manage:" + parameter);
		OrderBillingDTO orderAdd = JSON.parseObject(parameter, OrderBillingDTO.class);
		System.err.println("manage:" + orderAdd);
		boolean insert = orderService.insert(orderAdd);
		if (insert) {
			System.err.println("manage:SUCCESS");
			response.getWriter().append("true");
		} else {
			System.err.println("manage:FALSE");
			response.getWriter().append("false");
		}
	}
}
