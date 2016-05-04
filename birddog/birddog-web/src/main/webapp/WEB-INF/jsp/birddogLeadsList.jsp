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
</head>
<body>
	<div class="container">
	
	<form:form method="POST" action="searchLeadByBirddogDate"
		modelAttribute="Lead" onsubmit="return jQuery(this).validationEngine('validate');">
    <div class="form-group">
      <label class="control-label col-sm-3" for="email">From Date:</label>
      <div class="col-sm-9">
        <form:input path="fromDate" type="date" class="form-control txt validate[required] input-text" id="name" placeholder="Enter Name"/></br>
      </div> 
      <label class="control-label col-sm-3" for="email">To Date:</label>
      <div class="col-sm-9">
        <form:input path="toDate" type="date" class="form-control txt validate[required] input-text" id="name" placeholder="Enter Name"/></br>
         <button type="submit" class="btn btn-default">Search</button>
        <div class="col-sm-offset-4 col-sm-10">
       
      </div>
      </div>
      
    </div>
    </form:form>
		<h2>LEADS</h2>
		<div class="table-responsive">
		<c:if test="${leads!=null}">
			<c:set var="count" value="0" scope="page" />
      <display:table name="leads" pagesize="4" class="table" uid="lead" requestURI="viewBirddogLeads">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
        <display:column title="Address">
        ${lead.address.address1}, ${lead.address.address2},${lead.address.city.cityName}, ${lead.address.city.county.countyName} 
        </display:column>
        <<display:column property="birddog.name" title="Uploaded By" />
           <display:column title="Owner" >
           ${lead.ownerFirstName} ${lead.ownerLastName}
           </display:column>
             <display:column property="creationTime" title="creationTime" />
               <display:column property="status" title="Status" />
        <display:column title="View">
          <a href="viewBirddogLead?leadId=${lead.id}"> <span class="glyphicon glyphicon-eye-open"></span>
							</a>
        </display:column>
        <display:column title="ARCHIVE">
          <a href="deleteLead?leadId=${lead.id}" onclick="return confirm('Please confirm if you want to ARCHIVE this lead!');">ARCHIVE</a>
						
        </display:column>
        <display:column title="Edit">
        <a href="updateBirddogLead?leadId=${lead.id}">Edit</a>
        </display:column>
      </display:table>
      </c:if>
      <c:if test="${birddogLeads!=null}">
      <c:set var="count" value="0" scope="page" />
      <display:table name="birddogLeads" pagesize="10" class="table" uid="lead" requestURI="searchLeadByBirddogDate">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
        <display:column title="Address">
        ${lead.address.address1}, ${lead.address.address2},${lead.address.city.cityName}, ${lead.address.city.county.countyName} 
        </display:column>
        <<display:column property="birddog.name" title="Uploaded By" />
           <display:column title="Owner" >
           ${lead.ownerFirstName} ${lead.ownerLastName}
           </display:column>
             <display:column property="creationTime" title="creationTime" />
               <display:column property="status" title="Status" />
        <display:column title="View">
          <a href="viewBirddogLead?leadId=${lead.id}"> <span class="glyphicon glyphicon-eye-open"></span>
							</a>
        </display:column>
        <display:column title="ARCHIVE">
          <a href="deleteLead?leadId=${lead.id}" onclick="return confirm('Please confirm if you want to ARCHIVE this lead!');">ARCHIVE</a>
						
        </display:column>
        <display:column title="Edit">
        <a href="updateBirddogLead?leadId=${lead.id}">Edit</a>
        </display:column>
      </display:table>
      </c:if>
		</div>
	</div>
</body>
</html>