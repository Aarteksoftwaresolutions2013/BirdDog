<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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

	<br>
	<br>


	<div class="container">

		<div class="row">
			<h3 align="center">
				<A>RE-Investor profile</A>
			</h3>

			<div
				class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 tab toppad">
				<h5 align="center">
					<A>${message}</A>
				</h5>


				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title"><label>${reInvestor.name}</label>
						&nbsp;&nbsp;&nbsp;&nbsp;<label>&nbsp;&nbsp; URL: &nbsp;&nbsp;</label><input value="${investorId}" style="width:300px "/></h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3 col-lg-3 " align="center">
								<img alt="User Pic" src="${image}" onerror="this.src='http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png'"
									class="img-circle img-responsive">
							</div>
							<div class=" col-md-9 col-lg-9 ">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>Name:</td>
											<td>${reInvestor.name}</td>
										</tr>
										<tr>
											<td>EmailId</td>
											<td>${reInvestor.email}</td>
										</tr>
										<tr>
											<td>ContactNo</td>
											<td>${reInvestor.contactNo}</td>
										</tr>

										<tr>
										<tr>
											<td>Address1</td>
											<td>${reInvestor.address.address1}</td>
										</tr>
										<tr>
											<td>Address2</td>
											<td>${reInvestor.address.address2}</td>
										</tr>
										<tr>
											<td>State</td>
											<td>${reInvestor.address.city.county.state.stateName}</td>
										</tr>
										<tr>
											<td>County</td>
											<td>${reInvestor.address.city.county.countyName}</td>
										</tr>
										<tr>
											<td>City</td>
											<td>${reInvestor.address.city.cityName}</td>
										</tr>

										<tr>
											<td>Zip Code</td>
											<td>${reInvestor.address.zipCode}</td>
										</tr>

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i
							class="glyphicon glyphicon-envelope"></i></a> <span class="pull-right"> <a
							href="reiProfile?reiId=${reInvestor.id}" data-original-title="Edit this user" data-toggle="tooltip" type="button"
							class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a> <a href="welcome"
							data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i
								class="glyphicon glyphicon-remove"></i></a>
						</span>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>