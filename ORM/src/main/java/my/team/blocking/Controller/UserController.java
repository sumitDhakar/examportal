package my.team.blocking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.team.blocking.Service.UserService;
import my.team.blocking.entity.User;

@Controller

public class UserController {

	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/hello")
	public String showHello() {
		return "hello";
	}
	
	@GetMapping("/customer")
	public String showCustomer() {
		return "customer";
	}
	
	@GetMapping("/admin")
	public String showAdmin() {
		return "admin";
	}
	

}
