package com.mrj.ska.repository;

import java.util.List;

import com.mrj.ska.model.PurchaseHistory;

public interface PurchaseHistoryRepo {
	
	public String save(PurchaseHistory his);

	public List<PurchaseHistory> fetchSingleUserPurchaseHistory(int id);

}
