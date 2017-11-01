<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/24/2017
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navLibrarian.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Add Student</title>
</head>
<body>
<form action="AddStudent" method="post">
    <table align="center">
        <th><h2>Add Student</h2></th>
        <tr>
            <td>Student RegNo:</td>
            <td><input type="text" name="studentregno" required/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="studentname" required/></td>
        </tr>
        <tr>
            <td>Year of Study:</td>
            <td><input type="text" name="year" required/></td>
        </tr>
        <tr>
            <td>Department:</td>
            <td><input type="text" name="department" required/></td>
        </tr>
        <tr>
            <td>Contact:</td>
            <td><input type="text" name="contact" required/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" required/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" required/></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" value="Add Student"/></td>
        </tr>
    </table>
</form>
</body>
</html>
