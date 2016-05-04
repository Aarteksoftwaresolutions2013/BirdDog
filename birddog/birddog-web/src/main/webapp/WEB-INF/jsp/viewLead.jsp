<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/jsp-css/viewbox.css">
<script src="resources/jsp-js/jquery.viewbox.js"></script>
<script src="resources/jsp-js/jquery.viewbox.min.js"></script>
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

pre.prettyprint.prettyprinted {
	padding: 10px 20px;
	border: 1px solid #ccc;
	margin: 0 0 40px;
}

dl {
	display: block;
	margin: 5px 0 20px;
	overflow: hidden;
}

dl>dt {
	display: block;
	clear: left;
	float: left;
	min-width: 160px;
}

.comm1{
    width: 48% !important;
    background-color: #DADADA;
    float: left;
    position:relative;
    padding: 9px 0px 0px 7px;
    border-radius: 10px;
}

.form-group.comm1:after {
   content: " ";
    border-left: solid 12px #DADADA;
    border-right: solid 12px rgba(0, 0, 0, 0);
    border-top: solid 17px rgba(0, 0, 0, 0);
    position: absolute;
    border-bottom: solid 17px rgba(0, 0, 0, 0);
    left: 24px;
    bottom: -13px;
}


.form-group.comm2:before {
       content: " ";
    /* border-left: solid 19px #DADADA; */
    border-right: solid 12px rgb(218, 218, 218);
    border-top: solid 12px rgba(0, 0, 0, 0);
    position: absolute;
    border-bottom: solid 16px rgba(0, 0, 0, 0);
    right: 25px;
    bottom: -13px;
}

.comm2{
    width: 48% !important;
    background-color: #DADADA;
    float: right;
    position:relative;
    padding: 9px 0px 0px 7px;
    border-radius: 10px;
}

.commContainer{
width: 100%;
    float: left;
    padding: 0px 20px;
}

.commUser{
	float: left;
    clear: both;
    font-size: 15px;
    font-weight: 600;
}

.commTitle{
	float: left;
    margin: 0px 10px;
}

.commDesc{
	float: left;
    clear: both;
    padding: 12px 24px;
}

dl>dd {
	display: block;
	float: left;
	margin: 0 0 20px 10px;
}
</style>
</head>
<body>
	<div class="container">

		<div class="row">
			<h3 align="center">
				<A>LEAD</A>
			</h3>

			<div
				class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 tab toppad">
				<h5 align="center">
					<A>${message}</A>
				</h5>


				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">${lead.birddog.name}</h3>
					</div>
					<div class="panel-body">
						<div class="row">

							<div class=" col-md-12 col-lg-12 ">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>Address:</td>
											<td>${lead.address.address1},${lead.address.address2},${lead.address.city.cityName},
												${lead.address.city.county.countyName}</td>
										</tr>
										<tr>
											<td>Price</td>
											<td>${lead.lastDatePrice}</td>
										</tr>
										<tr>
											<td>Property type</td>
											<td>${lead.propertyType}</td>
										</tr>
										<tr>
											<td>Uploaded By</td>
											<td>${lead.birddog.name}</td>
										</tr>
										<tr>
											<td>Owner</td>
											<td>${lead.ownerFirstName}&nbsp${lead.ownerLastName} </td>
										</tr>
										<tr>
											<td>Creation Time</td>
											<td>${lead.creationTime}</td>
										</tr>
										
										<tr>
											<td>Status</td>
											<td>${lead.status}</td>
										</tr>
										<tr>
											<td>Approval Status</td>
											<td>${lead.approval}</td>
										</tr>

										<tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="panel-footer"></div>
					<br>
					<hr>
					COMMENTS
					<hr>
					<c:forEach varStatus="count" items="${comments}" var="comment">
					<div class="commContainer">
						<div class="form-group comm${comment.userRole.userRoleId} ">
							<span class="commUser">${comment.userRole.userRoleId} </span>
							
							<span class="commTitle"> ${comment.commentTitle}</span>
							
							<span class="commDesc"> ${comment.commentDetails}</span>
							
						</div>
						</div>
					</c:forEach>

					<hr>
					<h4>&nbsp; ADD COMMENT</h4>
					<form:form action="addComment" modelAttribute="comment" onsubmit="return jQuery(this).validationEngine('validate');">
						<input type="hidden" name="lead.id" value="${lead.id}" />
						<div class="form-group">
							<form:label class="control-label col-sm-3" path="commentTitle">Title</form:label>
							<form:input class="form-control validate[required] input-text" maxlength="150" path="commentTitle" />
						</div>
						<div class="form-group">
							<form:label class="control-label col-sm-3" path="commentDetails">Detail</form:label>
							<form:textarea class="form-control validate[required] input-text"  path="commentDetails" maxlength="450"/>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-10">
								<button type="submit" class="btn btn-default">Submit</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>

		<div class="row">

			<div
				class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 tab toppad">
				<c:forEach items="${images}" var="images">
					<div class="col-xs-6 col-md-3 multipleimg">

						<a href="${images}" class="thumbnail" title="San Francisco"> <img src="${images}" alt="">
						</a>

					</div>
				</c:forEach>
			</div>

		</div>

	</div>
	<script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
	<script src="resources/jsp-js/jquery.viewbox.min.js"></script>
	<script>
		$(function() {

			$('.thumbnail').viewbox();
			$('.thumbnail-2').viewbox();

			(function() {
				var vb = $('.popup-link').viewbox();
				$('.popup-open-button').click(function() {
					vb.trigger('viewbox.open');
				});
				$('.close-button').click(function() {
					vb.trigger('viewbox.close');
				});
			})();

			(function() {
				var vb = $('.popup-steps').viewbox({
					navButtons : false
				});

				$('.steps-button').click(function() {
					vb.trigger('viewbox.open', [ 0 ]);
				});

				$('.next-button').click(function() {
					vb.trigger('viewbox.open', [ 1 ]);
				});
				$('.prev-button').click(function() {
					vb.trigger('viewbox.open', [ 0 ]);
				});
				$('.ok-button').click(function() {
					vb.trigger('viewbox.close');
				});
			})();

		});
	</script>
</body>
</html>