package com.oguztasgin;

import com.oguztasgin.util.HibernateUtils;
import com.oguztasgin.util.ProductManagementSystemMenu;

public class ProductManagementApp {

	public static void main(String[] args) {
		//HibernateUtils.getSessionFactory().openSession();
		
		ProductManagementSystemMenu managementSystemMenu = new ProductManagementSystemMenu();
		while(true) {
			managementSystemMenu.menu();
		}
	}

}
