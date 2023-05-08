package com.usersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usersystem.model.User;
import com.usersystem.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping
	@ResponseBody
	public String userById(@RequestParam(value = "id") String id) {
		return userService.getById(Integer.parseInt(id)).toString();
	}
	
	@GetMapping("/list")
	@ResponseBody
	public String allUsers() {
		return userService.getAll().toString();
	}
	
	@PostMapping("/new")
	@ResponseBody
	public String saveUser(@RequestParam(value = "name", defaultValue = "None") String name, @RequestParam(value = "age") String age) {
		return userService.save(name, Integer.parseInt(age)).toString() + "added to Database.";
	}
	
	@DeleteMapping("/delete")
	@ResponseBody
	public String deleteUser(@RequestParam(value = "id") String id) {
		userService.delete(Integer.parseInt(id));
		return "User by ID " + id + " successfully deleted";
	}
	
	@PutMapping("/update")
	@ResponseBody
	public String updateUser(@RequestParam(value = "id") String id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age") String age) {
		
		userService.update(Integer.parseInt(id), name, Integer.parseInt(age));
		
		return "User by ID " + id + " updated";
		
	}


}
