package com.zr.nas.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zr.nas.pojo.ReservationToday;
import com.zr.nas.service.IReservationService;
import com.zr.nas.service.impl.ReservationService;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends BaseServlet {
	IReservationService iReservationService = new ReservationService();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void showTodayReservations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("hello:加载今日预约");
		List<ReservationToday> showTodayReservation = iReservationService.showTodayReservation();
		PrintWriter writer = response.getWriter();
		String jsonString = JSON.toJSONString(showTodayReservation);
		System.err.println("hello:"+jsonString);
		writer.append(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
