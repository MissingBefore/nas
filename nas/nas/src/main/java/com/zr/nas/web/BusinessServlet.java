package com.zr.nas.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.zr.nas.pojo.Business;
import com.zr.nas.service.IBusinessService;
import com.zr.nas.service.impl.BusinessService;
import com.zr.nas.pojo.Performance_report;


@SuppressWarnings("serial")
@WebServlet("/BusinessServlet")
public class BusinessServlet extends BaseServlet{

	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");

		
		System.out.println(start_date+" "+end_date);
		IBusinessService businessService = new BusinessService();
		Business business = businessService.search(start_date,end_date);
		
		ArrayList<Business> businessesList = new ArrayList<Business>();
		businessesList.add(business);
		JSONArray json = new JSONArray(businessesList);
		String stringJson = json.toString();
		System.out.println(stringJson);
		resp.getWriter().print(stringJson);
		
	}
	
	
	public void Performance_report(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selected = req.getParameter("selected");
		System.out.println(selected);
		IBusinessService businessService = new BusinessService();
		
		ArrayList<Performance_report> performance_ReportList = businessService.Performance_report(Integer.valueOf(Integer.parseInt(selected)));
		JSONArray json = new JSONArray(performance_ReportList);
		String stringJson = json.toString();
		System.out.println(stringJson);
		resp.getWriter().print(stringJson);
		
	}
}
