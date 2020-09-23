package ca.sheridancollege.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Role;
import ca.sheridancollege.beans.User;
import ca.sheridancollege.repositories.RoleRepository;
import ca.sheridancollege.repositories.UserRepository;


@Controller
public class AppController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	@Lazy
	private UserRepository userRepository;

	@GetMapping("/")
	public String goHome() {
		return "home.html";
	}
	
	@GetMapping("/users")
	public String goUserHome() {
		return "/users/landing.html";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return"/admin/index.html";    
	}
	
	@GetMapping("/login")
	public String login() {
		return"login.html";    
	}
	
	@GetMapping("/employee")
	public String goEmployeePage() {
		return "/employee/index.html";
	}
	
	@GetMapping("/access-denied")
	public String goAccessDenied() {
		return "/error/access-denied.html";
	}
	
	@GetMapping("/admin/GoAddUser")
	public String adminGoAddUser(Model model) {
		
		List<Role> roles = roleRepository.findAll();
		model.addAttribute("roles", roles);
		
		return"/admin/addUser.html";    
	}
	
	@PostMapping("/admin/addUser")
	public String goAddPlayer(@RequestParam String username, @RequestParam String password, @RequestParam long role, Model model) {

		User user = new User();
		
		user.setUsername(username);
		user.setPassword(encodePassword(password));
		user.getRoles().add(roleRepository.findById(role));
		List<Role> roles = roleRepository.findAll();

		model.addAttribute("roles", roles);
		model.addAttribute("users", userRepository.findAll());
		model.addAttribute("user", new User());
		
		if (userRepository.findByUsername(username) == null) {
			userRepository.save(user);
			return"/admin/addUser.html";    
		} else
			//change to error
			return"/admin/addUser.html";    

	}
	
	private String encodePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
