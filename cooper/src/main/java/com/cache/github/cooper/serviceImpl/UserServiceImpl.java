/**
 * 
 */
package com.cache.github.cooper.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cache.github.cooper.model.User;
import com.cache.github.cooper.repository.UserRepository;
import com.cache.github.cooper.service.UserService;

/**
 * @author kxhb130
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cache.github.cooper.service.UserService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public void saveAllUsers(List<User> list) {
		repository.saveAll(list);
	}

}
