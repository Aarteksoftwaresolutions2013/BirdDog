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
<style>
.table {
    width: 75%;
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

		<div class="row">
			<h3 align="center">
				<A>View Video</A>
			</h3>
					<div class="panel-body">
						<div class="row">

							<div class=" col-md-12 col-lg-12 ">
								<div class="row" align="center">
						 <c:set var="count" value="0" scope="page" />
      <display:table name="tutorialList" pagesize="10" class="table" uid="tutorialList" requestURI="viewReiTutorialBySuperAdmin">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
        <div align="right"><display:column title="TITLE" >
        <a href="viewSingleTutorialBirddogByRei?tutorialId=${tutorialList.id}">${tutorialList.title}</a></td>
        </display:column></div>
        
      </display:table>
				</div>
							</div>
						</div>
					</div>
					
					
				</div>
			

		</div>
</body>
</html>