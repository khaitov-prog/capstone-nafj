package ca.sheridancollege.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

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
}
