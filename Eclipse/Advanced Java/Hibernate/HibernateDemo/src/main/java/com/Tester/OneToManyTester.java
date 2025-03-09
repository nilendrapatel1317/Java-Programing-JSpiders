package com.Tester;

import java.util.ArrayList;
import java.util.List;

import com.Entity.OneToMany_Mapping.Book;
import com.Entity.OneToMany_Mapping.Library;
import com.Service.Service;

public class OneToManyTester {
	public static void main(String[] args) {
		Service service = new Service();

//		inseertOneToMany(service);		

		System.out.println();
		service.fetchBooks(2);
		System.out.println();

		service.updateBook(2, 3, 1);
//		service.updateBook1(3);
		
		System.out.println();
		service.fetchBooks(2);
		System.out.println();
	}

	private static void inseertOneToMany(Service service) {
		Book book1 = new Book();
		book1.setName("String");
		
		Book book2 = new Book();
		book2.setName("Array");
		
		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		
		Library library = new Library();
		library.setLocation("Indore");
		library.setBooks(books);
		
		book1.setLibrary(library);
		book2.setLibrary(library);
		
		
		service.ontToManyMapping(library);
		System.out.println(library.toString());
	}
}
