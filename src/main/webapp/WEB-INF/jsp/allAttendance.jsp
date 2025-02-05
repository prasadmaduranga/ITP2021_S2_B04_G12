<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Employee Management </title>
    <link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">
    <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->

    <link href="../../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">
    <link href="../../css/common.css" rel="stylesheet">
    <%
        SimpleDateFormat sdf = new SimpleDateFormat ( "dd-MM-yyyy" );
        String date = sdf.format ( new Date ( ) );
    %>
    <script>
        function myFunction() {
            // Declare variables
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("datatable-responsive");
            tr = table.getElementsByTagName("tr");
            // Loop through all table rows, and hide those who don't match the search query
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
    <style>
        .row-selected {
            background-color: rgba(36, 107, 218, 0.21) !important;
        }
    </style>
</head>

<body class="nav-md" style="cursor: pointer">
<%! String date = ""; %>
<div class="container body">
    <div class="main_container">


        <!-- Side header -->
        <jsp:include page="sideHeader.jsp"/>
        <!-- /Side header -->

        <!-- Top header -->
        <jsp:include page="topHeader.jsp"/>
        <!-- /Top header -->

        <!-- /top navigation -->
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Attendance
                            <small>All Attendance Details</small>
                        </h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5   form-group pull-right top_search">
                            <!--/////-->
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
                                        <h6 style="color:#73879C; float:right;border: none;background-color: #f6f6f6">


                                            <input style="color:#73879C; float:right;border: none;background-color: #f6f6f6"
                                                   class="clock2" type="text" name="sivam" size="12"><br>
                                            <p><%=date%>
                                            </p>

                                        </h6>

                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="clock3" for="1"><input type="radio" style="display: none"
                                                                                 id="1" name="sivamtime"
                                                                                 checked></label><br>
                                            <label class="clock3" for="2"><input type="radio" style="display: none"
                                                                                 id="2" name="sivamtime"></label>
                                        </td>
                                    </tr>
                                </table>

                            </form>
                            <!--////-->
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row" style="display: block;">

                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12 ">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Find Employees
                                        <small>Attendance Table</small>
                                    </h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
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
                                <a href="/attendance">
                                        <button style=" border: 2px solid #775e51;  background-color: #8c6f60; width:8%; height:5%;
                                        color: #E9EDEF;font-weight: bolder" type="button"  class="btn btn-secondary"><i class="fa fa-reply">
                                            Back</i>
                                    </button>
                                </a>
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="card-box table-responsive">
                                                <p class="text-muted font-13 m-b-30">
                                                    This table provides Attendance details of Employees.
                                                    To remove details, find the User and click the Delete icon.
                                                </p>
                                                <table id="datatable-buttons"
                                                       class="table table-striped table-bordered">
                                                    <thead class="thead-light">
                                                    <tr>
                                                        <th>Attendance ID</th>
                                                        <th>Date</th>
                                                        <th>Employee Id</th>
                                                        <th>Name</th>
                                                        <th>Position</th>
                                                        <th>Img</th>
                                                        <th>In Time</th>
                                                        <th>Out Time</th>
                                                        <th>OT Hours</th>

                                                    </tr>

                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${listAttendance}" var="e">
                                                    <tr>
                                                        <td>${e.attendanceId}</td>
                                                        <td>${e.date}</td>
                                                        <td>${e.employeeID}</td>
                                                        <td>${e.empName}</td>
                                                        <td>${e.position}</td>
                                                        <td>
                                                            <ul class="list-inline">
                                                                <li>
                                                                    <img src="${e.pic}"
                                                                         class="avatar" alt="Avatar">
                                                                </li>
                                                            </ul>
                                                        </td>
                                                        <td>${e.inTime}</td>
                                                        <td>${e.outTime}</td>
                                                        <td>${e.overtimeHours}</td>
                                                    </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- /page content -->

        <jsp:include page="footer.jsp"/>
        <!-- /footer content -->

    </div>
</div>

<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="../../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../../vendors/nprogress/nprogress.js"></script>
<!-- iCheck -->
<script src="../../vendors/iCheck/icheck.min.js"></script>
<!-- Datatables -->
<script src="../../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="../../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="../../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="../../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="../../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="../../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="../../vendors/jszip/dist/jszip.min.js"></script>
<script src="../../vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="../../vendors/pdfmake/build/vfs_fonts.js"></script>
<script>
    var selectedRow = null;
    $("#datatable-responsive tbody").on('click', 'tr', function () {
        var date = new Date();
        var date2 = new Date();
        var today = date.getHours() + ":" + (date.getMinutes()) + ":" + date.getSeconds();
        date2.setHours(date.getHours() + 8);
        var today2 = date2.getHours() + ":" + (date.getMinutes()) + ":" + date.getSeconds();
        selectedRow = $(this);
        $("#itemCode").val($(this).find("td:first-child").text());
        $("#itemDesc").val($(this).find("td:nth-child(2)").text());
        $("#itemTime").val(today);
        $("#itemTime2").val(today2);
        $("#datatable-responsive tbody tr").removeClass('row-selected');
        selectedRow.addClass('row-selected');
    });
</script>
<script>
    var selectedRow = null;
    $("#datatable-buttons tbody").on('click', 'tr', function () {

        selectedRow = $(this);
        $("#itemCode").val($(this).find("td:nth-child(2)").text());
        $("#itemTime").val($(this).find("td:nth-child(5)").text());
        $("#itemDesc").val($(this).find("td:nth-child(3)").text());
        $("#itemTime2").val($(this).find("td:nth-child(6)").text());
        $("#itemTime3").val($(this).find("td:nth-child(7)").text());
        $("#datatable-responsive tbody tr").removeClass('row-selected');
        selectedRow.addClass('row-selected');
    });
</script>
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>
</body>
</html>