package com.mrj.ska.service;

import java.util.List;

import com.mrj.ska.model.Recipe;

public interface RecipeService {

	public String addRecipe(Recipe recipe);

	public String updateRecipe(Recipe recipe);

	public String removeRecipe(int id);
	
	public Recipe getRecipeById(int id);

	public List<Recipe> getAllRecipes();

}
