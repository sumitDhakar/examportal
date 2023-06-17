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
@RequestMapping("/user")
public class AuthController {
	@Autowired
	private UserService userService;

		
		@GetMapping("/")
		public String home() {
			return "home";
		}
		
		@GetMapping("/showRegistration")
		public String showRegistration() {
			return "UserRegister";
		}
		
		@PostMapping("/save")
		public String addUser(@ModelAttribute User user,Model model){
			model.addAttribute("message","User Registered with id : "+this.userService.saveUser(user));
		  return "UserRegister";
		}
		
		
	}


