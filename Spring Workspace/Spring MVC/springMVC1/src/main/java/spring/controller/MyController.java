package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/home")
	public String openHome(Model model) {
		return "home";
	}
	
	@GetMapping("/about")
	public String openAbout(Model model) {
		return "about";
	}
}
