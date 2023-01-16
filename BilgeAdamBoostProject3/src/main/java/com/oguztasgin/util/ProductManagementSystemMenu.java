package com.oguztasgin.util;

import java.util.HashMap;

import com.oguztasgin.controller.CustomerController;
import com.oguztasgin.controller.ProductController;
import com.oguztasgin.entity.Customer;

public class ProductManagementSystemMenu {
	ProductController productController;
	CustomerController customerController;
	Customer customer;
	
	public ProductManagementSystemMenu() {
		productController = new ProductController();
		customerController = new CustomerController();
	}
	
	public void menu() {
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Admin");
		menuItems.put(2, "Customer");

		
		int key = BAUtils.menu(menuItems);
		
		switch (key) {
		case 1:
			adminMenu();
			break;
		case 2:
			customer();
			break;

		default:
			break;
		}
	}
	
	private void customer() {
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Kayit Ol");
		menuItems.put(2, "Giris Yap");
		int key = BAUtils.menu(menuItems);
		
		switch (key) {
		case 1:
			customer = customerController.create();
			if(customer != null) {
				customerMenu();
			}
			else {
				System.out.println("Hatali bir islem yaptiniz lutfen tekrar deneyiniz.");
			}
			break;
		case 2:
			customer = customerController.checkCustomer();
			if(customer != null) {
				customerMenu();
			}
			else {
				System.out.println("Hatali bir islem yaptiniz lutfen tekrar deneyiniz.");
			}
		default:
			break;
		}
	}

	private void customerMenu() {
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Satin al");
		menuItems.put(2, "Yorum yap");
		menuItems.put(3, "Stock'u bitmek uzere olan ürünler");
		menuItems.put(4, "Tum urunleri Listele");
		menuItems.put(5, "Urune gore Yorumlari Listele");
		menuItems.put(6, "Menuye Don");
		int key = BAUtils.menu(menuItems);
		
		switch (key) {
		case 1:
			customerController.addProductToCustomer(customer);
			break;
		case 2:
			customerController.addCommentAndPointToProduct(customer);
			break;
		case 3:
			customerController.aboutToRunOut(customer);
			break;
		case 4:
			customerController.getAllProduct(customer);
			break;
		case 5:
			productController.getAllCommentsForOneProduct();
			break;
		case 6:
			menu();
			break;

		default:
			break;
		}
	}

	private void adminMenu() {
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Category ekle");
		menuItems.put(2, "Product ekle");
		menuItems.put(3, "Customerlari Listele");
		menuItems.put(4, "Menuye Don");
		int key = BAUtils.menu(menuItems);
		
		switch (key) {
		case 1:
			productController.addCategory();
			break;
		case 2:
			productController.addProduct();
			break;
		case 3:
			customerController.getAll();
			break;
		case 4:
			menu();
			break;
		default:
			break;
		}
		
		
	}
	
	
}
