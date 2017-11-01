<nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Library Management System</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li class="active"><a href="StudentHomePage">Home</a></li>
            <li><a href="StudentViewBook">ViewBook</a></li>
            <li><a href="StudentViewBorrowed">View Borrowed Book</a></li>
            <li><a href="StudentLogout">Logout</a></li>
            <li style="text-align: center; font-weight: bold; font-size: medium ">
                Welcome <%session.getAttribute("Susern");%></li>
            <li>
        </ul>
        <div class="col-sm-3 col-md-3 pull-right">
            <form class="navbar-form" role="search" method="post" action="SearchBookByName">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Book Name" name="bName">
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</nav>