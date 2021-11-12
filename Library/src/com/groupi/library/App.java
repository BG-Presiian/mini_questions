package com.groupi.library;

import com.groupi.library.database.DatabaseConnection;
import com.groupi.library.database.DatabaseInitializer;

public class App {
	
	public static void main(String[] args) throws Exception {
		
		// just testing to make sure these work
		DatabaseConnection dc = new DatabaseConnection();
		DatabaseInitializer di = new DatabaseInitializer();
		dc.start();	
		di.makeTables();
		dc.close();
	}

}
