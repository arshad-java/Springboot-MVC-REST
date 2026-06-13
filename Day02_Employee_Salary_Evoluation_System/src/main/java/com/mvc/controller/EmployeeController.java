package com.mvc.controller;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.model.Employee;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
	
	@GetMapping("/salaryForm")
	public String displayForm(@ModelAttribute Employee e)
	{
		return "Salary_Form";
	}
	
	@PostMapping("/salary")
	public String display(HttpServletRequest req,Model model)
	{
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		Double basic = Double.parseDouble(req.getParameter("basic"));
		Double hra = Double.parseDouble(req.getParameter("hra"));
		Double da = Double.parseDouble(req.getParameter("da"));
		Double bonus = Double.parseDouble(req.getParameter("bonus"));
		Double total = basic+hra+da+bonus;
		
		model.addAttribute("name", name);
		model.addAttribute("basic", basic);
		model.addAttribute("hra", hra);
		model.addAttribute("da", da);
		model.addAttribute("bonus", bonus);
		model.addAttribute("total", total);
		
		
		return "Salary_Result";
	}
	

}
