package com.oguztasgin.service;

import java.util.List;


import com.oguztasgin.dao.CategoryDao;
import com.oguztasgin.entity.Category;

public class CategoryService implements IService<Category>{
	
	private CategoryDao categoryDao;
	
	public CategoryService() {
		categoryDao = new CategoryDao();
	}

	@Override
	public void create(Category entity) {
		categoryDao.create(entity);
		
	}

	@Override
	public void delete(long id) {
		categoryDao.delete(id);
		
	}

	@Override
	public void update(long id, Category entity) {
		categoryDao.update(id, entity);
		
	}

	@Override
	public List<Category> listAll() {
		return categoryDao.listAll();
	}

	@Override
	public Category find(long id) {
		Category category = categoryDao.find(id);
		return category;
	}

}
