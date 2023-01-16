package com.oguztasgin.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductEvaluate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productEvaluateId;
	private String comment;
	private int point;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;

	public ProductEvaluate() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ProductEvaluate(String comment, int point) {
		super();
		this.comment = comment;
		this.point = point;
	}


	public ProductEvaluate(String comment, int point, Product product) {
		super();
		this.comment = comment;
		this.point = point;
		this.product = product;
	}

	public long getProductEvaluateId() {
		return productEvaluateId;
	}

	public void setProductEvaluateId(long productEvaluateId) {
		this.productEvaluateId = productEvaluateId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductEvaluate [productEvaluateId=" + productEvaluateId + ", comment=" + comment + ", point=" + point
				+ ", product=" + product + "]";
	}
	
	
}
