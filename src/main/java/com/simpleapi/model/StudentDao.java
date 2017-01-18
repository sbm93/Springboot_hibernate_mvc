package com.simpleapi.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentDao {
	
	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}
	
	
	public void save(Student st) {
		getSession().save(st);
		return;
	}
	
	public List<Student> getAll() {
        
		List st = getSession().createCriteria(Student.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return st;
	}
}
