package com.aurionpro.dbconnect.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.dbconnect.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

	//for communicating with database we need to define a method
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Student> getAllStudents() {
		//SELECT s from Student s Student is name of class
		TypedQuery<Student>query = manager.createQuery("SELECT s from Student s", Student.class);
		return query.getResultList();
	}
	
}
