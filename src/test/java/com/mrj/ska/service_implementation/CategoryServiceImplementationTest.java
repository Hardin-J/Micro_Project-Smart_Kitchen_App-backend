package com.mrj.ska.service_implementation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mrj.ska.model.Category;
import com.mrj.ska.service.CategoryService;

@SpringBootTest
class CategoryServiceImplementationTest {

	@Autowired
	CategoryService service;
	
	
	@Test
	void testUpdateCategory() {
		Category cat = service.getCategoryByName("category");
		cat.setCategoryName("category");
		String msg = service.updateCategory(cat);
		assertEquals("Category Updated Successfully", msg);
	}

	@Test
	void testGetCategoryByName() {
		Category cat = service.getCategoryByName("category");
		assertNotNull(cat);
	}

	@Test
	void testGetAllCategories() {
		assertNotNull(service.getAllCategories());
	}

}
