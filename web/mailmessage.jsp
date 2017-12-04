<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="islogin.jsp" %> 
<jsp:useBean id="mail" class="employee.action.InternalMessageAction"/>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Employee Scheduler</title>

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
        <script src="js/MailScript.js" type="text/javascript"></script>
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
                                        <span class="pull-left">
                                            <img class="media-object" src="http://placehold.it/50x50" alt="">
                                        </span>
                                        <div class="media-body">
                                            <h5 class="media-heading"><strong><s:property value="username"/></strong>
                                            </h5>
                                            <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                            <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="message-preview">
                                <a href="#">
                                    <div class="media">
                                        <span class="pull-left">
                                            <img class="media-object" src="http://placehold.it/50x50" alt="">
                                        </span>
                                        <div class="media-body">
                                            <h5 class="media-heading"><strong><s:property value="username"/></strong>
                                            </h5>
                                            <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                            <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="message-preview">
                                <a href="#">
                                    <div class="media">
                                        <span class="pull-left">
                                            <img class="media-object" src="http://placehold.it/50x50" alt="">
                                        </span>
                                        <div class="media-body">
                                            <h5 class="media-heading"><strong><s:property value="username"/></strong>
                                            </h5>
                                            <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                            <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="message-footer">
                                <a href="#">Read All New Messages</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                        <ul class="dropdown-menu alert-dropdown">
                            <li>
                                <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                            </li>
                            <li>
                                <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                            </li>
                            <li>
                                <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                            </li>
                            <li>
                                <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                            </li>
                            <li>
                                <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                            </li>
                            <li>
                                <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">View All</a>
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
                        <li class="active">
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="getstafflist"><i class="fa fa-fw fa-table"></i> Staffs</a>
                        </li>
                        <li>
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
                                Mail Message
                            </h1>
                        </div>
                    </div>
                    <!-- /.row -->

                    <div class="row">
                        <div class="col-lg-6">
                            <%   String pass = null, mgusername = null, mgemail = null;
                                try {
                                    
                                } catch (Exception ee) {
                                }

                                if (pass != null) {%>                          
                            <div class="alert alert-info alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button> 
                                <i class="fa fa-info-circle"></i>  <strong>Success sending mail</strong>
                            </div>
                            <% session.removeAttribute("staffupdate");
                                }%>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-lg-6">
                            <h2>Send Message</h2>
                            <form role="form" action="sendobservermail" method="post" name="mailmessage" onsubmit="return validateMail()">
                                <br/>

                                <div class="form-group">
                                    <label>Multiple Selects</label>
                                    <select multiple class="form-control" name="multiselectemployee" id="multiselectemployee">

                                        <%
                                            for (int i = 0; i < mail.getUsernameList().size(); i++) {
                                                out.println("<option value = '" + mail.getEmailAddressList().get(i).toString() + "'>" + mail.getUsernameList().get(i).toString() + "</option>");
                                            }
                                        %>

                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>Select Employees</label>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="allstaffs" name="allstaffs">All Staffs
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="allmanagers" name="allmanagers">All Managers
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="nonmamager" name="nonmamager">Administator
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>Message</label>
                                    <textarea class="form-control" rows="3" name="message"></textarea>
                                </div>

                                <button type="submit" class="btn btn-default">Send Message</button>
                                <button type="reset" class="btn btn-default">Reset Message</button>

                            </form>

                        </div>
                        <div class="row">

                            <h2>View Messages</h2>
                            <br/>
                            <div class="col-lg-6">
                                <div class="table-responsive">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>From</th>
                                                <th>Message</th>
                                                <th>Reply</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="internalArrayList">  
                                            <fieldset> 
                                                <tr>
                                                    <th><s:property value="tousername"/></th>
                                                    <th><s:property value="message"/></th>
                                                    <th> 

                                                        <button class="btn btn-sm btn-primary btn-block" value="<s:property value="message"/> ">Reply</button>
                                                    </th>
                                                    <th></th>
                                                </tr>
                                            </fieldset>  
                                        </s:iterator> 

                                        </tbody>
                                    </table>
                                </div>
                            </div>


                        </div>
                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap-datepicker.js" type="text/javascript"></script>
        <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {

                $('#dob').datepicker({
                    format: "dd/mm/yyyy"
                });

            });

            $(document).ready(function () {

                $('#hiredate').datepicker({
                    format: "dd/mm/yyyy"
                });

            });
        </script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
        <link href="css/datepicker.css" rel="stylesheet" type="text/css"/>
    </body>

</html>
