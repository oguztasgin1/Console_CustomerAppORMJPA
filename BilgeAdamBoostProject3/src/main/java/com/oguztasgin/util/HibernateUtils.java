package com.oguztasgin.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oguztasgin.entity.Admin;
import com.oguztasgin.entity.Category;
import com.oguztasgin.entity.Customer;
import com.oguztasgin.entity.Product;
import com.oguztasgin.entity.ProductEvaluate;



public class HibernateUtils {
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {

		try {
			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(Admin.class);
			configuration.addAnnotatedClass(Customer.class);
			configuration.addAnnotatedClass(Product.class);
			configuration.addAnnotatedClass(ProductEvaluate.class);
			configuration.addAnnotatedClass(Category.class);

			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
