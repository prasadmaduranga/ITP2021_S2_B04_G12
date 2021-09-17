<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/17/2021
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>

    <meta charset="utf-8">
    <title>Burger King - Food Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free Website Template" name="keywords">
    <meta content="Free Website Template" name="description">

    <!-- Favicon -->
    <link href="../../online/img/favicon.ico" rel="icon">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Nunito:600,700" rel="stylesheet">

    <!-- CSS Libraries -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="../../online/lib/animate/animate.min.css" rel="stylesheet">
    <link href="../../online/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="../../online/lib/flaticon/font/flaticon.css" rel="stylesheet">
    <link href="../../online/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="../../online/css/style.css" rel="stylesheet">
    <style>



        .table {
            border-collapse: collapse;
            width: 100%;
            border: 1px solid #ddd;
            text-align: left;
        }

        .thead-data {
            padding: 15px;
            border: 1px solid #ddd;
            text-align: left;

        }
        .menu.topp{
            display: flex;
            align-items: flex-end;
        }


    </style>

</head>
<body >

<!-- Nav Bar Start -->
<div class="navbar navbar-expand-lg bg-light navbar-light">
    <div class="container-fluid">
        <a href="index.html" class="navbar-brand">Burger <span>King</span></a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
            <div class="navbar-nav ml-auto">
                <a href="index.html" class="nav-item nav-link">Home</a>
                <a href="about.html" class="nav-item nav-link">About</a>
                <a href="feature.html" class="nav-item nav-link">Feature</a>
                <a href="team.html" class="nav-item nav-link">Chef</a>
                <a href="menu" class="nav-item nav-link active">Menu</a>
                <a href="booking.html" class="nav-item nav-link">Booking</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                    <div class="dropdown-menu">
                        <a href="blog.html" class="dropdown-item">Blog Grid</a>
                        <a href="single.html" class="dropdown-item">Blog Detail</a>
                    </div>
                </div>
                <a href="contact.html" class="nav-item nav-link">Contact</a>
            </div>
        </div>
    </div>
</div>
<!-- Nav Bar End -->

<!-- Page Header Start -->
<div class="page-header mb-0">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2>Food Menu</h2>
            </div>
            <div class="col-12">
                <a href="">Home</a>
                <a href="">Menu</a>
            </div>
        </div>
    </div>
</div>
<!-- Page Header End -->

<!-- Food Start -->
<div class="food mt-0">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-4">
                <div class="food-item">
                    <i class="flaticon-burger"></i>
                    <h2>Breakfast</h2>
                    <p>
                        Lorem ipsum dolor sit amet elit. Phasel nec pretium mi. Curabit facilis ornare velit non vulputa. Aliquam metus tortor auctor quis sem.
                    </p>
                    <a href="">View Menu</a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="food-item">
                    <i class="flaticon-snack"></i>
                    <h2>Lunch</h2>
                    <p>
                        Lorem ipsum dolor sit amet elit. Phasel nec pretium mi. Curabit facilis ornare velit non vulputa. Aliquam metus tortor auctor quis sem.
                    </p>
                    <a href="">View Menu</a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="food-item">
                    <i class="flaticon-cocktail"></i>
                    <h2>Dinner</h2>
                    <p>
                        Lorem ipsum dolor sit amet elit. Phasel nec pretium mi. Curabit facilis ornare velit non vulputa. Aliquam metus tortor auctor quis sem.
                    </p>
                    <a href="">View Menu</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Food End -->
<!-- Menu Start -->



<div class="menu">
    <div class="container">
        <div class="section-header text-center">
            <p>Food Menu</p>
            <h2>Delicious Food Menu</h2>
        </div>
        <div class="menu-tab">
            <ul class="nav nav-pills justify-content-center">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="pill" href="#burgers">Breakfast</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="pill" href="#snacks">Lunch</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="pill" href="#beverages">Dinner</a>
                </li>
            </ul>

            <div class="tab-content">
                <div id="burgers" class="container tab-pane active">
                    <div class="row">

                        <div class="col-lg-7 col-md-12">

                            <table id="dataTablesButton1" >

                                <c:forEach items="${loadAllFoods}" var="e">
                                    <c:if test="${e.itemCategory == 'Sandwiches' }">
                                        <tr class="menu-item">
                                            <td>
                                                <div class="menu-img">
                                                    <img src="${e.src}" alt="Image">
                                                </div>
                                            </td>
                                            <td class="menu-text" >
                                                <h3><span>${e.itemName}</span></h3>
                                            </td>
                                            <td class="menu-text" >
                                                <h3><strong style="padding-left:330px;">${e.unitePrice}</strong></h3>
                                            </td>

                                            <td style="bottom: 0;
  position: absolute;white-space:nowrap;top:40px;left:100px;">
                                                <p >${e.description}</p>
                                            </td>
                                            <td>

                                                <button id="btnAdd1"
                                                        style="width: 40px;height: 40px;background-color: #bbb7b7; border-radius: 5px;"
                                                        type="button"><i class="fa fa-plus"></i></button>
                                            </td>
                                                <%--                                        <td><br>Unite Price : ${e.unitePrice}</td>--%>
                                            <td style="display: none" >${e.itemId}</td>
                                            <td style="display: none" >${e.unitePrice}</td>
                                        </tr>

                                    </c:if>
                                </c:forEach>
                            </table>
                        </div>
                        <div class="col-lg-5 d-none d-lg-block">
                            <img src="../../online/img/menu-burger-img.jpg" alt="Image">
                        </div>
                    </div>
                </div>

                <div id="snacks" class="container tab-pane fade">
                    <div class="row">

                        <div class="col-lg-7 col-md-12">

                            <table id="dataTablesButton2">

                                <c:forEach items="${loadAllFoods}" var="e">
                                    <c:if test="${e.itemCategory == 'Appetizers' }">

                                        <tr class="menu-item">
                                            <td>
                                                <div class="menu-img">
                                                    <img src="${e.src}" alt="Image">
                                                </div>
                                            </td>

                                            <td class="menu-text" >
                                                <h3><span>${e.itemName}</span></h3>
                                            </td>
                                            <td class="menu-text" >
                                                <h3><strong style="padding-left:330px;">${e.unitePrice}</strong></h3>
                                            </td>
                                            <td style="bottom: 0;
  position: absolute;white-space:nowrap;top:40px;left:100px;">
                                                <p >${e.description}</p>
                                            </td>

                                            <td>

                                                <button id="btnAdd2"
                                                        style="width: 40px;height: 40px;background-color: #bbb7b7; border-radius: 5px"
                                                        type="button"><i class="fa fa-plus"></i></button>
                                            </td>
                                                <%--                                        <td><br>Unite Price : ${e.unitePrice}</td>--%>
                                            <td style="display: none" >${e.itemId}</td>
                                            <td style="display: none" >${e.unitePrice}</td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </table>
                        </div>
                        <div class="col-lg-5 d-none d-lg-block">
                            <img src="../../online/img/menu-burger-img.jpg" alt="Image">
                        </div>
                    </div>
                </div>


                <div id="beverages" class="container tab-pane fade">
                    <div class="row">

                        <div class="col-lg-7 col-md-12">

                            <table id="dataTablesButton3">

                                <c:forEach items="${loadAllFoods}" var="e">
                                    <c:if test="${e.itemCategory == 'Rice & Noodles' }">

                                        <tr class="menu-item">
                                            <td>
                                                <div class="menu-img">
                                                    <img src="${e.src}" alt="Image">
                                                </div>
                                            </td>
                                            <td class="menu-text" >
                                                <h3><span>${e.itemName}</span></h3>
                                            </td>
                                            <td class="menu-text" >
                                                <h3><strong style="padding-left:380px;">${e.unitePrice}</strong></h3>
                                            </td>

                                            <td style="bottom: 0;
  position: absolute;white-space:nowrap;top:40px;left:100px;">
                                                <p >${e.description}</p>
                                            </td>
                                            <td>

                                                <button id="btnAdd3"
                                                        style="width: 40px;height: 40px;background-color: #bbb7b7; border-radius: 5px"
                                                        type="button"><i class="fa fa-plus"></i></button>
                                            </td>
                                                <%--                                        <td><br>Unite Price : ${e.unitePrice}</td>--%>
                                            <td style="display: none" >${e.itemId}</td>
                                            <td style="display: none" >${e.unitePrice}</td>
                                        </tr>

                                    </c:if>
                                </c:forEach>
                            </table>
                        </div>
                        <div class="col-lg-5 d-none d-lg-block">
                            <img src="../../online/img/menu-burger-img.jpg" alt="Image">
                        </div>
                    </div>
                </div>


                <h1>Food Order</h1>
                <div class="row contact-form">
                    <div class="col-md-6">
                        <form >
                            <div class="control-group">
                                <label >Item Id</label>
                                <input  type="text" class="form-control"
                                        required="required" readonly name="itemId"
                                        id="itemCode" placeholder="Item Id"/>

                            </div>

                            <div class="control-group">
                                <label >Qty</label>
                                <input type="number" class="form-control"
                                       required="required" name="itemId"
                                       id="qty" placeholder="Item Qty"/>
                            </div>

                            <input type="hidden" class="form-control"
                                   required="required"readonly name="itemId"
                                   id="price" placeholder="Item Price"/>
                            <br>
                            <button type='button' class="btn custom-btn"
                                    id="btnAdd"
                                    value="Register">
                                Add
                            </button>
                        </form>
                    </div>

                    <div class="col-md-6">
                        <div id="success"></div>

                        <table class="table">
                            <thead class="thead-data">
                            <tr>
                                <th >ItemId</th>
                                <th >Name</th>
                                <th >Price</th>
                                <th >Qty</th>
                                <th >Total</th>
                                <th >Delete</th>
                            </tr>

                            </thead>
                            <tbody id="tblOrder" class="thead-data">
                            </tbody>
                        </table>
                    </div>

                </div>


            </div>
        </div>



        <%--    <form method="POST" action="saveOnlineOrder" name="saveOnlineOrder">--%>
        <%--        <input style="display: none" type="text" id="itemPay" name="orderData">--%>

        <%--        <button type="submit" value="Register" id="demo"--%>
        <%--                style="background-color: #63060a;color: white;height: 40px;--%>
        <%--                     margin-top: -32%;margin-left: 80%; font-weight: bold;color: #ffffff; width: 10%" onclick="getValue()"--%>
        <%--                class="col-1-1  btn btn-success button1x1 "> Pay <i class="fa fa-save"></i>--%>
        <%--        </button>--%>

        <%--    </form>--%>




    </div>
</div>

<!-- Footer Start -->
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-7">
                <div class="row">
                    <div class="col-md-6">
                        <div class="footer-contact">
                            <h2>Our Address</h2>
                            <p><i class="fa fa-map-marker-alt"></i>123 Street, New York, USA</p>
                            <p><i class="fa fa-phone-alt"></i>+012 345 67890</p>
                            <p><i class="fa fa-envelope"></i>info@example.com</p>
                            <div class="footer-social">
                                <a href=""><i class="fab fa-twitter"></i></a>
                                <a href=""><i class="fab fa-facebook-f"></i></a>
                                <a href=""><i class="fab fa-youtube"></i></a>
                                <a href=""><i class="fab fa-instagram"></i></a>
                                <a href=""><i class="fab fa-linkedin-in"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="footer-link">
                            <h2>Quick Links</h2>
                            <a href="">Terms of use</a>
                            <a href="">Privacy policy</a>
                            <a href="">Cookies</a>
                            <a href="">Help</a>
                            <a href="">FQAs</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-5">
                <div class="footer-newsletter">
                    <h2>Newsletter</h2>
                    <p>
                        Lorem ipsum dolor sit amet elit. Quisque eu lectus a leo dictum nec non quam. Tortor eu placerat rhoncus, lorem quam iaculis felis, sed lacus neque id eros.
                    </p>
                    <div class="form">
                        <input class="form-control" placeholder="Email goes here">
                        <button class="btn custom-btn">Submit</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="copyright">
        <div class="container">
            <p>Copyright &copy; <a href="#">Your Site Name</a>, All Right Reserved.</p>
            <p>Designed By <a href="https://htmlcodex.com">HTML Codex</a></p>
        </div>
    </div>
</div>


<!-- Footer End -->

<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="../../online/lib/easing/easing.min.js"></script>
<script src="../../online/lib/owlcarousel/owl.carousel.min.js"></script>
<script src="../../online/lib/tempusdominus/js/moment.min.js"></script>
<script src="../../online/lib/tempusdominus/js/moment-timezone.min.js"></script>
<script src="../../online/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

<!-- Contact Javascript File -->
<script src="../../online/mail/jqBootstrapValidation.min.js"></script>
<script src="../../online/mail/contact.js"></script>

<!-- Template Javascript -->
<script src="../../online/js/main.js"></script>
<script src="../../online/js/custom.js"></script>




<!-- jQuery -->
<%--<script src="../../vendors/jquery/dist/jquery.min.js"></script>--%>
<%--<script type="text/javascript"> Cufon.now(); </script>--%>

<script src="../../js/onlineOrders.js"></script>
<script src="../../js/onlineOrders2.js"></script>
<script src="../../js/onlineOrders3.js"></script>
</div>
</body>
</html>