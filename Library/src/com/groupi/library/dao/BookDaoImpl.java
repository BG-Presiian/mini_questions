package com.groupi.library.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.groupi.library.database.DatabaseConnection;
import com.groupi.library.database.DatabaseInitializer;
import com.groupi.library.dto.Book;

/**
 * Handles transactions dealing with books in the database.
 * 
 * @author Sarah Hansen & Presiian Iskrenov
 *
 */
public class BookDaoImpl extends DatabaseInitializer implements BookDao {

	private DatabaseConnection dc;
	
	//trying to figure out a way to store the objects so that they are retrievable as objects
	public static List<Book> DataBaseObjects = new ArrayList<Book>();
	private Statement st;

	public BookDaoImpl() throws Exception {
		this.dc = new DatabaseConnection();
	}

	@Override
	public void create(Book myData) {
		// TODO Auto-generated method stub

		try {

			st = con.createStatement();

			String sql = "INSERT INTO book VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			// There are ways to do this with less code but this was the most readable
			/* Inserts values into table starting from 1 */
			stmt.setString(1, null);
			stmt.setString(2, myData.getTitle());
			stmt.setString(3, myData.getAuthor());
			stmt.setDate(4, java.sql.Date.valueOf(myData.getPublicationDate()));
			stmt.setBoolean(5, myData.isOnHold());
			stmt.setBoolean(6, myData.isLentOut());
			stmt.setDate(7, java.sql.Date.valueOf(myData.getDueBack()));
			stmt.setInt(8, myData.getUID());
			stmt.executeUpdate();
			
			//DataBaseObjects.add(myData);
			stmt.close();

			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		try {
			st = con.createStatement();
			String sql = "DELETE FROM book " + "WHERE BookId=" + id;
			st.executeUpdate(sql);
			DataBaseObjects.remove(this);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Book myData, String location) {
		// TODO Auto-generated method stub
		try {
			st = con.createStatement();
			
			String sql = "UPDATE book SET Title= ?, Author=?, PublicationDate=?,OnHold=?, LentOut=?, DueBack=?, UniqueId=? WHERE BookId=" + location;
			PreparedStatement stmt = con.prepareStatement(sql);
			
			
			stmt.setString(1, myData.getTitle());
			stmt.setString(2, myData.getAuthor());
			stmt.setDate(3, java.sql.Date.valueOf(myData.getPublicationDate()));
			stmt.setBoolean(4, myData.isOnHold());
			stmt.setBoolean(5, myData.isLentOut());
			stmt.setDate(6, java.sql.Date.valueOf(myData.getDueBack()));
			stmt.setInt(7, myData.getUID());
			stmt.executeUpdate();
			stmt.close();

			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Book get(String id) {

		Book boo = null;
		try {

			st = con.createStatement();

			// Select which row to parse through
			String sql = "SELECT * FROM book " + "WHERE BookId=" + id;
			ResultSet rs;
			rs = st.executeQuery(sql);
			// Parse through the row in the table
			while (rs.next()) {
				// Gets the corresponding values within the table
				boo = new Book(id, rs.getString(2), rs.getString(3), rs.getObject(4, LocalDate.class), rs.getBoolean(5),
						rs.getBoolean(6), rs.getObject(7, LocalDate.class), rs.getInt(8));
				System.out.println(boo.toString());
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boo;
	}

	
	/**
	 * Arraylists below are currently not working as intended.
	 */
	@Override
	public ArrayList<Book> getByTitle(String title) {
		// TODO Auto-generated method stub
		Book boo = null;
		List<Book> getTitles = new ArrayList<Book>();
		try {

			st = con.createStatement();
			
			// Select which row to parse through
			String sql = "SELECT * FROM book " + "WHERE Title=" +title ;
			
			ResultSet rs;
			rs = st.executeQuery(sql);
			// Parse through the row in the table
			while (rs.next()) {
				
				//getTitles.add(boo)
				//getTitles.add((Book) rs.getObject(sql));
				System.out.println(getTitles);
				// Gets the corresponding values within the table
				//boo = new Book(id, rs.getString(2), rs.getString(3), rs.getObject(4, LocalDate.class), rs.getBoolean(5),
						//rs.getBoolean(6), rs.getObject(7, LocalDate.class), rs.getInt(8));
				System.out.println(boo.toString());
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Book> getByAuthor(String author) {
		Book boo = null;
		List<Book> getBooksByAuthor = new ArrayList<Book>();
		try {

			st = con.createStatement();

			// Select which row to parse through
			String sql = "SELECT * FROM book " + "WHERE Author=" + author ;
			ResultSet rs;
			rs = st.executeQuery(sql);
			// Parse through the row in the table
			while (rs.next()) {
				// Gets the corresponding values within the table
				//boo = new Book(id, rs.getString(2), rs.getString(3), rs.getObject(4, LocalDate.class), rs.getBoolean(5),
					//	rs.getBoolean(6), rs.getObject(7, LocalDate.class), rs.getInt(8));
				System.out.println(boo.toString());
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Book> getByPublicationDate(LocalDate publicationDate) {
		Book boo = null;
		List<Book> getByPubDate = new ArrayList<Book>();
		try {

			st = con.createStatement();

			// Select which row to parse through
			String sql = "SELECT * FROM book " + "WHERE BookId=" ;
			ResultSet rs;
			rs = st.executeQuery(sql);
			// Parse through the row in the table
			while (rs.next()) {
				// Gets the corresponding values within the table
				//boo = new Book(id, rs.getString(2), rs.getString(3), rs.getObject(4, LocalDate.class), rs.getBoolean(5),
					//	rs.getBoolean(6), rs.getObject(7, LocalDate.class), rs.getInt(8));
				System.out.println(boo.toString());
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Book> getOnHold() {
		Book boo = null;
		List<Book> getAllOnHold = new ArrayList<Book>();
		try {

			st = con.createStatement();

			// Select which row to parse through
			String sql = "SELECT * FROM book " + "WHERE BookId=" ;
			ResultSet rs;
			rs = st.executeQuery(sql);
			// Parse through the row in the table
			while (rs.next()) {
				// Gets the corresponding values within the table
				//boo = new Book(id, rs.getString(2), rs.getString(3), rs.getObject(4, LocalDate.class), rs.getBoolean(5),
					//	rs.getBoolean(6), rs.getObject(7, LocalDate.class), rs.getInt(8));
				System.out.println(boo.toString());
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public static Book getInstance(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
