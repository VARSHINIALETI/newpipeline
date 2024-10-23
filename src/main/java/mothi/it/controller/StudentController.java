package mothi.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mothi.it.Student;
import mothi.it.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	
	
	@GetMapping("/index")
	public String getStudentDetails(Model model) {
		
		init(model);
		
		return "index";
	}
	
	
	private void  init(Model model) {
		model.addAttribute("student",new Student());
		model.addAttribute("courses",service.getCourses());
		model.addAttribute("timings",service.getTimings());
	}
	
	@PostMapping("/save")
	public String handlesavebutton(Student s, Model model) {
		
		
		System.out.println(s);
		boolean isSaved =service.saveStudent(s);
		if(isSaved==true) {
		model.addAttribute("msg","Datasaved.....Succesfully.....");
		}
		init(model);
		
		
		return "index";
		
	}
	
	
}
