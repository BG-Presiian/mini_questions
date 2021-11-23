package com.groupi.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.groupi.library.dao.BookDaoImpl;
import com.groupi.library.database.DatabaseConnection;
import com.groupi.library.database.DatabaseInitializer;
import com.groupi.library.dto.Book;

public class App {
	
	public static void main(String[] args) throws Exception {
		
		// just testing to make sure these work
		DatabaseConnection dc = new DatabaseConnection();
		DatabaseInitializer di = new DatabaseInitializer();
		dc.start();	
		di.makeTables();
		
		
		/**
		 * Testing
		 */
		//public Book(String id, String myTitle, String myAuthor, LocalDate myPublicationDate, boolean onHold, boolean lentOut, LocalDate dueBack, int UID ) {
		LocalDate d = LocalDate.now();
		Book bk = new Book("5", "POdsdasadr Man", "Henrdsay ohms", d, true, false, d, 4);
		BookDaoImpl book = new BookDaoImpl();
		
		
		book.create(bk);
		
		//System.out.println(BookDaoImpl.DataBaseObjects.toString());
		
		
		//book.remove("4");
		//book.get("5");
		
		//book.update(bk, "6");
		
	
		//List<Book> books = new ArrayList<Book>();
		
		//book.getByAuthor("John");
		
		dc.close();
	}

}