package com.proyecto.ecommerce.service.implement;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.ecommerce.model.Category;
import com.proyecto.ecommerce.model.Product;
import com.proyecto.ecommerce.repository.CategoryRepository;
import com.proyecto.ecommerce.repository.ProductRepository;
import com.proyecto.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		product.setProductId(product.getProductId());
		return this.productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	@Transactional(readOnly = true)
	public Product findProductById(Integer productId) {
		return this.productRepository.findById(productId).get();
	}

	@Override
	public void deleteProduct(Integer productId) {
		this.productRepository.deleteById(productId);
	}

	public Product assignProductToCategory(Integer productId, Integer categoryId) {
		Set<Category> categorySet = null;
		Product product = this.productRepository.findById(productId).get();
		Category category = this.categoryRepository.findById(categoryId).get();
		categorySet = product.getCategories();
		categorySet.add(category);
		product.setCategories(categorySet);
		return this.productRepository.save(product);
	}

}
