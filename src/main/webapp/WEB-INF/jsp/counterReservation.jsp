<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/6/2021
  Time: 9:47 PM
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

    <c:if test="${not empty loginError}">
        <script>
            window.addEventListener("load", function () {
                alert("${loginError}");
            });
        </script>
    </c:if>

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
            border: 5px solid rgb(174, 182, 203);
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
                    rgba(135, 141, 156, 0.4),
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

                    <h3>Room Booking
                        <small></small>
                    </h3>


                    <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="col-6 col-sm-6 col-md-8 col-lg-8 col-xl-8">
                            <a href="/customerRegistration">
                                <button style="background: #8c6f60 none repeat scroll 0 0;border-color:#4c2a18;color: #fff;
                                font-size: 14px;font-weight: 700;letter-spacing: 0;padding: 8px 15px;text-transform: uppercase" type="button" class="btnq2 btn"><i
                                        class="">
                                    Back</i>
                                </button>
                            </a>

                            <!--
                            <a href="/counterReservation">
                                <button style=" border: 5px solid rgb(174, 182, 203);background-color: #45526e;
                                    color: #c6d4d3;font-weight: bolder" type="button" class="btnq2 btn"><i
                                        class="fa fa-fast-forward">
                                    Next</i>
                                </button>
                            </a>
                            -->

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
                <div class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-4">
                    <form method="POST" action="findAvailability">

                        <div class="form-group">


                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
                                <label>Customer Email</label>
                                <input type="email" value="" class="form-control"
                                       required="required" name="email"
                                       id="customerId" placeholder="min@gmail.com"/></div>
                        </div>


                                <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"><br>
                                    <label>Check-In</label>
                                    <input type="date" class="form-control"
                                           required="required" name="checkIn"
                                           id="checkIn" placeholder="check-in"/></div>



                            <div class="form-group">
                                <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"><br>
                                        <label>Check-Out</label>
                                    <input type="date" class="form-control"
                                           required="required" name="checkOut"
                                           id="checkOut" placeholder="check-out"/></div>

                                <!--
                                <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"><br>
                                    <label>Mobile No</label>
                                    <input type="number" class="form-control"
                                           required="required" name="contactNumber"
                                           id="contactNumber" placeholder="Mobile No"/></div>
                                           -->
                            </div>


                            <button type='submit' class="btn btn-primary"
                                    style="width: 50%; top: 20px; position: relative" value="Register">
                                Check Availability
                            </button>
                            <button type='reset' class="btn btn-outline-success" style="top: 20px; position: relative"
                                    value="">Reset
                            </button>

                    </form>
                </div>
                <%--/Input Feilds--%>

                <%--Table--%>
                <div class="col-12 col-sm-12 col-md-12 col-lg-7 col-xl-7">
                    <form method="POST" action="saveCounterRooms" name="saveCounterRooms">
                        <input style="display: none" readonly required type="text" id="itemPay" name="details">
                        <input  style="" readonly required="required" type="hidden" id="customer" value="${loggedCustomer.customerId}" name="customer">
                        <input  style="" readonly required="required" type="hidden" id="vDate" value="${checkIn}" name="checkIn">
                        <input readonly required ="required"type="hidden" id="timeIn" value="${checkOut}" name="checkOut">
                        <button style="float: right"  type="submit" onclick="getValue()" class="reserved-btn btn btn-dark" id="submitButton">Submit</button>
                    </form>
                    <div class="row">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Find Room
                                    <small></small>
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
                                    <div class="card-box table-responsive">
                                        <table id="datatable-buttons" class="table table-striped table-bordered">
                                            <thead class="thead-light">
                                            <tr>
                                                <th>Room ID</th>
                                                <th>Room Type</th>
                                                <th>Room Price</th>
                                                <th>Available From</th>
                                                <th>Room Condition</th>
                                                <th>Room Status</th>

                                            </tr>

                                            </thead>
                                            <tbody>
                                            <c:forEach items="${loadRooms}" var="a">
                                                <tr>
                                                    <td>${a.roomId2}</td>
                                                    <td>${a.type}</td>
                                                    <td>${a.price}</td>
                                                    <td>${a.date}</td>
                                                    <td>${a.status}</td>
                                                    <td class="cell100 column5"><button onclick="myFunction(${a.roomId2})"
                                                                                        type="button" class="book-now-btn">Book Now</button></td>

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
    var myTableArray = [];
    var selectedRow = null;

    function myFunction(x) {
        selectedRow = $(this)
        if (!myTableArray.includes(x)) {
            alert("Added Table " + x);
            myTableArray.push(x)
        } else {
            alert("Table " + x + " already Booked");
        }
    }

    function getValue() {

        /*  if (vDate == "" || timeIn == "" || timeOut == "") {
              alert("Please Select Room In Table");
              return;
          }
  */
        var str, stre = "";
        var inputArray = []

        for (var i = 0; i < myTableArray.length; i++) {
            if (!inputArray.includes(myTableArray[i])) {
                inputArray.push(myTableArray[i])
                str = myTableArray[i] + " "
                stre += str;
            }
        }
        alert(stre)
        $("#itemPay").val(stre);
    }
</script>

</body>
</html>
