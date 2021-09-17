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
    <title>Employee Management </title>

    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">

    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
    %>
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
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h2>Invoice
                            <small>Submit Payment And Print Bill</small>
                        </h2>
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

                        <!--////////////////////////-->

                        <!--//////////////////////////-->
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Invoice Print
                                    <small>Employee invoice</small>
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
                            <div class="x_content">

                                <section class="content invoice">
                                    <!-- title row -->
                                    <div class="row">
                                        <div class="  invoice-header">
                                            <h1>
                                                <i class="fa fa-globe"></i> Invoice.
                                                <small><%=date%>
                                                </small>
                                            </h1>
                                        </div>
                                    </div>
                                    <!-- info row -->
                                    <div class="row invoice-info">
                                        <div class="col-sm-4 invoice-col">
                                            From
                                            <address>
                                                <strong>Manager</strong>
                                                <br>Sapphire Marroitt
                                                <br>Galle, Sri Lanka
                                                <br>------------------
                                                <br>(signature)
                                            </address>
                                        </div>
                                        <!-- /.col -->
                                        <div class="col-sm-4 invoice-col">
                                            To
                                            <address>
                                                <strong>Name:---------------------</strong>
                                                <br>------------------------------
                                                <br>------------------------------
                                                <br>phone:---------------------
                                                <br>Email:----------------------
                                            </address>
                                        </div>
                                        <!-- /.col -->
                                        <div class="col-sm-4 invoice-col">
                                            <b>Invoice No: -----------</b>
                                            <br>
                                            <b>Order ID:</b> --------------------
                                            <br>
                                            <b>Payment Due:</b><%=date%>
                                            <br>
                                            <b>Account:</b> ---------------------
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                    <!-- /.row -->

                                    <!-- Table row -->
                                    <div class="row">
                                        <div class="  table">
                                            <table id="saq" class="table table-striped">
                                                <thead>

                                                <tr>

                                                    <th>Emp Id</th>
                                                    <th>Name</th>
                                                    <th>Basic Salary</th>
                                                    <th>OT Hours</th>

                                                    <th>Total Salary</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${getSalaryData}" var="e">
                                                    <tr>

                                                        <td>${e.employee}</td>
                                                        <td>${e.name}</td>
                                                        <td>${e.basicSalary}</td>
                                                        <td>${e.otHours}</td>
                                                        <td>${e.basicSalary + (e.otHours*200)}</td>
                                                    </tr>
                                                    <script>
                                                        var aa = aa + ${e.otHours};
                                                        document.getElementById("demo").innerHTML = 11;
                                                    </script>
                                                </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                    <!-- /.row -->

                                    <div class="row">
                                        <!-- accepted payments column -->
                                        <div class="col-md-6">
                                            <p class="lead">Payment Methods:</p>
                                            <img src="../../images/visa.png" alt="Visa">
                                            <img src="../../images/mastercard.png" alt="Mastercard">
                                            <img src="../../images/american-express.png" alt="American Express">
                                            <img src="../../images/paypal.png" alt="Paypal">
                                            <p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
                                                This is a legal document provided by Hotel sapphire Marriott©, Galle, Sri Lanka
                                                <br>
                                                For more information:
                                                <br>
                                                Contact us: 011-2976284
                                            </p>
                                        </div>
                                        <!-- /.col -->
                                        <div class="col-md-6">
                                            <p class="lead">Amount Due <%=date%></p>
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <tbody>
                                                    <tr>
                                                        <th style="width:50%">Basic Tot:</th>
                                                        <td><span id="val2"></span></td>
                                                    </tr>
                                                    <tr>
                                                        <th>Ot Tot:
                                                            <small style="font-weight: bold"><span id="val9"></span>
                                                            </small>
                                                        </th>
                                                        <td><span id="val3"></span></td>
                                                    </tr>
                                                    <tr>
                                                        <th>Tax:</th>
                                                        <td>2%<span id="val4"></span></td>
                                                    </tr>
                                                    <tr>
                                                        <th>Total:</th>
                                                        <td><span id="val"></span></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                    <!-- /.row -->

                                    <!-- this row will not appear when printing -->
                                    <div class="row no-print">
                                        <div class=" ">

                                            <form method="POST" action="deleteSalaryTable"
                                                  name="deleteSalaryTable">
                                                <input style="display: none" type="text" id="itemPay" name="source">
                                                <ul class="nav navbar-right panel_toolbox">
                                                    <button type="submit" value="Register"
                                                            style="font-weight: bold;color: #c6d4d3" ; id="name"
                                                            onclick="window.print();"
                                                            class="btn btn-success "> Submit Payment <i
                                                            class="fa fa-file-image-o"></i>
                                                    </button>
                                                </ul>

                                            </form>

                                        </div>
                                    </div>
                                </section>
                            </div>
                        </div>
                    </div>
                </div>
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

<script>
    var rowCount = document.getElementById('saq').rows.length;
    var table = document.getElementById("saq"), sumVal2 = 0.0, sumVal3 = 0.0, sumVal4 = 0.0, sumVal5 = 0.0;
    var sumVal = 0.0;
    var avgTax = 0.0;
    var str = '';


    for (var i = 1; i < table.rows.length; i++) {
        str = str + (table.rows[i].cells[0].innerHTML) + " ";
        sumVal = sumVal + parseFloat(table.rows[i].cells[4].innerHTML);
        sumVal2 = sumVal2 + parseFloat(table.rows[i].cells[2].innerHTML);
        sumVal3 = sumVal3 + parseFloat(table.rows[i].cells[3].innerHTML);
    }
    $("#itemPay").val(str);
    document.getElementById("val").innerHTML = "Rs: " + sumVal;
    document.getElementById("val2").innerHTML = "Rs: " + sumVal2;
    document.getElementById("val3").innerHTML = sumVal3;
    document.getElementById("val5").innerHTML = "Rs: " + sumVal5;
    document.getElementById("val4").innerHTML = "Rs: " + sumVal4;
    document.getElementById("val9").innerHTML = "(avg)" + avgTax + "%";


</script>

<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="../../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../../vendors/nprogress/nprogress.js"></script>

<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

</body>
</html>