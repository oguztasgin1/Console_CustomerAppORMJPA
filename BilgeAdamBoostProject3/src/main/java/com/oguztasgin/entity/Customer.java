package com.oguztasgin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String password;
	private String identity;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Product> productList;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProductEvaluate> productEvaluateList;
	
	public Customer(long customerId, String password, String identity) {
		super();
		this.customerId = customerId;
		this.password = password;
		this.identity = identity;
	}
	
	public Customer(String password, String identity, List<Product> productList,
			List<ProductEvaluate> productEvaluateList) {
		super();
		this.password = password;
		this.identity = identity;
		this.productList = productList;
		this.productEvaluateList = productEvaluateList;
	}
	
	public Customer(String firstName, String lastName, String email, String password, String identity) {
		super(firstName, lastName, email);
		this.password = password;
		this.identity = identity;
	}


	public Customer(String firstName, String lastName, String email, String password, String identity,
			List<Product> productList) {
		super(firstName, lastName, email);
		this.password = password;
		this.identity = identity;
		this.productList = productList;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		// TODO Auto-generated constructor stub
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<ProductEvaluate> getProductEvaluateList() {
		return productEvaluateList;
	}

	public void setProductEvaluateList(List<ProductEvaluate> productEvaluateList) {
		this.productEvaluateList = productEvaluateList;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", password=" + password + ", identity=" + identity
				+ ", productList=" + productList.size() + ", productEvaluateList=" + productEvaluateList.size() + "]";
	}
	
	
	
}
