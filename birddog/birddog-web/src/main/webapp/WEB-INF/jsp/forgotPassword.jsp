<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="resources/jsp-js/jquery.validationEngine-en.js"></script>
<script src="resources/jsp-js/jquery.validationEngine.js"></script>
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
	<p style="color: red" align="center">${message} </p>
  <h2 style="text-align: center">FORGOT PASSWORD</h2>
  <div class="col-sm-6" style="border: solid 1px #BDBDBD;border-radius: 8px;padding: 31px; float:none;margin:0 auto;">
  
  <form:form method="POST" action="forgotPassword"
		modelAttribute="Login" id="ReInvestor" onsubmit="return jQuery(this).validationEngine('validate');">
		 <div class="form-group">
      <label class="control-label col-sm-3" for="email">Enter emailId:</label>
      <div class="col-sm-9">
        <form:input path="email" class="form-control validate[required,custom[email],maxSize[30]] input-text" maxlength="50" id="name" placeholder="Enter Name"/>
 
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-4 col-sm-10" align="left">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form:form>
   </div>
</div>
</body>
</html>