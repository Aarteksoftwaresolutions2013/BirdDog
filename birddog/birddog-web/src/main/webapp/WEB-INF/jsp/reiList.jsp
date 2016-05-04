<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
.txt{
	width: 26%;
}
.table {
    width: 100%;
    border:2px solid #49A2C3;
    max-width: 100%;
    margin-bottom: 20px;
}
.table thead{
    background-color: #44A1D7;
    color: #fff;}


</style>
<script>
function myFunction() {
    var name = document.getElementById("name").value;
    var fdate = document.getElementById("fdate").value;
    var tdate = document.getElementById("tdate").value;
    if(name=="" && fdate =="" && tdate ==""){
    document.getElementById("demo").innerHTML = "please select atleast one field";
    return false;
      }else{
    	  return true;
      }
}
</script>
</head>
<body>
	<div class="container">
	<form:form method="POST" action="searchReiCreationDateByAdmin" modelAttribute="ReInvestor"  onsubmit="return myFunction();">
			<div class="form-group">
				<label class="control-label col-sm-3" for="email">Search By ReInvestor:</label>
				<div class="col-sm-9">
					<form:input path="search" class="form-control txt" id="name" placeholder="Enter Name" />
					</br>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3" for="email">From Date:</label>
				<div class="col-sm-9">
					<form:input path="fromDate" type="date" class="form-control txt" id="fdate" placeholder="Enter Name" />
					</br>
				</div>
				<label class="control-label col-sm-3" for="email">To Date:</label>
				<div class="col-sm-9">
					<form:input path="toDate" type="date" class="form-control txt" id="tdate" placeholder="Enter Name" /></br>
					</div>
					<div class="col-sm-offset-4 col-sm-10">
						
					</div>
						<label class="control-label col-sm-3" for="email"></label>
					<div class="col-sm-9">
					<button type="submit" class="btn btn-default">Search</button><span style="color: red;padding-left: 18px;" id="demo" align="left">
					</span>
				</div>
					

			</div>
			
		</form:form>
	<div style="color: red" align="center">${message}</div>
		<h2>RE-Investors</h2>
		<div class="table-responsive">
		<h3><b><A><div align="center">${records}</div></A></b></h3>
			<c:if test="${investors!=null}">
      <c:set var="count" value="0" scope="page" />
      <display:table name="investors" pagesize="10" class="table" uid="investor" requestURI="viewReiList">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
        <display:column property="name" title="Name" />
         <display:column property="contactNo" title="Contact No" />
           <display:column property="email" title="MailId" />
             <display:column property="address.city.cityName" title="City" />
               <display:column property="address.city.county.countyName" title="County" />
                <display:column property="address.city.county.state.stateName" title="State" />
        <display:column title="View">
          <a href="viewRei?reiId=${investor.id}"> <span class="glyphicon glyphicon-eye-open"></span>
							</a>
        </display:column>
        <display:column title="Delete">
         <a href="deleteInvestor?investorId=${investor.id}" onclick="return confirm('Please confirm if you want to delete this investor!');">Delete</a>
						
        </display:column>
      </display:table>
      </c:if> 
      <c:if test="${investorsList!=null}">
      <c:set var="count" value="0" scope="page" />
      <display:table name="investorsList" pagesize="10" class="table" uid="investor" requestURI="searchReiCreationDateByAdmin">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
        <display:column property="name" title="Name" />
         <display:column property="contactNo" title="Contact No" />
           <display:column property="email" title="MailId" />
             <display:column property="address.city.cityName" title="City" />
               <display:column property="address.city.county.countyName" title="County" />
                <display:column property="address.city.county.state.stateName" title="State" />
        <display:column title="View">
          <a href="viewRei?reiId=${investor.id}"> <span class="glyphicon glyphicon-eye-open"></span>
							</a>
        </display:column>
        <display:column title="Delete">
         <a href="deleteInvestor?investorId=${investor.id}" onclick="return confirm('Please confirm if you want to delete this investor!');">Delete</a>
						
        </display:column>
      </display:table>
      </c:if> 
		</div>
	</div>
</body>
</html>