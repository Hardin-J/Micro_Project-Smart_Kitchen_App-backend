package com.mrj.ska.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrj.ska.model.Recipe;
import com.mrj.ska.repository.RecipeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RecipeRepositoryImplementation implements RecipeRepository{

	EntityManager em;
	
	public RecipeRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public String save(Recipe recipe) {
		String msg = "";
		try {
			em.persist(recipe);
			msg = "Recipe Added Successfully";
		} catch (Exception e) {
			msg = "Adding Recipe Failed";
		}
		return msg;
	}

	@Override
	public String update(Recipe recipe) {
		String msg = "";
		Recipe oldRecipe = em.find(Recipe.class, recipe.getRecipeId());
		if (oldRecipe != null) {
			try {
				em.merge(recipe);
				msg = "Recipe Updated Successfully";
			} catch (Exception e) {
				msg = "Updating Recipe Failed";
			}
		} else {
			msg = "Recipe Not found";
		}
		return msg;
	}

	@Override
	public String delete(int id) {
		String msg = "";
		Recipe recipe = em.find(Recipe.class, id);
		if (recipe != null) {
			try {
				em.remove(recipe);
				msg = "Recipe Removed Successfully";
			} catch (Exception e) {
				msg = "Recipe removed Unsuccessfully";
			}
		} else {
			msg = "Recipe Not found";
		}
		return msg;
	}
	
	@Override
	public Recipe findRecipeById(int id) {
		Recipe recipe = em.find(Recipe.class, id);
		if(recipe != null) {
			return recipe;
		} else {
			return null;			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> findAllRecipes() {
		String hql = "From Recipe";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

}
