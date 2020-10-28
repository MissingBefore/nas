package com.zr.nas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.zr.nas.service.IReservationUserService;
import com.zr.nas.service.impl.ReservationUserService;
@WebServlet("/yuuser")
public class ReservationUserServlet extends BaseServlet {
	//预约用户服务层对象
	IReservationUserService iu=new ReservationUserService();
	//查看预约列表
	public void chaYuYue(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer fw= Integer.parseInt(req.getParameter("fw"));
		Integer zt= Integer.parseInt(req.getParameter("zt"));
		String addtime = req.getParameter("addtime");
		String endtime=req.getParameter("endtime");
		String hao=req.getParameter("hao");
		System.out.println(fw);
		System.out.println(zt);
		System.out.println(addtime);
		System.out.println(endtime);
		System.out.println(hao);
		List list=iu.chaYuYue(fw,zt,addtime,endtime,hao);
		System.out.println(list);
		JSONArray js = new JSONArray(list);
		String string = js.toString();
		resp.getWriter().print(string);
		
	}
	//查看服务
	public void chaFuWu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List list=iu.chaFuWu();
		JSONArray js = new JSONArray(list);
		
		String string = js.toString();
		resp.getWriter().print(string);
		
	}
	//编辑预约信息
	public void gaiYue(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer fw= Integer.parseInt(req.getParameter("fw"));
		Integer zt= Integer.parseInt(req.getParameter("zt")); 
		Integer id= Integer.parseInt(req.getParameter("id")); 
		System.out.println(id);
	    String name = req.getParameter("name");                                                               
		String phone=req.getParameter("phone");                                                        
		String chepai=req.getParameter("chepai");                                                             
		String beizhu=req.getParameter("beizhu");  
		String addtime=req.getParameter("addtime");
		String ttime=req.getParameter("ttime");  
		iu.gaiYue(id,name,fw,addtime,ttime,zt,phone,chepai,beizhu);
	}  
	//查看所有预约信息
	public void chaAllYuYue(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List list=iu.chaAllYuYue();
		JSONArray js = new JSONArray(list);
		String string = js.toString();
		resp.getWriter().print(string);
		
		
	}
}                                                                                                             
                                                                                                              
                                                                                                                      