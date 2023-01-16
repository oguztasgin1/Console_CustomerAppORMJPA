package com.oguztasgin.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.oguztasgin.entity.Customer;

public class CustomerDao implements IRepository<Customer>{

	@Override
	public void create(Customer entity) {
		Session session = null;
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Customer data is added to DB");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Customer to DB");
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Customer deletedCustomer = find(id);
			if (deletedCustomer != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deletedCustomer);
				session.getTransaction().commit();
				System.out.println("Customer data is added to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Customer to DB");
		} finally {
			session.close();
		}
		
	}

	@Override
	public void update(long id, Customer entity) {
		Session session = null;
		try {
			Customer customer = find(id);
			
			if (customer != null) {
				customer.setFirstName(entity.getFirstName());
				customer.setLastName(entity.getLastName());
				customer.setEmail(entity.getEmail());
				customer.setPassword(entity.getPassword());
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(customer);
				session.getTransaction().commit();
				System.out.println("Customer data is added to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Customer to DB");
		} finally {
			session.close();
		}
		
		
	}

	@Override
	public List<Customer> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select customer from Customer as customer";
		TypedQuery<Customer> typedQuery = session.createQuery(query, Customer.class);
		List<Customer> customerList = typedQuery.getResultList();
		customerList.forEach(System.out::println);
		return customerList;
	}

	@Override
	public Customer find(long id) {
		Session session = dataBaseConnectionHibernate();
		Customer customer ;
		try {
			customer = session.find(Customer.class, id);
			if (customer != null) {
				System.out.println("Customer Found--> " + customer);
				return customer;
			} else {
				System.out.println("Customer not found");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while adding Customer to DB");
		} finally {
			session.close();
		}
		return null;
	}

}
