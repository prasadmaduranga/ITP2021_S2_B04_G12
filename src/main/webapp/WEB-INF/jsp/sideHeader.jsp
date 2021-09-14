
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sapphire Marriot</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">

</head>
<body>
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="dashboard" class="site_title"> <img style="margin-top: 20px; width: 162px;height: 102px"
                                                         src="../../images/logonewe.png">
                   </a>
        </div>

        <div class="clearfix"></div>

        <br/>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">

                <ul class="nav side-menu">
                    <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="dashboard">Dashboard</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-tasks"></i> Front Desk <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="reservation">Reservation</a></li>
                            <li><a href="banquet">BanquetManagement</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-coffee"></i> Restaurant<span
                            class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="restaurant"> Food & Bev </a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-coffee"></i> Bar<span
                            class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="foodAndBeverage"> Food & Bev </a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-life-buoy"></i> House Keeping <span
                            class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="housekeeping">Room Manage</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-cutlery"></i> Kitchen<span
                            class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="kitchen">Kitchen Manage</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-shopping-cart"></i> Inventory<span
                            class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="inventory">Inventory Manage</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="menu_section">
                <h3>Live On</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-gear"></i> Manage System<span
                            class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="manage">Manager</a></li>
                            <li><a href="hr">HR</a></li>
                        </ul>
                    </li>
                </ul>
            </div>

        </div>
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Logout" href="login">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>



</body>

</html>
