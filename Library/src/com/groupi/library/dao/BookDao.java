package com.groupi.library.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.groupi.library.dto.Book;

/**
 * Interface to deal with database operations relating to books in the
 * library system.
 * @author Sarah Hansen
 *
 */
public interface BookDao extends LibraryObjectDao<Book> {
	
	/**
	 * Returns all books in the database with a given title.
	 * @param title
	 * @return A Collection of all books with a matching title
	 */
	ArrayList<Book> getByTitle(String title);
	
	/**
	 * Returns all books in the database written by a given author.
	 * @param author The author to be searched for
	 * @return A Collection of all books by that author.
	 */
	ArrayList<Book> getByAuthor(String author);
	
	/**
	 * Returns all books in the database with the given publication date.
	 * @param publicationDate The date to be searched for
	 * @return A Collection of all books published on that date.
	 */
	ArrayList<Book> getByPublicationDate(LocalDate publicationDate);
	
	/**
	 * Returns all books in the database that are currently on hold.
	 * @return A Collection of all on-hold books
	 */
	ArrayList<Book> getOnHold();
}
