package com.crud;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.apphosting.api.DatastorePb.GetResponse.Entity;

/**
 * Servlet implementation class Read
 */
@WebServlet("/readserv")
public class Read extends HttpServlet {
	DatastoreService datastore;
	Query q = new Query("Book");

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		datastore = DatastoreServiceFactory.getDatastoreService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Filter filterbyname = new FilterPredicate("BookName", FilterOperator.EQUAL, request.getParameter("bookname"));

		q = q.setFilter(filterbyname);
		PreparedQuery pq = datastore.prepare(q);

		List<com.google.appengine.api.datastore.Entity> results = pq.asList(FetchOptions.Builder.withLimit(2));
		if (!results.isEmpty()) {
			com.google.appengine.api.datastore.Entity book = results.get(0);

			request.setAttribute("status", "");
			request.setAttribute("bookname", book.getProperty("BookName"));
			request.setAttribute("bookauthor", book.getProperty("BookAuthor"));
			request.setAttribute("bookpages", book.getProperty("BookPages"));
			request.setAttribute("bookgenre", book.getProperty("BookGenre"));
			
			request.getRequestDispatcher("/readbook.jsp").forward(request, response);
		}
		
		else {
			response.getWriter().println("Item not found");
			request.getRequestDispatcher("/readbook.jsp").forward(request, response);
		}

	}

}
