<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/25/2017
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="navLibrarian.jsp" %>
<html>
<head>
    <title>ViewBooks</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="jumbotron">
        <table class="table table-bordered" align="center">
            <tr>
                <thead>
                <td>BookNo</td>
                <td>ISBN</td>
                <td>Name</td>
                <td>Author</td>
                <td>Edition</td>
                <td>Category</td>
                <td>ShelfNo</td>
                <td>Row No</td>
                <td>Column No</td>
                <td>Available</td>
                <td>Price</td>
                <td>Date Added</td>
                <td>Action</td>
                <td>Action</td>
                </thead>
            </tr>
            <c:forEach var="book" items="${booklist}">
                <tr>
                    <td><c:out value="${book.bookId}"></c:out></td>
                    <td><c:out value="${book.isbn}"></c:out></td>
                    <td><c:out value="${book.bookName}"></c:out></td>
                    <td><c:out value="${book.author}"></c:out></td>
                    <td><c:out value="${book.edition}"></c:out></td>
                    <td><c:out value="${book.category}"></c:out></td>
                    <td><c:out value="${book.shelfNo}"></c:out></td>
                    <td><c:out value="${book.rowNo}"></c:out></td>
                    <td><c:out value="${book.columNo}"></c:out></td>
                    <td><c:out value="${book.available}"></c:out></td>
                    <td><c:out value="${book.price}"></c:out></td>
                    <td><c:out value="${book.addedDate}"></c:out></td>
                    <form action="DeleteBook" method="post">
                        <input type="hidden" name="bookId" value="${book.bookId}">
                        <td><input type="submit" value="Delete"></td>
                    </form>
                    <form action="UpdateBook" method="post">
                        <input type="hidden" name="bookId" value="${book.bookId}">
                        <td><input type="submit" value="Edit"></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<img src="images/HP-PC%20-%20IMG_20160529_132554.jpg" alt="image">
</body>
</html>
