package com.groupi.library.dao;

import com.groupi.library.dto.LibraryObject;

/**
 * This is a generic interface for CRUD operations on data objects within this
 * database. All other DAO should implement or extend this interface.
 * @author Sarah Hansen
 *
 * @param <L> a generic LibraryObject, standing in for Books, Users, etc.
 */
public interface LibraryObjectDao<L extends LibraryObject> {
	
	/**
	 * Adds the info in the given Book to the Book table in the database. 
	 * @param myBook 
	 */
	
	void create(L myData);
	
	/**
	 * Removes the data associated with the given id from the database.
	 * @param uuid the Unique id field associated with the Book to be removed
	 */
	void remove(String uuid);
	
	/**
	 * Updates the current data in the database for the given object.
	 * @param myData the new data 
	 */
	void update(L myData, String location);
	
	/**
	 * Retrieves the data associated with the given id from the database.
	 * @param uuid
	 */
	L get(String uuid);
	
}
