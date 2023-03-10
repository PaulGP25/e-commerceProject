package com.proyecto.ecommerce.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.dto.CategoryDTO;
import com.proyecto.ecommerce.dto.ProductDTO;
import com.proyecto.ecommerce.model.Category;
import com.proyecto.ecommerce.model.Product;

@Component
public class ProductDTOMapper{
	
	@Autowired
	private CategoryDTOMapper mapper;
	
	public ProductDTO toDto(Product p) {
		Integer productId = p.getProductId();
		String productName = p.getProductName();
		Double price = p.getPrice();
		String description = p.getDescription();
		Boolean state = p.getState();
		String image = p.getImageUrl();
		List<Category> categories = p.getProductCategory().stream().map(x -> x.getCategory()).collect(Collectors.toList());
		List<CategoryDTO> categoriesDTO = categories.stream().map(x -> mapper.toDto(x)).collect(Collectors.toList());
		return new ProductDTO(productId, productName, price, description, state, image, categoriesDTO);
	}
	

}
