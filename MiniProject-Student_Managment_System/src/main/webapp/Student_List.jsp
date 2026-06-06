<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<body>

<h2>User List</h2>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Actions</th>
        <th>Actions</th>
    </tr>


    <tr th:each="user : ${users}">
    <th>${user.id}</th>

        <td th:text="${user}"></td>
        <td th:text="">${user.name}</td>

        <td>
            <!-- Edit Button -->
            <a th:href="">Edit</a>

            <!-- Delete Button -->
            <a th:href=""
               onclick="return confirm('Are you sure?')">
               Delete
            </a>
        </td>

    </tr>

</table>

</body>
</html>