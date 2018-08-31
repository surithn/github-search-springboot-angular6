package com.cache.github.cooper.service;

import java.util.List;

import com.cache.github.cooper.model.User;

public interface UserService {

	public List<User> getAllUsers();
	public User saveUser(User user);
	public void saveAllUsers(List<User> list);
}
