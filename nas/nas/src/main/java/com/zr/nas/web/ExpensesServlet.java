package com.zr.nas.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.zr.nas.pojo.Expenses;
import com.zr.nas.pojo.Expenses_Record;
import com.zr.nas.service.IExpensesService;
import com.zr.nas.service.impl.ExpensesService;

/**
 * 消耗品管理
 * 
 * @author YYT
 *
 */
@SuppressWarnings("serial")
@WebServlet("/ExpensesServlet")
public class ExpensesServlet extends BaseServlet {

	/**
	 * 展示消耗品出入库记录
	 */
	public void showExpenses_RecordList(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IExpensesService expensesService = new ExpensesService();
		ArrayList<Expenses_Record> expenses_RecordList = expensesService.showExpenses_RecordList();
		JSONArray json = new JSONArray(expenses_RecordList);
		String stringJson = json.toString();
		resp.getWriter().print(stringJson);
	}

	/**
	 * 根据条件搜索消耗品出入库记录
	 */
	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		String history = req.getParameter("history");
		ArrayList<Expenses_Record> expenses_RecordList = new ArrayList<Expenses_Record>();
		IExpensesService expensesService = new ExpensesService();

		if (start_date == "" && end_date == "") {
			if (history.equals("1")) {
				expenses_RecordList = expensesService.showExpenses_RecordList();
			} else if (history.equals("2")) {
				expenses_RecordList = expensesService.sign_InExpenses_RecordList();
			} else {
				expenses_RecordList = expensesService.sign_OutExpenses_RecordList();
			}
		} else {
			if (history.equals("1")) {
				expenses_RecordList = expensesService.showExpenses_RecordListWithDate(start_date, end_date);
			} else if (history.equals("2")) {
				expenses_RecordList = expensesService.sign_InExpenses_RecordListWithDate(start_date, end_date);
			} else {
				expenses_RecordList = expensesService.sign_OutExpenses_RecordWithDate(start_date, end_date);
			}
		}

		JSONArray json = new JSONArray(expenses_RecordList);
		String stringJson = json.toString();
		resp.getWriter().print(stringJson);
	}

	/**
	 * 展示消耗品信息
	 */
	public void showExpensesList(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IExpensesService expensesService = new ExpensesService();
		ArrayList<Expenses> expensesList = expensesService.showExpensesList();
		JSONArray json = new JSONArray(expensesList);
		String stringJson = json.toString();
		resp.getWriter().print(stringJson);
	}

	/**
	 * 添加消耗品信息
	 */
	public void add_Expenses(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String proname = req.getParameter("proname");
		String digits = req.getParameter("digits");
		UUID randomUUID = UUID.randomUUID();
		String uuid = randomUUID.toString().replaceAll("-", "");
		Expenses expenses = new Expenses(null, uuid, proname, Integer.parseInt(digits));
		IExpensesService expensesService = new ExpensesService();
		expensesService.add_Expenses(expenses);
		resp.getWriter().print("{\"msg\":\"操作成功\"}");

	}

	/**
	 * 商品入库
	 */
	public void sign_In(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		Integer c_id = Integer.valueOf(Integer.parseInt(id));
		String digits = req.getParameter("digits");
		Integer ware_number = Integer.valueOf(Integer.parseInt(digits));
		UUID randomUUID = UUID.randomUUID();
		String ware_id = randomUUID.toString().replaceAll("-", "");
		Date ware_date = new Date();

		Expenses_Record expenses_Record = new Expenses_Record(null, Integer.valueOf(0), ware_date, ware_number, ware_id,
				c_id);
		IExpensesService expensesService = new ExpensesService();

		expensesService.sign_In(expenses_Record);
		resp.getWriter().print("{\"msg\":\"success\"}");
	}

	/**
	 * 商品出库
	 */
	public void sign_Out(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Integer c_id = Integer.valueOf(Integer.parseInt(id));
		String digits = req.getParameter("digits");
		Integer ware_number = Integer.valueOf(Integer.parseInt(digits));
		UUID randomUUID = UUID.randomUUID();
		String ware_id = randomUUID.toString().replaceAll("-", "");
		Date ware_date = new Date();

		Expenses_Record expenses_Record = new Expenses_Record(null, Integer.valueOf(1), ware_date, ware_number, ware_id,
				c_id);
		IExpensesService expensesService = new ExpensesService();
		Expenses expenses = expensesService.findExpensesById(c_id);
		if (expenses.getCon_number() < ware_number) {
			resp.getWriter().print("{\"msg\":\"操作失败，消耗品数量不够\"}");
		} else {
			expensesService.sign_Out(expenses_Record);
			resp.getWriter().print("{\"msg\":\"操作成功\"}");
		}
		
	}
}
