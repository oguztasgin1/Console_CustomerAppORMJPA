package com.oguztasgin.service;

import java.util.List;

import com.oguztasgin.dao.ProductEvaluateDao;
import com.oguztasgin.entity.ProductEvaluate;

public class ProductEvaluateService implements IService<ProductEvaluate>{
	
	ProductEvaluateDao productEvaluateDao;

	public ProductEvaluateService() {
		productEvaluateDao = new ProductEvaluateDao();
	}

	@Override
	public void create(ProductEvaluate entity) {
		productEvaluateDao.create(entity);
		
	}

	@Override
	public void delete(long id) {
		productEvaluateDao.delete(id);
		
	}

	@Override
	public void update(long id, ProductEvaluate entity) {
		productEvaluateDao.update(id, entity);
		
	}

	@Override
	public List<ProductEvaluate> listAll() {
		
		return productEvaluateDao.listAll();
	}

	@Override
	public ProductEvaluate find(long id) {
		ProductEvaluate productEvaluate = productEvaluateDao.find(id);
		return productEvaluate;
	}

}
