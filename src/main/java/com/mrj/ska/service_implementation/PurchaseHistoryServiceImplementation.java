package com.mrj.ska.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mrj.ska.model.PurchaseHistory;
import com.mrj.ska.repository.PurchaseHistoryRepo;
import com.mrj.ska.service.PurchaseHistoryService;

@Service
public class PurchaseHistoryServiceImplementation implements PurchaseHistoryService {

	PurchaseHistoryRepo repo;
	
	public PurchaseHistoryServiceImplementation(PurchaseHistoryRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<PurchaseHistory> getAllPurchaseHistoriesOfSingleUser(int id) {
		return repo.fetchSingleUserPurchaseHistory(id);
	}
}
