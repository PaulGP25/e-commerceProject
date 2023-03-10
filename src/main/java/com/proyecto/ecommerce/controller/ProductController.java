package com.proyecto.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ecommerce.model.Product;
import com.proyecto.ecommerce.service.implement.ProductServiceImpl;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductServiceImpl service;
	
	@GetMapping
	//@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Product> products = this.service.findAll();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		Product productAdded = this.service.addProduct(product);
		return new ResponseEntity<>(productAdded, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> updateProduct(@RequestBody Product product){
		Product productUpdated = this.service.updateProduct(product);
		return new ResponseEntity<>(productUpdated, HttpStatus.OK);
	}
	
	@GetMapping("{productId}")
	public ResponseEntity<?> findProductById(@PathVariable Integer productId){
		Product productFound = this.service.findProductById(productId);
		 if(productFound == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<>(productFound, HttpStatus.OK);
	}
	
	@DeleteMapping("{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
		this.service.deleteProduct(productId);
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
	}
	
	/*//ejemplo
	@PutMapping("/{productId}/category/{categoryId}")
	public Product assignProductToCategory(@PathVariable Integer productId, @PathVariable Integer categoryId){
		 return service.assignProductToCategory(productId, categoryId);
	}
	*/
}
