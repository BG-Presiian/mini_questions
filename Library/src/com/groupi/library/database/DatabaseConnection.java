package com.groupi.library.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * This class is used and referenced in any DAO that performs operations
 * on the database, in order to establish a connection. For initializing tables,
 * see DatabaseInitializer.
 * @author Sarah Hansen
 *
 */
public class DatabaseConnection {
	
	// all database classes will require a connection to the database
	protected Connection con;
	
	public DatabaseConnection() throws SQLException, IOException {
		con = login();
	}
	
	private static Connection login() throws SQLException, IOException {
		// logins for server, using local machine
		// PUT THIS IN .config LATER!!
		DatabaseLogin dl = new DatabaseLogin();
		
		final String url = dl.getLoginValue("url");
		final String user = dl.getLoginValue("user");
		final String password = dl.getLoginValue("password"); 
				
		// establish connection
		Connection con = DriverManager.getConnection(url, user, password);	
		return con;
	}
	
	public void start() throws Exception {
		// Make sure you have the driver as a referenced library, or none of this will work!
		// register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = login();
		
		// status of attempt
		if (con == null) {
			System.out.println("JDBC connection not established.");
			return;
		} else {
			System.out.println("JDBC connection established successfully.");
		}
	}
	
	public void close() throws SQLException {
		this.con.close();
	}
	
}
