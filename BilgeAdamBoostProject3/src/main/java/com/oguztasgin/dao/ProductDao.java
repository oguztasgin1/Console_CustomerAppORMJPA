package com.oguztasgin.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.oguztasgin.entity.Product;

public class ProductDao implements IRepository<Product>{

	@Override
	public void create(Product entity) {
		Session session = null;
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Product data is added to DB");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Product to DB");
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Product deletedProduct = find(id);
			if (deletedProduct != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deletedProduct);
				session.getTransaction().commit();
				System.out.println("Product data is added to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Product to DB");
		} finally {
			session.close();
		}
	}

	@Override
	public void update(long id, Product entity) {
		Session session = null;
		try {
			Product product = find(id);
			
			if (product != null) {
				product.setName(entity.getName());
				product.setPrice(entity.getPrice());
				product.setStock(entity.getStock());
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(product);
				session.getTransaction().commit();
				System.out.println("Product data is added to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Product to DB");
		} finally {
			session.close();
		}
	}

	@Override
	public List<Product> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select category from Category as category";
		TypedQuery<Product> typedQuery = session.createQuery(query, Product.class);
		List<Product> productList = typedQuery.getResultList();
		productList.forEach(System.out::println);
		return productList;
	}

	@Override
	public Product find(long id) {
		Session session = dataBaseConnectionHibernate();
		Product product ;
		try {
			product = session.find(Product.class, id);
			if (product != null) {
				System.out.println("Product Found--> " + product);
				return product;
			} else {
				System.out.println("Product not found");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while adding Product to DB");
		} finally {
			session.close();
		}
		return null;
	}

}
