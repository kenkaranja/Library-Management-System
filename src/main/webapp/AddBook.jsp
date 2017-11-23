<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/23/2017
  Time: 10:17 AM
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
    <title>Add-Book</title>
</head>
<body>
<form action="AddBook" method="post" enctype="multipart/form-data">
    <table align="center">
        <th><h2>Add Book</h2></th>
        <tr>
            <td>BookId:</td>
            <td><input type="text" name="bookid" required/></td>
        </tr>
        <tr>
            <td>ISBN:</td>
            <td><input type="text" name="isbn" required/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="bname" required/></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><input type="text" name="author" required/></td>
        </tr>
        <tr>
            <td>Edition:</td>
            <td><input type="text" name="edition" required/></td>
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
            <td><input type="text" name="shelfno" required/></td>
        </tr>
        <tr>
            <td>Row:</td>
            <td><input type="text" name="row" required/></td>
        </tr>
        <tr>
            <td>Column:</td>
            <td><input type="text" name="column" required/></td>
        </tr>
        <tr>
            <td>Added Date:</td>
            <td><input type="date" name="addeddate" required/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" required/></td>
        </tr>
        <tr>
            <td>Book Image:</td>
            <td><input type="file" name="photo" size="50"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Add Book"/></td>
        </tr>
    </table>
</form>
</body>
</html>
