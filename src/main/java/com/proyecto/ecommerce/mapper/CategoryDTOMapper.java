package com.proyecto.ecommerce.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.ecommerce.dto.CategoryDTO;
import com.proyecto.ecommerce.model.Category;

@Component
public class CategoryDTOMapper {
	public CategoryDTO toDto(Category c) {
		String categoryName = c.getCategoryName();
		String description = c.getDescription();
		String imageUrl = c.getImageUrl();
		
		return new CategoryDTO(categoryName, description, imageUrl);
	}
}
