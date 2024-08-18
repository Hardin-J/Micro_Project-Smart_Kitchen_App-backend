package com.mrj.ska.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mrj.ska.model.Category;
import com.mrj.ska.repository.CategoryRepository;
import com.mrj.ska.service.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService{

	CategoryRepository repo;
	
	public CategoryServiceImplementation(CategoryRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addCategory(Category cat) {
		return repo.save(cat);
	}

	@Override
	public String updateCategory(Category cat) {
		return repo.update(cat);
	}

	@Override
	public String removeCategory(int id) {
		return repo.delete(id);
	}

	@Override
	public Category getCategoryByName(String catName) {
		return repo.findCategoryByName(catName);
	}

	@Override
	public List<Category> getAllCategories() {
		return repo.findAllCategories();
	}

}
