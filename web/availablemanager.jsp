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
                        <div class="col-lg-6">                            
                            <form role="form" name="availablecapacity"  method="post" onsubmit="return validatePassword(this)">
                                <h3>Update Working Days</h3>
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <label><b>Day</b></label>                                        
                                        <br/>                     
                                        <div class="form-group">                                           
                                            <select class="form-control" name="dayy" id="dayy">
                                                <option value="Monday">Monday</option>
                                                <option value="Tuesday">Tuesday</option>
                                                <option value="Wednesday">Wednesday</option>
                                                <option value="Thursday">Thursday</option>
                                                <option value="Friday">Friday</option>
                                                <option value="Saturday">Saturday</option>
                                                <option value="Sunday">Sunday</option>
                                            </select>
                                            <br/><br/>

                                            <label>Capacity</label> <input class="form-control" name="capacitty" id="capacitty">
                                            <br/><br/>
                                            <button type="submit" class="btn btn-default">Update Record</button>
                                            <br/><br/>
                                        </div>
                                    </li>
                                </ul>
                            </form>
                        </div>

                        <div class="col-lg-6">
                            <h3>Capacity</h3>
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                        <tr>
                                            <th>Days</th>
                                            <th>Capacity</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <s:iterator value="returndayworkdays">  
                                        <fieldset> 
                                            <tr>
                                                <th><s:property value="genWeekday"/></th>
                                                <th><s:property value="genCapacity"/></th>
                                            </tr>
                                        </fieldset>  
                                    </s:iterator> 

                                    </tbody>
                                </table>
                            </div>
                        </div>


                        <div class="col-lg-6">

                            <h3>Update Time Zone</h3>

                            <form role="form" action="manageravailable" method="post">

                                <ul class="list-group">
                                    <li class="list-group-item">

                                        <div id="example">
                                            <div class="demo-section k-content">

                                                <label>Set days</label>
                                                <select class="form-control" name="managerdays" id="managerdays">
                                                    <option value="1">Monday</option>
                                                    <option value="2">Tuesday</option>
                                                    <option value="3">Wednesday</option>
                                                    <option value="4">Thursday</option>
                                                    <option value="5">Friday</option>
                                                    <option value="6">Saturday</option>
                                                    <option value="7">Sunday</option>
                                                </select>
                                                <br/>
                                                

                                                <h4>Start time</h4>
                                                <input id="start" value="6:00 AM" style="width: 100%;" name="managerstarttime" id="managerstarttime"/>

                                                <h4 style="margin-top: 2em;">End time</h4>
                                                <input id="end" value="6:30 AM" style="width: 100%;" name="managerendtime" id="managerendtime"/>
                                                <br/><br/>
                                                <button type="submit" class="btn btn-default">Update time zone</button>
                                            </div>
                                            <script>
                                                $(document).ready(function () {
                                                    function startChange() {
                                                        var startTime = start.value();

                                                        if (startTime) {
                                                            startTime = new Date(startTime);

                                                            end.max(startTime);

                                                            startTime.setMinutes(startTime.getMinutes() + this.options.interval);

                                                            end.min(startTime);
                                                            end.value(startTime);
                                                        }
                                                    }

                                                    //init start timepicker
                                                    var start = $("#start").kendoTimePicker({
                                                        change: startChange
                                                    }).data("kendoTimePicker");

                                                    //init end timepicker
                                                    var end = $("#end").kendoTimePicker().data("kendoTimePicker");

                                                    //define min/max range
                                                    start.min("6:00 AM");
                                                    start.max("10:30 PM");

                                                    //define min/max range
                                                    end.min("6:30 AM");
                                                    end.max("11:30 PM");
                                                });
                                            </script>

                                            <style>

                                            </style>
                                        </div>

                                    </li>
                                </ul>
                            </form>
                        </div>



                        <div class="col-lg-6">
                            <h3>Time zone</h3>
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                        <tr>
                                            <th>Days</th>
                                            <th>Capacity</th>
                                            <th>Time From</th>
                                            <th>Time To</th>
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
                                            </tr>
                                        </fieldset>  
                                    </s:iterator> 

                                    </tbody>
                                </table>
                            </div>
                        </div>


                        <!-- /.row -->

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
