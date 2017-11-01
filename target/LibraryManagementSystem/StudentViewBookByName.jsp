<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/25/2017
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="navStudent.jsp" %>
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
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
