<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<p style="color: red" align="center">${message}</p>
		<h2 style="text-align: center">Payment</h2>
		<div class="col-sm-9"
			style="border: solid 1px #BDBDBD; border-radius: 8px; padding: 31px; float: none; margin: 0 auto; height: 450px;">

			<form:form method="POST" action="saveAccountSettings" modelAttribute="accountSettings">

				<form:hidden path="id" />


				<div class="form-group">
					<label class="control-label col-sm-3" style="margin-top: 21px;">QS 1:</label>
					<div class="col-sm-9" style="margin-top: 14px;">
						<form:input path="qs1" class="form-control" placeholder="Enter Name" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" style="margin-top: 21px;" for="email">QS 2:</label>
					<div class="col-sm-9" style="margin-top: 14px;">
						<form:input path="qs2" class="form-control" placeholder="Enter Name" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" style="margin-top: 21px;" for="email">QS 3:</label>
					<div class="col-sm-9" style="margin-top: 14px;">
						<form:input path="qs3" class="form-control" placeholder="Enter Name" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" style="margin-top: 21px;" for="email">QS 4:</label>
					<div class="col-sm-9" style="margin-top: 14px;">
						<form:input path="qs4" class="form-control" placeholder="Enter Name" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" style="margin-top: 21px;" for="email">QS 5 and more:</label>
					<div class="col-sm-9" style="margin-top: 14px;">
						<form:input path="qs5AndMore" class="form-control" placeholder="Enter Name" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" style="margin-top: 21px;" for="email">Payment Interval:</label>
					<div class="col-sm-9" style="margin-top: 14px;">
						<form:select path="paymentInterval" class="form-control">
							<form:options items="${paymentIntervals}" />
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" style="margin-top: 21px;" for="email">Product level</label>
					<div class="col-sm-9" style="margin-top: 14px;">
						<%-- <form:input path="productlevel" class="form-control" placeholder="Enter Name" /> --%>
						<input type="text" value="${investor.version}" class="form-control" readonly="readonly" disabled="disabled" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10" style="margin-top: 14px;">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>