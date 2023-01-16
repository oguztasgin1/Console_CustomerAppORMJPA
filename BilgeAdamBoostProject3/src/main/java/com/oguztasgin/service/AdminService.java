package com.oguztasgin.service;

import java.util.List;

import com.oguztasgin.dao.AdminDao;
import com.oguztasgin.entity.Admin;

public class AdminService implements IService<Admin>{

	private AdminDao adminDao;
	
	
	
	public AdminService() {
		adminDao = new AdminDao();
	}

	@Override
	public void create(Admin entity) {
		adminDao.create(entity);
	}

	@Override
	public void delete(long id) {
		adminDao.delete(id);
		
	}

	@Override
	public void update(long id, Admin entity) {
		adminDao.update(id, entity);
	}

	@Override
	public List<Admin> listAll() {
		return adminDao.listAll();
	}

	@Override
	public Admin find(long id) {
		Admin admin = adminDao.find(id);
		return admin;
	}

}
