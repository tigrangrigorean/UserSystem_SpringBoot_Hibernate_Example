package com.usersystem.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.springframework.stereotype.Repository;

import com.usersystem.configuration.Configurations;
import com.usersystem.model.User;

import jakarta.persistence.Query;

@Repository
public class UserRepository {
	
	Configuration config = Configurations.getConfiguration();
	SessionFactory sessionFactory = config.buildSessionFactory();
	
	
	/**
	 * Method get's user by id
	 * @param id
	 * @return
	 */
	
	public User getById(long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = session.get(User.class,id);
		session.getTransaction().commit();
		session.close();
		return user;
	}
	
	/**
	 * Method get's all users
	 * @return
	 */
	public List<User> getAll() {
		 Session session = sessionFactory.openSession();
		 Query query = session.createQuery("FROM User");
		 session.beginTransaction();
		 List<User> usersList = ((org.hibernate.query.Query) query).list();
	     session.getTransaction().commit();
	     session.close();
	     return usersList;
	}
	
	/**
	 * Method saves new User
	 * @param user
	 * @return
	 */
	public User save(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}
	
	/**
	 * Method deletes User
	 * @param id
	 */
	public void delete(long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = session.get(User.class, id);
		session.delete(user);;
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Method updates User
	 * @param user
	 */
	public void update(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
}
