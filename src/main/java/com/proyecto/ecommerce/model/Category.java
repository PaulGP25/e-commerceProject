package com.proyecto.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private Integer categoryId;
	
	@Column(name="description", nullable = false)
	private String description;
	@Column(name="category_name", nullable = false)
	private String categoryName;
	@Column(name="image_url", nullable = false)
	private String imageUrl;
	
	public Category(Integer categoryId, String description, String categoryName, String imageUrl) {
		super();
		this.categoryId = categoryId;
		this.description = description;
		this.categoryName = categoryName;
		this.imageUrl = imageUrl;
	}

	public Category() {
		
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
