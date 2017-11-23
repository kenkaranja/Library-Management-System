<%--
  Created by IntelliJ IDEA.
  User: machine learning
  Date: 11/3/2017
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navLibrarian.jsp" %>
<html>
<head>
    <title>Pay Debt</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form action="StudentPayDebt" method="post">
    <table align="center">
        <th><h2>Pay Debt</h2></th>
        <tr>
            <td>Amount Paid</td>
            <td><input type="number" name="amount" required/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Pay"/></td>
        </tr>
    </table>
</form>
</body>
</html>
