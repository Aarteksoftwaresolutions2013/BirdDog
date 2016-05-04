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
<script src="resources/jsp-js/status.js"></script>
<script src="resources/jsp-js/approval.js"></script>
<style type="text/css">
.txt {
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
.color{
color: #FFF; 
}
</style>
<script type="text/javascript">

$(document).on("change", "#leadApproval", function(){
	
	if( $("#leadApproval").val()=='Pending'){
    $(this).css('background','#D2D221');
	}  
	else if( $("#leadApproval").val()=='Approved'){
	    $(this).css('background','#1CAF49');
		}
	else if( $("#leadApproval").val()=='Rejected'){
	    $(this).css('background','#FF0000');
		}
});
</script>
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
		<form:form method="POST" action="searchLeadByRei" modelAttribute="Lead"  onsubmit="return myFunction();">
			<div class="form-group">
				<label class="control-label col-sm-3" for="email">Search By Birddog:</label>
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
					<button type="submit" class="btn btn-default">Search</button><span style="color: red;padding-left: 18px;" id="demo" align="left"></span>
					<div class="col-sm-offset-4 col-sm-10">
						
					</div>
				</div>
			</div>
		</form:form>
		<h2>LEADS</h2>
		<div class="table-responsive">
			<div style="color: red" align="center">${message}</div>
		<%-- 	<table class="table">
				<thead>
					<tr>
						<th>S.No.</th>
						<th>Address</th>
						<th>Uploaded By</th>
						<th>Owner</th>
						<th>CreationTime</th>
						<th>Status</th>
						<th>ApprovalStatus</th>
						<th>View</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lead" items="${leads}" varStatus="count">
						<tr>
							<td>${count.index+1}</td>
							<td>${lead.address.address1},${lead.address.address2},${lead.address.city.cityName},
								${lead.address.city.county.countyName}</td>
							<td>${lead.birddog.name}</td>
							<td>${lead.ownerFirstName}${lead.ownerLastName}</td>
							<td>${lead.creationTime}</td>
							<td><select id="leadStatus" onchange="saveStatus(${lead.id},this.value)">
									<c:forEach items="${leadStatus}" var="status">
										<c:choose>
											<c:when test="${status==lead.status}">
												<option value="${status}" selected="selected">${status}</option>
											</c:when>
											<c:otherwise>
												<option value="${status}">${status}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select></td>
							<td><select id="leadApproval" style="background: #${lead.approvalStatusColour}; color: #FFF;"
								onchange="saveApproval(${lead.id},this.value)">
									<c:forEach items="${leadApproval}" var="approval">
										<c:choose>
											<c:when test="${approval==lead.approval}">
												<option value="${approval}" selected="selected">${approval}</option>
											</c:when>
											<c:otherwise>
												<option value="${approval}">${approval}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select></td>
							<td><a href="viewLead?leadId=${lead.id}"> <span class="glyphicon glyphicon-eye-open"></span>
							</a></td>
							<td><a href="deleteLead?leadId=${lead.id}"
								onclick="return confirm('Please confirm if you want to delete this lead!');">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table> --%>
			
			<c:if test="${leads!=null}">
			 <c:set var="count" value="0" scope="page" />
      <display:table name="leads" pagesize="10" class="table" uid="cat" requestURI="viewLeads">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
       <display:column title="Address" >
   ${cat.address.address1},${cat.address.address2},${cat.address.city.cityName},
								${cat.address.city.county.countyName}
       
       </display:column>
           <display:column property="birddog.name" title="Uploaded By" />
               <display:column title="Owner" >
               ${cat.ownerFirstName}${cat.ownerLastName}
               </display:column>
                <display:column property="creationTime" title="CreationTime" />
                <display:column title="Status" >
                <select id="leadStatus" onchange="saveStatus(${cat.id},this.value)">
									<c:forEach items="${leadStatus}" var="status">
										<c:choose>
											<c:when test="${status==cat.status}">
												<option value="${status}" selected="selected">${status}</option>
											</c:when>
											<c:otherwise>
												<option value="${status}">${status}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
				</select>
                </display:column>
                <display:column title="ApprovalStatus" >
                <select id="leadApproval" style="background: #${cat.approvalStatusColour}; color: #FFF;"
								onchange="saveApproval(${cat.id},this.value)">
									<c:forEach items="${leadApproval}" var="approval">
										<c:choose>
											<c:when test="${approval==cat.approval}">
												<option value="${approval}" selected="selected">${approval}</option>
											</c:when>
											<c:otherwise>
												<option value="${approval}">${approval}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>
                </display:column>
        <display:column title="View">
         <a href="viewLead?leadId=${cat.id}"> <span class="glyphicon glyphicon-eye-open"></span>
							</a></td>
        </display:column>
        <display:column title="ARCHIVE">
         <a href="deleteLead?leadId=${cat.id}"
								onclick="return confirm('Please confirm if you want to ARCHIVE this lead!');">ARCHIVE</a></td>
						
        </display:column>
      </display:table>
      </c:if>
      <c:if test="${searchLeads!=null}">
			 <c:set var="count" value="0" scope="page" />
      <display:table name="searchLeads" pagesize="10" class="table" uid="cat" requestURI="searchLeadByRei">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
       <display:column title="Address" >
   ${cat.address.address1},${cat.address.address2},${cat.address.city.cityName},
								${cat.address.city.county.countyName}
       
       </display:column>
           <display:column property="birddog.name" title="Uploaded By" />
               <display:column title="Owner" >
               ${cat.ownerFirstName}${cat.ownerLastName}
               </display:column>
                <display:column property="creationTime" title="CreationTime" />
                <display:column title="Status" >
                <select id="leadStatus" onchange="saveStatus(${cat.id},this.value)">
									<c:forEach items="${leadStatus}" var="status">
										<c:choose>
											<c:when test="${status==cat.status}">
												<option value="${status}" selected="selected">${status}</option>
											</c:when>
											<c:otherwise>
												<option value="${status}">${status}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
				</select>
                </display:column>
                <display:column title="ApprovalStatus" >
                <select id="leadApproval" style="background: #${cat.approvalStatusColour}; color: #FFF;"
								onchange="saveApproval(${cat.id},this.value)">
									<c:forEach items="${leadApproval}" var="approval">
										<c:choose>
											<c:when test="${approval==cat.approval}">
												<option value="${approval}" selected="selected">${approval}</option>
											</c:when>
											<c:otherwise>
												<option value="${approval}">${approval}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>
                </display:column>
        <display:column title="View">
         <a href="viewLead?leadId=${cat.id}"> <span class="glyphicon glyphicon-eye-open"></span>
							</a></td>
        </display:column>
        <display:column title="ARCHIVE">
         <a href="deleteLead?leadId=${cat.id}"
								onclick="return confirm('Please confirm if you want to ARCHIVE this lead!');">ARCHIVE</a></td>
						
        </display:column>
      </display:table>
      </c:if>
		</div>
	</div>
</body>
</html>