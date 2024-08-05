package com.operator.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating the student object
		Student s1 = new Student();
		
		//setting the value
		s1.studentRollNo = 5;
		s1.studentName = "Nishank";
		
		String filename = "D:\\Training\\Assignments\\01_Operator_POC\\src\\com\\operator\\test\\test1.txt";
		
		try {
			
			//it is used to write the file named 
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			
			//writes the student object to the file
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			//writes the student object s1 to the file
			objectOutputStream.writeObject(s1);
			
			objectOutputStream.close();
			fileOutputStream.close();
			
			System.out.println("Object saved in file");
			
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}


//  serialization is the process of converting the state of the object into a bytestream (platform independent)
// 	this is used for storing the object into the mem, database
// 	this mechanism is used to persist the object
//	to make java object serializable we implement java.io.Serializable
//	ObjectOutputStream class contain writeObject() method used for serializing an object
//	if parent class has implemented it then it is not require for the child class to implement(vice versa not applicable)
// 	only non static data members are saved via Serialization process (static[current value], transient[default value])
// 	SerialVersionUID (version number)

