package com.simpleapi.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentFeeDao {
	
	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}
	
	public void save(Fee fee) {
		getSession().save(fee);
    	return;
    }
	
	public List<Fee> getAll() {
		List<Fee> st = getSession().createCriteria(Fee.class).list();
		return st;
	}
	
}
