package com.prabin.springproject.dao;

import java.util.List;

import com.prabin.springproject.model.Employee;

public interface EmployeeDao {

	void addEmp(Employee emp);

	void deleteEmp(int id);

	void updateEmp(Employee emp);

	Employee getById(int id);

	List<Employee> getAllEmp();
}
