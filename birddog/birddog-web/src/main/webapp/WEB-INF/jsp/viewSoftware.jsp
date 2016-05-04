<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.lable {
	color: #333;
	background-color: #EAE9E9;
	border-color: #ccc;
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 0;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	background-image: none;
	border: 1px solid rgba(0, 0, 0, 0.05);
	border-radius: 4px;
}

.user-row {
	margin-bottom: 14px;
}

.user-row:last-child {
	margin-bottom: 0;
}

.dropdown-user {
	margin: 13px 0;
	padding: 5px;
	height: 100%;
}

.dropdown-user:hover {
	cursor: pointer;
}

.table-user-information>tbody>tr {
	border-top: 1px solid rgb(221, 221, 221);
}

.table-user-information>tbody>tr:first-child {
	border-top: 9;
}

.table-user-information>tbody>tr>td {
	border-top: 0;
}

.toppad {
	margin-top: 20px;
}

.tab {
	width: 82% !important;
	float: none !important;
	margin: 30px auto !important;
}

pre.prettyprint.prettyprinted {
	padding: 10px 20px;
	border: 1px solid #ccc;
	margin: 0 0 40px;
}

dl {
	display: block;
	margin: 5px 0 20px;
	overflow: hidden;
}

dl>dt {
	display: block;
	clear: left;
	float: left;
	min-width: 160px;
}

.comm1 {
	width: 48% !important;
	background-color: #DADADA;
	float: left;
	position: relative;
	padding: 9px 0px 0px 7px;
	border-radius: 10px;
}

.form-group.comm1:after {
	content: " ";
	border-left: solid 12px #DADADA;
	border-right: solid 12px rgba(0, 0, 0, 0);
	border-top: solid 17px rgba(0, 0, 0, 0);
	position: absolute;
	border-bottom: solid 17px rgba(0, 0, 0, 0);
	left: 24px;
	bottom: -13px;
}

.form-group.comm2:before {
	content: " ";
	/* border-left: solid 19px #DADADA; */
	border-right: solid 12px rgb(218, 218, 218);
	border-top: solid 12px rgba(0, 0, 0, 0);
	position: absolute;
	border-bottom: solid 16px rgba(0, 0, 0, 0);
	right: 25px;
	bottom: -13px;
}

.comm2 {
	width: 48% !important;
	background-color: #DADADA;
	float: right;
	position: relative;
	padding: 9px 0px 0px 7px;
	border-radius: 10px;
}

.commContainer {
	width: 100%;
	float: left;
	padding: 0px 20px;
}

.commUser {
	float: left;
	clear: both;
	font-size: 15px;
	font-weight: 600;
}

.commTitle {
	float: left;
	margin: 0px 10px;
}

.commDesc {
	float: left;
	clear: both;
	padding: 12px 24px;
}

dl>dd {
	display: block;
	float: left;
	margin: 0 0 20px 10px;
}
</style>
</head>
<body>
		<div class="container">

				<div class="row">
						<h3 align="center">
							
						</h3>

						<div
								class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 tab toppad">
								<div class="panel panel-info">
										<div class="panel-heading"></div>
										<div class="panel-body">
												<div class="row">

														<div class=" col-md-12 col-lg-12 ">
																<table class="table table-user-information">
																		<h3 align="center">
																				<a href="uploadSoftware?roleId=1&type=default"><u>REI Software</u></a>
																		</h3>

																		<h3 align="center">
																				<a href="uploadSoftware?roleId=2&type=default"><u>Birddog Software</u></a>
																		</h3>
																</table>
														</div>
												</div>
										</div>


								</div>
						</div>
				</div>

		</div>
</body>
</html>