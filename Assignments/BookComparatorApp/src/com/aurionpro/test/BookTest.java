package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.model.Book;
import com.aurionpro.model.BooksComparators;

public class BookTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		List<Book> books = new ArrayList<Book>();
		
		System.out.println("Enter the number of books");
		int numberOfBooks = scanner.nextInt();
		
		for(int i=0; i< numberOfBooks; i++) {
			System.out.println("Enter the title of the book");
			String title = scanner.next();
			System.out.println("Enter the name of the author");
			String author = scanner.next();
			System.out.println("Enter the price of the book");
			double price = scanner.nextDouble();
			System.out.println("Enter the publication year of the book");
			int publicationYear = scanner.nextInt();
			
			books.add(new Book(title, author, price, publicationYear));
		}
		
		System.out.println("Sorted list of title he book");
		Collections.sort(books, new BooksComparators.BookTitleComparator());
		for(Book book : books)
			System.out.println(book);
		
		System.out.println("Sorted list of name of the book");
		Collections.sort(books, new BooksComparators.BookAuthorComparator());
		for(Book book : books)
			System.out.println(book);
		
		System.out.println("Sorted list based on price of the book");
		Collections.sort(books, new BooksComparators.BookPriceComparator());
		for(Book book : books)
			System.out.println(book);
		
		System.out.println("Sorted list based on the publication year");
		Collections.sort(books, new BooksComparators.BookPublicationYearComparator());
		for(Book book : books)
			System.out.println(book);
		
		System.out.println("Sorting the books first by author, then by title, and finally by price");
		Collections.sort(books, new BooksComparators.BookAuthorComparator().thenComparing(Book :: getTitle).thenComparing(Book:: getPrice));
		for(Book book : books)
			System.out.println(book);
		
		System.out.println("Sorting the books first by publication, then by price, then by author");
		Collections.sort(books, new BooksComparators.BookPublicationYearComparator().thenComparing(Book :: getPrice).thenComparing(Book:: getAuthor));
		for(Book book : books)
			System.out.println(book);
		
		scanner.close();
		
		
		
		

	}

}
