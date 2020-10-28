package com.zr.nas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.nas.pojo.Manger;
import com.zr.nas.service.IMangerLoginService;
import com.zr.nas.service.impl.MangerLoginService;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userlogin")
public class MangerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MangerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//传入数据
		String zhanghao = req.getParameter("zhanghao");
		String mima = req.getParameter("mima");
		//得到接口对象
		
		IMangerLoginService ml=new MangerLoginService();
		//判断是否能够登陆
	Manger pd=ml.managerLogin(zhanghao,mima);
		if(pd!=null){
			res.sendRedirect("/nas/index.html");
			
			
		}
		
		else{
			res.getWriter().write("登陆失败，重新登陆");
			res.setHeader("refresh", "1;url=/nas/userlogin/login.jsp");
		}
		
	}

}
