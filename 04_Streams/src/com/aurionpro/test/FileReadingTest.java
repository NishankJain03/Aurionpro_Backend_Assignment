package com.aurionpro.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch;
		int charCount = 0;
		int wordCount = 0;
		int lineCount = 0;
		boolean isWord = false;
		try {
			FileInputStream fileInputStream = new FileInputStream("D:\\Training\\04_Streams\\src\\com\\aurionpro\\test\\test1");
			
			while((ch = fileInputStream.read()) != -1) {
				
				//reads the character 
				charCount++;
				
				
				if((char)ch == ' ' || (char)ch == '\n' || (char)ch == '\t') {
                    if(isWord) {
                        wordCount++;
                        isWord = false;  // Reset the word flag
                    }
                } else {
                    isWord = true;  // We are in a word
                }
				
				

				if((char)ch == '\n') {
					lineCount++;
				}
				
			}
			if(isWord) {
                wordCount++;
            }
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		System.out.println(charCount);
		System.out.println(wordCount);
		System.out.println(lineCount);
		
		

	}

}

//in output stream there is no necessary if the file is present
//if the file is present and it will remove the original content and replace it with one
