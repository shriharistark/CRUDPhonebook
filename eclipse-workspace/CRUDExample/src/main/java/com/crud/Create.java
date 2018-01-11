package com.crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreFailureException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@WebServlet(
    name = "CreateBook",
    urlPatterns = {"/createserv"}
)
public class Create extends HttpServlet {

DatastoreService datastore;
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
      
	  String name = request.getParameter("bookname");
	  String author = request.getParameter("bookauthor");
	  String pages = request.getParameter("bookpages");
	  String genre = request.getParameter("bookgenre");
	  
	  Entity book = new Entity("Book");
	  book.setProperty("BookName",name);
	  book.setProperty("BookAuthor", author);
	  book.setProperty("BookPages", pages);
	  book.setProperty("BookGenre", genre);
	  
	  try {
	  datastore.put(book);
	  }catch(DatastoreFailureException ds) {
		  System.out.println("Data add fail!");
	  }finally {
		  response.sendRedirect("/index.html");
	  }

  }
  
  @Override
  public void init() throws ServletException{
	  datastore = DatastoreServiceFactory.getDatastoreService();
  }
}