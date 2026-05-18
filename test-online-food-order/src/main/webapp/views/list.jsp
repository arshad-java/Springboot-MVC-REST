<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Food List</title>
</head>
<body>

<h2>Order Table</h2>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Item Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Operation</th>
        
    </tr>

    <c:forEach var="o" items="${orders}">
        <tr>
            <td>${o.name}</td>
            <td>${o.itemName}</td>
            <td>${o.quantity}</td>
            <td>${o.price}</td>
            <td><a href="update/${o.id}">edit</a><a href="delete/${o.id}">delete</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>