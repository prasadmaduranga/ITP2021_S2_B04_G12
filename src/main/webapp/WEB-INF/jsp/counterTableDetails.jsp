
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
    <%--Chrat--%>

    <script src="https://www.amcharts.com/lib/4/core.js"></script>
    <script src="https://www.amcharts.com/lib/4/charts.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
    <%--/Pie Chrat--%>

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
                    <h3>Manage Restaurant Table<br>
                        <small>Welcome To Hotel Hareesha</small>
                    </h3>
                    <h2>Available Tables</h2>
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

            <%--Table--%>
            <div class="col-12 col-sm-12 col-md-12 col-lg-7 col-xl-7">


            </div>

            <%--///////////////////////////////////////////////////////////////////////////////////////////////////////////--%>

            <div class="body2">
                <div class="main zerogrid">
                    <article id="content2">
                        <div class="wrapper">
                            <section>
                                <div class="wrapper">
                                    <form method="POST" action="saveCounterTable" name="saveCounterTable">
                                        <input style="display: none" readonly required type="text" id="itemPay" name="orderData">
                                        <input  style="" readonly required="required" type="date" id="vDate" value="${reservedDate}" name="vDate">
                                        <input readonly required ="required"type="time" id="timeIn" value="${timeIn}" name="vStatT">
                                        <input readonly required ="required" type="time" id="timeOut" value="${timeOut}" name="vEndT">
                                        <button type="submit" onclick="getValue()" class="col-1-1 button1x1" id="submitButton">Submit</button>
                                    </form>
                                    <br>
                                    <table>

                                        <tbody id="reservationTable">
                                        <c:forEach items="${loadAllTable}" var="e">
                                            <td style="width: 120px">
                                                <div class="col ">
                                                    <div class="wrap-col">
                                                        <div class="wrapper pad_bot1" id="#0001">
                                                            <figure style="   width: 10px;height: 10px;" class="pad_bot1"><img
                                                                    style="   width: 100px;height: 100px;" src="../../onlineRestaurant/restaurant/images/pngwave.png"
                                                                    alt=""></figure>


                                                            <h5 style="font-size: 20px;margin-top: 100px; background-color: #630000;
                                                            color: white" onclick="myFunction(${e.tableId})" ><span
                                                                    id="selectedTableId"> &nbsp; ${e.place} </span><a
                                                                    class="button1x"></a></h5>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </section>
                        </div>
                    </article>
                    <!-- / content -->
                </div>
            </div>

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

<script>
    $(window).scroll(function () {
        if ($(document).scrollTop() > 224) {
            $(".button1x1").show();
        } else {
            $(".button1x1").hide();
        }
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

        if (vDate == "" || timeIn == "" || timeOut == "") {
            alert("Please Select Item In Table");
            return;
        }

        var str, stre = "";
        var inputArray = []

        for (var i = 0; i < myTableArray.length; i++) {
            if (!inputArray.includes(myTableArray[i])) {
                inputArray.push(myTableArray[i])
                str = myTableArray[i] + " "
                stre += str;
            }
        }

        $("#itemPay").val(stre);
    }
</script>



<%--/Pie Chart 2--%>
</body>
</html>