package com.groupi.library.dao;

import com.groupi.library.database.DatabaseConnection;
import com.groupi.library.database.DatabaseInitializer;
import com.groupi.library.dto.Book;
import com.groupi.library.dto.User;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;;

/**
 * Handles transactions dealing with users in the database.
 * 
 * @author Sarah Thompson
 *
 */

public class UserDaoImpl extends DatabaseInitializer implements UserDao {

	private DatabaseConnection dc;
	private Statement st;

	public UserDaoImpl() throws Exception {
		super();
		this.dc = new DatabaseConnection();
	}

	@Override
	public void create(User myData) {
		/*
		 * For creating users if we make a sign up page or while we are testing
		 */
		try {
			st = con.createStatement();
			String us = "SELECT * FROM user";
			ResultSet re = st.executeQuery(us);
			while (re.next()) {
				if (re.getString("Username").equals(myData.getUsername())) {
					System.out.println("user already exists");
					re.close();
					st.close();
					return;
				}
			}
			re.close();
			// String
			String sql = "INSERT INTO user VALUES(?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, null);
			stmt.setString(2, myData.getUsername());
			stmt.setString(3, myData.getEncryptedPassword());
			stmt.setString(4, "0");
			stmt.setString(5, myData.getId());
			stmt.executeUpdate();
			stmt.close();
			st.close();

		} catch (Exception ex) {
			System.out.println(ex);
			// ex.printStackTrace();
		}
	}

	@Override
	public void remove(String uuid) {
		/* For deleting accounts */
		try {
			st = con.createStatement();
			String query = "DELETE FROM user WHERE UserID = "+uuid;
			Statement stmt = con.createStatement();
			returnBooks(uuid);
			stmt.execute(query);	
			String sql = "INSERT INTO user VALUES(?,?,?,?,?)";
			st.close();
			stmt.close();			
		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
	}

	@Override
	public User get(String id) {
		User currentUser = null;
		try {
			/* Get user information by UserId*/
			st = con.createStatement();
			String sql = "SELECT * FROM user " + "WHERE UserId=" + id;
			ResultSet rs;
			rs = st.executeQuery(sql);
			while (rs.next()) {
				currentUser = new User(rs.getString("UserId"), rs.getString("Username"), rs.getString("EncryptedPassword"));
				currentUser.setLoggedIn(rs.getString("LoggedIn").contentEquals("1"));
				/* create function for finding all held books and turning them into a list */
				System.out.println(currentUser.toString());
			}
			rs.close();
			st.close();

		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
		return currentUser;
	}

	@Override
	public User getByUsername(String username) {
		/* Get user by username in database */
		User currentUser = null;
		try {
			st = con.createStatement();
			String sql = "SELECT * FROM user WHERE Username='"+username+"'";
			
			ResultSet re = st.executeQuery(sql);
			while(re.next()) {
			currentUser = new User(re.getString("UserId"), re.getString("Username"), re.getString("EncryptedPassword"));
			//System.out.println(currentUser);
			}
			re.close();
			st.close();
		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
		return currentUser;
	}

	@Override
	public Boolean checkPass(String username, String password) {
		/*
		 * check to see if this is a valid account and that the password is correct
		 */
		User currentUser = getByUsername(username);
		User trying = new User(username, password);
		if (currentUser != null && currentUser.getEncryptedPassword().equals(trying.getEncryptedPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public void update(User myData, String id) {
		try {
			/* update user information */
			st = con.createStatement();
			String sql="UPDATE user SET Username=?, EncryptedPassword=?,LoggedIn=? WHERE UserId="+id;
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, myData.getUsername());
			stmt.setString(2, myData.getEncryptedPassword());
			stmt.setString(3, myData.isLoggedIn()?"1":"0");
			stmt.executeUpdate();
			stmt.close();
			st.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
	}
	/*Functions that interact with the book dao*/
	@Override
	public Book[] getUsersHeldBooks(String uuid) {
		/* retrieve held books by user */
		return null;
	}
	private void returnBooks(String uuid) {
		/*Return books the deleted account checked out*/

	}

}
