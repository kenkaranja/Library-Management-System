<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/25/2017
  Time: 9:04 AM
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
    <title>Delete Book</title>
</head>
<body>
<form action="DeleteBook" method="post">

    <table align="center">
        <th><h2>Delete Book</h2></th>
        <tr>
            <td>BookId:</td>
            <td><input type="text" name="bookid" required/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Delete Book"/></td>
        </tr>
    </table>
</form>
</body>
</html>
