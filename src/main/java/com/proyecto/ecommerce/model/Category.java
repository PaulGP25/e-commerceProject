package com.proyecto.ecommerce.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category implements Serializable{
	
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
	
	@JsonIgnore
	@OneToMany(mappedBy ="category")
	Set<ProductCategory> productCategory;
	
	/*
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
    private Set<Product> products = new HashSet<>();
	*/
	
	public Category() {
		
	}


	public Category(Integer categoryId, String description, String categoryName, String imageUrl) {
		super();
		this.categoryId = categoryId;
		this.description = description;
		this.categoryName = categoryName;
		this.imageUrl = imageUrl;
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


	public Set<ProductCategory> getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(Set<ProductCategory> productCategory) {
		this.productCategory = productCategory;
	}

	/*
	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	*/
	
	
	
}
