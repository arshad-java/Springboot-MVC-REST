package com.csp.lbms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.csp.lbms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Page<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String author,
			Pageable pageable);

	Page<Book> findByGenreContainingIgnoreCaseAndAvailability(String genre, Boolean availability, Pageable pageable);

	Page<Book> findByGenreContainingIgnoreCase(String genre, Pageable pageable);

	long countByAvailability(Boolean availability);
}