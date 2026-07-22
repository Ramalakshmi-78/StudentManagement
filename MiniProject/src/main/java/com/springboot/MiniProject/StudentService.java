package com.springboot.MiniProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	public StudentRepository repo;
	
	public StudentDetails save(StudentDetails details) {
	return repo.save(details);
	}
	
	public StudentDetails get(int id) {
	//return repo.findById(id).map(StudentDetails::getName).orElse("Student not found");
		return repo.findById(id).orElseThrow(()-> new RuntimeException("student not exist"));	
	}
	
	public  List<StudentDetails> show() {
		return repo.findAll();	
	}
	
	public void deleteStudent(int id) {
		if (repo.existsById(id)) {
	        repo.deleteById(id);
	    } else {
	        System.out.println("Student not found with id: " + id);
	    }
	}
	
	public StudentDetails update(int id,StudentDetails details) {
		 StudentDetails stu =repo.findById(id).get();
		 
		 stu.setName(details.getName());
		 stu.setPhone(details.getPhone());
	     return repo.save(stu);
	}
	
}