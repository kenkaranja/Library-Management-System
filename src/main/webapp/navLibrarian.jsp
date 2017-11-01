<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Library Management System</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="LibrarianHomePage">Home</a></li>
                <li><a href="AddStudent">Add Student</a></li>
                <li><a href="AddBook">Add Book</a></li>
                <li><a href="IssueBook">Issue Book</a></li>
                <li><a href="ReturnBook">Return Book</a></li>
                <li><a href="LibrarianViewBook">View Books</a></li>
                <li><a href="LibrarianViewIssued">View Borrowed Books</a></li>
                <l><a href="LibrarianLogout">Logout</a></l>
                <li style="text-align: center; font-weight: bold; font-size: medium ">
                    Welcome <%session.getAttribute("Lusern");%></li>

            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->

</nav>
