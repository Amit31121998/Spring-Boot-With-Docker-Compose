package com.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amit.entity.User;
import com.amit.repo.UserRepo;
import com.amit.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo uRepo;

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute(new User());

		List<User> users = uRepo.findAll();

		model.addAttribute("users", users);

		return "index";
	}

	@PostMapping("/user")
	public String saveData(@ModelAttribute("user") User user, Model model) {
		userService.saveUser(user);

		List<User> users = uRepo.findAll();

		model.addAttribute("users", users);

		model.addAttribute("msg", "Success");

		return "index";
	}
}
