package com.zr.nas.service.impl;

import java.util.List;

import com.zr.nas.dao.IEmployeeDao;
import com.zr.nas.dao.impl.EmployeeDao;
import com.zr.nas.pojo.Employee;
import com.zr.nas.service.IEmployeeService;

/**
 * IEmployeeService的实现类
 */
public class EmployeeService implements IEmployeeService {

	IEmployeeDao dao=new EmployeeDao();
	
	//显示员工信息
	@Override
	public List<Employee> showEmployeeList() {
		
		return dao.showEmployeeList();
	}

	//显示在职员工信息
	@Override
	public List<Employee> showOnJobList() {
		
		return dao.showOnJobList();
	}

	//显示离职员工信息
	@Override
	public List<Employee> showOutJobList() {
		
		return dao.showOutJobList();
	}

	//修改回显员工信息
	@Override
	public List<Employee> preUpdateEmployee(String id) {
		
		return dao.preUpdateEmployee(id);
	}

	//修改员工信息
	@Override
	public void updateEmployee(Employee employee) {
		dao.updateEmployee(employee);;
	}

	//添加员工
	@Override
	public void addEmployee(Employee employee) {
		dao.addEmployee(employee);
	}

}
