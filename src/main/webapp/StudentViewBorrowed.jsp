<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/26/2017
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="navStudent.jsp" %>
<html>
<head>
    <title>View Borrowed Books</title>
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
                <td>Issued Date</td>
                <td>Return Date</td>
                <td>Return Status</td>
                </thead>
            </tr>
            <c:forEach var="book" items="${booklist}">
                <tr>
                    <td><c:out value="${book.book.bookId}"></c:out></td>
                    <td><c:out value="${book.book.isbn}"></c:out></td>
                    <td><c:out value="${book.book.bookName}"></c:out></td>
                    <td><c:out value="${book.book.author}"></c:out></td>
                    <td><c:out value="${book.book.edition}"></c:out></td>
                    <td><c:out value="${book.book.category}"></c:out></td>
                    <td><c:out value="${book.issueDate}"></c:out></td>
                    <td><c:out value="${book.returnDate}"></c:out></td>
                    <td><c:out value="${book.returnStatus}"></c:out></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
