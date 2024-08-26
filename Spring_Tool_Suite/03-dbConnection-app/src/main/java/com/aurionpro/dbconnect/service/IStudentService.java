package com.aurionpro.dbconnect.service;

import java.util.List;

import com.aurionpro.dbconnect.entity.Student;

public interface IStudentService {
	List<Student> getAllStudents();
	Student getStudent(int rollnumber);
	Student addStudent(Student student);
	List<Student> getStudentByName(String name);
}
