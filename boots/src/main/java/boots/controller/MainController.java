package boots.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.Customer;
import boots.model.Student;
import boots.model.Task;
import boots.service.CustomerService;
import boots.service.StudentService;
import boots.service.TaskService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

@Controller
public class MainController {
	@Autowired
	private TaskService taskService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request){
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/all-customers")
	public String allCustomers(HttpServletRequest request){
		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("mode", "MODE_CUSTOMERS");
		return "index";
	}
	
	@GetMapping("/new-task")
	public String newTasks(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@GetMapping("/new-customer")
	public String newCustomers(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_CUSTOMER");
		return "index";
	}
	
	@GetMapping("/update-task")
	public String updateTasks(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("task", taskService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/update-customer")
	public String updateCustomers(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("customer", customerService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_CUSTOMER");
		return "index";
	}
	
	@GetMapping("/delete-task")
	public String deleteTasks(@RequestParam int id, HttpServletRequest request){
		taskService.delete(id);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/delete-customer")
	public String deleteCustomers(@RequestParam int id, HttpServletRequest request){
		customerService.delete(id);
		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("mode", "MODE_CUSTOMERS");
		return "index";
	}
	
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Task task,
			BindingResult bindingResult, HttpServletRequest request){
		taskService.save(task);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@PostMapping("/save-customer")
	public String saveCustomer(@ModelAttribute Customer customer,
			BindingResult bindingResult, HttpServletRequest request){
		customerService.save(customer);
		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("mode", "MODE_CUSTOMERS");
		return "index";
	}
	
	@GetMapping("/all-students")
	public String allStudents(HttpServletRequest request){
		request.setAttribute("students", studentService.findAll());
		request.setAttribute("mode", "MODE_STUDENTS");
		return "index";
	}
	
	@GetMapping("/new-student")
	public String newStudents(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_STUDENT");
		return "index";
	}
	
	@GetMapping("/update-student")
	public String updateStudents(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("student", studentService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_STUDENT");
		return "index";
	}

	@GetMapping("/delete-student")
	public String deleteStudents(@RequestParam int id, HttpServletRequest request){
		studentService.delete(id);
		request.setAttribute("students", studentService.findAll());
		request.setAttribute("mode", "MODE_STUDENTS");
		return "index";
	}
	
	@PostMapping("/save-student")
	public String saveStudent(@ModelAttribute Student student,
			BindingResult bindingResult, HttpServletRequest request){
		studentService.save(student);
		request.setAttribute("students", studentService.findAll());
		request.setAttribute("mode", "MODE_STUDENTS");
		return "index";
	}

}
