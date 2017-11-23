<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/25/2017
  Time: 5:48 PM
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
                <td>Book Name</td>
                <td>Student Name</td>
                <td>Student RegNo</td>
                <td>Issued Date</td>
                <td>Return Date</td>
                <td>Today Date</td>
                <td>Late</td>
                <td>LateFee</td>
                <td>Amount Paid</td>
                <td>Paid</td>
                <td>

                </thead>
            </tr>
            <c:forEach var="returnBook" items="${debtList}">
                <tr>
                    <td><c:out value="${returnBook.issuedBook.book.bookId}"></c:out></td>
                    <td><c:out value="${returnBook.issuedBook.book.bookName}"></c:out></td>
                    <td><c:out value="${returnBook.issuedBook.student.name}"></c:out></td>
                    <td><c:out value="${returnBook.issuedBook.student.regNo}"></c:out></td>
                    <td><c:out value="${returnBook.issuedBook.issueDate}"></c:out></td>
                    <td><c:out value="${returnBook.issuedBook.returnDate}"></c:out></td>
                    <td><c:out value="${returnBook.todayDate}"></c:out></td>
                    <td><c:out value="${returnBook.late}"></c:out></td>
                    <td><c:out value="${returnBook.lateFee}"></c:out></td>
                    <td><c:out value="${returnBook.amountPaid}"></c:out></td>
                    <td><c:out value="${returnBook.paid}"></c:out></td>
                    <form action="StudentPayDebt" method="get">
                        <input type="hidden" name="regno" value="${returnBook.issuedBook.student.regNo}">
                        <input type="hidden" name="bookId" value="${returnBook.issuedBook.book.bookId}">
                        <input type="hidden" name="amount" value="${returnBook.amountPaid}">
                        <td><input type="submit" value="Pay"></td>
                    </form>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
<a href="LibrarianHomePage">Home</a>
</body>
</html>
