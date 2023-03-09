package com.proyecto.ecommerce.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.ecommerce.model.Category;
import com.proyecto.ecommerce.repository.CategoryRepository;
import com.proyecto.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Category> findAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Category addCategory(Category category) {
		category.setCategoryId(category.getCategoryId());
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	@Transactional(readOnly = true)
	public Category findCategoryById(Integer categoryId) {
		return this.categoryRepository.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		this.categoryRepository.deleteById(categoryId);
	}

	
	
}
