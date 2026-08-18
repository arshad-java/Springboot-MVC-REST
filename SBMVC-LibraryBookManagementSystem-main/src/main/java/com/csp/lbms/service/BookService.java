package com.csp.lbms.service;

import org.springframework.data.domain.Page;
import com.csp.lbms.entity.Book;

public interface BookService {
	Page<Book> getAllBooks(int page, String sortField, String sortDir, String keyword, String genre);

	void saveBook(Book book);

	Book getBookById(Long id);

	void deleteBook(Long id);

	long totalBooks();

	long availableBooks();

	long issuedBooks();
}