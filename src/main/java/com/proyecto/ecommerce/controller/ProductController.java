package com.proyecto.ecommerce.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

import com.proyecto.ecommerce.dto.CategoryDTO;
import com.proyecto.ecommerce.dto.ProductDTO;
import com.proyecto.ecommerce.mapper.CategoryDTOMapper;
import com.proyecto.ecommerce.mapper.ProductDTOMapper;
import com.proyecto.ecommerce.model.Product;
import com.proyecto.ecommerce.model.ProductCategory;
import com.proyecto.ecommerce.service.implement.ProductServiceImpl;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductServiceImpl service;
	@Autowired
	private ProductDTOMapper mapper;
	
	@GetMapping
	@RequestMapping()
	public ResponseEntity<?> findAll(){
		//Una nueva lista de productos se llena con los productos obtenidos en el findAll
		List<Product> products = this.service.findAll();
		//Una nueva lista de productosDTO = a los productos obtenidos arriba, asignandolos a un stream() que es tambien una lista
		//usando map() para transformar a otro objeto(tambien se puede para tipos de dato por ejemplo)
		//en este caso transforma "x" que es la lista Product, invocando al mapper y su metodo, insertandole el producto
		//luego se colecta los datos ya transformados.....NOTA: 'mapper::toDto' es lo mismo que 'x -> mapper.toDto(x)'
		List<ProductDTO> productDTO = products.stream().map(x -> mapper.toDto(x)).collect(Collectors.toList());
		return new ResponseEntity<>(productDTO, HttpStatus.OK);
	}
	
	/*
	@GetMapping
	//@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Product> products = this.service.findAll();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}*/
	
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
	
	@GetMapping("{productId}")
	public ResponseEntity<?> findProductByIdDTO(@PathVariable Integer productId){
	    List<Product> product = this.service.findAll();
	    List<ProductDTO> productDTO = product.stream().map(x -> mapper.toDto(x)).filter(x -> x.getProductId().equals(productId)).collect(Collectors.toList());
	    if(productDTO.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(productDTO, HttpStatus.OK);
	}
	
	/*
	@GetMapping("{productId}")
	public ResponseEntity<?> findProductById(@PathVariable Integer productId){
	    Product productFound = this.service.findProductById(productId);
	    return new ResponseEntity<>(productFound, HttpStatus.OK);
	}
	*/
	
}
