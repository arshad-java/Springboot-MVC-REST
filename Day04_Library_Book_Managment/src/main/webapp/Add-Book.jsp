<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
<center>
<form action="save" method="post">
<table>
  
  <tr>
    <td>Title</td><td> <input type="text" name="title"> </td>
  </tr>
  <tr>
    <td>Author</td><td> <input type="text" name="author"> </td>
  </tr>
  <tr>
    <td>Genre</td><td> <input type="text" name="genre"> </td>
  </tr>
  <tr>
    <td>Price</td><td> <input type="text" name="price"> </td>
  </tr>
  <tr>
    <td>Availability</td><td> <input type="text" name="availability"> </td>
  </tr>
  <tr>
    <td colspan="2"> <input type="submit" name="submit"> </td>
  </tr>
</table>
</form>
</center>
</body>
</html>