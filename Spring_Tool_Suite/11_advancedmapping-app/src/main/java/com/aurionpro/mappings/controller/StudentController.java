package com.aurionpro.mappings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.mappings.entity.Address;
import com.aurionpro.mappings.entity.Student;
import com.aurionpro.mappings.service.StudentService;

@RestController
@RequestMapping("/studentapp")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<Student> addNewStudent(@RequestBody Student student){
		return ResponseEntity.ok(studentService.addStudent(student));
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudent(){
		return ResponseEntity.ok(studentService.getAllStudent());
	}
	
	@GetMapping("/address/{rollnumber}")
	public ResponseEntity<Address> getAddress(@PathVariable int rollnumber){
		return ResponseEntity.ok(studentService.getStudentAddress(rollnumber));
	}
	
	@PutMapping("/address")
	public String updateAddress(@RequestParam int rollnumber, @RequestParam String city){
		studentService.updateStudentAddress(rollnumber, city);
		return "Updated the record";
	}
}
