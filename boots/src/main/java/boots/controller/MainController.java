package boots.controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("task")
	public String homeT(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_TASK");
		return "task";
	}
		
	@GetMapping("student")
	public String homeS(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_STUDENT");
		return "student";
	}
	
	@GetMapping("customer")
	public String homeC(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_CUSTOMER");
		return "customer";
	}
}
