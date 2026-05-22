package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.model.Book;
import com.mvc.service.LibraryService;

@Controller 
public class LibraryController {
	
	@Autowired
	LibraryService service;
	
	@GetMapping("/")
	public String home()
	{
		return "Home";
	}
	
	@GetMapping("/view")
	public String view(Model model)
	{
		List<Book> books = service.view();
		System.out.println(books);
		model.addAttribute("books", books);
		return "view";
	}
	
	@GetMapping("/add")
	public String add()
	{
		
		return "Add-Book";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id)
	{
		
		return "Add-Book";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id)
	{
		String delete = service.delete(id);
		System.out.println(delete);
		return "redirec:/home";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Book book,Model model)
	{
		String msg = service.add(book);
		model.addAttribute("msg", msg);
		return "Home";
	}
	

}
