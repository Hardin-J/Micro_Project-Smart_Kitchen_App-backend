package com.mrj.ska.service_implementation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mrj.ska.model.Recipe;
import com.mrj.ska.service.RecipeService;

@SpringBootTest
class RecipeServiceImplementationTest {

	@Autowired
	RecipeService service;
	
	@Test
	void testAddRecipe() {
		Recipe recipe = new Recipe();
		String msg = service.addRecipe(recipe);
		assertEquals("Recipe Added Successfully", msg);		
	}

	@Test
	void testUpdateRecipe() {
		Recipe recipe = new Recipe(4,"Recipe","","ingredients",null,null);
		String msg = service.updateRecipe(recipe);
		assertEquals("Recipe Not found", msg);
		
	}

	@Test
	void testGetAllRecipes() {
		assertNotNull(service.getAllRecipes());
	}

}
