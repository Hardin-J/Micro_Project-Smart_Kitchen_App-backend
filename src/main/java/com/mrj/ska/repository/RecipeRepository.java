package com.mrj.ska.repository;

import java.util.List;

import com.mrj.ska.model.Recipe;

public interface RecipeRepository {

	public String save(Recipe recipe);

	public String update(Recipe recipe);

	public String delete(int id);
	
	public Recipe findRecipeById(int id);

	public List<Recipe> findAllRecipes();
}
