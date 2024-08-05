package com.operator.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// creating an object of the file
		File myFile = new File("D:\\Training\\Assignments\\01_Operator_POC\\src\\com\\operator\\test\\newFile.txt");
		
		
		try {
			Scanner scanner = new Scanner(myFile);
			while(scanner.hasNextLine()) {
				String data = scanner.nextLine();
				System.out.println(data);
			}
			scanner.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		try {
			FileWriter myWriter = new FileWriter("D:\\\\Training\\\\Assignments\\\\01_Operator_POC\\\\src\\\\com\\\\operator\\\\test\\\\newFile.txt");
			
			//it will write the content in the file
			myWriter.write("This is the demo");
			myWriter.close();
			System.out.println("Successfully wrote the file");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			// creates a new file
			myFile.createNewFile();
			System.out.println("File created successfully");
			
			
			//here we get the absolute path of the particular path
			System.out.println(myFile.getAbsolutePath());
			
			//checks whether we can modify the file
			System.out.println(myFile.canWrite());
			
			//test whether the file or directory exits
			System.out.println(myFile.exists());
			
			//returns the pathname of the parent
			System.out.println(myFile.getParent());
			
			//returns the name of the file
			System.out.println(myFile.getName());
			
			//converts it into the string
			System.out.println(myFile.getPath());
			
			//returns the length of the file
			System.out.println(myFile.length());
			
			//construct a file URI
			System.out.println(myFile.toURI());
			
			//rename the file
			System.out.println(myFile.renameTo(myFile));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//this is delete the file
		myFile.delete();

	}

}


//	it is representation of the file or directory pathname.
//	instances of the file class are immutable