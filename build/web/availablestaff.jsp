<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="islogin.jsp" %> 

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Employee Scheduler</title>

        <script src="js/validatepassword.js" type="text/javascript"></script>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">


        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


        <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

        <link href="kendo/default.css" rel="stylesheet" type="text/css"/>
        <link href="kendo/kendo.common.min.css" rel="stylesheet" type="text/css"/>
        <script src="kendo/kendo.all.min.js" type="text/javascript"></script>


    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index">Employee Scheduler</a>
                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                        <ul class="dropdown-menu message-dropdown">
                            <li class="message-preview">
                                <a href="#">
                                    <div class="media">
                                        <div class="media-body">
                                            <h5 class="media-heading"><strong><s:property value="username"/></strong>
                                            </h5>
                                        </div>
                                    </div>
                                </a>
                            </li>

                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>${sessionScope.username} <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="logoff"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="index"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="mailmessage"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="getstafflist"><i class="fa fa-fw fa-table"></i> Staffs</a>
                        </li>
                        <li class="active">
                            <a href="availability"><i class="fa fa-fw fa-edit"></i> Availability</a>
                        </li>
                        <li>
                            <a href="password.jsp"><i class="fa fa-fw fa-desktop"></i> Password</a>
                        </li>
                        <li>
                            <a href="reporter"><i class="fa fa-fw fa-wrench"></i> Reports</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>


            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Availability
                            </h1>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12">      

                            <div class="col-lg-8">
                                <h3>Time zone</h3>
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>Days</th>
                                                <th>Capacity</th>
                                                <th>Time From</th>
                                                <th>Time To</th>
                                                <th>Availability</th>
                                                <th>Register</th>
                                                <th>UnRegister</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <s:iterator value="returndayworkschedule">  
                                            <fieldset> 
                                                <tr>
                                                    <th><s:property value="days"/></th>
                                                    <th><s:property value="capacity"/></th>
                                                    <th><s:property value="timespanfrom"/></th>
                                                    <th><s:property value="timespanto"/></th>
                                                    <th><s:property value="avail"/></th>


                                                    <th> 

                                                        <s:if test='%{unregisavail==0}'>
                                                            <s:if test='%{capacity>avail}'>
                                                                <a href=updatestaff?idd=<s:property value="id"/> > Register </a>
                                                            </s:if>
                                                        </s:if>
                                                        
                                                        <s:if test='%{capacity>avail}'>
                                                             
                                                        </s:if>
                                                                
                                                    </th>
                                                    <th> <a href=unupdatestaff?idd=<s:property value="id"/> > Unregister </a></th>
                                                </tr>
                                            </fieldset>  
                                        </s:iterator> 

                                        </tbody>
                                    </table>
                                </div>
                            </div>


                        </div>




                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- /#page-wrapper -->

            </div>
            <!-- /#wrapper -->

            <!-- Bootstrap Core JavaScript -->
            <script src="js/bootstrap.min.js"></script>    
    </body>

</html>
