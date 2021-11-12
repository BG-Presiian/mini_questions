package com.groupi.library.dao;

import java.time.LocalDate;
import java.util.Collection;
import com.groupi.library.database.DatabaseConnection;
import com.groupi.library.dto.Book;

/**
 * Handles transactions dealing with books in the database.
 * @author Sarah Hansen
 *
 */
public class BookDaoImpl implements BookDao {
	
	private DatabaseConnection dc;
	
	BookDaoImpl() throws Exception{
		 this.dc = new DatabaseConnection();
	}

	@Override
	public void create(Book myData) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove(String uuid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Book myData) {
		// TODO Auto-generated method stub

	}

	@Override
	public Book get(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Book> getByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Book> getByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Book> getByPublicationDate(LocalDate publicationDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Book> getOnHold() {
		// TODO Auto-generated method stub
		return null;
	}

}
