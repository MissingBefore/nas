package com.zr.nas.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zr.nas.dao.IExpensesDao;
import com.zr.nas.pojo.Expenses;
import com.zr.nas.pojo.Expenses_Record;
import com.zr.nas.utils.TxDBUtils;

public class ExpensesDao implements IExpensesDao {

	@Override
	public ArrayList<Expenses> showExpensesList() {
		ArrayList<Expenses> expensesList = null;
		// TODO Auto-generated method stub
		try {
			String sql = "select id ,con_id , con_name, con_number from nas_consumables";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			expensesList = (ArrayList<Expenses>) runner.query(sql, new BeanListHandler<Expenses>(Expenses.class));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return expensesList;
	}

	@Override
	public ArrayList<Expenses_Record> showExpenses_RecordList() {
		// TODO Auto-generated method stub
		ArrayList<Expenses_Record> expenses_RecordList = null;
		try {
			String sql = "select nas_consumables_records.id as id,nas_consumables_records.status,nas_consumables_records.ware_date,nas_consumables.con_name, nas_consumables_records.ware_number from nas_consumables,nas_consumables_records where nas_consumables.id = nas_consumables_records.c_id";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			expenses_RecordList = (ArrayList<Expenses_Record>) runner.query(sql,
					new BeanListHandler<Expenses_Record>(Expenses_Record.class));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return expenses_RecordList;
	}

	@Override
	public void add_Expenses(Expenses expenses) {
		try {
			String sql = "insert into nas_consumables (id,con_id,con_name,con_number) value(null,?,?,?)";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			runner.update(sql, expenses.getCon_id(), expenses.getCon_name(), expenses.getCon_number());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void sign_In(Expenses_Record expenses_Record) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ware_date = df.format(expenses_Record.getWare_date());
			String sql = "insert into nas_consumables_records (id,c_id,status,ware_id,ware_date,ware_number) value(null,?,?,?,?,?)";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			runner.update(sql, expenses_Record.getC_id(), expenses_Record.getStatus(), expenses_Record.getWare_id(),
					ware_date, expenses_Record.getWare_number());
			sql = "update nas_consumables set con_number=con_number+? where id=?";
			runner.update(sql, expenses_Record.getWare_number(), expenses_Record.getC_id());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void sign_Out(Expenses_Record expenses_Record) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ware_date = df.format(expenses_Record.getWare_date());
			String sql = "insert into nas_consumables_records (id,c_id,status,ware_id,ware_date,ware_number) value(null,?,?,?,?,?)";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			runner.update(sql, expenses_Record.getC_id(), expenses_Record.getStatus(), expenses_Record.getWare_id(),
					ware_date, expenses_Record.getWare_number());
			sql = "update nas_consumables set con_number=con_number-? where id=?";
			runner.update(sql, expenses_Record.getWare_number(), expenses_Record.getC_id());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public ArrayList<Expenses_Record> sign_InExpenses_RecordList() {
		ArrayList<Expenses_Record> expenses_RecordList = null;
		try {
			String sql = "select nas_consumables_records.id as id,nas_consumables_records.status,nas_consumables_records.ware_date,nas_consumables.con_name, nas_consumables_records.ware_number from nas_consumables,nas_consumables_records where nas_consumables.id = nas_consumables_records.c_id and nas_consumables_records.status = 0";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			expenses_RecordList = (ArrayList<Expenses_Record>) runner.query(sql,
					new BeanListHandler<Expenses_Record>(Expenses_Record.class));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return expenses_RecordList;
	}

	@Override
	public ArrayList<Expenses_Record> sign_OutExpenses_RecordList() {
		ArrayList<Expenses_Record> expenses_RecordList = null;
		try {
			String sql = "select nas_consumables_records.id as id,nas_consumables_records.status,nas_consumables_records.ware_date,nas_consumables.con_name, nas_consumables_records.ware_number from nas_consumables,nas_consumables_records where nas_consumables.id = nas_consumables_records.c_id and nas_consumables_records.status = 1";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			expenses_RecordList = (ArrayList<Expenses_Record>) runner.query(sql,
					new BeanListHandler<Expenses_Record>(Expenses_Record.class));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return expenses_RecordList;
	}

	@Override
	public ArrayList<Expenses_Record> showExpenses_RecordListWithDate(String start_date, String end_date) {
		ArrayList<Expenses_Record> expenses_RecordList = null;
		try {
			String sql = "select nas_consumables_records.id as id,nas_consumables_records.status,nas_consumables_records.ware_date,nas_consumables.con_name, nas_consumables_records.ware_number from nas_consumables,nas_consumables_records where nas_consumables.id = nas_consumables_records.c_id and nas_consumables_records.ware_date BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' ) AND date_format(?,'%Y-%m-%d %H:%i:%S')";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			expenses_RecordList = (ArrayList<Expenses_Record>) runner.query(sql,
					new BeanListHandler<Expenses_Record>(Expenses_Record.class), start_date, end_date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return expenses_RecordList;
	}

	@Override
	public ArrayList<Expenses_Record> sign_OutExpenses_RecordListWithDate(String start_date, String end_date) {
		ArrayList<Expenses_Record> expenses_RecordList = null;
		try {
			String sql = "select nas_consumables_records.id as id,nas_consumables_records.status,nas_consumables_records.ware_date,nas_consumables.con_name, nas_consumables_records.ware_number from nas_consumables,nas_consumables_records where nas_consumables.id = nas_consumables_records.c_id and nas_consumables_records.status = 1 and nas_consumables_records.ware_date BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' )AND date_format(?,'%Y-%m-%d %H:%i:%S')";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			expenses_RecordList = (ArrayList<Expenses_Record>) runner.query(sql,
					new BeanListHandler<Expenses_Record>(Expenses_Record.class), start_date, end_date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return expenses_RecordList;
	}

	@Override
	public ArrayList<Expenses_Record> sign_InExpenses_RecordListWithDate(String start_date, String end_date) {
		ArrayList<Expenses_Record> expenses_RecordList = null;
		try {
			String sql = "select nas_consumables_records.id as id,nas_consumables_records.status,nas_consumables_records.ware_date,nas_consumables.con_name, nas_consumables_records.ware_number from nas_consumables,nas_consumables_records where nas_consumables.id = nas_consumables_records.c_id and nas_consumables_records.status = 0 and nas_consumables_records.ware_date BETWEEN date_format( ?, '%Y-%m-%d %H:%i:%S' )AND date_format(?,'%Y-%m-%d %H:%i:%S')";
			QueryRunner runner = new QueryRunner(TxDBUtils.getSource());
			expenses_RecordList = (ArrayList<Expenses_Record>) runner.query(sql,
					new BeanListHandler<Expenses_Record>(Expenses_Record.class), start_date, end_date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return expenses_RecordList;
	}

	@Override
	public Expenses findExpensesById(Integer c_id) {
		Expenses expenses = null;
		try {
			String sql = "select id ,con_id , con_name, con_number from nas_consumables where id = ?";
			QueryRunner ruuner = new QueryRunner(TxDBUtils.getSource());
			expenses = ruuner.query(sql, new BeanHandler<Expenses>(Expenses.class),c_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return expenses;
	}

}
