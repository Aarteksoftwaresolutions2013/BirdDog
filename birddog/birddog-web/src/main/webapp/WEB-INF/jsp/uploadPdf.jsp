<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.txt {
	width: 26%;
}

.table {
	width: 100%;
	border: 2px solid #49A2C3;
	max-width: 100%;
	margin-bottom: 20px;
}

.table thead {
	background-color: #44A1D7;
	color: #fff;
}
</style>
</head>
<body>

	<form:form method="POST" action="savePdf" class="form-horizontal"
		role="form" modelAttribute="UploadPdf"
		onsubmit="return jQuery(this).validationEngine('validate');"
		enctype="multipart/form-data">
		<div class="container" style="padding-top: 60px;">
			<div style="color: red" align="center">${message}</div>
			<h1 class="page-header">Upload Pdf</h1>
			<div class="row">
				<div class="form-group">
					<label class="col-lg-3 control-label">Title</label>
					<div class="col-lg-8">
						<form:input path="title" id="title"
							class="form-control validate[required] input-text"
							maxlength="150" />
						<form:hidden path="roleId" value="${roleId}" />
						<form:hidden path="type" value="${type}" />
						<form:hidden path="id" />
						<form:hidden path="fileType" value="pdf" />

					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Description:</label>
					<div class="col-lg-8">
						<form:textarea path="description"
							class="form-control validate[required] input-text" value=""
							type="text" style="height:114px;" maxlength="550" />

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-3 control-label">Upload Pdf:</label>
					<div class="col-md-8">
						<input type="file" name="file"
							class="form-control validate[required]" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label"></label>
					<div class="col-md-8">
						<input class="btn btn-primary" value="Save Changes" type="submit">
						<span></span><a href="cancel"><input class="btn btn-default"
							value="Cancel" type=""></a>

					</div>
				</div>

			</div>
		</div>
		</div>
	</form:form>
	<div class="container" style="padding-top: 60px;">

		<div class="row">
			<c:set var="count" value="0" scope="page" />
			<display:table name="pdfAndSWList" pagesize="10" class="table"
				uid="list" requestURI="uploadPdf">
				<c:set var="count" value="${count+1}" scope="page" />
				<display:column title="S.NO" style="width:1%;">
    				 ${count}
   				</display:column>
				<display:column title="TITLE">
					<a href="viewSinglePdfAndSW?id=${list.id}">${list.title}</a>
				</display:column>
				<display:column title="UPDATE">
					<a
						href="updateSuperAdminPdfAndSW?id=${list.id}&roleId=1&type=default&fileType=${list.fileType}">Update
					</a>
				</display:column>
				<display:column title="Delete">
					<a
						href="deleteSuperAdminPdfAndSW?id=${list.id}&roleId=1&type=default&fileType=${list.fileType}"
						onclick="return confirm('Please confirm if you want to delete this tutorial!');">Delete</a>

				</display:column>
			</display:table>
		</div>
	</div>

</body>
</html>
