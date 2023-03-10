package com.proyecto.ecommerce.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.dto.ProductDTO;
import com.proyecto.ecommerce.model.Category;
import com.proyecto.ecommerce.model.Product;

@Component
public class ProductDTOMapper{
	public ProductDTO toDto(Product p) {
		Integer productId = p.getProductId();
		String productName = p.getProductName();
		Double price = p.getPrice();
		String description = p.getDescription();
		Boolean state = p.getState();
		//String image = p.getImageUrl();
		List<Category> categories = p.getProductCategory().stream().map(t -> t.getCategory()).collect(Collectors.toList());
		
		return new ProductDTO(productId, productName, price, description, state, categories);
	}
	

}
