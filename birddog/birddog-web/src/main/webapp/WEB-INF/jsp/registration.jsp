<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="resources/jsp-js/emailIdVerification.js"></script>
<title>Insert title here</title>
<style type="text/css">
.tab td {
	border: 0;
}

#ReInvestor .form-group {
	height: 30px;
}
</style>
</head>
<body>
	<div class="container">
		<p style="color: red" align="center">${message}</p>
		<h2 style="text-align: center">ADD REAL STATE INVESTOR</h2>
		<div class="col-sm-6"
			style="border: solid 1px #BDBDBD; border-radius: 8px; padding: 31px; float: none; margin: 0 auto;">

			<form:form method="POST" action="saveRegistration" modelAttribute="ReInvestor" id="ReInvestor"  onsubmit="return jQuery(this).validationEngine('validate');">
				<p align="center">
					<span style="color: red; padding-left: 18px;" id="msg"></span>
				</p>
				<div class="form-group">
					<label class="control-label col-sm-3" for="email">Full Name:</label>
					<div class="col-sm-9">
						<form:input path="name" class="form-control validate[required] input-text" maxlength="30" id="name" placeholder="Enter Name" />

					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="email">Email:</label>
					<div class="col-sm-9">
						<form:input path="email" class="form-control validate[required,custom[email],maxSize[30]] input-text" maxlength="40" id="email" placeholder="Enter email"
							onblur="emailVarification(this);" />
						<form:hidden path="reiRole" value="1" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="pwd">ContactNo:</label>
					<div class="col-sm-9">
						<form:input path="contactNo" class=" form-control validate[required,custom[phone],minSize[10],maxSize[10]] input-text" id="ContactNo" maxlength="11" placeholder="Enter ContactNo" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="country">Product Version:</label>
					<div class="col-sm-9">
						<select class="form-control validate[required] input-text" name="version">
							<c:forEach items="${productVersions}" var="c">
								<option value="${c}" selected="selected">${c}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>