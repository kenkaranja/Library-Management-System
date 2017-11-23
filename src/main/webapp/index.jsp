<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/24/2017
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function validateLibrarian() {
            var username = document.form.username.value;
            var password = document.form.password.value;
            if (username == null || username == "") {
                alert("Username can't be blank");
                return false;
            }
            else if (password.length < 6) {
                alert("Password must be at least 6 characters long.");
                return false;
            }
        }
        function validateStudent() {
            var regno = document.form.regno.value;
            var password = document.form.password.value;
            if (regno == null || regno == "") {
                alert("Regno can't be blank");
                return false;
            }
            else if (password.length < 6) {
                alert("Password must be at least 6 characters long.");
                return false;
            }
        }
    </script>
</head>
<body>

<head>
    <title>Library Management System</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Library Management System</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Home</a></li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h2>Librarian Login</h2>
            <form action="LibrarianLogin" method="post" onsubmit="validateLibrarian()">
                <table align="center">
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" required/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" class="btn btn-default" value="Login"/></td>
                    </tr>
                    <tr>
                        <td>Not Register? <a href="AddLibrarian">Register</a></td>
                    </tr>
                </table>
            </form>
        </div>

        <div class="col-md-6">
            <h2>Student Login</h2>
            <form action="StudentLogin" method="post" onsubmit="validateStudent()">
                <table>
                    <tr>
                        <td>Student RegNo:</td>
                        <td><input type="text" name="regno" required/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" class="btn btn-default" value="Login"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>

<div class="container-fluid footer">
    <p>&copy;Copyright 2017. Kenneth Karanja</p>
</div>
</body>
</html>
