package com.oguztasgin.dao;

import java.util.List;

import org.hibernate.Session;

import com.oguztasgin.util.HibernateUtils;


public interface IRepository<T> {
public void create(T entity);
	
	public void delete(long id);
	
	public void update(long id, T entity);
	
	public List<T> listAll();
	
	public T find(long id);
	
	default Session dataBaseConnectionHibernate() {

		return HibernateUtils.getSessionFactory().openSession();
	}	
}
