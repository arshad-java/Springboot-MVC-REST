package com.mvc.task;

/*
 Spring MVC Task 2 — Employee Salary Evaluation System

Objective:

To demonstrate form submission with multiple numeric fields,
use of @RequestParam to fetch input data,
and display calculated results using JSP.

Task Requirements:
1️.Create a Spring MVC Project

Standard structure:

com.example.employeemvc
 ┣ controller
 ┣ model
 ┗ webapp/WEB-INF/views

2️.Create a Model Class — Employee

Fields:

empId → int

empName → String

basic → double

hra → double

da → double

bonus → double

grossSalary → double

Purpose: To represent employee and salary structure.

3️.Create a Controller Class — EmployeeController

Responsibilities:

Display salary input form (/salaryForm)

Read data using @RequestParam

Calculate grossSalary = basic + hra + da + bonus

Pass computed data to result page using Model

4️.Create JSP Pages

Page 1 — salary-form.jsp
→ Input fields for all salary components.

Page 2 — salary-result.jsp
→ Display breakdown of components and total salary:
5️. Configuration (dispatcher-servlet.xml)

Include:

Component scanning for controllers

View resolver configuration

Expected Flow:
--------------
1️.Access /salaryForm.
2️. Enter employee salary details and submit.
3️. Controller computes total salary.
4️. JSP displays:

Employee info

Salary component list (looped via <c:forEach>)

Gross salary

Expected Output:
-----------------
Employee Name: Bob
Salary Components:
 - Basic: ₹25000
 - HRA: ₹5000
 - DA: ₹3000
 - Bonus: ₹2000
Total Salary: ₹35000
 */