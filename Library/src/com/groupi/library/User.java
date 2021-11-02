package com.groupi.library;

import java.security.*;
import java.util.UUID;
public class User {
	
	//fields
	private String userID;
	private String username;
	private String encryptedPassword;
	private boolean loggedIn = false; //do we need this? unsure
	private Book[] booksHeld;
	
	//constructors
	
	//users shouldn't be created without both usernames and passwords
	public User(String myUsername, String myPassword) {
		this.userID = UUID.randomUUID().toString(); 
		this.username = myUsername;
		this.encryptedPassword = hash(myPassword);
	}
	
	//getters, setters
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public Book[] getBooksHeld() {
		return booksHeld;
	}

	public void setBooksHeld(Book[] booksHeld) {
		this.booksHeld = booksHeld;
	}
	
	
	//other methods
	private static String hash(String ptPW) {
		String hashedPW = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(ptPW.getBytes());
			byte[] bytes = md.digest();
			
			//convert from dec to hex
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			hashedPW = sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashedPW;
	}


	
	
}