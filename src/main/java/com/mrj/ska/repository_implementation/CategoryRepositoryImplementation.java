package com.mrj.ska.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrj.ska.model.Category;
import com.mrj.ska.repository.CategoryRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CategoryRepositoryImplementation implements CategoryRepository{

	EntityManager em;
	
	public CategoryRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public String save(Category cat) {
		String msg = "";
		try {
			em.persist(cat);
			msg = "Category Added Successfully";
		} catch (Exception e) {
			msg = "Adding Category Failed";
		}
		return msg;
	}

	@Override
	public String update(Category cat) {
		String msg = "";
		Category oldCat = em.find(Category.class, cat.getCategoryId());
		if (oldCat != null) {
			try {
				em.merge(cat);
				msg = "Category Updated Successfully";
			} catch (Exception e) {
				msg = "Updating Category Failed";
			}
		} else {
			msg = "Category Not found";
		}
		return msg;
	}

	@Override
	public String delete(int id) {
		String msg = "";
		Category oldCat = em.find(Category.class, id);
		if (oldCat != null) {
			try {
				em.remove(oldCat);
				msg = "Category Deteled Successfully";
			} catch (Exception e) {
				msg = "Category removed UnSuccessfully";
			}
		} else {
			msg = "Category Not found";
		}
		return msg;
	}

	@Override
	public Category findCategoryByName(String catName) {
		String hql = "select us from Category us where us.categoryName = :catName";
		Category cat;
		try {
			Query query = em.createQuery(hql).setParameter("catName", catName);
			cat = (Category) query.getSingleResult();

		} catch (Exception e) {
			cat = null;
		}
		return cat;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllCategories(){
		String hql = "from Category";
		Query query = em.createQuery(hql); 
		return query.getResultList();
	}

}
