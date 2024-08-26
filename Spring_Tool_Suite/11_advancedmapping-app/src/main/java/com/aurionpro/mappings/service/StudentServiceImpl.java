package com.aurionpro.mappings.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.mappings.entity.Address;
import com.aurionpro.mappings.entity.Student;
import com.aurionpro.mappings.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	
	
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	@Override
	public Address getStudentAddress(int rollnumber) {
		Student studentObj1 = studentRepository.findById(rollnumber).orElse(null);
		return studentObj1.getAddress();	
	}
	@Override
	public Address updateStudentAddress(int rollnumber, String city) {
		Student studentObj1 = studentRepository.findById(rollnumber).orElse(null);
		studentObj1.getAddress().setCity(city);
		studentRepository.save(studentObj1);
		return studentObj1.getAddress();
	}

}
