package com.aurionpro.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.onetomany.dto.CourseDto;
import com.aurionpro.onetomany.entity.Course;
import com.aurionpro.onetomany.entity.Instructor;
import com.aurionpro.onetomany.service.CourseService;

@RestController
@RequestMapping("/studentapp")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestBody CourseDto courseDto) {
		courseService.addCourse(courseDto);
		return "Course Added Successfully";
	}
	
	@PutMapping("/courses/instructors")
	public ResponseEntity<Course> allocateInstructor(@RequestParam int courseId, @RequestBody Instructor instructor){
		return ResponseEntity.ok(courseService.allocateInstructor(courseId, instructor));
	}
}


