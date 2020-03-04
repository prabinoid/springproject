package com.prabin.springproject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prabin.springproject.model.Employee;
@Repository  //data base implementation 
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Resource  //binding hibernate bean (object)
	private SessionFactory  sessionFactory;
	

	@Override
	public void addEmp(Employee emp) {
		 
		Session sess = sessionFactory.getCurrentSession();
		sess.save(emp);
	}

	@Override
	public void deleteEmp(int id) {
		Session sess = sessionFactory.getCurrentSession();
		Employee emp =(Employee) sess.get(Employee.class, id);
		sess.delete(emp);
	}

	@Override
	public void updateEmp(Employee emp) {
		Session sess = sessionFactory.getCurrentSession();
		sess.update(emp);
	}

	@Override
	public Employee getById(int id) {
		Session sess = sessionFactory.getCurrentSession();
		Employee emp = (Employee) sess.get(Employee.class, id);
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmp() {
		
		Session sess = sessionFactory.getCurrentSession();
		Criteria crt = sess.createCriteria(Employee.class);
		
		return crt.list();
	}

}
