<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/25/2017
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Add Librarian</title>
</head>
<body>
<form action="AddLibrarian" method="post">

    <table align="center">
        <th><h2>Add Librarian</h2></th>
        <tr>
            <td>Librarian No:</td>
            <td><input type="text" name="librarianno" required/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="librarianname" required/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email" required/></td>
        </tr>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" required/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" required/></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" value="Add Librarian"/></td>
        </tr>
    </table>
</form>
</body>
</html>
