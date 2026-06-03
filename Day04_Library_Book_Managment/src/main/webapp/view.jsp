<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>

<style>
table{
    border-collapse: collapse;
    width: 70%;
    margin: auto;
}

th, td{
    padding: 10px;
    text-align: center;
}

th{
    background-color: black;
    color: white;
}

body{
    background-color: cyan;
}
</style>

</head>

<body>

<h2 style="text-align:center;">Book Management System</h2>

<table border="1">

<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Author</th>
    <th>Genre</th>
    <th>Price</th>
    <th>Availability</th>
    <th>Operation</th>
</tr>

<c:forEach var="book" items="${books}">

<tr>
    <td>${book.id}</td>
    <td>${book.title}</td>
    <td>${book.author}</td>
    <td>${book.genre}</td>
    <td>${book.price}</td>
    <td>${book.availability}</td>

    <td>
        <a href="edit/${book.id}">Edit</a>
        |
        <a href="delete/${book.id}">Delete</a>
    </td>
</tr>

</c:forEach>

</table>

</body>
</html>