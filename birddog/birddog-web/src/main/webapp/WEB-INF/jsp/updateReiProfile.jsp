<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="resources/jsp-js/lead.js"></script>
<script src="resources/jsp-js/imageupload.js"></script>
</head>
<body>
<form:form action="saveReiProfile" class="form-horizontal"
					role="form" modelAttribute="reInvestor"
					enctype="multipart/form-data" onsubmit="return jQuery(this).validationEngine('validate');">
	<div class="container" style="padding-top: 60px;">
		<div style="color: red" align="center">${message}</div>
		<h1 class="page-header">Edit Profile</h1>
		<div class="row">
			<!-- left column -->
			<div class="col-md-4 col-sm-6 col-xs-12">
				<div class="text-center">
					<img
						src="${image}" onerror="this.src='http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png'"
						class="avatar img-circle img-thumbnail" alt="avatar" id="output" >
					<h6>Upload a different photo...</h6>
					<input type="file" name="file"
						class="text-center center-block well well-sm" accept="image/*"
						onchange="loadFile(event)">
				</div>
			</div>
			<!-- edit form column -->
			<div class="col-md-8 col-sm-6 col-xs-12 personal-info">
				<!-- <div class="alert alert-info alert-dismissable">
					<a class="panel-close close" data-dismiss="alert">×</a> <i
						class="fa fa-coffee"></i> This is an <strong>.alert</strong>. Use
					this to show important messages to the user.
				</div> -->
				<h3>
					<A>Personal info</A>
				</h3>
				
					<div class="form-group">
						<label class="col-lg-3 control-label">Name:</label>
						<div class="col-lg-8">
							<form:input path="name" id="name" class="form-control validate[required] input-text"
								type="text" />
							<form:hidden path="id" />
							<form:hidden path="address.id" />

						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">Email</label>
						<div class="col-lg-8">
							<form:input path="email" id="email" class="form-control validate[required] input-text"
								disabled="true" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">ContactNo:</label>
						<div class="col-lg-8">
							<form:input path="contactNo" id="contactNo" class=" form-control validate[required,custom[phone],minSize[10],maxSize[10]] input-text" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">Address1:</label>
						<div class="col-lg-8">
							<form:input path="address.address1" class="form-control validate[required] input-text" value=""
								type="text" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">Address2:</label>
						<div class="col-lg-8">
							<form:input path="address.address2" class="form-control validate[required] input-text" value=""
								type="text" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">State:</label>
						<div class="col-lg-8">
							<div class="ui-select">
								<select id="stateId" class="form-control validate[funcCall[ifStateNotSelected]]">
									<option value="0">Your Location</option>
									<c:forEach var="state" items="${states}">
										<c:choose>
											<c:when
												test="${state.id==reInvestor.address.city.county.state.id}">
												<option selected="selected" value="${state.id}">${state.stateName}</option>
											</c:when>
											<c:otherwise>
												<option value="${state.id}">${state.stateName}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>


							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">County:</label>
						<div class="col-lg-8">
							<div class="ui-select">
								<select id="countyId" class="form-control validate[funcCall[ifCountyNotSelected]]">
									<option value="0">Your Location</option>
									<c:forEach items="${counties}" var="county">
										<c:choose>
											<c:when
												test="${county.id==reInvestor.address.city.county.id}">
												<option selected="selected" value="${county.id}">${county.countyName}</option>
											</c:when>
											<c:otherwise>
												<option value="${county.id}">${county.countyName}</option>
											</c:otherwise>

										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">City:</label>
						<div class="col-lg-8">
							<div class="ui-select">
								<select name="address.city.id" id="cityId" class="form-control validate[funcCall[ifCityNotSelected]]">
									<option value="0">Your Location</option>
									<c:forEach items="${cities}" var="city">
										<c:choose>
											<c:when test="${city.id==reInvestor.address.city.id}">
												<option selected="selected" value="${city.id}">${city.cityName}</option>
											</c:when>
											<c:otherwise>
												<option value="${city.id}">${city.cityName}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>

							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Zip code:</label>
						<div class="col-md-8">
							<form:input path="address.zipCode" class="form-control validate[required] input-text" />
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
</body>
</html>