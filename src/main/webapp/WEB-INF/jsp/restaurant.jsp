
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
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
    <style>
        .large-btn {
            height: 90px;
            width: 100%;
            font-family: "Playfair Display", Georgia, "Times New Roman", serif;
            font-weight: bolder;
            font-size: 27px;
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
            color: #0f0f0f;
        }

        #backImg {
            background-image: url("../../images/picture.jpg");
        }

        #myVideo {
            position: fixed;
            right: 0;
            bottom: 0;
            top: 110px;
            min-width: 100%;
            min-height: 100%;
        }


        #myBtn {
            width: 200px;
            font-size: 18px;
            padding: 10px;
            border: none;
            background: #000;
            color: #fff;
            cursor: pointer;
        }

        #myBtn:hover {
            background: #ddd;
            color: black;
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

        <%--/////////aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa--%>
        <div id="" class="right_col " role="main">

            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Restaurant Manage
                            <small>Welcome To Hotel Sapphire Marriott</small>
                        </h3>
                        <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                            <div class="col-6 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                <a href="/foodAndBeverage">
                                    <button type="button" class=" btn btn-dark"><i class="fa fa-mail-reply"> Back to Dashboard</i>
                                    </button>
                                </a>

                            </div>
                        </div>
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

                <%-- ////////////////////////////////////////////// BODY /////////////////////////////////////////////////////////////--%>
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">


                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <a href="restaurantOrder">
                            <button type="button" class="large-btn btn btn-dark">Order</button>
                        </a>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <a href="restaurantTableIndex">
                            <button type="button" class="large-btn btn btn-dark">Table</button>
                        </a>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <a href="onlineDashboard">
                            <button type="button" class="large-btn btn btn-dark">Online</button>
                        </a>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <a href="restaurantManage">
                        <button type="button" class="large-btn btn btn-dark">Manage Online Orders And Table Reservations</button>
                        </a>
                    </div>

                </div>
                <%--%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Chart Income %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%--%>
                <%--Chart Income--%>
                <%--Chart Today--%>
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">

                        <div id="chartdiv"></div>
                        <h6>This Week</h6>
                    </div>
                    <%--/Chart Today--%>
                    <%--Chart Yesterday--%>
                    <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">

                        <div id="chartdiv1"></div>
                        <h6>Previous Week</h6>
                    </div>
                    <%--/Chart Yesterday--%>
                    <%--/Chart Income--%>
                </div>
                <%--                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>


                <%--////////////////////////////////////////////////////////////--%>
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
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

<!-- Chart code -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/moonrisekingdom.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
<script>
    am4core.ready(function () {

// Themes begin
        am4core.useTheme(am4themes_moonrisekingdom);
        am4core.useTheme(am4themes_animated);
// Themes end

// Create chart instance
        var chart = am4core.create("chartdiv", am4charts.XYChart3D);

// Add data
        chart.data = [{
            "Date": "Sunday",
            "income": 544
        }, {
            "Date": "Monday",
            "income": 655
        }, {
            "Date": "Tuesday",
            "income": 233
        }, {
            "Date": "Wednesday",
            "income": 65
        }, {
            "Date": "Thursday",
            "income": 87
        }, {
            "Date": "Friday",
            "income": 32
        }, {
            "Date": "Saturday",
            "income": 65
        }];

// Create axes
        let categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
        categoryAxis.dataFields.category = "Date";
        categoryAxis.renderer.labels.template.rotation = 270;
        categoryAxis.renderer.labels.template.hideOversized = false;
        categoryAxis.renderer.minGridDistance = 20;
        categoryAxis.renderer.labels.template.horizontalCenter = "right";
        categoryAxis.renderer.labels.template.verticalCenter = "middle";
        categoryAxis.tooltip.label.rotation = 270;
        categoryAxis.tooltip.label.horizontalCenter = "right";
        categoryAxis.tooltip.label.verticalCenter = "middle";

        let valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
        valueAxis.title.text = "Income";
        valueAxis.title.fontWeight = "bold";

// Create series
        var series = chart.series.push(new am4charts.ColumnSeries3D());
        series.dataFields.valueY = "income";
        series.dataFields.categoryX = "Date";
        series.name = "income";
        series.tooltipText = "{categoryX}: [bold]{valueY}[/]";
        series.columns.template.fillOpacity = .8;

        var columnTemplate = series.columns.template;
        columnTemplate.strokeWidth = 2;
        columnTemplate.strokeOpacity = 1;
        columnTemplate.stroke = am4core.color("#FFFFFF");

        columnTemplate.adapter.add("fill", function (fill, target) {
            return chart.colors.getIndex(target.dataItem.index);
        })

        columnTemplate.adapter.add("stroke", function (stroke, target) {
            return chart.colors.getIndex(target.dataItem.index);
        })

        chart.cursor = new am4charts.XYCursor();
        chart.cursor.lineX.strokeOpacity = 0;
        chart.cursor.lineY.strokeOpacity = 0;

    }); // end am4core.ready()
</script>

<script>
    am4core.ready(function () {

// Themes begin
        am4core.useTheme(am4themes_spiritedaway);
        am4core.useTheme(am4themes_animated);
// Themes end

// Create chart instance
        var chart = am4core.create("chartdiv1", am4charts.XYChart3D);

// Add data
        chart.data = [{
            "Date": "Sunday",
            "income": 98
        }, {
            "Date": "Monday",
            "income": 433
        }, {
            "Date": "Tuesday",
            "income": 655
        }, {
            "Date": "Wednesday",
            "income": 766
        }, {
            "Date": "Thursday",
            "income": 87
        }, {
            "Date": "Friday",
            "income": 34
        }, {
            "Date": "Saturday",
            "income": 433
        }];

// Create axes
        let categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
        categoryAxis.dataFields.category = "Date";
        categoryAxis.renderer.labels.template.rotation = 270;
        categoryAxis.renderer.labels.template.hideOversized = false;
        categoryAxis.renderer.minGridDistance = 20;
        categoryAxis.renderer.labels.template.horizontalCenter = "right";
        categoryAxis.renderer.labels.template.verticalCenter = "middle";
        categoryAxis.tooltip.label.rotation = 270;
        categoryAxis.tooltip.label.horizontalCenter = "right";
        categoryAxis.tooltip.label.verticalCenter = "middle";

        let valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
        valueAxis.title.text = "Income";
        valueAxis.title.fontWeight = "bold";

// Create series
        var series = chart.series.push(new am4charts.ColumnSeries3D());
        series.dataFields.valueY = "income";
        series.dataFields.categoryX = "Date";
        series.name = "income";
        series.tooltipText = "{categoryX}: [bold]{valueY}[/]";
        series.columns.template.fillOpacity = .8;

        var columnTemplate = series.columns.template;
        columnTemplate.strokeWidth = 2;
        columnTemplate.strokeOpacity = 1;
        columnTemplate.stroke = am4core.color("#FFFFFF");

        columnTemplate.adapter.add("fill", function (fill, target) {
            return chart.colors.getIndex(target.dataItem.index);
        })

        columnTemplate.adapter.add("stroke", function (stroke, target) {
            return chart.colors.getIndex(target.dataItem.index);
        })

        chart.cursor = new am4charts.XYCursor();
        chart.cursor.lineX.strokeOpacity = 0;
        chart.cursor.lineY.strokeOpacity = 0;

    }); // end am4core.ready()
</script>


</body>
</html>