
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<html lang="en">
<head>

	<link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../../fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="../../css/util.css">
	<link rel="stylesheet" type="text/css" href="../../css/main.css">

	<%
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(new Date());
	%>
</head>
<body style="background-color: #666666; cursor: pointer">

<div class="limiter">
	<div class="container-login100">
		<div class="wrap-login100">

			<form class="login100-form validate-form" method="post" action="Dashboard">

					<span class="login100-form-title p-b-43" style="font-family: 'Arial Black';margin-top: 20px">
						Login to continue
					</span>

				<div class="wrap-input100 validate-input" data-validate = "Valid Id is required">
					<input class="input100" type="text" name="userId"/>
					<span class="focus-input100"></span>
					<span class="label-input100">User Id</span>
				</div>
				<div class="wrap-input100 validate-input" data-validate="Password is required">
					<input class="input100" type="password" name="password"  />
					<span class="focus-input100"></span>
					<span class="label-input100">Password</span>
				</div>
				<div class="flex-sb-m w-full p-t-3 p-b-32">
					<div class="contact100-form-checkbox">
						<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
						<label class="label-checkbox100" for="ckb1">
							Remember me
						</label>
					</div>
					<div>
						<a href="#" class="txt1">
							Forgot Password?
						</a>
					</div>
				</div>

				<div class="container-login100-form-btn">

					<button  class="login100-form-btn"> Login</button>
				</div>

				<div class="text-center p-t-46 p-b-20">
						<span class="txt2">SignIn as a Visitor
						</span>
				</div>

				<div class="login100-form-social flex-c-m">
					<a href="#" class="login100-form-social-item flex-c-m bg1 m-r-5">
						<i class="fa fa-facebook-f" aria-hidden="true"></i>
					</a>

					<a href="#" class="login100-form-social-item flex-c-m bg2 m-r-5">
						<i class="fa fa-twitter" aria-hidden="true"></i>
					</a>
				</div>
			</form>

			<div class="login100-more" style="background-image: url('../../images/login.png');">

			</div>
		</div>
	</div>
</div>

<script src="../../js/main.js"></script>

</body>
</html>