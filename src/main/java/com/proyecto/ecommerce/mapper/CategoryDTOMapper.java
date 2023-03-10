package com.proyecto.ecommerce.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.ecommerce.dto.CategoryDTO;
import com.proyecto.ecommerce.model.Category;

@Component
public class CategoryDTOMapper {
	public CategoryDTO toDto(Category c) {
		Integer categoryId = c.getCategoryId();
		String categoryName = c.getCategoryName();
		
		return new CategoryDTO(categoryId, categoryName);
	}
}
