package boots.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.Student;
import boots.service.StudentService;

@Controller
public class ControllerStudent {
	@Autowired
	private StudentService studentService;
		
	
	@GetMapping("/all-students")
	public String allStudents(HttpServletRequest request){
		request.setAttribute("students", studentService.findAll());
		request.setAttribute("mode", "MODE_STUDENTS");
		return "student";
	}
	
	@GetMapping("/new-student")
	public String newStudents(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_STUDENT");
		return "student";
	}
	
	@GetMapping("/update-student")
	public String updateStudents(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("student", studentService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_STUDENT");
		return "student";
	}

	@GetMapping("/delete-student")
	public String deleteStudents(@RequestParam int id, HttpServletRequest request){
		studentService.delete(id);
		request.setAttribute("students", studentService.findAll());
		request.setAttribute("mode", "MODE_STUDENTS");
		return "student";
	}
	
	@PostMapping("/save-student")
	public String saveStudent(@ModelAttribute Student student,
			BindingResult bindingResult, HttpServletRequest request){
		studentService.save(student);
		request.setAttribute("students", studentService.findAll());
		request.setAttribute("mode", "MODE_STUDENTS");
		return "student";
	}


}
