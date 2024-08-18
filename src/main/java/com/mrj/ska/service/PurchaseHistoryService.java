package com.mrj.ska.service;

import java.util.List;

import com.mrj.ska.model.PurchaseHistory;

public interface PurchaseHistoryService {
	
	public List<PurchaseHistory> getAllPurchaseHistoriesOfSingleUser(int id);

}
