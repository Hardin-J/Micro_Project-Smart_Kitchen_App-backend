package com.mrj.ska.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.ska.model.Recipe;
import com.mrj.ska.service.RecipeService;

@RestController
@RequestMapping("/recipes")
@CrossOrigin("http://localhost:3000")
public class RecipeController {

	RecipeService service;

	public RecipeController(RecipeService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public String doAddNewRecipe(@RequestBody Recipe recipe) {
		String msg = "";
		try {
			msg = service.addRecipe(recipe);
		} catch (Exception e) {
			msg = "Transaction Insert failed";
		}
		return msg;
	}

	@PutMapping
	public String doUpdateRecipe(@RequestBody Recipe recipe) {
		String msg = "";
		try {
			msg = service.updateRecipe(recipe);
		} catch (Exception e) {
			msg = "Transaction Update failed";
		}
		return msg;
	}

	@DeleteMapping("{id}")
	public String doDeleteRecipe(@PathVariable("id") int id) {
		String msg = "";
		try {
			msg = service.removeRecipe(id);
		} catch (Exception e) {
			msg = "Transaction Remove failed";
		}
		return msg;
	}

	@GetMapping("{id}")
	public Recipe doFindRecipeById(@PathVariable("id") int id) {
		Recipe rp;
		rp = service.getRecipeById(id);
		if (rp != null) {
			return rp;
		} else {
			return null;
		}
	}

	@GetMapping("/all")
	public List<Recipe> doFindAllUsers() {
		return service.getAllRecipes();
	}

}
