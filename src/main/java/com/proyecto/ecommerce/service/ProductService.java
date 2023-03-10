package com.proyecto.ecommerce.service;

import java.util.List;

import com.proyecto.ecommerce.model.Product;

public interface ProductService {

	public List<Product> findAll();
	
	public Product addProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public Product findProductById(Integer productId);
	
	public void deleteProduct(Integer productId);
	
}
