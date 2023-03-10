package com.proyecto.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product_Categories")
public class ProductCategory {

	@EmbeddedId
	ProductCategoryKey id;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name="product_id")
	Product product;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("categoryId")
	@JoinColumn(name="category_id")
	Category category;
	
	public ProductCategory() {
		// TODO Auto-generated constructor stub
	}

	public ProductCategory(ProductCategoryKey id, Product product, Category category) {
		super();
		this.id = id;
		this.product = product;
		this.category = category;
	}

	public ProductCategoryKey getId() {
		return id;
	}

	public void setId(ProductCategoryKey id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
