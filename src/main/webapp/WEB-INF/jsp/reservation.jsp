<%--
  Created by IntelliJ IDEA.
  User: prabo
  Date: 8/23/2021
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<html>
<head>
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

    <%
        SimpleDateFormat sdf = new SimpleDateFormat ( "dd-MM-yyyy" );
        String date = sdf.format ( new Date( ) );
    %>
    <style>
        .large-btn {
            height: 90px;
            width: 100%;
            font-family: "Playfair Display", Georgia, "Times New Roman", serif;
            font-weight: bolder;
            font-size: 27px;
        }

        .btnq2:hover {
            transform: scale(1.05, 1.1);
            transition: 0.8s ease;
            -webkit-transition: 0.8s ease;
            -moz-transition: 0.8s ease;
        }

        .btnq3:hover {
            transform: scale(1.3, 1.3);
            transition: 0.8s ease;
            -webkit-transition: 0.8s ease;
            -moz-transition: 0.8s ease;
        }
        #chartdiv {
            width: 100%;
            height: 500px;
        }

        #chartdiv1 {
            width: 100%;
            height: 500px;
        }

        .large-btn:hover {
            color: #cebbbb;
        }
        /*//////////////////////////////////////////////////////////////*/

        .containerx {
            display: flex;

        }

        .btnq {
            text-decoration: none;
            border: 5px solid rgb(190, 175, 166);
            position: relative;
            overflow: hidden;
            height: 90px;
            width: 100%;
            font-size: 1.5rem;
            text-align: center;
            border-radius: 5px 5px;
        }

        .btnq:before {
            content: "";
            position: absolute;
            top: 0;
            left: -00%;
            text-align: center;
            width: 100%;
            height: 100%;
            background: linear-gradient(
                    120deg,
                    transparent,
                    rgba(64, 45, 34, 0.4),
                    transparent
            );
            transition: all .8s;
        }

        .btnq:hover:before {
            left: 100%;
        }

    </style>
</head>
<body class="nav-md" style="cursor: pointer">

<div class="form-container sign-in-container">

    <div class="container body">
        <div class="main_container">

            <!-- Side header -->
            <jsp:include page="sideHeader.jsp" />
            <!-- /Side header -->

            <!-- Top header -->
            <jsp:include page="topHeader.jsp" />
            <!-- /Top header -->


            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Reservation Dashboard
                                <small></small>
                            </h3>
                        </div>

                        <div class="title_right">
                            <script>

                                function formatTime() {
                                    now = new Date();
                                    hour = now.getHours();
                                    min = now.getMinutes();
                                    sec = now.getSeconds();

                                    if (document.clock.sivamtime[0].checked) {
                                        if (min <= 9) {
                                            min = "0" + min;
                                        }
                                        if (sec <= 9) {
                                            sec = "0" + sec;
                                        }
                                        if (hour > 12) {
                                            hour = hour - 12;
                                            add = " p.m.";
                                        } else {
                                            hour = hour;
                                            add = " a.m.";
                                        }
                                        if (hour == 12) {
                                            add = " p.m.";
                                        }
                                        if (hour == 0) {
                                            hour = "12";
                                        }

                                        document.clock.sivam.value = ((hour <= 9) ? "0" + hour : hour) + ":" + min + ":" + sec + add;
                                    }

                                    if (document.clock.sivamtime[1].checked) {
                                        if (min <= 9) {
                                            min = "0" + min;
                                        }
                                        if (sec <= 9) {
                                            sec = "0" + sec;
                                        }
                                        if (hour < 10) {
                                            hour = "0" + hour;
                                        }
                                        document.clock.sivam.value = hour + ':' + min + ':' + sec;
                                    }

                                    setTimeout("formatTime()", 1000);
                                }

                                window.onload = formatTime;

                            </script>
                            <form name="clock" style="float: right">
                                <table class="clock" width="135">
                                    <tr>
                                        <td class="clock2">
                                        </td>
                                    </tr>
                                    <tr>
                                        <h6 style="color:#73879C; float:right;border: none;background-color: #f6f6f6">
                                            <input style="color:#73879C; float:right;border: none;background-color: #f6f6f6"
                                                   class="clock2" type="text" name="sivam" size="12"><br>
                                            <p><%=date%>
                                            </p>
                                        </h6>

                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="clock3" for="1"><input type="radio" style="display: none" id="1"
                                                                                 name="sivamtime" checked></label><br>
                                            <label class="clock3" for="2"><input type="radio" style="display: none" id="2"
                                                                                 name="sivamtime"></label>
                                        </td>
                                    </tr>
                                </table>

                            </form>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">


                        <div class="col-sm-12 col-md-4 col-lg-3 col-xl-3">
                            <div class="containerx">
                                <a style=" font-family: Playfair Display, Georgia, Times New Roman, serif;
                             background-color:#a98e77; color: #ffffff;font-weight: bolder"
                                   href="/home" class="btnq"><h2
                                        style="position: relative; letter-spacing: 1px;
                                     margin-top: 30px">Online Reservation</h2></a>
                            </div>
                            <br>
                        </div>

                        <div class="col-sm-12 col-md-4 col-lg-3 col-xl-3">
                            <div class="containerx">
                                <a style=" font-family: Playfair Display, Georgia, Times New Roman, serif;
                             background-color:#a98e77; color: #ffffff;font-weight: bolder"
                                   href="/customerRegistration" class="btnq"><h2
                                        style="position: relative; letter-spacing: 1px;
                                     margin-top: 30px">Counter Reservation</h2></a>
                            </div>
                            <br>
                        </div>

                        <div class="col-sm-12 col-md-4 col-lg-3 col-xl-3">
                            <div class="containerx">
                                <a style=" font-family: Playfair Display, Georgia, Times New Roman, serif;
                             background-color:#a98e77; color: #ffffff;font-weight: bolder"
                                   href="/customerCheckOut" class="btnq"><h2
                                        style="position: relative; letter-spacing: 1px;
                                     margin-top: 30px">Check-Out</h2></a>
                            </div>
                            <br>
                        </div>

                        <div class="col-sm-12 col-md-4 col-lg-3 col-xl-3">
                            <div class="containerx">
                                <a style=" font-family: Playfair Display, Georgia, Times New Roman, serif;
                             background-color:#a98e77; color: #ffffff;font-weight: bolder"
                                   href="/activityReports" class="btnq"><h2
                                        style="position: relative; letter-spacing: 1px;
                                     margin-top: 30px">Daily Activity Reports</h2></a>
                            </div>
                            <br>
                        </div>

                    </div>

                    <%--                    /////////////////////////////////////////////////////--%>
                    <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row" style="display: block;">
                            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Latest Reservations</h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                            </li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                    <a class="dropdown-item" href="#">Settings 1</a>
                                                    <a class="dropdown-item" href="#">Settings 2</a>
                                                </div>
                                            </li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">

                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>Reservation ID</th>
                                                <th>Customer Name</th>
                                                <th>Mobile</th>
                                                <th>Email</th>
                                                <th>No of Rooms</th>

                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${loadTable1}" var="e">
                                                <tr>
                                                    <td>${e.orderId}</td>
                                                    <td>${e.name}</td>
                                                    <td>${e.contactNumber}</td>
                                                    <td>${e.date}</td>
                                                    <td>${e.hallId}</td>
                                                    <td>${e.noOfPlates}</td>
                                                    <td>${e.advanceFee}</td>
                                                    <td>${e.orderState}</td>
                                                    <td><a href="/updateBanquetStatus?orderId=${e.orderId}">
                                                        <button value="" id="billBtn" name="billBtn" class="btn btn-outline-success" style="font-size: 12px;">confirmed</button>
                                                    </a></td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <%--/////////////////////////////////////////////    /////////////////////////////////////////////--%>





                </div>
            </div>
            <!-- /page content -->

            <!-- footer content -->
            <jsp:include page="footer.jsp" />
            <!-- /footer content -->
        </div>
    </div>
</div>



<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

</body>

</html>
