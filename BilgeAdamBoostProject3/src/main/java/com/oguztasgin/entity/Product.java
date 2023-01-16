package com.oguztasgin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int price;
	private int stock;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	private List<ProductEvaluate> productEvaluateList;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price, int stock, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}

	public Product(String name, int price, int stock, List<ProductEvaluate> productEvaluateList) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.productEvaluateList = productEvaluateList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<ProductEvaluate> getProductEvaluateList() {
		return productEvaluateList;
	}

	public void setProductEvaluateList(List<ProductEvaluate> productEvaluateList) {
		this.productEvaluateList = productEvaluateList;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock
				+ ", productEvaluateList=" + productEvaluateList.size() + ", category=" + category + "]";
	}
}
