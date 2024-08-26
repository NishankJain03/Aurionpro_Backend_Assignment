package com.aurionpro.onetomany.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.onetomany.dto.CourseDto;
import com.aurionpro.onetomany.entity.Course;
import com.aurionpro.onetomany.entity.Instructor;
import com.aurionpro.onetomany.repository.CourseRepository;
import com.aurionpro.onetomany.repository.InstructorRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public Course addCourse(CourseDto courseDto) {
		Course course = new Course();
		course.setCourseName(courseDto.getCourseName());
		course.setDuration(courseDto.getDuration());
		course.setFees(courseDto.getFees());
		return courseRepository.save(course);
	}

	@Override
	public Course allocateInstructor(int courseId, Instructor instructor) {
		Optional<Course> course = courseRepository.findById(courseId);
		Optional<Instructor> OptionalInstructor = instructorRepository.findById(instructor.getInstructorId());
		Instructor dbInstructor = OptionalInstructor.get();
		if(!course.isPresent())
			return null;
		Course dbCourse = course.get();
		dbCourse.setInstructor(dbInstructor);
		
		return courseRepository.save(dbCourse);
	}

	
	
}
