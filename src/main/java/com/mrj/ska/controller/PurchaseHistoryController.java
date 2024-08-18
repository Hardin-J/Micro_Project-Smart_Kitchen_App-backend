package com.mrj.ska.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.ska.model.PurchaseHistory;
import com.mrj.ska.service.PurchaseHistoryService;

@RestController
@RequestMapping("/purchaseHistories")
@CrossOrigin("http://localhost:3000")
public class PurchaseHistoryController {
	
	PurchaseHistoryService service;

	public PurchaseHistoryController(PurchaseHistoryService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("{id}")
	public List<PurchaseHistory> doFetchAllPurchaseHistoriesOfSingleUser(@PathVariable("id") int id){
		return service.getAllPurchaseHistoriesOfSingleUser(id);
	}

}
