package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.entity.TestFood;
import com.mvc.service.FoodOrderService;

@Controller
public class FoodOrderController {
	
	@Autowired
	FoodOrderService service;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/add")
	public String add()
	{
		return "addForm";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute TestFood tf)
	{
		service.addOrder(tf);
		return "home";
	}
	
	@PostMapping("/upsave")
	public String upsave(@ModelAttribute TestFood tf)
	{
		service.addOrder(tf);
		return "home";
	}
	
	@GetMapping("/view")
	public String view(Model model)
	{
		List<TestFood> orders = service.viewOrders();
		model.addAttribute("orders", orders);
		return "list";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id,Model model)
	{
		TestFood food = service.getOrderById(id);
		model.addAttribute("f", food);
		return "update";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id)
	{
		
		service.deleteOrder(id);
		return "redirect:home";
	}

}
