


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
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
        <script>
            function isNumber(evt) {

                evt = (evt) ? evt : window.event;
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                if (charCode > 31 && (charCode < 48 || charCode > 57)) {
                    alert('Can only contain number values');
                    return false;
                } else if (charCode.length > 9)
                {
                    alert('Invalid value');
                    return false;
                }
                return true;
            }
        </script>

        <script src="js/generalscript.js" type="text/javascript"></script>
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
                        <li>
                            <a href="mailmessage"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li class="active">
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
                                Staff details
                            </h1>
                        </div>
                    </div>
                    <!-- /.row -->

                    <div class="row">
                        <div class="col-lg-6">
                            <%   String pass = null, mgusername = null, mgemail = null;
                                try {
                                    pass = session.getAttribute("staffupdate").toString();
                                } catch (Exception ee) {
                                }

                                try {
                                    mgusername = session.getAttribute("ManagerActionUsername").toString();
                                } catch (Exception ee) {

                                }

                                try {
                                    mgemail = session.getAttribute("ManagerActionEmailaddress").toString();
                                } catch (Exception ee) {
                                }

                                if (pass != null) {%>                          
                            <div class="alert alert-info alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button> 
                                <i class="fa fa-info-circle"></i>  <strong>Success creating new staff detail!!!</strong>
                            </div>
                            <% session.removeAttribute("staffupdate");
                            } else if (mgusername != null) {%>                          
                            <div class="alert alert-info alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button> 
                                <i class="fa fa-info-circle"></i>  <strong>Username already exist!!!</strong>
                            </div>
                            <% session.removeAttribute("ManagerActionUsername");
                            } else if (mgemail != null) {%>                          
                            <div class="alert alert-info alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button> 
                                <i class="fa fa-info-circle"></i>  <strong>Email address already exist!!!</strong>
                            </div>
                            <% session.removeAttribute("ManagerActionEmailaddress");
                                }
                            %>



                        </div>
                    </div>


                    <div class="row">
                        <div class="col-lg-6">
                            <h2>Add new employee</h2>
                            <form role="form" action="createnewmanager" method="post" name="mystaff" onsubmit="return validateForm()">
                                <br/>
                                <div class="form-group input-group">
                                    <span class="input-group-addon">@</span>
                                    <input type="text" class="form-control" placeholder="Username" name="username">
                                </div>

                                <div class="form-group">
                                    <input class="form-control" placeholder="Firstname" name="firstname">
                                </div>

                                <div class="form-group">
                                    <input class="form-control" placeholder="Lastname" name="lastname">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Emailaddress" name="emailaddress">
                                </div>
                                <div class="form-group">        
                                    <input class="form-control" type="text" placeholder="Date of birth" name="dob" id="dob" readonly/>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Hiredate" name="hiredate" id="hiredate" readonly />
                                </div>

                                <div class="form-group">
                                    <input class="form-control" placeholder="Sinno" name="sinno" onkeypress="return isNumber(event)">
                                </div>

                                <div class="form-group">
                                    <label>Gender</label>
                                    <select class="form-control" name="gender">
                                        <option>Male</option>
                                        <option>Female</option>
                                    </select>
                                </div>


                                <div class="form-group">
                                    <label>Employee Status</label>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="managerradio" id="managerradio" value="Manager" checked>Manager
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="managerradio" id="managerradio" value="Non Manager">Non Manager
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>About staff</label>
                                    <textarea class="form-control" rows="3" name="aboutstaff"></textarea>
                                </div>

                                <button type="submit" class="btn btn-default">Submit Button</button>
                                <button type="reset" class="btn btn-default">Reset Button</button>

                            </form>

                        </div>
                        <div class="row">

                            <h2>List of Employees</h2>
                            <br/>
                            <div class="col-lg-6">
                                <div class="table-responsive">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>Username</th>
                                                <th>Firstname</th>
                                                <th>Lastname</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="arrlistmanager">  
                                            <fieldset> 
                                                <tr>
                                                    <th><s:property value="username"/></th>                                                    
                                                    <th><s:property value="firstname"/></th>
                                                    <th><s:property value="lastname"/></th>
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
