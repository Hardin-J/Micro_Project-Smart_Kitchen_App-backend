package com.mrj.ska.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrj.ska.model.Admin;
import com.mrj.ska.repository.AdminRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdminRepositoryImplementation implements AdminRepository {

	EntityManager em;

	public AdminRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public String save(Admin admin) {
		String msg = "";
		try {
			em.persist(admin);
			msg = "Admin Added Successfully";
		} catch (Exception e) {
			msg = "Adding Admin Failed";
		}
		return msg;
	}

	@Override
	public String update(Admin admin) {
		String msg = "";
		Admin oldAdmin = em.find(Admin.class, admin.getAdminId());
		if (oldAdmin != null) {
			try {
				em.merge(admin);
				msg = "Admin Updated Successfully";
			} catch (Exception e) {
				msg = "Updating Admin Failed";
			}
		} else {
			msg = "Admin Not found";
		}
		return msg;
	}

	@Override
	public String delete(int id) {
		String msg = "";
		Admin admin = em.find(Admin.class, id);
		if (admin != null) {
			try {
				em.remove(admin);
				msg = "Admin Removed Successfully";
			} catch (Exception e) {
				msg = "Admin removed Unsuccessfully";
			}
		} else {
			msg = "Admin Not found";
		}
		return msg;
	}

	@Override
	public Admin findAdminById(int id) {
		Admin admin = em.find(Admin.class, id);
		if (admin != null) {
			return admin;
		} else {
			return null;
		}
	}

	@Override
	public Admin findAdminByEmail(String email) {
		String hql = "select us from Admin us where us.emailId = :email";
		Admin admin;
		try {
			Query query = em.createQuery(hql).setParameter("email", email);
			admin = (Admin) query.getSingleResult();

		} catch (Exception e) {
			admin = null;
		}
		return admin;
	}

	public Admin login(String email, String password) {
		String hql = "select r from Admin r where emailId = :email and password = :password ";
		Query query = em.createQuery(hql).setParameter("email", email).setParameter("password", password);
		return (Admin) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAllAdmins() {
		String hql = "From Admin";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}
	
	

}
