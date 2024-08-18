package com.mrj.ska.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.ska.model.Product;
import com.mrj.ska.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000")
public class ProductController {

	ProductService service;

	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public String doAddNewProduct(@RequestBody Product pro) {
		String msg = "";
		try {
			msg = service.addProduct(pro);
		} catch (Exception e) {
			msg = "Transaction Insert failed";
		}
		return msg;
	}

	@PutMapping
	public String doUpdateProduct(@RequestBody Product product) {
		String msg = "";
		try {
			msg = service.updateProduct(product);
		} catch (Exception e) {
			msg = "Transaction Update failed";
		}
		return msg;
	}

	@DeleteMapping("{id}")
	public String doDeleteProduct(@PathVariable("id") int id) {
		String msg = "";
		try {
			msg = service.removeProduct(id);
		} catch (Exception e) {
			msg = "Transaction removal failed";
		}
		return msg;
	}

	@GetMapping("{id}")
	public List<Product> doFilterAllProductsByUserId(@PathVariable("id") int id) {
		return service.getProductsByUserId(id);
	}

	@GetMapping("/all")
	public List<Product> doFindAllProducts() {
		return service.getAllProducts();
	}

}
