package com.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.entity.Student;
import com.mvc.exception.InvalidId;
import com.mvc.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repo;
	
	public List<Student> showStudent()
	{
		return repo.findAll();
	}
	
	public String addStudent(Student s)
	{
		repo.save(s);
		return s.getId()+" Added Succefully";
	}
	
	public Optional<Student> getById(Integer id)
	{
		return repo.findById(id);
		
	}
	
	public String deleteStudent(Integer id)
	{
		Student s =repo.findById(id).orElseThrow(()-> new InvalidId("Invalid Id Value, please Check Once"));
		repo.delete(s);
		return id+" Student Is Deleted Succesfully";
	}
	
	

}
