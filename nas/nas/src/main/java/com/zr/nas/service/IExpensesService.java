package com.zr.nas.service;

import java.util.ArrayList;

import com.zr.nas.pojo.Expenses;
import com.zr.nas.pojo.Expenses_Record;

public interface IExpensesService {

	ArrayList<Expenses> showExpensesList();

	ArrayList<Expenses_Record> showExpenses_RecordList();

	void add_Expenses(Expenses expenses);

	void sign_In(Expenses_Record expenses_Record);

	void sign_Out(Expenses_Record expenses_Record);

	ArrayList<Expenses_Record> sign_InExpenses_RecordList();

	ArrayList<Expenses_Record> sign_OutExpenses_RecordList();

	ArrayList<Expenses_Record> showExpenses_RecordListWithDate(String start_date, String end_date);

	ArrayList<Expenses_Record> sign_InExpenses_RecordListWithDate(String start_date, String end_date);

	ArrayList<Expenses_Record> sign_OutExpenses_RecordWithDate(String start_date, String end_date);

	Expenses findExpensesById(Integer c_id);

}
