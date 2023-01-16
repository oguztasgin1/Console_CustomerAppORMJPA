package com.oguztasgin.service;

import java.util.List;

import com.oguztasgin.dao.ProductDao;
import com.oguztasgin.entity.Product;

public class ProductService implements IService<Product>{

	ProductDao productDao;
	
	
	public ProductService() {
		productDao = new ProductDao();
				
	}

	@Override
	public void create(Product entity) {
		productDao.create(entity);
	}

	@Override
	public void delete(long id) {
		productDao.delete(id);
		
	}

	@Override
	public void update(long id, Product entity) {
		productDao.update(id, entity);
		
	}

	@Override
	public List<Product> listAll() {
		return productDao.listAll();			
	}

	@Override
	public Product find(long id) {
		Product product = productDao.find(id);
		return product;
	}

}
