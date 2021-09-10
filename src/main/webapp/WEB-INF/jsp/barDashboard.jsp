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
    <%--Pie Chrat--%>
    <script src="https://www.amcharts.com/lib/4/core.js"></script>
    <script src="https://www.amcharts.com/lib/4/charts.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/moonrisekingdom.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
    <%--/Pie Chrat--%>

    <style>

        #chartdiv {
            position: relative;
            top: 40px;
            width: 100%;
            height: 400px;
        }

        #chartdiv1 {
            position: relative;
            top: 40px;
            width: 100%;
            height: 400px;
        }

        #chartdiv {
            width: 100%;
            height: 500px;
        }

        #chartdiv1 {
            width: 100%;
            height: 500px;
        }
        /*//////////////////////////////////////////////////////////////*/

        .containerx {
            display: inline-flex;

        }

        .btnq {
            border: 5px solid rgb(190, 175, 166);
            text-decoration: none;
            position: relative;
            overflow: hidden;
            height: 90px;
            width: 530px;
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
            background:linear-gradient(
                    120deg,
                    transparent,
                    rgba(64, 45, 34, 0.4),
                    transparent
            );
            transition: all .5s;
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
                    <h3>Bar Dashboard
                        <small>Hotel Sapphire Marriott</small>
                    </h3>
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

            <%--Button--%>
            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">

                <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <div class="containerx" >
                        <a style=" font-family: Playfair Display, Georgia, Times New Roman, serif;
                             background-color:#a98e77; color: #ffffff;font-weight: bolder"
                           href="bar" class="btnq"><h2
                                style="position: relative; letter-spacing: 1px;
                                     margin-top: 30px">Beverage</h2></a>
                    </div>
                    <br>
                </div>


                <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <div class="containerx" style="margin-left: 270px">
                        <a style=" font-family: Playfair Display, Georgia, Times New Roman, serif;
                             background-color:#a98e77; color: #ffffff;font-weight: bolder"
                           href="beverageStock" class="btnq"><h2
                                style="position: relative; letter-spacing: 1px;
                                     margin-top: 30px">Beverage Inventory</h2></a>
                    </div>
                    <br>
                </div>
            </div>
            <%--/Button--%>

            <%--///////////////////////////////////////////////////////////////////////////////////////////////////////////--%>

            <%--Chart Income--%>
            <%--Chart Today--%>
            <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">

                <div id="chartdiv"></div>
                <br>
                <P><h6>This Month Income</h6></P>
            </div>
            <%--/Chart Today--%>
            <%--Chart Yesterday--%>
            <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">

                <div id="chartdiv1"></div>
                <br>
                <P><h6>Last month Income</h6></P>
            </div>
            <%--/Chart Yesterday--%>
            <%--/Chart Income--%>

            <%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>


        </div>
    </div>
    <!-- /page content -->

    <!-- footer content -->
    <jsp:include page="footer.jsp"/>
    <!-- /footer content -->
</div>
</div>

<script src="https://www.amcharts.com/lib/4/themes/frozen.js"></script>
<%--Pie Chart 1--%>
<script>
    am4core.ready(function() {

// Themes begin
        am4core.useTheme(am4themes_frozen);
        am4core.useTheme(am4themes_animated);
// Themes end

// Create chart instance
        var chart = am4core.create("chartdiv", am4charts.XYChart3D);
        chart.paddingBottom = 30;
        chart.angle = 35;

// Add data
        chart.data = [{
            "Date": "week1",
            "Income": 334
        }, {
            "Date": "week2",
            "Income": 1882
        }, {
            "Date": "week3",
            "Income": 0
        }, {
            "Date": "week4",
            "Income": 0
        }, {
            "Date": "week5",
            "Income": 0
        },];

// Create axes
        var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
        categoryAxis.dataFields.category = "Date";
        categoryAxis.renderer.grid.template.location = 0;
        categoryAxis.renderer.minGridDistance = 20;
        categoryAxis.renderer.inside = true;
        categoryAxis.renderer.grid.template.disabled = true;

        let labelTemplate = categoryAxis.renderer.labels.template;
        labelTemplate.rotation = -90;
        labelTemplate.horizontalCenter = "left";
        labelTemplate.verticalCenter = "middle";
        labelTemplate.dy = 10; // moves it a bit down;
        labelTemplate.inside = false; // this is done to avoid settings which are not suitable when label is rotated

        var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
        valueAxis.renderer.grid.template.disabled = true;

// Create series
        var series = chart.series.push(new am4charts.ConeSeries());
        series.dataFields.valueY = "Income";
        series.dataFields.categoryX = "Date";

        var columnTemplate = series.columns.template;
        columnTemplate.adapter.add("fill", function(fill, target) {
            return chart.colors.getIndex(target.dataItem.index);
        })

        columnTemplate.adapter.add("stroke", function(stroke, target) {
            return chart.colors.getIndex(target.dataItem.index);
        })

    }); // end am4core.ready()
</script>
<%--/Chart 1--%>
<script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
<%--Chart 2--%>
<script>
    am4core.ready(function() {

// Themes begin
        am4core.useTheme(am4themes_spiritedaway);
        am4core.useTheme(am4themes_animated);
// Themes end

// Create chart instance
        var chart = am4core.create("chartdiv1", am4charts.XYChart3D);
        chart.paddingBottom = 30;
        chart.angle = 35;



// Add data
        chart.data = [{
            "Date": "week1",
            "Income": 334
        }, {
            "Date": "week2",
            "Income": 1882
        }, {
            "Date": "week3",
            "Income": 1809
        }, {
            "Date": "week4",
            "Income": 1322
        }, {
            "Date": "week5",
            "Income": 1122
        },];
// Create axes
        var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
        categoryAxis.dataFields.category = "Date";
        categoryAxis.renderer.grid.template.location = 0;
        categoryAxis.renderer.minGridDistance = 20;
        categoryAxis.renderer.inside = true;
        categoryAxis.renderer.grid.template.disabled = true;

        let labelTemplate = categoryAxis.renderer.labels.template;
        labelTemplate.rotation = -90;
        labelTemplate.horizontalCenter = "left";
        labelTemplate.verticalCenter = "middle";
        labelTemplate.dy = 10; // moves it a bit down;
        labelTemplate.inside = false; // this is done to avoid settings which are not suitable when label is rotated

        var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
        valueAxis.renderer.grid.template.disabled = true;

// Create series
        var series = chart.series.push(new am4charts.ConeSeries());
        series.dataFields.valueY = "Income";
        series.dataFields.categoryX = "Date";

        var columnTemplate = series.columns.template;
        columnTemplate.adapter.add("fill", function(fill, target) {
            return chart.colors.getIndex(target.dataItem.index);
        })

        columnTemplate.adapter.add("stroke", function(stroke, target) {
            return chart.colors.getIndex(target.dataItem.index);
        })

    }); // end am4core.ready()
</script>
<%--/Chart 2--%>

<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

</body>
</html>