package com.csp.lbms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.csp.lbms.entity.Book;
import com.csp.lbms.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;

	@Override
	public Page<Book> getAllBooks(int page, String sortField, String sortDir, String keyword, String genre) {

		Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(page - 1, 5, sort);

		// ✅ Priority: keyword search takes precedence over genre filter
		if (keyword != null && !keyword.isEmpty()) {
			return repository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword, pageable);
		}

		// ✅ Genre filter — "all" or null means no filter
		if (genre != null && !genre.isEmpty() && !genre.equalsIgnoreCase("all")) {
			// availability=null means show both available and issued
			// We reuse the existing repo method — pass null for availability
			return repository.findByGenreContainingIgnoreCaseAndAvailability(genre, null, pageable);
		}

		return repository.findAll(pageable);
	}

	@Override
	public void saveBook(Book book) {
		repository.save(book);
	}

	@Override
	public Book getBookById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void deleteBook(Long id) {
		repository.deleteById(id);
	}

	@Override
	public long totalBooks() {
		return repository.count();
	}

	@Override
	public long availableBooks() {
		return repository.countByAvailability(true);
	}

	@Override
	public long issuedBooks() {
		return repository.countByAvailability(false);
	}
}