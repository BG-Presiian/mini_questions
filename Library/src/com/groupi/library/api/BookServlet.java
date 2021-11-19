package com.groupi.library.api;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.groupi.library.dao.BookDaoImpl;
import com.groupi.library.dto.Book;

public class BookServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestUrl = request.getRequestURI();
		String id = requestUrl.substring("/book/".length());

		// uses BookDaoImpl functions
		Book book = BookDaoImpl.getInstance(id);

		if (book != null) {
			String json = "{\n";
			json += "\"title\": " + JSONObject.quote(book.getTitle()) + ",\n";
			json += "\"author\": " + JSONObject.quote(book.getAuthor()) + ",\n";
			json += "\"publicationDate\": " + book.getPublicationDate() + "\n";
			json += "\"onHold\": " + book.isOnHold() + "\n";
			json += "\"onHold\": " + book.isLentOut() + "\n";
			json += "\"dueBack\": " + book.getDueBack() + "\n";
			json += "}";
			response.getOutputStream().println(json);
		} else {
			// return empty JSON object in case not found
			response.getOutputStream().println("{}");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String pubDate = request.getParameter("publicationDate");
		boolean onHold = Boolean.parseBoolean(request.getParameter("onHold"));
		boolean lentOut = Boolean.parseBoolean(request.getParameter("lentOut"));
		LocalDate dueBack = LocalDate.parse(request.getParameter("dueBack"));
		
		//put into db
	}

}
