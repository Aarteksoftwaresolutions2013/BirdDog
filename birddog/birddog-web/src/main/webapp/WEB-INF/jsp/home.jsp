<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style type="text/css">
#ReInvestor .form-group {
	height: 30px;
}
</style>
<script>
	$(function() {

		if (localStorage.chkbx && localStorage.chkbx != '') {
			$('#remember_me').attr('checked', 'checked');
			$('#username').val(localStorage.usrname);
			$('#pass').val(localStorage.pass);
		} else {
			$('#remember_me').removeAttr('checked');
			$('#username').val('');
			$('#pass').val('');
		}

		$('#remember_me').click(function() {

			if ($('#remember_me').is(':checked')) {
				// save username and password
				localStorage.usrname = $('#username').val();
				localStorage.pass = $('#pass').val();
				localStorage.chkbx = $('#remember_me').val();
			} else {
				localStorage.usrname = '';
				localStorage.pass = '';
				localStorage.chkbx = '';
			}
		});
	});
</script>
</head>
<body>
<br><br><br>
		<div class="container">
				<p style="color: red" align="center">${message}</p>
				<h2 style="text-align: center">LOGIN SCREEN</h2>
				<div class="col-sm-6"
						style="border: solid 1px #BDBDBD; border-radius: 8px; padding: 31px; float: none; margin: 0 auto;">
						<form name='loginForm' action="<c:url value='/login' />"
								method='POST' autocomplete="off" id="ReInvestor" onsubmit="return jQuery(this).validationEngine('validate');">
								<div class="form-group">
										<label class="control-label col-sm-3" for="email">Email
												ID:</label>
										<div class="col-sm-9">
												<input type='text' class="form-control validate[required,custom[email],maxSize[25]] input-text" maxlength="50" name='userName' id='username'
														placeholder="Username" />
										</div>
								</div>
								<div class="form-group">
										<label class="control-label col-sm-3" for="email">Password:</label>
										<div class="col-sm-9">
												<input type='password' class="form-control validate[required] input-text" maxlength="20" name='password' id="pass"
														placeholder="Password" />
										</div>
								</div>
								<div class="form-group">
										<div class="col-sm-offset-3 col-sm-10">
												<div class="checkbox">
														<label><input type="checkbox" value="remember-me" id="remember_me"> Remember me</label>
														&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<label><a
																href="showForgotPasswordPage"> forgot password</a></label>
												</div>
										</div>
								</div>
								<div class="form-group">
										<div class="col-sm-offset-3 col-sm-10">
												<input name="submit" type="submit" value="Sign In"
														class="btn btn-default" /> <input type="hidden"
														name="${_csrf.parameterName}" value="${_csrf.token}" />
										</div>
								</div>
						</form>
				</div>
		</div>
		<br><br><br>
</body>
</html>

