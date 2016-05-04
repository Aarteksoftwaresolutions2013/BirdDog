<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function selectall(){
	 var all=document.getElementById('all').checked;
	if(all){
		  $("input[type=checkbox]").each(function () {
              $(this).prop("checked", true);
          });
	}
	else {
        $("input[type=checkbox]").each(function () {
            $(this).prop("checked", false);
        });
    }
}
</script>

</head>
<body>
	<form:form action="sendMailToBirddog" class="form-horizontal"
		role="form" modelAttribute="SendMail" enctype="multipart/form-data" onsubmit="return jQuery(this).validationEngine('validate');">
		<div class="container" style="padding-top: 60px;">
			<div style="color: red" align="center">${message}</div>
			<div class="col-sm-6" style="margin: 0 auto;float: none !important;text-align:center"><h1 class="page-header" style="border: none !important;margin-right: 370px;">Send Mail</h1><hr style="width: 890px"></hr></div>
			<div class="row">
				<div class="col-sm-6 frmpadding" style="margin: 0 auto;float: none !important;">
					<h1 class="text-left">Compose New Message</h1>
					<div class="row">
						<div id="content" class="box">
							<div style="width: 100%; height: 200px; overflow: scroll;">
								<div>

									<br>
									<div>
										<input type="checkbox" id="all" onclick="selectall()" /> <label><b>To
												All</b></label> <br>
									</div>
									<c:forEach items="${birddogsList}" var="birddogsList">
										<div id="toMailId${birddogsList.id}">
											<form:checkbox path="toMailId" value="${birddogsList.email}" />
											<label><b>Name:</b> ${birddogsList.name} &nbsp;&nbsp;
												<b>Email Id:</b> ${birddogsList.email}</label> <br>
										</div>
									</c:forEach>
								</div>

							</div>
						</div>
						
					</div>
				</div>
			</div></br>
			<div class="row">
			<div class="form-group">
			<label class="control-label col-sm-3" for="email">Enter
				Subject:</label>
			<div class="col-sm-9">
				<form:input path="subject" type="text" class="form-control validate[required] input-text"
					placeholder="Enter Subject" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="pwd">Enter
				Message:</label>
			<div class="col-sm-9">
				<form:textarea path="body" class="form-control" rows="3"
					placeholder="Enter Message" maxlength="3000"></form:textarea>
				<form:hidden path="reiId" value="${reiId}" />
			</div>
		</div>
		<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-8">
							<input class="btn btn-primary" value="Send Mail" type="submit">
							<span></span><a href="cancel"><input class="btn btn-default"
								value="Cancel" type=""></a>

						</div>
					</div>
	
			</div>
			</div>
		

		
		
	</form:form>
</body>
</html>