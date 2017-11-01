<%@ page import="Entities.Book" %><%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/30/2017
  Time: 7:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="navLibrarian.jsp" %>
<html>
<head>
    <title>Title</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form action="UpdatingBook" method="post">
    <table align="center">
        <th><h2>Update Book</h2></th>
        <tr>
            <td>BookId:</td>
            <td><input type="text" name="bookid" value="<%=session.getAttribute("bookId")%>" required/></td>
        </tr>
        <tr>
            <td>ISBN:</td>
            <td><input type="text" name="isbn" value="<%=session.getAttribute("isbn")%>" required/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="bname" value="<%=session.getAttribute("bname")%>" required/></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><input type="text" name="author" value="<%=session.getAttribute("author")%>" required/></td>
        </tr>
        <tr>
            <td>Edition:</td>
            <td><input type="text" name="edition" value="<%=session.getAttribute("edition")%>" required/></td>
        </tr>
        <tr>
            <td>Category:</td>
            <td>
                <select name="category">
                    <option>English</option>
                    <option>Math</option>
                    <option>Kiswahili</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Shelf Number:</td>
            <td><input type="text" name="shelfno" value="<%=session.getAttribute("shelfNo")%>" required/></td>
        </tr>
        <tr>
            <td>Row:</td>
            <td><input type="text" name="row" value="<%=session.getAttribute("row")%>" required/></td>
        </tr>
        <tr>
            <td>Column:</td>
            <td><input type="text" name="column" value="<%=session.getAttribute("colum")%>" required/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Update Book"/></td>
        </tr>
    </table>

</form>
</body>
</html>
