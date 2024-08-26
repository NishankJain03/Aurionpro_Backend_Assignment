package com.aurionpro.onetomany.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.onetomany.dto.CourseDto;
import com.aurionpro.onetomany.dto.InstructorDto;
import com.aurionpro.onetomany.dto.PageResponse;
import com.aurionpro.onetomany.entity.Course;
import com.aurionpro.onetomany.entity.Instructor;
import com.aurionpro.onetomany.repository.CourseRepository;
import com.aurionpro.onetomany.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService{

	@Autowired
	private InstructorRepository instructorRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public InstructorDto addInstructor(InstructorDto instructorDto) {
		
		Instructor instructor = instructorToDtoMapper(instructorDto);
		
		instructor = instructorRepository.save(instructor);
		
		return (instructorDtoToInstructorMapper(instructor));
		
		
	}

	public Instructor instructorToDtoMapper(InstructorDto instructorDto) {
		Instructor instructor = new Instructor();
		instructor.setInstructorName(instructorDto.getInstructorName());
		instructor.setQualification(instructorDto.getQualification());
		instructor.setEmail(instructorDto.getEmail());
		return instructor;
	}
	
	public InstructorDto instructorDtoToInstructorMapper(Instructor dbInstructor) {
		InstructorDto instructorDto = new InstructorDto();
		instructorDto.setInstructorId(dbInstructor.getInstructorId());
		instructorDto.setEmail(dbInstructor.getEmail());
		instructorDto.setInstructorName(dbInstructor.getInstructorName());
		instructorDto.setQualification(dbInstructor.getQualification());
		return instructorDto;
	}
	@Override
	public Instructor allocateCourses(int instructorId, List<Course> course) {
		Optional<Instructor> instructor = instructorRepository.findById(instructorId);
		if(!instructor.isPresent())
			return null;
		Instructor dbInstructor = instructor.get();
		List<Course> dbCourse = dbInstructor.getCourses();
		course.forEach((courses) -> {
			Course temp = courseRepository.findById(courses.getCourseId()).get();
			temp.setInstructor(dbInstructor);
			
			dbCourse.add(temp);
		});
		dbInstructor.setCourses(dbCourse);
		return instructorRepository.save(dbInstructor);
	}

	@Override
	public InstructorDto getInstructor(int instructorId) {	
		 Optional<Instructor> optionalInstructor = instructorRepository.findById(instructorId);
		 if(!optionalInstructor.isPresent())
			 return null;
		 return (instructorDtoToInstructorMapper(optionalInstructor.get()));
		 
	}

	@Override
	public List<CourseDto> getInstructorCourses(int instructorId) {
		Optional<Instructor> optionalCourse = instructorRepository.findById(instructorId);
		if(!optionalCourse.isPresent())
			return null;
		List<Course> courses = optionalCourse.get().getCourses();
		List<CourseDto> courseDto = new ArrayList<>();
		for(Course course : courses) {
			courseDto.add(CourseDtoMapper(course));
		}
		return courseDto;
	}
	
	public Course courseTODtoMapper(CourseDto courseDto) {
		Course course = new Course();
		course.setCourseName(courseDto.getCourseName());
		course.setDuration(courseDto.getDuration());
		course.setFees(courseDto.getFees());
		return course;
	}

	public CourseDto CourseDtoMapper(Course course) {
		CourseDto courseDto = new CourseDto();
		courseDto.setCourseId(course.getCourseId());
		courseDto.setCourseName(course.getCourseName());
		courseDto.setDuration(course.getDuration());
		courseDto.setFees(courseDto.getFees());
		return courseDto;
	}

	@Override
	public PageResponse<InstructorDto> getAllInstructor(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Instructor> instructorPage = instructorRepository.findAll(pageable);
		Page<InstructorDto> instructorDto = instructorPage.map(instructor -> this.instructorDtoToInstructorMapper(instructor));
		PageResponse<InstructorDto> pageResponse = new PageResponse<>(instructorDto);
		return pageResponse;
				
  	}
	
	
	

}
