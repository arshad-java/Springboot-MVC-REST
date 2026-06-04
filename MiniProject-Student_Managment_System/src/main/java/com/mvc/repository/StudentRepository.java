package com.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
