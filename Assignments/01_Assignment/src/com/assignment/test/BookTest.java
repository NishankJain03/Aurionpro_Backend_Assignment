package com.assignment.test;

import java.util.Scanner;

import com.assignment.model.Book;
import com.assignment.model.Player;

public class BookTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
			System.out.println("Enter the number of books");
			int size = scanner.nextInt();
			
			Book books[] = new Book[size];
			for(int i=0; i<books.length;i++) {
				System.out.println("Enter the name of the book");
				String name = scanner.next();
				System.out.println("Enter the book id");
				int bookId = scanner.nextInt();
				System.out.println("Enter the name of the author ");
				String author = scanner.next();
				System.out.println("Enter the price");
				double price = scanner.nextDouble();
				
				books[i] = new Book(bookId, name, author, price);
			}
			
			//sort in descending
			sortDescending(books);
			
			//display
			for(int i=0;i<books.length;i++) {
				System.out.println("BookId " +  books[i].getBookId());
				System.out.println("Name " + books[i].getName());
				System.out.println("Author " + books[i].getAuthor());
				System.out.println("Price "+ books[i].getPrice());
			}
			

	}
	public static void sortDescending(Book []books) {
		for(int i=0; i<books.length-1;i++) {
			for(int j=0; j<books.length- i -1;j++) {
				if(books[j].getPrice() < books[j+1].getPrice()) {
					Book temp = books[j];
					books[j] = books[j+1];
					books[j+1] = temp;
				}
			}
		}
	}

}
