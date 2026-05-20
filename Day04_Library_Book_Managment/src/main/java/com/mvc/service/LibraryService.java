package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mvc.model.Book;
import com.mvc.repo.LibraryRepository;

@Service
public class LibraryService {
	@Autowired
	LibraryRepository repo;
	
	public String add(Book book)
	{
		repo.save(book);
		return book.getId()+" Book Added Succesfully";
		
	}
	
	public String delete(Integer id)
	{
		repo.deleteById(id);
		return id+" Book Deleted Succesfully";
		
	}
	
	public List<Book> view()
	{
		//Pageable pg = PageRequest.of(0, 5);
		return  repo.findAll();
	}

}
