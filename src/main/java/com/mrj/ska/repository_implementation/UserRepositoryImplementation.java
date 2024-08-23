package com.mrj.ska.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrj.ska.model.User;
import com.mrj.ska.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepositoryImplementation implements UserRepository {

	EntityManager em;

	public UserRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public String save(User user) {
		String msg = "";
		try {
			em.persist(user);
			msg = "User Added Successfully";
		} catch (Exception e) {
			msg = "Adding user Failed";
		}
		return msg;
	}

	@Override
	public String update(User user) {
		String msg = "";
		User oldUser = em.find(User.class, user.getUserId());
		if (oldUser != null) {
			try {
				em.merge(user);
				msg = "User Updated Successfully";
			} catch (Exception e) {
				msg = "Updating user Failed";
			}
		} else {
			msg = "User Not found";
		}
		return msg;
	}

	@Override
	public String delete(int id) {
		String msg = "";
		User user = em.find(User.class, id);
		if (user != null) {
			try {
				em.remove(user);
				msg = "User Removed Successfully";
			} catch (Exception e) {
				msg = "User removed Unsuccessfully";
			}
		} else {
			msg = "User Not found";
		}
		return msg;
	}

	@Override
	public String updatePassword(int id, String password) {
		String msg;
		String hql = "update User us set us.password = :password where us.userId = :id";
		try {
			Query query = em.createQuery(hql).setParameter("password", password) // Consider hashing the password here
					.setParameter("id", id);
			int updatedCount = query.executeUpdate();
			if (updatedCount > 0) {
				msg = "User Password Updated successfully";
			} else {
				msg = "User not found or no changes made";
			}
		} catch (Exception e) {
			msg = "Update Password failed";
		}
		return msg;
	}

	@Override
	public User findUserById(int id) {
		User user = em.find(User.class, id);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public User findUserByName(String name) {
		String hql = "select us from User us where us.name = :name";
		User user;
		try {
			Query query = em.createQuery(hql).setParameter("name", name);
			user = (User) query.getSingleResult();

		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	public User login(String email, String password) {
		String hql = "select r from User r where email = :email and password = :password ";
		Query query = em.createQuery(hql).setParameter("email", email).setParameter("password", password);
		return (User) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		String hql = "From User";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

}
