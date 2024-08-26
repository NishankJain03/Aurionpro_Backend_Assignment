package com.aurionpro.onetomany.service;

import com.aurionpro.onetomany.dto.CourseDto;
import com.aurionpro.onetomany.entity.Course;
import com.aurionpro.onetomany.entity.Instructor;

public interface CourseService {
	Course addCourse(CourseDto courseDto);

	Course allocateInstructor(int courseId, Instructor instructor);
}
