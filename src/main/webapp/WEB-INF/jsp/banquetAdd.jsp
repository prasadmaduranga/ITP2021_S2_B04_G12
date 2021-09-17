<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 9/9/2021
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html lang="en">
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
    %>
    <%
        if(request.getAttribute("myp1") != null){
    %>
    <script>alert("Date is Unavailable... Please check availability.")</script>
    <%
        }
    %>

    <%
        if(request.getAttribute("myp2") != null){
    %>
    <script>alert("Hall 01 is Unavailable... Please check availability.")</script>
    <%
        }
    %>

    <%
        if(request.getAttribute("myp3") != null){
    %>
    <script>alert("Hall 02 is Unavailable... Please check availability.")</script>
    <%
        }
    %>

    <%
        if(request.getAttribute("successfulMsg") != null){
    %>
    <script>alert("Added Successfully")</script>
    <%
        }
    %>

    <!-- Datatables -->
    <link href="../../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">

    <style>
        .large-btn {
            height: 40px;
            width: 100%;
            font-family: "Playfair Display", Georgia, "Times New Roman", serif;
            font-weight: bolder;

        }

        .large-btn:hover {
            color: #0f0f0f;
        }

        #chartdiv {
            position: relative;
            top: 40px;
            width: 100%;
            height: 500px;
        }

        #chartdiv1 {
            position: relative;
            top: 40px;
            width: 100%;
            height: 500px;
        }
    </style>
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
            /*background-color: #a98e77;*/
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
<div class="container body">
    <div class="main_container">


        <!-- Side header -->
        <jsp:include page="sideHeader.jsp"/>
        <!-- /Side header -->

        <!-- Top header -->
        <jsp:include page="topHeader.jsp"/>
        <!-- /Top header -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="page-title">
                <div class="title_left">
                    <h3>Add Banquet<h4>Welcome to Sapphire Marriott</h4>
                    </h3>
                    <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="col-6 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <a href="/banquet">
                                <button style=" border: 3px solid #4c2a18;  background-color: #8c6f60;
                                    color: #c6d4d3;font-weight: bolder" type="button"  class="btnq2 btn"><i class="fa fa-reply">
                                    Back</i>
                                </button>
                            </a>

                        </div>

                    </div>
                </div>

                <%--Time--%>
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
            <%--/Time--%>

            <%--Input Feilds--%>
            <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <div class="col-12 col-sm-12 col-md-12 col-lg-5 col-xl-5">
                    <form method="POST"  action="saveBanquet" name="saveBanquet">

                        <div class="form-group">

                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
                                <label >Banquet Id</label>
                                <input type="number" value="${topBanquetId}" class="form-control"
                                       required="required" name="orderId"
                                       id="orderId" placeholder="Banquet Id" readonly/></div>

                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
                                <label for="orderId">Customer Id</label>
                                <input type="number" value="${topBanquetCustomerId}" class="form-control"
                                       required="required" name="customerId"
                                       id="customerId" placeholder="Customer Id" readonly/></div>
                        </div>

                        <div class="form-group">


                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"> <br>
                                <label for="orderId">Customer Name</label>
                                <input type="text" class="form-control"
                                       required="required" name="name"
                                       id="name" placeholder="Customer Name"/></div>

                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"> <br>
                                <label for="orderId">Address</label>
                                <input type="text" class="form-control"
                                       required="required" name="address"
                                       id="address" placeholder="Address"/></div>
                        </div>


                        <div class="form-group">
                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"> <br>
                                <label for="orderId">Email</label>
                                <input type="email" class="form-control"
                                       required="required" name="email"
                                       id="email" placeholder="Email"/></div>

                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"> <br>
                                <label for="orderId">Mobile No</label>
                                <input type="tel" class="form-control"
                                       pattern="[0-9]{10}" required name="contactNumber"
                                       id="contactNumber" placeholder="Mobile No"/></div>
                        </div>

                        <div class="form-group">

                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"> <br>
                                <label for="orderId">Date</label>
                                <input type="date" class="form-control"
                                       required="required" name="date"
                                       id="date" placeholder="Date"/></div>
                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"> <br>
                                <label for="orderId">Hall No</label>
                                <select class="form-control"required="required" name="hallId"
                                        id="hallId">
                                    <option value="No 1">Choose Hall No</option>
                                    <option value="No 1">No 1</option>
                                    <option value="No 2">No 2</option>
                                </select>

                            </div>
                            <br>
                        </div>
                        <div class="form-group">
                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"> <br>
                                <label for="orderId">Num Of Plates</label>
                                <input type="number" size="6" min="10" max="1000" class="form-control"
                                       required="required" name="noOfPlates"
                                       id="noOfPlates" placeholder="Num Of Plates"/></div>

                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"> <br>
                                <label for="orderId">Package</label>
                                <select class="form-control"required="required" name="menuId"
                                        id="menuId">
                                    <option value="1">Choose Package</option>
                                    <option value="1">Bronze</option>
                                    <option value="2">Silver</option>
                                    <option value="3">Gold</option>
                                    <option value="4">Platinum</option>
                                </select>

                            </div>

                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"> <br>
                                <input type="hidden" required="required" name="banquetBillId"
                                       id="billId" value="${topBanquetBillId}">
                                <label for="orderId">Advance Payment</label>
                                <input type="number" class="form-control"
                                       required="required" name="advanceFee"
                                       id="advancePayment" placeholder="Advance Payment"/></div>

                        </div>

                        <button type='submit' class="btn btn-primary" style="width: 50%; top: 20px; position: relative" value="Register">
                            Submit
                        </button>
                        <button type='reset' class="btn btn-outline-success" style="top: 20px; position: relative" value="">Reset</button>

                    </form>
                </div>
                <%--/Input Feilds--%>
                <%--Table--%>
                <div class="col-12 col-sm-12 col-md-12 col-lg-7 col-xl-7">
                    <div class="row">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Registered Customers
                                    <small>Find customers</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                           aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <a class="dropdown-item" href="#">Settings 1</a>
                                        </div>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card-box table-responsive">
                                            <table id="datatable-buttons" class="table table-striped table-bordered">
                                                <thead class="thead-light">
                                                <tr>
                                                    <th>Customer Id</th>
                                                    <th>Name</th>
                                                    <th>Address</th>
                                                    <th>MobileNo</th>
                                                    <th>Email</th>


                                                </tr>

                                                </thead>
                                                <tbody>
                                                <c:forEach items="${loadTable}" var="a">
                                                    <tr>
                                                        <td>${a.customerId}</td>
                                                        <td>${a.name}</td>
                                                        <td>${a.address}</td>
                                                        <td>${a.contactNumber}</td>
                                                        <td>${a.email}</td>
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
                <%--/Table--%>

                <%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>


            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <jsp:include page="footer.jsp"/>
        <!-- /footer content -->
    </div>
</div>


<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Datatables -->
<script src="../../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<%--Show Print Buttons--%>
<script src="../../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="../../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="../../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="../../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<%--Responsive Table--%>
<script src="../../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<%--<script src="../../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>--%>
<%--Print--%>
<script src="../../vendors/jszip/dist/jszip.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>
<%--Pie Chart 1--%>

<script>

    var selectedRow = null;
    $("#datatable-buttons tbody").on('click', 'tr', function () {
        selectedRow = $(this);
        $("#customerId").val($(this).find("td:nth-child(1)").text());
        $("#name").val($(this).find("td:nth-child(2)").text());
        $("#address").val($(this).find("td:nth-child(3)").text());
        $("#contactNumber").val($(this).find("td:nth-child(4)").text());
        $("#email").val($(this).find("td:nth-child(5)").text());
        selectedRow.addClass('row-selected');
    });
</script>
<script>
    var dateController = {
        currentDate : null
    }

    $(document).on( "change", "#date",function( event, ui ) {
        var now = new Date();
        var selectedDate = new Date($(this).val());

        if(selectedDate <= now) {
            $(this).val("");
            alert("Invalid date... Please enter future date... Can't enter today and old dates");

        } else {
            dateController.currentDate = $(this).val();
        }
    });
</script>




</body>
</html>
