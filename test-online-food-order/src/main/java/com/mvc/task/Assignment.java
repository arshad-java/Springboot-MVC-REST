package com.mvc.task;
/*
Project:: Online Food Delivery System

=================================================================================================

Description:
------------
The Online Food Delivery System is a Spring Boot MVC web application designed to manage customer food orders through a browser-based interface. 
The system allows users to place new orders, view all existing orders, update order details, and delete orders. 
It also calculates the total bill amount dynamically and applies discounts based on predefined business rules. 
The application follows a layered architecture and uses Spring Data JPA for database interaction, reducing the need for manual SQL queries.

The application uses a database table named FoodOrder, which contains the following fields: 
orderId (primary key), customerName, itemName, quantity, price, and totalAmount. 
A corresponding FoodOrder entity class is created using JPA annotations such as @Entity, @Id, and @GeneratedValue. 
The class includes all fields along with appropriate getters and setters to bind form data in the MVC flow.

The Repository layer replaces the traditional DAO layer and consists of an interface named FoodOrderRepository, 
which extends JpaRepository<FoodOrder, Integer>. This provides built-in methods such as save(), findAll(), findById(), and deleteById(), 
eliminating the need for manual implementation.

The Service layer includes an interface IFoodOrderService with methods like addOrder(), viewOrders(), deleteOrder(), getOrderById(), 
and updateOrder(). This layer contains the business logic of the application. The totalAmount is calculated as quantity multiplied by price, 
and a 10% discount is applied if the totalAmount exceeds 1000. The system also validates that the quantity is greater than zero before processing any order.

The Controller layer, implemented in the FoodOrderController class, handles HTTP requests using Spring MVC annotations such as @Controller, 
@GetMapping, and @PostMapping. It interacts with the service layer to process user actions and returns appropriate view pages.

The View layer is developed using JSP or Thymeleaf templates. It includes pages such as add-order form, view-orders list, update-order form, 
and confirmation pages. Data is passed between controller and view using the Model object.

The application is configured using application.properties, where database connection details such as URL, username, password, 
and JPA properties (like Hibernate dialect and ddl-auto) are defined. Spring Boot automatically manages the DataSource and ORM layer.

Finally, the application runs as a Spring Boot web application and can be accessed through a browser. 
Users can perform operations like adding, viewing, updating, and deleting food orders using web forms, 
making the system more interactive and user-friendly.*/