package com.aurionpro.mappings.service;

import java.util.List;

import com.aurionpro.mappings.entity.Address;
import com.aurionpro.mappings.entity.Student;

public interface StudentService {
	Student addStudent(Student student);
	List<Student> getAllStudent();
	Address getStudentAddress(int rollnumber);
	Address updateStudentAddress(int rollnumber, String city);
}
