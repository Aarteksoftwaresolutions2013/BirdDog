<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
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
</style>
</head>
<body>
	<div class="container">

		<div class="row">
			<h3 align="center">
				<A>BIRDDOG PROFILE</A>
			</h3>

			<div
				class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 tab toppad">
				<h5 align="center">
					<A>${message}</A>
				</h5>


				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">${birddog.name}</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3 col-lg-3 " align="center">
								<img alt="User Pic" src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png"
									class="img-circle img-responsive">
							</div>
							<div class=" col-md-9 col-lg-9 ">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>Name:</td>
											<td>${birddog.name}</td>
										</tr>
										<tr>
											<td>EmailId</td>
											<td>${birddog.email}</td>
										</tr>
										<tr>
											<td>ContactNo</td>
											<td>${birddog.contactNo}</td>
										</tr>

										<tr>
										<tr>
											<td>Address1</td>
											<td>${birddog.address.address1}</td>
										</tr>
										<tr>
											<td>Address2</td>
											<td>${birddog.address.address2}</td>
										</tr>
										<tr>
											<td>State</td>
											<td>${birddog.address.city.county.state.stateName}</td>
										</tr>
										<tr>
											<td>County</td>
											<td>${birddog.address.city.county.countyName}</td>
										</tr>
										<tr>
											<td>City</td>
											<td>${birddog.address.city.cityName}</td>
										</tr>

										<tr>
											<td>Zip Code</td>
											<td>${birddog.address.zipCode}</td>
										</tr>

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="panel-footer"></div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>