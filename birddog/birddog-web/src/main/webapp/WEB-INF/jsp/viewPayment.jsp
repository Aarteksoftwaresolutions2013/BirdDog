<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="width:300px;background-color: #FFFFFF">
	<h2 style="text-align:center">
		Type in title here</h2>
	<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post" name="paypal_form">
		<h3 style="text-align:center">
			<select name="a3" onclick="javascript: paypal_form.item_name.value=this.options[this.selectedIndex].text"><option value="${birddog}">One Time</option><option value="${birddog}">Month</option><option value="${birddog}">Year</option><option value="420">3 Years</option></select></h3>
		<p align="center">
			<input type="submit" value="Subscribe" /></p>
		<input name="cmd" type="hidden" value="_xclick-subscriptions" /> 
		<input name="business" type="hidden" value="paymerchant01@gmail.com"/> 
		<input name="item_name" type="hidden" value="" />
		<input name="no_note" type="hidden" value="1" /> 
		<input name="return" type="hidden" value="http://localhost:8080/birddog-web/viewBirddogs" />
		<input name="cancel_return" type="hidden" value="http://localhost:8080/birddog-web/viewBirddogs" /> 
		<input name="notify_url" type="hidden" value="http://localhost:8080/birddog-web/notifyPage" />
		<input name="rm" type="hidden" value="1" /> 
		<input name="currency_code" type="hidden" value="USD" />
		<input name="t3" type="hidden" value="M" /> 
		<input name="p3" type="hidden" value="1" />
		<input name="src" type="hidden" value="1" />
		<input name="sra" type="hidden" value="1" />
		</form>
</div>
</body>
</html>