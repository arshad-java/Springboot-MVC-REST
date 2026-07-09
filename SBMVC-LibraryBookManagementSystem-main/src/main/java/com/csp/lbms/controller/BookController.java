package com.csp.lbms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.csp.lbms.entity.Book;
import com.csp.lbms.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping("/")
	public String viewHomePage(Model model, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "title") String sortField, @RequestParam(defaultValue = "asc") String sortDir,
			@RequestParam(required = false) String keyword,
			@RequestParam(required = false, defaultValue = "all") String genre) {

		Page<Book> bookPage = service.getAllBooks(page, sortField, sortDir, keyword, genre);

		model.addAttribute("bookPage", bookPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", bookPage.getTotalPages());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("keyword", keyword);
		model.addAttribute("genre", genre);
		model.addAttribute("totalBooks", service.totalBooks());
		model.addAttribute("availableBooks", service.availableBooks());
		model.addAttribute("issuedBooks", service.issuedBooks());
		return "index";
	}

	@GetMapping("/showNewBookForm")
	public String showNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "add-book";
	}

	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute Book book) {
		service.saveBook(book);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		model.addAttribute("book", service.getBookById(id));
		return "edit-book";
	}

	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable Long id) {
		service.deleteBook(id);
		return "redirect:/";
	}
}