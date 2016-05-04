<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="resources/jsp-js/jquery.validationEngine-en.js"></script>
<script src="resources/jsp-js/jquery.validationEngine.js"></script>
<script src="resources/jsp-js/stateCityValidation.js"></script>

<link
	href="http://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700"
	rel="stylesheet" type="text/css">
<link href="resources/fonts/font-awesome.min.css" rel="stylesheet"
	type="text/css">


<link rel="stylesheet" href="resources/jsp-css/animate.css">
<link rel="stylesheet" href="resources/jsp-css/style.css">
</head>

<header class="site-header">
<div class="bottom-header">
	<div class="container">
		<a href="#" class="branding pull-left"> <img
			src="resources/images/Birddog1.png" width="200" alt="Site title"
			class="logo-icon">
		</a>
		<!-- #branding -->
		<nav class="main-navigation pull-right">
		<button type="button" class="menu-toggle">
			<i class="fa fa-bars"></i>
		</button>
		<ul class="menu">
			<li class="menu-item"><a href="welcome">Home</a></li>
			<li class="menu-item"><a href="viewReiList">View RE
					Investors</a></li>
			<li class="menu-item dropdown abt_p1"><a href=""
				class="dropdown-toggle" data-toggle="dropdown">Add Attachment<span
					class="fa fa-angle-down"></span></a>
				<ul class="dropdown-menu abt_p" role="menu">
					<li class="abt_p"><a href="tutorial"
						style="padding: 5px 10 !important; color: #fff !important;">Upload
							Tutorials</a></li>
					<li class="abt_p"><a href="pdf"
						style="padding: 5px 10 !important; color: #fff !important;">Upload
							Pdf</a></li>
					<li class="abt_p"><a href="software"
						style="padding: 5px 10 !important; color: #fff !important;">Upload
							Software</a></li>
				</ul></li>
			<!-- <li class="menu-item"><a href="tutorial">Tutorials</a></li> -->
			<li class="menu-item"><a href="registration">RE Investor
					registration</a></li>
			<li class="menu-item"><a href="showAdminChangePassword">Change
					Password</a></li>
			<li class="menu-item"><a href="javascript:formSubmit()">Logout</a></li>
		</ul>
		</nav>
		<!-- .main-navigation -->
	</div>
	<!-- .container -->
</div>
<!-- .bottom-header --> </header>
<!-- .site-header -->

<c:url value="/logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>

<script>
	$('ul.nav li.dropdown').bootstrapDropdownHover(methodName, parameter);
	$('ul.nav li.dropdown').hover(
			function() {
				$(this).find('.dropdown-menu').stop(true, true).delay(200)
						.fadeIn(500);
			},
			function() {
				$(this).find('.dropdown-menu').stop(true, true).delay(200)
						.fadeOut(500);
			});
</script>

</html>