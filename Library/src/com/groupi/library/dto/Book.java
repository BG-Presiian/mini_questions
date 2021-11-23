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
	private LocalDate publicationDate;
	private boolean onHold = false;
	private boolean lentOut = false;
	private LocalDate dueBack = null;
	private String id;
	private int UID;
	
	
	/* 
	 * no copies field: each book will be tracked individually 
	 * within the database using the book id assigned
	*/
	
	//constructors
	public Book(String id, String myTitle, String myAuthor, LocalDate myPublicationDate, boolean onHold, boolean lentOut, LocalDate dueBack, int UID ) {
		this.id = UUID.randomUUID().toString();
		this.title = myTitle;
		this.author = myAuthor;
		this.publicationDate = myPublicationDate;
		this.onHold = onHold;
		this.lentOut = lentOut;
		this.dueBack = dueBack;
		this.UID = UID;
	}
	
	public Book(String myTitle, String myAuthor) {
		this("2",myTitle, myAuthor, null, false,false, null, 0);
	}
	
	public Book(String myTitle) {
		this("2",myTitle, "", null, false,false, null, 0);
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
	
	public LocalDate getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
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

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		this.UID = uID;
	}

	
	
	@Override
	public String toString()
	{
		return "BookID= " + this.getId() + " \nTitle= " + this.getTitle() + " \nAuthor= " + this.getAuthor() + 
				"\nPublicationDate= " + this.getPublicationDate() + "\nisOnHold= " + this.isOnHold() + " \nisLentOut= " + 
				this.isLentOut() + " \nDueBack= " + this.getDueBack() + " \nUID= " + this.getUID();
	}
}
