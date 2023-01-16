package com.oguztasgin.controller;

import java.util.Iterator;
import java.util.List;

import com.oguztasgin.entity.Customer;
import com.oguztasgin.entity.Product;
import com.oguztasgin.entity.ProductEvaluate;
import com.oguztasgin.service.CustomerService;
import com.oguztasgin.service.ProductService;
import com.oguztasgin.util.BAUtils;

public class CustomerController {
	CustomerService customerService;
	ProductService productService;

	public CustomerController() {
		this.customerService = new CustomerService();
		this.productService = new ProductService();
	}
	
	public Customer create() {
		String isim = BAUtils.readString("İsminiz: ");
		String soyIsim = BAUtils.readString("Soy İsminiz: ");
		String email = BAUtils.readString("Email: ");
		String tcKimlik = BAUtils.readString("TCkimlik: ");
		String password = BAUtils.readString("Sifreniz: ");
		
		Customer customer = new Customer(isim, soyIsim, email, password, tcKimlik);
		
		customerService.create(customer);
		
		return customer;
		
	}
	
	public Customer checkCustomer() {
		String email = BAUtils.readString("Email: ");
		String password = BAUtils.readString("Sifreniz: ");
		List<Customer> customers;
		customers = customerService.listAll();
		for (Customer customer : customers) {
			if(customer.getEmail().equalsIgnoreCase(email) && customer.getPassword().equalsIgnoreCase(password)){
				return customer;
			}
		}
		return null;
	}
	
	public void getAll() {
		List<Customer> customers = customerService.listAll();
		for (Customer customer : customers) {
			System.out.println("Isim: " + customer.getFirstName() + " Soyisim: " + customer.getLastName());
		}
		
	}
	
	public void addProductToCustomer(Customer customer) {
		int productId = BAUtils.readInt("Satin almak istediniz product ID' yi giriniz: ");
		int productStock = BAUtils.readInt("Kaç adet almak istiyorsunuz: ");
		Product product;
		product = productService.find(productId);
		if(!(product==null)) {
			customer.getProductList().add(product);
			for (Product productFinder : customer.getProductList()) {
				if(productFinder.getId() == productId) {
					productFinder.setStock(productStock);
				}
			}
		}else {
			System.out.println("Bulunamadi...");
		}
		
	}
	
	public void addCommentAndPointToProduct(Customer customer) {
		int productId = BAUtils.readInt("Yorum yapmak istediginiz product ID' sini giriniz: ");
		Product product;
		product = productService.find(productId);
		if(product != null) {
			String  message = BAUtils.readString("Yorumunuz: ");
			int point = BAUtils.readInt("Puaniniz: ");
			product.getProductEvaluateList().add(new ProductEvaluate(message, point, product));
		}
		else {
			System.out.println("Product bulunamadi.");
		}
	}
	
	public void aboutToRunOut(Customer customer) {
		for (Product product : customer.getProductList()) {
			if(product.getStock() < 10) {
				System.out.println(product.getName() + "' dan " + product.getStock() + " kadar kaldi.");
			}
		}
	}
	
	public void getAllProduct(Customer customer) {
		System.out.println(customer.getFirstName() + " isimli kullanicinin urun listesi\n");
		for (Product product : customer.getProductList()) {
			System.out.println("Urun adi: " + product.getName() + " Stock Durumu: " + product.getStock());
		}
	}
	
	
}
