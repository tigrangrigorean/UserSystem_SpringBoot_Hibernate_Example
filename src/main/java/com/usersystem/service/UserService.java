package com.usersystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersystem.model.User;
import com.usersystem.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	UserRepository userRepository;
	
	
	
	/**
	 * Method returns getById from User Repository
	 * @param id
	 * @return
	 */
	public User getById(long id) {
		return userRepository.getById(id);
	}
	
	/**
	 * Method returns getAll from User Repository
	 * @return
	 */
	public List<User> getAll() {
		return userRepository.getAll();
	}
	
	/**
	 * Method returns save from User Repository
	 * @param name
	 * @param age
	 * @return
	 */
	public User save(String name, int age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return userRepository.save(user);
	}
	
	/**
	 * Method calls delete from User Repository
	 * @param id
	 */
	public void delete(long id) {
		userRepository.delete(id);
	}
	
	public void update(long id, String name, int age) {
		User user = new User(id,name,age);
		userRepository.update(user);
	}

}
