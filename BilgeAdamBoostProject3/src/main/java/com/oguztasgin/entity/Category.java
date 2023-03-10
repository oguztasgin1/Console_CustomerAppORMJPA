package com.oguztasgin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	private String name;
	
	public Category(long categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}
	public Category(String name) {
		super();
		this.name = name;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}
	
	
	
}
