package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	
	@GetMapping()
	public String displayForm()
	{
		return "Form";
		
	}
	
	@PostMapping("/register")
	public String displayResult(@RequestParam String name,
			                    @RequestParam Integer rollno,
			                    @RequestParam Integer m1,
	                            @RequestParam Integer m2,
                                @RequestParam Integer m4,
                                Model model)
	{
		Double total = (double) (m1+m2+m4);
		Double per = total/3;
		
		String grade ;
		if(per>80)
			grade = "Excellent";
		else if(per>60)
			grade = "Average";
		else 
			grade ="Low";
		
		model.addAttribute("name", name);
		model.addAttribute("rollno", rollno);
		model.addAttribute("total", total);
		model.addAttribute("per", per);
		model.addAttribute("garde", grade);
		
		
		return "Result";
	}

}
