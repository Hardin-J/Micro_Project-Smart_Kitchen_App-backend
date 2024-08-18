package com.mrj.ska.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrj.ska.model.PurchaseHistory;
import com.mrj.ska.repository.PurchaseHistoryRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PurchaseHistoryRepoImplementation implements PurchaseHistoryRepo {

	EntityManager em;
	
	public PurchaseHistoryRepoImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public String save(PurchaseHistory his) 
	{
		String msg = "";
		try {
			em.persist(his);
			msg = "Purchase History Added Successfully";
		} catch (Exception e) {
			msg = "Adding Purchase History Failed";
		}
		return msg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PurchaseHistory> fetchSingleUserPurchaseHistory(int id) {
		String hql = "select his from PurchaseHistory his where user.userId = :id";
		Query query = em.createQuery(hql).setParameter("id", id);
		return query.getResultList();
	}

}
