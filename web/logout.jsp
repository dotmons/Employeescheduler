<link href="css/login.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>


<div class = "container">
    <div class="wrapper">

        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Logoff!</strong> You have been logged out of the system, Please do login to continue!!
        </div>


        <form action="islogin" class="form-signin" method="post"> 

            <h3 class="form-signin-heading">Welcome to Employee Scheduler<br/> Please Sign In</h3>
            <hr class="colorgraph"><br>

            <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus="" />
            <input type="password" class="form-control" name="password" placeholder="Password" required=""/>     		  

            <button class="btn btn-lg btn-primary btn-block" value="Login">Login</button>  			
        </form>			
    </div>
</div>