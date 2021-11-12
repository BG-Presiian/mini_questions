package com.groupi.library.dto;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Data object class for book info
 * @author Sarah Hansen
 *
 */
public class Book implements LibraryObject {
	
	//fields
	private String title;
	private String author;
	private LocalDate publicatonDate;
	private boolean onHold = false;
	private boolean lentOut = false;
	private LocalDate dueBack = null;
	private String id;
	/* 
	 * no copies field: each book will be tracked individually 
	 * within the database using the book id assigned
	*/
	
	//constructors
	public Book(String myTitle, String myAuthor, LocalDate myPublicationDate) {
		this.title = myTitle;
		this.author = myAuthor;
		this.publicatonDate = myPublicationDate;
		this.id = UUID.randomUUID().toString();
	}
	
	public Book(String myTitle, String myAuthor) {
		this(myTitle, myAuthor, null);
	}
	
	public Book(String myTitle) {
		this(myTitle, "unknown", null);
	}
	
	//methods
	public boolean lendBook() {
		if (!lentOut) {
			this.dueBack = LocalDate.now(); //uhh lookup how to add to dates
			this.onHold = false;
			this.lentOut = true;
			return true;
		}
		else {
			return false;
		}
	}
	
	//getters and setters
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public LocalDate getPublicatonDate() {
		return publicatonDate;
	}
	
	public void setPublicatonDate(LocalDate publicatonDate) {
		this.publicatonDate = publicatonDate;
	}
	
	public boolean isOnHold() {
		return onHold;
	}
	
	public void setOnHold(boolean onHold) {
		this.onHold = onHold;
	}
	
	public boolean isLentOut() {
		return lentOut;
	}
	
	public void setLentOut(boolean lentOut) {
		this.lentOut = lentOut;
	}
	
	public LocalDate getDueBack() {
		return dueBack;
	}
	
	public void setDueBack(LocalDate dueBack) {
		this.dueBack = dueBack;
	}
	
	// id is read only.
	@Override
	public String getId() {
		return id;
	}

	
}
