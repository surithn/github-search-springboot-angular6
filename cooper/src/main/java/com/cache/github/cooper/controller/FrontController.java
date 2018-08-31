/**
 * 
 */
package com.cache.github.cooper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cache.github.cooper.model.User;
import com.cache.github.cooper.service.UserService;

/**
 * @author kxhb130
 *
 */
@RestController
public class FrontController {

	@Autowired
	UserService userService;

	@GetMapping("/cache-search")
	public List<User> getUserFromCache(@RequestParam("user") String user) {
		User one = new User();
		one.setLogin(user);
		one.setRepos_url(user);
		one.setUrl("abc.com");
		userService.saveUser(one);
		return userService.getAllUsers();
	}

	@PostMapping("/save-usr")
	public User saveUserCache(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PostMapping("/save-allUsr")
	public void saveAllUserCache(@RequestBody List<User> userList) {
		userService.saveAllUsers(userList);
	}
}
