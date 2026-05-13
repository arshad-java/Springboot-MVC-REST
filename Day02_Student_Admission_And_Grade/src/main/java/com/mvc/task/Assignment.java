package com.mvc.task;

/*
 Spring MVC Task 1 — Student Admission and Grade Evaluation System

Objective:

To demonstrate how Spring MVC handles form submission and data binding using @RequestParam,
and how to display calculated results dynamically using JSP.

Task Requirements:
1️.Create a Spring MVC Project
Follow standard MVC structure:

com.example.studentmvc
 ┣ controller
 ┣ model
 ┗ webapp
    ┗ WEB-INF
       ┗ views

2️.Create a Model Class — Student

Fields:

name → String

rollNo → int

marks1, marks2, marks3 → int

Purpose: To hold user input and represent student data.

3️.Create a Controller Class — StudentController

Responsibilities:

Display the admission form (GET method)

Process submitted form data using @RequestParam

Compute total marks, percentage, and grade

Add all calculated values to Model

Forward to JSP for display

4️.Create JSP Pages

Page 1 — admission-form.jsp
→ Form with text fields for student details and marks.

Page 2 — admission-success.jsp
→ Displays total, percentage, and grade dynamically.
5️.Spring Configuration (dispatcher-servlet.xml)

Configure:

Component scanning for controller package

InternalResourceViewResolver with prefix /WEB-INF/views/ and suffix .jsp

Expected Flow:
--------------
1️.User accesses /admissionForm to open the form.
2️.Enters student details and marks.
3️.On submit, Spring MVC captures form data using @RequestParam.
4️.Controller computes:

Total = marks1 + marks2 + marks3

Percentage = total / 3

Grade (A/B/C/Fail) based on percentage
5️.Result JSP displays student info and calculated results.

Expected Output:
-----------------
--- Student Admission Result ---
Name: Alice
Roll No: 101
Total Marks: 245
Percentage: 81.67%
Grade: Excellent
 
  
 * */
 