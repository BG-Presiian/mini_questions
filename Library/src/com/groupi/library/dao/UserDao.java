package com.groupi.library.dao;

import com.groupi.library.dto.User;

/**
 * Interface to deal with database operations relating to users in the
 * library system.
 * @author Sarah Hansen
 *
 */
public interface UserDao extends LibraryObjectDao<User>{
	
	/**
	 * Returns the user with the given username.
	 * @return The user with the username, or null if there is no user with
	 * that username.
	 */
	User getByUsername(String username);
}
