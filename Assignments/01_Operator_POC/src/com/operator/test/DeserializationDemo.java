package com.operator.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "D:\\Training\\Assignments\\01_Operator_POC\\src\\com\\operator\\test\\test1.txt";
		try {
			
			//read from the file named 
			FileInputStream fileinputStream = new FileInputStream(filename);
			
			//it reads the student object from the file 
			ObjectInputStream objectInputStream = new ObjectInputStream(fileinputStream);
			
			
			//it will treat the deserialized object as an instance of the Student class
			Student obj = (Student) objectInputStream.readObject();
			System.out.println(obj.studentRollNo);
			System.out.println(obj.studentName);
			
			objectInputStream.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

// The ObjectInputStream class contain readObject() method for desiralizing the object
// constructor of object is never called when an object is deserialized
