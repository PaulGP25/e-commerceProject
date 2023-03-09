package com.proyecto.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ecommerce.model.Category;
import com.proyecto.ecommerce.service.implement.CategoryServiceImpl;

@RestController
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl service;
	
	@GetMapping
	//@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Category> categories = this.service.findAll();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		Category categoryAdded = this.service.addCategory(category);
		return new ResponseEntity<>(categoryAdded, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> updateCategory(@RequestBody Category category){
		Category categoryUpdated = this.service.updateCategory(category);
		return new ResponseEntity<>(categoryUpdated, HttpStatus.OK);
	}
	
	@GetMapping("{categoryId}")
	public ResponseEntity<?> findCategoryById(@PathVariable Integer categoryId){
		Category categoryFound = this.service.findCategoryById(categoryId);
		 if(categoryFound == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<>(categoryFound, HttpStatus.OK);
	}
	
	@DeleteMapping("{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId){
		this.service.deleteCategory(categoryId);
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
	}

	
	/*
	@GetMapping
	@RequestMapping(value = "BKList", method = RequestMethod.GET)
	public ResponseEntity<?> findWhereBK(){
		List<Category> newList = service.findAll();
		
		Predicate<Category> catePredi = newCategory -> newCategory.getCategoryName().equals("ELF");
		List<Category> BKList = newList.stream().filter(catePredi).collect(Collectors.toList());
		
		//List<Category> BKList = newList.stream().filter(newCategory -> newCategory.getCategoryName().equals("BK"))
		//.collect(Collectors.toList());
		
		return new ResponseEntity<>(BKList, HttpStatus.OK);
	}
	*/
}
