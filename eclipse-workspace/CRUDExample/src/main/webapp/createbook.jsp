<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Createbook</title>
</head>
<body>
<h3>Create - Book</h3><br>
<form action="createserv" method = "get">
<input type = "text" name = "bookname" placeholder = "bookname"><br>
<input type = "text" name = "bookauthor" placeholder = "bookauthor"><br>
<input type = "text" name = "bookpages" placeholder = "bookpages"><br>
<input type = "text" name = "bookgenre" placeholder = "bookgenre"><br>
<button type = "submit">Create Book</button>
</form>
</body>
</html>