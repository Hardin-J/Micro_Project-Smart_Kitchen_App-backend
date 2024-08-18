package com.mrj.ska.service;

import java.util.List;

import com.mrj.ska.model.Category;

public interface CategoryService {

	public String addCategory(Category cat);

	public String updateCategory(Category cat);

	public String removeCategory(int id);

	public Category getCategoryByName(String catName);

	public List<Category> getAllCategories();

}
