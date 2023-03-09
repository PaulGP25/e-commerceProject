package com.proyecto.ecommerce.service;

import java.util.List;

import com.proyecto.ecommerce.model.Category;

public interface CategoryService {

	public List<Category> findAll();
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Category findCategoryById(Integer categoryId);
	
	public void deleteCategory(Integer categoryId);
}
