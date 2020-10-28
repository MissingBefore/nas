package com.zr.nas.service.impl;

import java.util.ArrayList;

import com.zr.nas.dao.IExpensesDao;
import com.zr.nas.dao.impl.ExpensesDao;
import com.zr.nas.pojo.Expenses;
import com.zr.nas.pojo.Expenses_Record;
import com.zr.nas.service.IExpensesService;

public class ExpensesService implements IExpensesService {

	IExpensesDao expensesDao = new ExpensesDao();

	@Override
	public ArrayList<Expenses> showExpensesList() {
		// TODO Auto-generated method stub
		return expensesDao.showExpensesList();
	}

	@Override
	public ArrayList<Expenses_Record> showExpenses_RecordList() {
		// TODO Auto-generated method stub
		return expensesDao.showExpenses_RecordList();
	}

	@Override
	public void add_Expenses(Expenses expenses) {
		// TODO Auto-generated method stub
		expensesDao.add_Expenses(expenses);
	}

	@Override
	public void sign_In(Expenses_Record expenses_Record) {
		// TODO Auto-generated method stub
		expensesDao.sign_In(expenses_Record);
	}

	@Override
	public void sign_Out(Expenses_Record expenses_Record) {
		// TODO Auto-generated method stub
		expensesDao.sign_Out(expenses_Record);
	}

	@Override
	public ArrayList<Expenses_Record> sign_InExpenses_RecordList() {
		// TODO Auto-generated method stub
		return expensesDao.sign_InExpenses_RecordList();
	}

	@Override
	public ArrayList<Expenses_Record> sign_OutExpenses_RecordList() {
		// TODO Auto-generated method stub
		return expensesDao.sign_OutExpenses_RecordList();
	}

	@Override
	public ArrayList<Expenses_Record> showExpenses_RecordListWithDate(String start_date, String end_date) {
		// TODO Auto-generated method stub
		return expensesDao.showExpenses_RecordListWithDate(start_date, end_date);
	}

	@Override
	public ArrayList<Expenses_Record> sign_InExpenses_RecordListWithDate(String start_date, String end_date) {
		// TODO Auto-generated method stub
		return expensesDao.sign_InExpenses_RecordListWithDate(start_date, end_date);
	}

	@Override
	public ArrayList<Expenses_Record> sign_OutExpenses_RecordWithDate(String start_date, String end_date) {
		return expensesDao.sign_OutExpenses_RecordListWithDate(start_date, end_date);
	}

	@Override
	public Expenses findExpensesById(Integer c_id) {
		// TODO Auto-generated method stub
		return expensesDao.findExpensesById(c_id);
	}

}
