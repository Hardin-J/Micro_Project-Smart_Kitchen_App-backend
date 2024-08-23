package com.mrj.ska.service_implementation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mrj.ska.model.Product;
import com.mrj.ska.service.ProductService;

@SpringBootTest
class ProductServiceImplementationTest {

	@Autowired
	ProductService service;
	
	@Test
	void testAddProduct() {
		Product pro = new Product();
		String msg = service.addProduct(pro);
		assertEquals("Product Added Successfully", msg);
	}

	@Test
	void testUpdateProduct() {
		
		Product pro = new Product();
		pro.setProductId(8);
		String msg = service.updateProduct(pro);
		assertEquals("Product Updated Successfully", msg);		
	}


	@Test
	void testGetAllProducts() {
		assertNotNull(service.getAllProducts());
	}

	@Test
	void testGetProductsByUserId() {
		assertNotNull(service.getProductsByUserId(1));
	}

}
