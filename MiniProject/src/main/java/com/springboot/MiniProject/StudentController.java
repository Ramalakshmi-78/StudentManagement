package com.springboot.MiniProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	@Autowired
	private StudentService service;

	//postmapping 
	@PostMapping("/save")
	public StudentDetails savename(@RequestBody StudentDetails details) {
		return service.save(details);
	}
	
	@GetMapping("/get/{id}")
	public StudentDetails getname(@PathVariable int id) {
	  return service.get(id);
	}
	
	@GetMapping("/details")
	public List<StudentDetails> details() {
		return service.show();
	}
	
	@DeleteMapping("/delete/{id}")
    public void deletestu(@PathVariable int id) {
    	service.deleteStudent(id);
    }

	@PutMapping("/update/{id}")
	public StudentDetails updateStudent(@PathVariable int id,@RequestBody StudentDetails details) {
		return service.update(id,details);
	}
	
}
