package com.solr.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.solr.api.model.Student;
import com.solr.api.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	private StudentRepository repository;
	
	@PostConstruct
	public void addStudent() {
		List<Student> students=new ArrayList<>();
		students.add(new Student(1, "Harish", new String[] {"Delhi"}));
		students.add(new Student(2, "Rahul", new String[] {"Bangalore"}));
		students.add(new Student(3, "Ajay", new String[] {"Odisha"}));
		repository.saveAll(students);
	}
	@GetMapping("/getAll")
	public Iterable<Student> getAllStudents(){
		return repository.findAll();
	}
	@GetMapping("/getStudent/{name}")
	public Student getStudentByName(@PathVariable String name) {
		return repository.findByName(name);
	}
}
