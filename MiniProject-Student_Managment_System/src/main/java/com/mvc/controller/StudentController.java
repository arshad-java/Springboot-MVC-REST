package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/home")
	public String home()
	{
		return "Home";
	}
	
	@GetMapping("/add")
	public String addStudent()
	{
		return "Add_Student";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Student s,Model model) {
		
		String str = service.addStudent(s);
		model.addAttribute("msg",str);
		
		return "Home";
	}
	
	
	@GetMapping("/show")
	public String showStudents(Model model)
	{
		model.addAttribute("users", service.showStudent());
		return "Student_List";
	}
	
	

}
