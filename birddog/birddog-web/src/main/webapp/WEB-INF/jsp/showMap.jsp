<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
<script src="resources/jsp-js/map.js"></script>
<script src="resources/jsp-js/serchByName.js"></script>
<style type="text/css">
.txt{
	width: 100%;
}
.txt1{
width: 30%;
}
</style>
</head>
<body class="nav-md">
	<div class="container body">
	<form>
	<div class="form-group">
      <label class="control-label col-sm-3" for="email">Search By Birddog Name:</label>
      <div class="col-sm-9">
       <div class="col-sm-4">
        <input name="search" class="form-control txt"  id="search" placeholder="Enter Name" />
        </div>
        
        <div class="col-sm-offset-2 col-sm-4" style="margin-left: 0 !important;">
       <div class="form-group"> 
         <button type="button" class="btn btn-default" onclick="searchByBirddog()">Search</button><span style=" margin-left: 10px; color: red;" id="birddog"></span>
      </div>
     
      
    </div>
      </div>
      
    </div>
    <div class="form-group">
						<label class="col-lg-3 control-label" style="margin-right: 15px;">City:</label>
						<div class="col-lg-8">
							<div class="ui-select">
								<select id="cityId" class="form-control txt1 validate[required] input-text" onchange="searchByCity()">
									<c:forEach items="${city}" var="city">
										<option value="${city.id}">${city.cityName}</option>
											
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
    </form>
		<div class="main_container">
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12 bodySize">
							<div class="x_panel">
								<div class="x_title">
									<h2>All Property and location</h2>
									<div class="clearfix"></div>
								</div>
								<div id="dvMap" style="width: 1050px; height: 500px;"></div>
							</div>
						</div>
						<br /> <br /> <br />
					</div>
				</div>
				
				</div>
</body>
</html>