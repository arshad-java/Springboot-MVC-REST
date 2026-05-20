package com.mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.model.Book;

public interface LibraryRepository extends JpaRepository<Book, Integer> {

}
