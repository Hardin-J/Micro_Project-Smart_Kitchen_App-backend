package com.mrj.ska.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrj.ska.model.Product;
import com.mrj.ska.repository.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductRepositoryImplementation implements ProductRepository{

	EntityManager em;
	
	public ProductRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public String save(Product product) {
		String msg = "";
		try {
			em.persist(product);
			msg = "Product Added Successfully";
		} catch (Exception e) {
			msg = "Adding Product Failed";
		}
		return msg;
	}

	@Override
	public String update(Product product) {
		String msg = "";
		Product oldProduct = em.find(Product.class, product.getProductId());
		if (oldProduct != null) {
			try {
				em.merge(product);
				msg = "Product Updated Successfully";
			} catch (Exception e) {
				msg = "Updating Product Failed";
			}
		} else {
			msg = "Product Not found";
		}
		return msg;
	}

	@Override
	public String delete(int id) {
		String msg = "";
		Product oldPro = em.find(Product.class, id);
		if (oldPro != null) {
			try {
				em.remove(oldPro);
				msg = "Product Deteled Successfully";
			} catch (Exception e) {
				msg = "Product removed UnSuccessfully";
			}
		} else {
			msg = "Product Not found";
		}
		return msg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProducts() {
		String hql = "from Product";
		Query query = em.createQuery(hql); 
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> filterProductByUserId(int id) {
		String hql = "select pro from Product pro where user.userId = :id";
		Query query = em.createQuery(hql).setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public int getSingleProductQuant(Product product) {
		Product pro = em.find(Product.class, product.getProductId());
		if(pro != null) {
			return pro.getQuantity();
		} else {
			return -1;			
		}
	}
}
