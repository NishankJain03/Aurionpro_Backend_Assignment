package com.aurionpro.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("D:\\Training\\Assignments\\FileReadAssignmnetUsingStream\\src\\test");
			int i;
			try {
				while((i = fileReader.read())!= -1)
					System.out.print((char)i);
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
