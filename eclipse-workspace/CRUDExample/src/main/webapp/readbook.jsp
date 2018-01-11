<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Read - Book</title>
</head>
<body>
<h2>Read - Book</h2>

<br>
<form action="readserv" method = "get">
Enter the bookname : <input type = "text" name = "bookname">
<button type = "submit">Search and display</button>
<p> OR </p><a href = "/createbook.jsp">Create?</a>
<%

String name;
String author;
String pages;
String genre;

if(request.getAttribute("status") != null){
	name = (String)request.getAttribute("bookname");
	author = (String)request.getAttribute("bookauthor");
	pages = (String)request.getAttribute("bookpages");
	genre = (String)request.getAttribute("bookgenre");
%>
<br>
<h3>Results</h3>
<table>
<tr><th>Attribute</th><th>Value</th></tr>
<tr><td>Bookname</td><td><%= name %></td></tr>
<tr><td>Bookauthor</td><td><%= author %></td></tr>
<tr><td>Bookpages</td><td><%= pages %></td></tr>
<tr><td>Bookgenre</td><td><%= genre %></td></tr>
</table>
<% } %>

</form>
</body>
</html>