package com.proyecto.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductCategoryKey implements Serializable {
	
	@Column(name ="productId")
	Integer productId;
	
	@Column(name ="category_id")
	Integer categoryId;
	
	public ProductCategoryKey() {
		// TODO Auto-generated constructor stub
	}

	public ProductCategoryKey(Integer productId, Integer categoryId) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCategoryKey other = (ProductCategoryKey) obj;
		return Objects.equals(categoryId, other.categoryId) && Objects.equals(productId, other.productId);
	}
	
	
	
}
