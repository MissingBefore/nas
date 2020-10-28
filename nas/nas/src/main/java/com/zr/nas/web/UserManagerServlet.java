package com.zr.nas.web;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.alibaba.fastjson.JSON;
import com.zr.nas.pojo.Car;
import com.zr.nas.pojo.DebitCard;
import com.zr.nas.pojo.GiftPack;
import com.zr.nas.pojo.User;
import com.zr.nas.pojo.UserVO;
import com.zr.nas.pojo.YearCard;
import com.zr.nas.service.IUserService;
import com.zr.nas.service.impl.UserService;


/**
 * Servlet implementation class UserManagerServlet
 */
@WebServlet("/userManage")
public class UserManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManagerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.err.println("manage:载入用户");
		String parameter = request.getParameter("user");
		System.err.println("manage:" + parameter);
		UserVO userVO = JSON.parseObject(parameter, UserVO.class);
		System.err.println("manage:" + userVO);
		boolean insert = userService.insert(userVO);
		if (insert) {
			System.err.println("manage:SUCCESS");
			response.getWriter().append("true");
		} else {
			System.err.println("manage:FALSE");
			response.getWriter().append("false");
		}
	}
	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.err.println("manage:检索用户");
		String keywords = req.getParameter("keywords");
		UserVO userVO=userService.findByKeywords(keywords);
		System.err.println("manage-search:"+keywords);
		userVO.setName("李四");
		userVO.setId("1");
		String jsonString = JSON.toJSONString(userVO);
		resp.getWriter().append(jsonString);
	}


	
	/**
	 * 显示所有会员信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserService service=new UserService();
		List<User> list = new ArrayList<User>();
		list=service.showUserList();
		
		JSONArray array=new JSONArray(list);
		String jsonString=array.toString();//将jisn转换为字符串
		response.getWriter().print(jsonString);//返回json信息
		
	}
	
	/**
	 * 按手机号姓名车牌号查询会员信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String input=request.getParameter("input");
		IUserService service=new UserService();
		List<User> list = new ArrayList<User>();
		list=service.searchUserInfo(input);
		
		JSONArray array=new JSONArray(list);
		String jsonString=array.toString();//将jisn转换为字符串
		response.getWriter().print(jsonString);//返回json信息
		
	}
	
	/**
	 * 修改会员信息（姓名，手机号）
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		User user=new User();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setPhone(phone);
		IUserService service=new UserService();
		service.updateUser(user);
	}
	
	/**
	 * 查询用户车辆信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchUserCarInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		IUserService service=new UserService();
		List<Car> list=new ArrayList<Car>();
		list=service.searchUserCarInfo(id);
		
		JSONArray array=new JSONArray(list);
		String jsonString=array.toString();//将jisn转换为字符串
		response.getWriter().print(jsonString);//返回json信息
		//service.updateUser(user);
	}
	
	/**
	 * 查询用户储值卡信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchDebitCardInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		IUserService service=new UserService();
		List<DebitCard> list=new ArrayList<DebitCard>();
		list=service.searchDebitCardInfo(id);
		
		JSONArray array=new JSONArray(list);
		String jsonString=array.toString();//将jisn转换为字符串
		response.getWriter().print(jsonString);//返回json信息
		//service.updateUser(user);
	}
	
	/**
	 * 查询用户年卡信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchYearCardInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		IUserService service=new UserService();
		List<YearCard> list=new ArrayList<YearCard>();
		list=service.searchYearCardInfo(id);
		
		JSONArray array=new JSONArray(list);
		String jsonString=array.toString();//将jisn转换为字符串
		response.getWriter().print(jsonString);//返回json信息
		//service.updateUser(user);
	}
	
	/**
	 * 查询用户大礼包信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchGiftPackInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		IUserService service=new UserService();
		List<GiftPack> list=new ArrayList<GiftPack>();
		list=service.searchGiftPackInfo(id);
		System.out.println(list);
		
		JSONArray array=new JSONArray(list);
		String jsonString=array.toString();//将jisn转换为字符串
		response.getWriter().print(jsonString);//返回json信息
		//service.updateUser(user);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
