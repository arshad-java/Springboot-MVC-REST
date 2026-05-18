<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>UPdate</h1>
<form action="${pageContext.request.contextPath}/upsave" method="post">
<input type="hidden" name="id" value="${f.id}"><br>
Name : <input type="text" name="name" value="${f.name}"><br>
item name : <input type="text" name="iname" value="${f.itemName}"><br>
quntity : <input type="text" name="qty" value="${f.quantity}"><br>
price : <input type="text" name="price" value="${f.price}"><br>
<input type="submit" ><br>
</form>

</body>
</html>