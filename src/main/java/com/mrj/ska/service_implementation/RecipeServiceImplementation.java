package com.mrj.ska.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mrj.ska.model.Recipe;
import com.mrj.ska.repository.RecipeRepository;
import com.mrj.ska.service.RecipeService;

@Service
public class RecipeServiceImplementation implements RecipeService{

	RecipeRepository repo;
	
	public RecipeServiceImplementation(RecipeRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addRecipe(Recipe recipe) {
		return repo.save(recipe);
	}

	@Override
	public String updateRecipe(Recipe recipe) {
		return repo.update(recipe);
	}

	@Override
	public String removeRecipe(int id) {
		return repo.delete(id);
	}

	@Override
	public List<Recipe> getAllRecipes() {
		return repo.findAllRecipes();
	}

	@Override
	public Recipe getRecipeById(int id) {
		return repo.findRecipeById(id);
	}

}
