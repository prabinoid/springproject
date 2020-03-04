package com.prabin.springproject.dao;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prabin.springproject.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Resource
	private SessionFactory  sessionFactory;

	@Override
	@Transactional  //commit or rollback
	public void addUser(User user) {
		 
		Session  sess = sessionFactory.getCurrentSession();
		sess.save(user);
	}

	@Override
	@Transactional
	public User login(String un, String psw) {
	 
		Session sess = sessionFactory.getCurrentSession();
		Criteria crt = sess.createCriteria(User.class);
		
		crt.add(Restrictions.eq("username", un));
		crt.add(Restrictions.eq("password", psw));
		
		return (User) crt.uniqueResult();
	}

}
