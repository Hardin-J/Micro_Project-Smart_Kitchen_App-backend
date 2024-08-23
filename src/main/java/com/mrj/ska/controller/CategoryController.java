package com.mrj.ska.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.ska.model.Category;
import com.mrj.ska.service.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin("http://localhost:3000")
public class CategoryController {

	CategoryService service;

	public CategoryController(CategoryService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public String doAddNewCategory(@RequestBody Category cat) {
		String msg = "";
		try {
			msg = service.addCategory(cat);
		} catch (Exception e) {
			msg = "Transaction Insert failed";
		}
		return msg;
	}

	@GetMapping("{categoryName}")
	public Category doFetchSingleCategory(@PathVariable("categoryName") String catName) {
		Category cat;
		cat = service.getCategoryByName(catName);
		if (cat != null) {
			return cat;
		} else {
			return null;
		}
	}

	@GetMapping("/all")
	public List<Category> doFindAllCategories() {
		return service.getAllCategories();
	}

}
