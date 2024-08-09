package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection {
	Scanner scanner = new Scanner(System.in);
	public void connectToDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
				DatabaseMetaData databaseMetaData = connection.getMetaData();
				//Retrieving the columns in the database
			      ResultSet tables = databaseMetaData.getTables(null, null, "students", null);
			      //Printing the column name and size
			      while (tables.next()) {
			         System.out.println("Table name: "+tables.getString("Table_NAME"));
			         System.out.println("Table type: "+tables.getString("TABLE_TYPE"));
			         System.out.println("Table schema: "+tables.getString("TABLE_SCHEM"));
			         System.out.println("Table catalog: "+tables.getString("TABLE_CAT"));
			         System.out.println(" ");
			      }
			      
			      //column metadata
			      Statement stmt = connection.createStatement();
			      String query = "SELECT * FROM students"; 
		          ResultSet rs = stmt.executeQuery(query); 
			      ResultSetMetaData rsmd= rs.getMetaData();  
			      System.out.println("Total columns: "+rsmd.getColumnCount());  
			      System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
			      System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  
				System.out.println("Connection Successful");
				
//				Statement statement = connection.createStatement();
//				System.out.println("Enter the roll number");
//				int rollno = scanner.nextInt();
//				System.out.println("Enter the name");
//				String name = scanner.next();
//				System.out.println("Enter the percentage");
//				Double percentage = scanner.nextDouble();
//				
//				PreparedStatement preparedStatement = connection.prepareStatement("insert into students value(?,?,?)");
//				
//				preparedStatement.setInt(1, rollno);
//				preparedStatement.setString(2, name);
//				preparedStatement.setDouble(3, percentage);
//				preparedStatement.executeUpdate();
				
				
				
				
//				System.out.println("Enter the roll number for which you want to update data");
//				int Updaterollno = scanner.nextInt();
//				System.out.println("Enter the percentage");
//				Double Updatepercentage = scanner.nextDouble();
//				PreparedStatement preparedStatement = connection.prepareStatement("update students set percentage = ? where rollno = ?");
//				preparedStatement.setDouble(1, Updatepercentage);
//				preparedStatement.setInt(2, Updaterollno);
//				preparedStatement.executeUpdate();

//				preparedStatement = connection.prepareStatement("insert into students value(?,?,?)");
//				statement.executeUpdate("insert into students values(3,'nishank',78)");
//				System.out.println("Record Inserted Successfully");
//				
//				System.out.println("Enter the roll number");
//				int rollno = scanner.nextInt();
//				System.out.println("Enter the name");
//				String name = scanner.next();
//				System.out.println("Enter the percentage");
//				Double percentage = scanner.nextDouble();
				
//				statement.executeUpdate("insert into students values("+rollno+",'"+name+"',"+percentage+")");
//				System.out.println("Record Inserted Successfully");
				
//				System.out.println("Enter the roll number for which you want to update data");
//				int Updaterollno = scanner.nextInt();
//				System.out.println("Enter the percentage");
//				Double Updatepercentage = scanner.nextDouble();
				
//				statement.execute("update students set percentage = "+Updatepercentage+" where rollno = "+Updaterollno+"");
//				System.out.println("Record Inserted Successfully");
//	
//				ResultSet dbStudentData = statement.executeQuery("select * from students");
//				while(dbStudentData.next()) {
//					System.out.println(dbStudentData.getInt("rollno")+ "\t" + dbStudentData.getString("name") + "\t" + dbStudentData.getDouble("percentage"));
//				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
