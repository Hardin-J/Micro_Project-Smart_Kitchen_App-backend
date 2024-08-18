package com.mrj.ska.repository;

import java.util.List;

import com.mrj.ska.model.Category;

public interface CategoryRepository {

	public String save(Category cat);

	public String update(Category cat);

	public String delete(int id);

	public Category findCategoryByName(String catName);
	
	public List<Category> findAllCategories();

}
