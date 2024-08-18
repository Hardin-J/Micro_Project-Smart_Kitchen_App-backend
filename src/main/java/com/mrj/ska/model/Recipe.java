package com.mrj.ska.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Recipe_tbl")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Recipe_id")
	private long recipeId;

	@Column(name = "Recipe_name")
	private String recipeName;

	@Column(name = "Instruction")
	private String instruction;

	@Column(name = "Ingredients")
	private String ingredients;

	@Column(name = "Image_url")
	private String imageUrl;

	@Column(name = "Ratings")
	private String ratings;

	public Recipe() {
		super();
	}

	public Recipe(long recipeId, String recipeName, String instruction, String ingredients, String imageUrl,
			String ratings) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.instruction = instruction;
		this.ingredients = ingredients;
		this.imageUrl = imageUrl;
		this.ratings = ratings;
	}

	public long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(long recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
}
