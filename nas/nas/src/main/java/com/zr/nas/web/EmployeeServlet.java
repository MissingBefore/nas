package com.zr.nas.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.zr.nas.pojo.Employee;
import com.zr.nas.service.IEmployeeService;
import com.zr.nas.service.impl.EmployeeService;

/**
 * 员工servlet
 */

@WebServlet("/employeeServlet")
public class EmployeeServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;

	/**
	 * 显示员工信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String showEmployeeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IEmployeeService service = new EmployeeService();
		List<Employee> list = new ArrayList<Employee>();
		list=service.showEmployeeList();
		
		JSONArray array=new JSONArray(list);
		String jsonString=array.toString();//将jisn转换为字符串
		resp.getWriter().print(jsonString);//返回json信息
		
		return null;
	}
	
	/**
	 * 显示在职员工信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String showOnJobList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IEmployeeService service = new EmployeeService();
		List<Employee> list = new ArrayList<Employee>();
		list=service.showOnJobList();
		
		JSONArray array=new JSONArray(list);
		String jsonString=array.toString();//将jisn转换为字符串
		resp.getWriter().print(jsonString);//返回json信息
		
		return null;
	}
	
	/**
	 * 显示离职员工信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String showOutJobList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IEmployeeService service = new EmployeeService();
		List<Employee> list = new ArrayList<Employee>();
		list=service.showOutJobList();
		
		JSONArray array=new JSONArray(list);
		String jsonString=array.toString();//将jisn转换为字符串
		resp.getWriter().print(jsonString);//返回json信息
		
		return null;
	}
	
	/**
	 * 修改回显员工信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preUpdateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		IEmployeeService service = new EmployeeService();
		List<Employee> list = new ArrayList<Employee>();
		list=service.preUpdateEmployee(id);
		
		JSONArray array=new JSONArray(list);
		String jsonString=array.toString();//将jisn转换为字符串
		resp.getWriter().print(jsonString);//返回json信息
		
		return null;
	}

	/**
	 * 修改员工信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		System.out.println(id);
		int emp_state=0;
		String emp_name=req.getParameter("emp_name");
		System.out.println(emp_name);
		String emp_phone=req.getParameter("emp_phone");
		System.out.println(emp_phone);
		String emp_gender=req.getParameter("emp_gender");
		System.out.println(emp_gender);
		String state=req.getParameter("emp_state");
		System.out.println(emp_state);
		String emp_post=req.getParameter("emp_post");
		System.out.println(emp_post);
		if("在职".equals(state)) {
			emp_state=1;
		}
		Employee employee=new Employee(Integer.parseInt(id), emp_name, emp_phone, emp_gender, emp_post, emp_state, null);
		System.out.println(employee);
		IEmployeeService service = new EmployeeService();
		service.updateEmployee(employee);
		
		resp.getWriter().write("success");
		return null;
	}
	
	/**
	 * 添加员工
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int emp_state=0;
		String emp_name=req.getParameter("emp_name");
		String emp_phone=req.getParameter("emp_phone");
		String emp_gender=req.getParameter("emp_gender");
		String state=req.getParameter("emp_state");
		String emp_post=req.getParameter("emp_post");
		Date emp_createdate=new Date();
		if("在职".equals(state)) {
			emp_state=1;
		}
		Employee employee=new Employee(0,emp_name, emp_phone, emp_gender, emp_post, emp_state, emp_createdate);
		IEmployeeService service = new EmployeeService();
		service.addEmployee(employee);
		
		resp.getWriter().write("success");
		return null;
	}
}
