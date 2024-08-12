package com.aurionpro.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.entities.Student;

public class DbUtil {
	private Connection connection;
	private Statement statement;
	private static DbUtil dbUtil = null;
	
	private DbUtil() {
		
	}
	public static DbUtil getDbUtil() {
		if(dbUtil == null)
			dbUtil = new DbUtil();
		return dbUtil;
	}
	public void connectToDo() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
					System.out.println("Connection Successful");
					statement = connection.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public List<Student> getAllUsers() {
		ResultSet dbUsers = null;
		List<Student> students = new ArrayList<Student>();
		try {
			dbUsers = statement.executeQuery("select * from students");
			while(dbUsers.next()) {
				students.add(new Student(dbUsers.getInt("rollno"), dbUsers.getString("name"), dbUsers.getDouble("percentage")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
		
	}
	
	
}
