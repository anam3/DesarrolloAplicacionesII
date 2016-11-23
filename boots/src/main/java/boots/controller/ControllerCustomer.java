package boots.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.Customer;
import boots.service.CustomerService;

@Controller
public class ControllerCustomer {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/all-customers")
	public String allCustomers(HttpServletRequest request){
		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("mode", "MODE_CUSTOMERS");
		return "customer";
	}
	
	@GetMapping("/new-customer")
	public String newCustomers(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_CUSTOMER");
		return "customer";
	}
		
	@GetMapping("/update-customer")
	public String updateCustomers(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("customer", customerService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_CUSTOMER");
		return "customer";
	}
		
	@GetMapping("/delete-customer")
	public String deleteCustomers(@RequestParam int id, HttpServletRequest request){
		customerService.delete(id);
		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("mode", "MODE_CUSTOMERS");
		return "customer";
	}
	
	@PostMapping("/save-customer")
	public String saveCustomer(@ModelAttribute Customer customer,
			BindingResult bindingResult, HttpServletRequest request){
		customerService.save(customer);
		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("mode", "MODE_CUSTOMERS");
		return "customer";
	}
	
	
}
