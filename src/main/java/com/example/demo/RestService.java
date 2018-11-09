package com.example.demo;

import java.util.List;

import javax.validation.valueextraction.UnwrapByDefault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RestService {
	@Autowired
	StudentRepository repo;
	@PostMapping("/addStudent")
	public  String saveStudent(@RequestBody Student student) {
		repo.save(student);
		return "Student added successfully with id:" +student.getId();
	}
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		repo.deleteById(id);
		return "student deleted successfully with id:"+id;
	}
	@GetMapping("/listOfStudents")
	public  List<Student> listofStudent() {
		return repo.findAll();
	}
	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@RequestBody  Student student) {
		repo.save(student);
		return "student updated successfully with id:"+student.getId();
	}

}
