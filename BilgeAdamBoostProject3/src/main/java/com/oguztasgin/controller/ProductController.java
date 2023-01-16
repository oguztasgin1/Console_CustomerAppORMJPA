package com.oguztasgin.controller;

import com.oguztasgin.entity.Category;
import com.oguztasgin.entity.Product;
import com.oguztasgin.entity.ProductEvaluate;
import com.oguztasgin.service.CategoryService;
import com.oguztasgin.service.ProductEvaluateService;
import com.oguztasgin.service.ProductService;
import com.oguztasgin.util.BAUtils;

public class ProductController {
	CategoryService categoryService;
	ProductService productService;
	ProductEvaluateService productEvaluateService;
	
	public ProductController() {
		categoryService = new CategoryService();
		productService = new ProductService();
		productEvaluateService = new ProductEvaluateService();
	}
	
	public void addCategory() {
		String categoryName = BAUtils.readString("Category Ismini giriniz: ");
		Category category = new Category(categoryName);
		categoryService.create(category);
		System.out.println(categoryName + " isminde " + category.getCategoryId() + " numarasiyla olusturuldu.");
		
	}
	
	public void addProduct() {
		String name = BAUtils.readString("Product Name: ");
		int price = BAUtils.readInt("Product Price: ");
		int stock = BAUtils.readInt("Product Price: ");
		int categoryId = BAUtils.readInt("Category ID: ");
		Category category;
		category = categoryService.find(categoryId);
		Product product;
		if(!(category == null)) {
			product = new Product(name, price, stock, category);
			System.out.println("Category found: [" + category.getCategoryId() + ", " + category.getName()+ "]");
		}
		else {
			System.out.println("Product bulunamadi.");
		}
	}
	
	public void getAllCommentsForOneProduct() {
		int productId = BAUtils.readInt("Yorumlarini gormek istediginiz Urun Kodunu giriniz: ");
		Product product;
		product = productService.find(productId);
		if(product != null) {
			for (ProductEvaluate productEvaluate : product.getProductEvaluateList()) {
				System.out.println("Yorumlar: " + productEvaluate.getComment() + "\n" + 
						"Puanlar: " + productEvaluate.getPoint());
			}
		}
	}
	
	
}
