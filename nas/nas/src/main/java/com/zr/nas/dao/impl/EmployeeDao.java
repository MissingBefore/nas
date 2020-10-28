package com.zr.nas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zr.nas.dao.IEmployeeDao;
import com.zr.nas.pojo.Employee;
import com.zr.nas.utils.TxDBUtils;

//IEmployeeDao的实现类

public class EmployeeDao implements IEmployeeDao {

	//显示员工信息
	@Override
	public List<Employee> showEmployeeList() {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="select * from nas_employee";
		try {
			List<Employee> list = runner.query(sql, new BeanListHandler<Employee>(Employee.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//显示在职员工信息
	@Override
	public List<Employee> showOnJobList() {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="select * from nas_employee where emp_state=1";
		try {
			List<Employee> list = runner.query(sql, new BeanListHandler<Employee>(Employee.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//显示离职员工信息
	@Override
	public List<Employee> showOutJobList() {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="select * from nas_employee where emp_state=0";
		try {
			List<Employee> list = runner.query(sql, new BeanListHandler<Employee>(Employee.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//修改回显员工信息
	@Override
	public List<Employee> preUpdateEmployee(String id) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="select * from nas_employee where id=?";
		try {
			List<Employee> list = runner.query(sql, new BeanListHandler<Employee>(Employee.class),id);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//修改员工信息
	@Override
	public void updateEmployee(Employee employee) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="update nas_employee set emp_name=?,emp_phone=?,emp_gender=?,emp_state=?,emp_post=? where id=?";
		try {
			int i=runner.update(sql, employee.getEmp_name(),employee.getEmp_phone(),employee.getEmp_gender(),employee.getEmp_state(),employee.getEmp_post(),employee.getId());
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//添加员工
	@Override
	public void addEmployee(Employee employee) {
		QueryRunner runner=new QueryRunner(TxDBUtils.getSource());
		String sql="insert into nas_employee values(null,?,?,?,?,?,?)";
		try {
			int i=runner.update(sql, employee.getEmp_name(),employee.getEmp_phone(),employee.getEmp_gender(),employee.getEmp_post(),employee.getEmp_state(),employee.getEmp_createdate());
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
