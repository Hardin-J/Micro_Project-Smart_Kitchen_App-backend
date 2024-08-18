package com.mrj.ska.service;

import java.util.List;

import com.mrj.ska.model.Product;

public interface ProductService {
	
	public String addProduct(Product cat);

	public String updateProduct(Product cat);

	public String removeProduct(int id);

	public List<Product> getAllProducts();
	
	public List<Product> getProductsByUserId(int id);

}
