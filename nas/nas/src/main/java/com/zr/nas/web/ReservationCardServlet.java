package com.zr.nas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.zr.nas.service.IReservationCardService;
import com.zr.nas.service.impl.ReservationCardService;
@WebServlet("/yuka")
public class ReservationCardServlet extends BaseServlet{
	//创建预售卡服务层对象
	IReservationCardService ic=new ReservationCardService();
	//查看销售人员
	public void chaXiaoShou(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List list=ic.chaXiaoShou();
       JSONArray js = new JSONArray(list);
		String string = js.toString();
		System.out.println(list);
		resp.getWriter().print(string);
		
	}
	//添加预售卡
	public void tianYuShouKa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer yushouka= Integer.parseInt(req.getParameter("yushouka"));
		System.out.println(yushouka);
		Integer chuka= Integer.parseInt(req.getParameter("chuka"));
		Integer nianka= Integer.parseInt(req.getParameter("nianka"));
		Integer chongzhi= Integer.parseInt(req.getParameter("chong"));
		Integer kahao= Integer.parseInt(req.getParameter("num"));
		String pay= req.getParameter("pay");
		String xiaoshou= req.getParameter("xiaoshou");
		ic.tianYuShouKa(yushouka,chuka,nianka,kahao,chongzhi,pay,xiaoshou);
		
		
	}
}
