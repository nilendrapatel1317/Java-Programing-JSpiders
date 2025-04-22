package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import spring.entity.User;

@Controller
public class MyController {

	@GetMapping("/home")
	public String openHome(Model model) {
		String name = "Nilendra";
		model.addAttribute("name", name);
		return "home";
	}

	@GetMapping("/about")
	public ModelAndView openAbout() {
		String name = "Nilendra";
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("about");
		
		return mav;
	}

	@GetMapping("/register")
	public String openRegistationForm() {
		return "user-register";
	}


//	================================================================
//	================================================================

//	method 1 : To get data from frontend by using HttpServeltRequest

//	@PostMapping("/submit-register-form")
//	public String submitRegisterFform(HttpServletRequest req) {
//		
//		String name = req.getParameter("name");
//		String email = req.getParameter("email");
//		String password = req.getParameter("password");
//		
//		System.out.println("name : "+ name);
//		System.out.println("email : "+ email);
//		System.out.println("password : "+ password);
//		
//		
//		return "profile";
//	}

//	=================================================================
//	=================================================================

//	method 2 : To get data from frontend by using @RequestParam annotation

//	@PostMapping("/submit-register-form")
//	public String submitRegisterFform(@RequestParam("name") String name, @RequestParam("email") String email,
//			@RequestParam("password") String password) {
//
//		System.out.println("name : " + name);
//		System.out.println("email : " + email);
//		System.out.println("password : " + password);
//
//		return "profile";
//	}

	//	=================================================================
//	=================================================================
	
//	method 3 : To get data from frontend by using @RequestParam annotation and sending Data to the frontend 
	
//	@PostMapping("/submit-register-form")
//	public String submitRegisterFform(@RequestParam("name") String name, @RequestParam("email") String email,
//			@RequestParam("password") String password , Model model) {
//		
//		System.out.println("name : " + name);
//		System.out.println("email : " + email);
//		System.out.println("password : " + password);
//		
//		model.addAttribute("name", name);
//		model.addAttribute("email", email);
//		model.addAttribute("password", password);
//		
//		return "profile";
//	}
	
//	=================================================================
//	=================================================================
	
//	method 4 : To get data from frontend by using @RequestParam annotation and sending Data to the frontend 
	
//	@PostMapping("/submit-register-form")
//	public String submitRegisterFform(@RequestParam("name") String name, @RequestParam("email") String email,
//			@RequestParam("password") String password , Model model) {
//		
//		System.out.println("name : " + name);
//		System.out.println("email : " + email);
//		System.out.println("password : " + password);
//		
//		User user = new User();
//		user.setName(name);
//		user.setEmail(email);
//		user.setPassword(password);
//		
//		//Only one Model Object
//		model.addAttribute("user", user);
//		
//		return "profile";
//	}
	
//	=================================================================
//	=================================================================
	
//	method 5 : To get multiple data from frontend and sending multiple Data to the frontend by using @ModelAttribute annotation
	
	@PostMapping("/submit-register-form")
	public String submitRegisterFform(@ModelAttribute User user) {
		return "profile";
	}
}
