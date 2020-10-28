package com.zr.nas.service;

import java.util.List;

import com.zr.nas.pojo.Employee;

/**
 * 员工类的接口
 */
public interface IEmployeeService {

	//显示所有员工信息
	List<Employee> showEmployeeList();

	//显示在职员工信息
	List<Employee> showOnJobList();

	//显示离职员工信息
	List<Employee> showOutJobList();

	//修改回显员工信息
	List<Employee> preUpdateEmployee(String id);

	//修改员工信息
	void updateEmployee(Employee employee);

	//添加员工
	void addEmployee(Employee employee);

}
