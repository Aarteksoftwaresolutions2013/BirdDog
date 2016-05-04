<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<style type="text/css">
.tab td{
	border:0;
}

#ReInvestor .form-group{
    height: 30px;
}
</style>

</head>
<body>
<div class="container">
		<p style="color: red" align="center">${success}</p>
		<h2 style="text-align: center">SEND MESSAGE</h2>
		<div class="col-sm-6"
			style="border: solid 1px #BDBDBD; border-radius: 8px; padding: 31px; float: none; margin: 0 auto;">

			<form:form method="POST" action="saveMessage" modelAttribute="message" id="ReInvestor" onsubmit="return jQuery(this).validationEngine('validate');">
				<p align="center">
					<span style="color: red; padding-left: 18px;" id="msg"></span>
				</p>
				<div class="form-group">
					<label class="control-label col-sm-3" for="email">Title:</label>
					<div class="col-sm-9">
						<form:input path="title" class="form-control validate[required] input-text" id="name" placeholder="Enter title" />

					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="email">Body:</label>
					<div class="col-sm-9">
						<form:input path="body" class="form-control validate[required] input-text" id="body" placeholder="Enter body"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						<button type="submit" class="btn btn-default">Send</button>
					</div>
				</div>
				<!-- <div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						<button type="cancel" class="btn btn-default">Cancel</button>
					</div>
				</div> -->
			</form:form>
		</div>
		</div>
</body>
</html>