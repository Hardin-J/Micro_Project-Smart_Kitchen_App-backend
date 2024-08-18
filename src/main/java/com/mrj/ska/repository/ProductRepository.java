package com.mrj.ska.repository;

import java.util.List;

import com.mrj.ska.model.Product;

public interface ProductRepository {
	
	public String save(Product product);
	
	public String update(Product product);
	
	public String delete(int id);
	
	public int getSingleProductQuant(Product product);
	
	public List<Product> findAllProducts();
	
	public List<Product> filterProductByUserId(int id);

}
