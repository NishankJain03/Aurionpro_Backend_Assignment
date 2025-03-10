package com.aurionpro.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileReaderStreamDemo {

	public static void main(String[] args) {
		String fileName = "D:\\Training\\Assignments\\FileReadAssignmnetUsingStream\\src\\test";
		
		//using File.lines()
		try {
			Stream<String> fileStream = Files.lines(Paths.get(fileName));
			fileStream.forEach((line) -> System.out.println(line));
			fileStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//using BufferedReader.Lines()
		try {
			BufferedReader bufferReader = Files.newBufferedReader(Paths.get(fileName));
			Stream<String> lines = bufferReader.lines();
			lines.forEach((line) -> System.out.println(line));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//using the Files.readALLLines()
		Path filePath = Paths.get("D:\\Training\\Assignments\\FileReadAssignmnetUsingStream\\src\\test");
		
		try {
			List<String> lines = Files.readAllLines(filePath);
			lines.stream().forEach((line) -> System.out.println(line));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
