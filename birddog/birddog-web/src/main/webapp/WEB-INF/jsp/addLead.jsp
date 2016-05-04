<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="resources/jsp-js/lead.js"></script>
<script src="resources/jsp-js/popup.js"></script>


<title>Insert title here</title>
<style type="text/css">
.rig{
margin-left: -300px;
}

.tab td {
	border: 0;
}

.clr {
	clear: both;
}


.msgPopup {
	position: relative;
	padding: 16px;
	height: 131px;
	border-radius: 10px;
	text-align: center;
	margin: 186px auto;
	width: 399px;
	box-shadow: 0px 0px 15px 0px #6D6D6D;
	background-color: #FFF;
}

.msgPopupCont {
	position: fixed;
	top: 0px;
	left: 0;
	display: none;
	z-index: 9999999999999999999;
	background-color: rgba(68, 68, 68, 0.24);
	height: 800px;
	width: 100%;
}

.msgPopup button {
	float: right;
	margin-top: 0;
	height: 28px;
	width: 49px;
	padding: 0px 15px;
}

#ReInvestor .form-group {
	height: 30px;
}
float
:
 
none
;
</style>
<script type="text/javascript">
$( document ).ready(function() {
	<c:if test="${Lead.checkPhyIndicators==1}">
	$('.o5').prop("disabled",false); 
	$('.Phychange').text("Visual Signs"); 
	</c:if>
	<c:if test="${Lead.verifyPropertyOwnerIsPersion==1}">
	$('.o1').prop("disabled",false);
	</c:if>	
	<c:if test="${Lead.checkLastSaleDate==1}">
	$('.o2').prop("disabled",false);
	</c:if>	
	<c:if test="${Lead.checkLastSalePrice==1}">
	$('.o3').prop("disabled",false); 
	</c:if>
	<c:if test="${Lead.checkMotivation==1}">
	$('.o4').prop("disabled",false); 
	</c:if>
	<c:if test="${Lead.checkPerIndicators==1}">
	$('.o6').prop("disabled",false);
	$('.Perchange').text("Non-Visual Signs:");
	</c:if>
	<c:if test="${Lead.checkDrive==1}">
	$('.o7').prop("disabled",false);   
	</c:if>
	<c:if test="${Lead.propertyLeadType==1}">
	$("#dvPassport").show();
	</c:if>	
<c:forEach var="i" items="${phyIndicators}">
<c:if test="${i.equals('Overgrown Grass')}">
$('#phyOGG').prop('checked', true);
</c:if>
<c:if test="${i.equals('Roof Damage')}">
$('#phyRD').prop('checked', true);
</c:if>
<c:if test="${i.equals('Poor Exterior Condition')}">
$('#phyPEC').prop('checked', true);
</c:if>
<c:if test="${i.equals('Missing Mailbox')}">
$('#MM').prop('checked', true);
</c:if>
<c:if test="${i.equals('Boarded Windows')}">
$('#BW').prop('checked', true);
</c:if>
<c:if test="${i.equals('Stacked Newspapers/Notices at Door')}">
$('#SNN').prop('checked', true);
</c:if>
<c:if test="${i.equals('Tenant Move-out Debris')}">
$('#TMOD').prop('checked', true);
</c:if>


 
</c:forEach>

<c:forEach var="i" items="${perIndicators}">
<c:if test="${i.equals('Foreclosure')}">
$('#f').prop('checked', true);
</c:if>
<c:if test="${i.equals('Divorce')}">
$('#d').prop('checked', true);
</c:if>
<c:if test="${i.equals('Relocation')}">
$('#r').prop('checked', true);
</c:if>
<c:if test="${i.equals('Tired Landlord')}">
$('#t').prop('checked', true);
</c:if>
<c:if test="${i.equals('Short Sale')}">
$('#ss').prop('checked', true);
</c:if>
<c:if test="${i.equals('Down Sizing')}">
$('#ds').prop('checked', true);
</c:if>
<c:if test="${i.equals('Incomplete Rehab')}">
$('#inc').prop('checked', true);
</c:if>
<c:if test="${i.equals('Expired Listing')}">
$('#exp').prop('checked', true);
</c:if>
<c:if test="${i.equals('Probate')}">
$('#pr').prop('checked', true);
</c:if>
<c:if test="${i.equals('Inheritance')}">
$('#in').prop('checked', true);
</c:if>
<c:if test="${i.equals('Eviction')}">
$('#ev').prop('checked', true);
</c:if>
<c:if test="${i.equals('Storm Damage')}">
$('#st').prop('checked', true);
</c:if>
<c:if test="${i.equals('Excessive Repairs')}">
$('#ex').prop('checked', true);
</c:if>
</c:forEach>
$("#step2hide").hide();
$("#next2").on("click", function(){
    $("#step2hide").toggle();
    $("#step1hide").hide();
});

$("#step3hide").hide();
$("#next3").on("click", function(){
    $("#step3hide").toggle();
    $("#step2hide").hide();
});
$("#step4hide").hide();
$("#next4").on("click", function(){
    $("#step4hide").toggle();
    $("#step3hide").hide();
});
$("#step5hide").hide();
$("#next5").on("click", function(){
    $("#step5hide").toggle();
    $("#step4hide").hide();
   
});
$("#next41").on("click", function(){
    $("#step3hide").hide();
    $("#step2hide").toggle();
});

$("#next31").on("click", function(){
    $("#step2hide").hide();
    $("#step1hide").toggle();
});

$("#next51").on("click", function(){
    $("#step4hide").hide();
    $("#step3hide").toggle();
});

$("#next61").on("click", function(){
    $("#step5hide").hide();
    $("#step4hide").toggle();
});


});
</script>

</head>
<body>

		<div class="container">
				<p style="color: red" align="center">${message}</p>
				<h2 style="text-align: center">
						<b><u>LEAD VERIFICATION CHECKLIST</u></b>
				</h2>
				<div class="col-sm-8"
						style="border: solid 1px #BDBDBD; border-radius: 8px; padding: 31px; float: none; margin: 0 auto;">
						<form:form method="POST" action="saveLead" modelAttribute="Lead" id="ReInvestor" enctype="multipart/form-data"
								onsubmit="return jQuery(this).validationEngine('validate');">
								<span id="step1hide">
								<H2>
										<b>STEP #1 <u>Google Property Address to verify the following:</u></b>
								</H2>
								<hr>

								<div class="form-group">
										<label class="control-label col-sm-3" for="address">Address:</label>
										<div class="col-sm-9">
												<form:input path="address.address1" class="form-control validate[required] input-text" id="address"
														placeholder="Enter address" maxlength="300" />
												<form:hidden path="id" />
										</div>
								</div>
								<form:hidden path="address.id" />
								<div class="form-group">
										<label class="control-label col-sm-3" for="country">State:</label>
										<div class="col-sm-9">
												<select id="stateId" class="form-control validate[funcCall[ifStateNotSelected]]">
														<option value="0">Select State</option>
														<c:forEach items="${states}" var="c">
																<c:choose>
																		<c:when test="${c.id==Lead.address.city.county.state.id}">
																				<option value="${c.id}" selected="selected">${c.stateName}</option>
																		</c:when>
																		<c:otherwise>
																				<option value="${c.id}">${c.stateName}</option>
																		</c:otherwise>
																</c:choose>
														</c:forEach>
												</select>
										</div>
								</div>
								<div class="form-group">
										<label class="control-label col-sm-3" for="state">County:</label>
										<div class="col-sm-9">
												<select id="countyId" class="form-control validate[required] input-text">
														<c:forEach items="${counties}" var="county">
																<c:choose>
																		<c:when test="${county.id==Lead.address.city.county.id}">
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
								<div class="form-group">
										<label class="control-label col-sm-3" for="city">City:</label>
										<div class="col-sm-9">
												<form:select path="address.city.id" id="cityId" class="form-control validate[required] input-text">
														<c:forEach items="${cities}" var="city">
																<c:choose>
																		<c:when test="${city.id==Lead.address.city.id}">
																				<option selected="selected" value="${city.id}">${city.cityName}</option>
																		</c:when>
																		<c:otherwise>
																				<option value="${city.id}">${city.cityName}</option>
																		</c:otherwise>
																</c:choose>
														</c:forEach>
												</form:select>
										</div>
								</div>
								<div class="form-group">
										<label class="control-label col-sm-3" for="zipCode">Zip code:</label>
										<div class="col-sm-9">
												<form:input path="address.zipCode" class="form-control validate[required] input-text" id="zipCode"
														placeholder="Enter zip code" maxlength="8" />
										</div>
								</div>

								<div class="form-group">
										<div class="col-sm-offset-0 col-sm-12">
												<div class="checkbox" style="color: green;">
														<c:if test="${Lead.notListedWithRealtor==1}">
														<label style="">
																		<div class="msgPopupCont">
																				<div class="msgPopup">
																						<div id="ppContent"></div>
																						<br>
																						<br>
																						<button type="button" class="btn btn-default ppClose">Ok</button>
																				</div>
																		</div> <form:checkbox path="notListedWithRealtor" checked="checked" value="1" id="notListed"/>Property NOT
																		LISTED with a REALTOR

																</label>
														</c:if>
														<c:if test="${Lead.notListedWithRealtor!=1}">
																<label style="">
																		<div class="msgPopupCont">
																				<div class="msgPopup">
																						<div id="ppContent"></div>
																						<br>
																						<br>
																						<button type="button" class="btn btn-default ppClose">Ok</button>
																				</div>
																		</div> <form:checkbox path="notListedWithRealtor" value="1" id="notListed" />Property NOT LISTED with a
																		REALTOR

																</label>
														</c:if>
												</div>
										</div>
								</div>
								<div class="form-group">
										<div class="col-sm-offset-0 col-sm-12">
												<div class="checkbox" style="color: green;">
														<c:if test="${Lead.notListedAnyTypeAuctions==1}">
																<label><form:checkbox path="notListedAnyTypeAuctions" checked="checked" value="1" id="auctions"/>Property
																		NOT LISTED for any type of Auctions(Hubzu, Auction.com, Auction Company))</label>
														</c:if>
														<c:if test="${Lead.notListedAnyTypeAuctions!=1}">
																<label><form:checkbox path="notListedAnyTypeAuctions" value="1" id="auctions" />Property NOT
																		LISTED for any type of Auctions(Hubzu, Auction.com, Auction Company))</label>
														</c:if>
												</div>
										</div>
								</div>
								<br>
								<br>
								
								
								<div class="form-group">
										<div class="col-sm-offset-5 col-sm-10">
												<button type="button" class="btn btn-default" style="margin-left: 307px;" id="next2" >Next</button>
										</div>
								</div>
								</span>
								<span id="step2hide">
								<H2>
										<b>STEP #2 <u>Go to County Property Appraiser Site the Property is Located to verify:</u></b>
								</H2>
								
								<hr>
								<div style="color: green;">(Note: If you want to fill the data so first click on checkbox)</div></br>
								<div class="form-group">
								
										<div class="col-sm-offset-0 col-sm-12">
										
										
												<div class="checkbox" style="color: green;">
														<c:if test="${Lead.verifyPropertyOwnerIsPersion==1}">
																<label><form:checkbox path="verifyPropertyOwnerIsPersion" checked="checked" value="1" id="per"/>Verify
																		Property Owner is a PERSON, not a Corporation, (a Trust is ok!)</label>
														</c:if>
														<c:if test="${Lead.verifyPropertyOwnerIsPersion!=1}">
																<label><form:checkbox path="verifyPropertyOwnerIsPersion" value="1" id="per"/>Verify Property
																		Owner is a PERSON, not a Corporation, (a Trust is ok!)</label>
														</c:if>
												</div>
										</div>
								</div>
								
								
								
								
								<div class="con1" >
								
								
								
								<div class="form-group">
										<label class="control-label col-sm-3" for="address">Owner First Name:</label>
										<div class="col-sm-9">
												<form:input path="ownerFirstName" id="fname" class="form-control validate[required] input-text o1"
														placeholder="Enter owner first name" maxlength="80" disabled="true" />
										</div>
								</div>
								<div class="form-group">
										<label class="control-label col-sm-3" for="address">Owner Last Name:</label>
										<div class="col-sm-9">
												<form:input path="ownerLastName" id="lName" class="form-control validate[required] input-text o1"
														placeholder="Enter owner last name" maxlength="80" disabled="true" />
										</div>
								</div>
								<div class="form-group">
										<label class="control-label col-sm-3" for="city">Property Type:</label>
										<div class="col-sm-9">
												<form:select path="propertyType" id="proType" class="form-control validate[required] input-text o1"
														disabled="true">
														<option value="">Select</option>
														<c:forEach items="${propertyType}" var="propertyType">
																<c:choose>
																		<c:when test="${propertyType== Lead.propertyType}">
																				<option value="${propertyType}" selected="selected">${propertyType}</option>
																		</c:when>
																		<c:otherwise>
																				<option value="${propertyType}">${propertyType}</option>
																		</c:otherwise>
																</c:choose>
														</c:forEach>
												</form:select>
										</div>
								</div>
								<div class="form-group">
										<label class="control-label col-sm-3" for="city">Construction Type:</label>
										<div class="col-sm-9">
												<form:select path="constructionType" id="consType"
														class="form-control validate[funcCall[ifConstructionTypeNotSelected]] o1" disabled="true">
														<option value="0">Select</option>
														<c:forEach items="${constructionType}" var="consType">
																<c:choose>
																		<c:when test="${consType== Lead.constructionType}">
																				<option value="${consType}" selected="selected">${consType}</option>
																		</c:when>
																		<c:otherwise>
																				<option value="${consType}">${consType}</option>
																		</c:otherwise>
																</c:choose>
														</c:forEach>
												</form:select>
										</div>
								</div>
								<div class="form-group">
										<label class="control-label col-sm-3" for="city">Roof Construction Type:</label>
										<div class="col-sm-9">
												<form:select path="roofConstructionType" id="roofConstructionType"
														class="form-control validate[funcCall[ifRoofConstructionTypeNotSelected]] o1" disabled="true">
														<option value="0">Select</option>
														<c:forEach items="${roofConstructionType}" var="roofCons">
																<c:choose>
																		<c:when test="${roofCons== Lead.roofConstructionType}">
																				<option value="${roofCons}" selected="selected">${roofCons}</option>
																		</c:when>
																		<c:otherwise>
																				<option value="${roofCons}">${roofCons}</option>
																		</c:otherwise>
																</c:choose>
														</c:forEach>
												</form:select>
										</div>
								</div>
								<div class="form-group">
										<label class="control-label col-sm-3" for="address">Sq FootUnder Air:</label>
										<div class="col-sm-9">
												<form:input path="sqFootUnderAir" id="footUnder" class="form-control validate[required] input-text number o1"
														placeholder="Enter sq footunder air" maxlength="80" disabled="true" />
										</div>
								</div>
								<div class="form-group">
										<label class="control-label col-sm-3" for="address">Pool:</label>
										<div class="col-sm-9">
												<form:select path="pool" id="pool" class="form-control validate[funcCall[ifPoolNotSelected]] o1"
														disabled="true">
														<option value="0">Select</option>
														<c:forEach items="${pool}" var="pool">
																<c:choose>
																		<c:when test="${pool== Lead.pool}">
																				<option value="${pool}" selected="selected">${pool}</option>
																		</c:when>
																		<c:otherwise>
																				<option value="${pool}">${pool}</option>
																		</c:otherwise>
																</c:choose>
														</c:forEach>
														<!-- <option value="Y">Yes</option>
														<option value="N">No</option> -->
												</form:select>

										</div>
								</div>
								
								<div class="form-group">
										<label class="control-label col-sm-3" for="city">Built year:</label>
										<div class="col-sm-9">
<%-- 
												<input type="number" name="builtyear" id="bYear" class="form-control validate[required] input-text"
														value="${Lead.builtyear}" min="1900" max="2016" disabled="true" /> --%>
														
														<form:select path="builtyear" id="bYear" class="form-control validate[funcCall[ifbYearNotSelected]] o1"
														disabled="true">
														<option value="0">Select</option>
														<c:forEach items="${builtyear}" var="builtyear">
																<c:choose>
																		<c:when test="${builtyear== Lead.builtyear}">
																				<option value="${builtyear}" selected="selected">${builtyear}</option>
																		</c:when>
																		<c:otherwise>
																				<option value="${builtyear}">${builtyear}</option>
																		</c:otherwise>
																</c:choose>
														</c:forEach>
												</form:select>
												<%-- <form:select path="builtyear" class="form-control">
							<option value="0">Select</option>
							<c:forEach items="${builtyear}" var="builtyear">
								<c:choose>
									<c:when test="${builtyear== Lead.builtyear}">
										<option value="${builtyear}" selected="selected">${builtyear}</option>
									</c:when>
									<c:otherwise>
										<option value="${builtyear}">${builtyear}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<!-- <option value="2015">2015</option>
														<option value="2016 ">2016</option> -->
						</form:select> --%>
										</div>
								</div>
								<div class="form-group">
										<label class="control-label col-sm-3" for="address">Sq footage under air:</label>
										<div class="col-sm-9">
												<form:input path="sqFootageUnderAir" id="under" class="form-control validate[required] input-text number o1"
														placeholder="Enter sq footage under air" maxlength="20" disabled="true" />
										</div>
								</div>
								<div class="form-group">
										<label class="control-label col-sm-3" for="address">Number Of bed rooms:</label>
										<div class="col-sm-9">
												<form:select path="numberOfOBedrooms" id="bedRooms" class="form-control validate[funcCall[ifbedRoomsNotSelected]] o1" disabled="true">
												        <option value="0">Select</option>
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
														<option value="4">4</option>
														<option value="5">5</option>
														<option value="6">6</option>
														<option value="7">7</option>
														<option value="8">8</option>
														<option value="9">9</option>
														
												</form:select>

										</div>
								</div>
								
							
								<div class="form-group">
										<label class="control-label col-sm-3" for="address">Number Of bath rooms:</label>
										<div class="col-sm-9">
												<form:select path="numberOfBathRooms" id="bathRooms" class="form-control validate[funcCall[ifbathRoomsNotSelected]] o1" disabled="true">
												        <option value="0">Select</option>
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
														<option value="4">4</option>
														<option value="5">5</option>
														<option value="6">6</option>
														<option value="7">7</option>
														<option value="8">8</option>
														<option value="9">9</option>
														
												</form:select>

										</div>
								</div>
								</div>
								<%-- 	<div class="form-group">
					<label class="control-label col-sm-3" for="address">Obtain Last sale date</label>
					<div class="col-sm-9">
						<form:input path="lastSaleDate" type="date" class="form-control" id="name" placeholder="Enter last sale price" />
						</br>
					</div>
				</div> --%>
                             <div class="con2">
								<div class="form-group">
										<div class="col-sm-offset-0 col-sm-12">
												<div class="checkbox" style="color: green;">
														<label><form:checkbox path="checkLastSaleDate" value="1" id="lastDate" />Obtain Last sale date</label>
														<c:if test="${Lead.verifyPropertyOwnerIsPersion==1}">
																<form:input path="lastSaleDate" type="date" id="saleDate" class="form-control validate[required] input-text o2" checked="checked"
																		placeholder="Enter last sale price" />
														</c:if>
														<c:if test="${Lead.verifyPropertyOwnerIsPersion!=1}">
																<form:input path="lastSaleDate" type="date" id="saleDate"
																		class="form-control validate[required] input-text o2" placeholder="Enter last sale price" disabled="true" />
														</c:if>
												</div>
										</div>
								</div>
</div>
                              <div class="con3">

								<div class="form-group">
										<div class="col-sm-offset-0 col-sm-12">
												<div class="checkbox" style="color: green;">
														<label><form:checkbox path="checkLastSalePrice" value="1" id="lastPrice" />Obtain Last sale price:
														</label>
														<c:if test="${Lead.lastDatePrice==1}">
														
																<form:input path="lastDatePrice" id="lPrice" class="form-control validate[required] input-text o3 number " checked="checked"
																placeholder="Enter last sale price" maxlength="20" />
														</c:if>
														<c:if test="${Lead.lastDatePrice!=1}">
																<form:input path="lastDatePrice" id="lPrice" class="form-control validate[required] input-text o3 number "
																placeholder="Enter last sale price" maxlength="20" disabled="true" />
														</c:if>
														
												</div>
										</div>
								</div>
								
								</div>
								
								

								<br>
								<%-- 	<div class="form-group">
					<label class="control-label col-sm-3" for="address">Obtain Last sale price:</label>
					<div class="col-sm-9">
						<form:input path="lastDatePrice" class="form-control" placeholder="Enter last sale price" />

					</div>
				</div> --%>
								<br>
								<br>
								<div class="form-group">
										<div class="col-sm-offset-0 col-sm-12">
										<button type="button" class="btn btn-default" style="float: left;" id="next31">Back</button>
										<button type="button" class="btn btn-default" style="float: right" id="next3">Next</button>
										</div>
								</div>
								</span>
								<span id="step3hide">
								<H2>
										<b>STEP #3</b>
								</H2>
								<hr>
								<div class="form-group">
										<div class="col-sm-offset-0 col-sm-12">
												<div class="checkbox">
														<c:if test="${Lead.propertyLeadType==1}">
																<label for="chkPassport"><form:checkbox path="propertyLeadType" checked="checked" value="1"
																				id="chkPassport" />Is this Property Lead is from Craigslist/Internet, FSBO(For Sale by Owner), or
																		Bandit Sign(Y/N)</label>
														</c:if>
														<c:if test="${Lead.propertyLeadType!=1}">
																<label for="chkPassport"><form:checkbox path="propertyLeadType" value="1" id="chkPassport" />Is
																		this Property Lead is from Craigslist/Internet, FSBO(For Sale by Owner), or Bandit Sign(Y/N)</label>
														</c:if>
												</div>
										</div>
								</div>
								<div id="dvPassport" style="display: none">
										<div class="form-group">
												<div class="col-sm-offset-0 col-sm-12">
														<div class="checkbox" style="color: green;">
																<c:if test="${Lead.ownerVerification==1}">
																		<label><form:checkbox path="ownerVerification" checked="checked" value="1" id="wholeseller"/>You MUST have
																				spoken to the verified OWNER in step#2, NO WHOLESALERS!</label>
																</c:if>
																<c:if test="${Lead.ownerVerification!=1}">
																		<label><form:checkbox path="ownerVerification" value="1" id="wholeseller" />You MUST have
																				spoken to the verified OWNER in step#2, NO WHOLESALERS!</label>
																</c:if>
														</div>
												</div>
										</div>

										<%-- 		<div class="form-group">
						<label class="control-label col-sm-3">Seller Motivation:</label>
						<div class="col-sm-9">
							<form:select path="sellerMotivation" class="form-control">
								<option value="0">Select</option>
								<c:forEach items="${sellerMotivation}" var="sellerMotivation">
									<c:choose>
										<c:when test="${sellerMotivation== Lead.sellerMotivation}">
											<option value="${sellerMotivation}" selected="selected">${sellerMotivation}</option>
										</c:when>
										<c:otherwise>
											<option value="${sellerMotivation}">${sellerMotivation}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
						</div>
					</div> --%>
<div class="con4">
										<div class="form-group">
												<div class="col-sm-offset-0 col-sm-12">
														<div class="checkbox" style="color: green;">
																<label><form:checkbox path="checkMotivation" value="1" id="motivation" />You MUST identify the
																		Seller’s Motivation:</label>
																<form:select path="sellerMotivation" id="sellMov" class="form-control validate[funcCall[ifSellerNotSelected]] o4"
																		onmousedown="return myMotivation(this)" disabled="true">
																		<option value="0">Select</option>
																		<c:forEach items="${sellerMotivation}" var="sellerMotivation">
																				<c:choose>
																						<c:when test="${sellerMotivation== Lead.sellerMotivation}">
																								<option value="${sellerMotivation}" selected="selected">${sellerMotivation}</option>
																						</c:when>
																						<c:otherwise>
																								<option value="${sellerMotivation}">${sellerMotivation}</option>
																						</c:otherwise>
																				</c:choose>
																		</c:forEach>
																</form:select>
														</div>
												</div>
										</div>
									</div>
								</div>
								<br>
								<br>
								
								<div class="form-group">
										<div class="col-sm-offset-0 col-sm-12">
										<button type="button" class="btn btn-default" style="float: left;" id="next41">Back</button>
												<button type="button" class="btn btn-default" style="float: right;" id="next4">Next</button>
										</div>
								</div>
								</span>
								<span id="step4hide">
								<H2>
										<b>STEP #4 <u>Motivated Seller Indicators: (Check which Box Applies Below)</u></b>
								</H2>
								
								<hr>
								<%-- <div class="form-group">
					<div class="col-sm-offset-0 col-sm-12">
						<label class="control-label ">Physical Property Indicators:</label> <label> <form:checkbox
								path="physicalPropertyIndicators" id="phyOGG" value="Overgrown Grass" /> Overgrown Grass
						</label> <label> <form:checkbox path="physicalPropertyIndicators" id="phyRD" value="Roof Damage" /> Roof Damage
						</label> <label> <form:checkbox path="physicalPropertyIndicators" id="phyPEC" value="Poor Exterior Condition" />
							Poor Exterior Condition
						</label>

					</div>
				</div> --%>
								<div class="form-group">
										<div class="col-sm-offset-0 col-sm-12">
												<div class="checkbox" style="color: green;">
														<label><form:checkbox path="checkPhyIndicators" value="1" id="phyProperty" /><span class="Phychange">Physical Property
																Indicators:&nbsp;&nbsp; </span></label>
														<div>
																<label> <form:checkbox path="physicalPropertyIndicators" id="phyOGG" class="o5" value="Overgrown Grass"
																				disabled="true" /> Overgrown Grass
																</label> <label> <form:checkbox path="physicalPropertyIndicators" id="phyRD" class="o5" value="Roof Damage"
																				disabled="true" /> Roof Damage
																</label> <label> <form:checkbox path="physicalPropertyIndicators" id="phyPEC" class="o5"
																				value="Poor Exterior Condition" disabled="true" /> Poor Exterior Condition
																</label> <label> <form:checkbox path="physicalPropertyIndicators" id="MM" class="o5" value="Missing Mailbox"
																				disabled="true" /> Missing Mailbox
																</label> <label> <form:checkbox path="physicalPropertyIndicators" id="BW" class="o5" value="Boarded Windows"
																				disabled="true" /> Boarded Windows
																</label> <label> <form:checkbox path="physicalPropertyIndicators" id="SNN" class="o5"
																				value="Stacked Newspapers/Notices at Door" disabled="true" /> Stacked Newspapers/Notices at Door
																</label> <label> <form:checkbox path="physicalPropertyIndicators" id="TMOD" class="o5"
																				value="Tenant Move-out Debris" disabled="true" /> Tenant Move-out Debris
																</label>
														</div>
												</div>
										</div>
								</div>



								<%-- 	<div class="form-group">
					<label class="control-label col-sm-3">Personal Indicators:</label>
					<div class="col-sm-9">
						<form:select path="personalIndicators" class="form-control">
							<option value="0">Select</option>
							<c:forEach items="${personalIndicators}" var="personalIndicators">
								<c:choose>
									<c:when test="${personalIndicators== Lead.personalIndicators}">
										<option value="${personalIndicators}" selected="selected">${personalIndicators}</option>
									</c:when>
									<c:otherwise>
										<option value="${personalIndicators}">${personalIndicators}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>
				</div> --%>

								<div class="form-group">
										<div class="col-sm-offset-0 col-sm-12">
												<div class="checkbox" style="color: green;">

														<label><form:checkbox path="checkPerIndicators" value="1" id="perIndicator" /><span class="Perchange">Personal Indicators:
																&nbsp;&nbsp;</span> </label>
														<div>
																<label> <form:checkbox path="personalIndicators" id="f" class="o6" value="Foreclosure" disabled="true" />
																		Foreclosure
																</label> <label> <form:checkbox path="personalIndicators" id="d" class="o6" value="Divorce" disabled="true" />Divorce
																</label> <label> <form:checkbox path="personalIndicators" id="r" class="o6" value="Relocation" disabled="true" />
																		Relocation
																</label><label> <form:checkbox path="personalIndicators" id="t" class="o6" value="Tired Landlord" disabled="true" />
																		Tired Landlord
																</label> <label> <form:checkbox path="personalIndicators" id="ss" class="o6" value="Short Sale" disabled="true" />Short
																		Sale
																</label> <label> <form:checkbox path="personalIndicators" id="ds" class="o6" value="Down Sizing" disabled="true" />Down
																		Sizing
																</label> <label> <form:checkbox path="personalIndicators" id="inc" class="o6" value="Incomplete Rehab"
																				disabled="true" />Incomplete Rehab
																</label> <label> <form:checkbox path="personalIndicators" id="exp" class="o6" value="Expired Listing"
																				disabled="true" />Expired Listing
																</label> <label> <form:checkbox path="personalIndicators" id="pr" class="o6" value="Probate" disabled="true" />Probate
																</label> <label> <form:checkbox path="personalIndicators" id="in" class="o6" value="Inheritance" disabled="true" />Inheritance
																</label> <label> <form:checkbox path="personalIndicators" id="ev" class="o6" value="Eviction" disabled="true" />Eviction
																</label> <label> <form:checkbox path="personalIndicators" id="st" class="o6" value="Storm Damage" disabled="true" />Storm
																		Damage
																</label> <label> <form:checkbox path="personalIndicators" id="ex" class="o6" value="Excessive Repairs"
																				disabled="true" />Excessive Repairs
																</label>
														</div>
												</div>
										</div>
								</div>



								<br>
								<br>
								<p>
								
								<div class="form-group clr">
										<div class="col-sm-offset-0 col-sm-12">
										<button type="button" class="btn btn-default" style="float: left;" id="next51">Back</button>
												<button type="button" class="btn btn-default" style="float: right;" id="next5">Next</button>
										</div>
								</div>
								</span>
								</p>
								<span id="step5hide">
								<H2>
										<b>STEP #5 <u>Property Drive By:</u></b>
								</H2>
								<hr>
								<div style="color: green;">(Note: If you want to fill the data so first click on checkbox)</div></br>

								<div class="form-group">
										<div class="col-sm-offset-0 col-sm-12">
												<div class="checkbox" style="color: green;">
														<label><form:checkbox path="checkDrive" value="1" id="driveProperty" />Drive by Property for
																visible Inspection</label>
												</div>
										</div>
								</div>

<div class="con5">
								<div class="form-group">
										<label class="control-label col-sm-3" for="address">DriveByDate:</label>
										<div class="col-sm-9">
												<form:input path="driveByDate" type="date" class="form-control validate[required] input-text o7" id="byDate" placeholder="Drive by date"
														disabled="true" />
												</br>
										</div>
								</div>
								</div>
								<div class="con6">
								<div class="form-group">
										<label class="control-label col-sm-3">Verify Occupancy:</label>
										<div class="col-sm-9">
												<form:select path="verifyOccupancy" id="verigyOcc" class="form-control validate[funcCall[ifVerifyNotSelected]] o7" disabled="true">
														<!-- <option value="Owner Occupied">Owner Occupied</option>
														<option value="Vacant">Vacant</option>
														<option value="Rental">Rental</option> -->
														<option value="0">Select</option>
														<c:forEach items="${verifyOccupancy}" var="verifyOccupancy">
																<c:choose>
																		<c:when test="${verifyOccupancy== Lead.verifyOccupancy}">
																				<option value="${verifyOccupancy}" selected="selected">${verifyOccupancy}</option>
																		</c:when>
																		<c:otherwise>
																				<option value="${verifyOccupancy}">${verifyOccupancy}</option>
																		</c:otherwise>
																</c:choose>
														</c:forEach>
												</form:select>
										</div>
								</div>
								</div>
								</br>
								<div class="con7">
								<div class="form-group">
										<label class="control-label col-sm-3" for="address">Comment:</label>
										<div class="col-sm-9">
												<form:textarea path="comment" class="form-control validate[required] input-text o7" id="comment" placeholder="Enter comment" maxlenght="1000"
														onmousedown="return drive(this)" disabled="true" />
										</div>
								</div>
								</div>
								<br>
								<div class="form-group" id="fileDiv">
										<div class="col-sm-6" style="margin-top: 7px;">
												<input type="file" name="file">
										</div>
								</div>
								<div class="col-sm-6" id="uploadMore">
										<a href="javascript:addFile();">Upload More Image</a><br />
								</div>
								
								<div class="form-group clr">
										<div class="col-sm-offset-0 col-sm-12">
										<button type="button" class="btn btn-default" style="float: left;" id="next61">Back</button>
												<button type="submit" class="btn btn-default" style="float: right;" id="submit" onClick="return submitForm()">Submit</button>
										</div>
								</div>
								</span>
						</form:form>
				</div>
		</div>
	<script type="text/javascript">
$('#per').change( function() {
    var checked = this.checked;
    if(checked) {
    	$('.o1').prop("disabled",false);
    } else {
    	$('.o1').prop("disabled",true);
    	$('.con1 input[type="text"]').val('');
    	$('.con1 select').prop('selectedIndex',0);
    }

});
	
$('#lastDate').change( function() {
    var checked = this.checked;
    if(checked) {
    	$('.o2').prop("disabled",false);
    	   
    } else {
    	$('.o2').prop("disabled",true);
    	$('.con2 input[type="date"]').val('');
	   
    }

});


$('#lastPrice').change( function() {
    var checked = this.checked;
    if(checked) {
    	$('.o3').prop("disabled",false); 
    	   
    } else {
    	$('.o3').prop("disabled",true); 
    	$('.con3 input[type="text"]').val('');
	   
    }

});
 
$('#phyProperty').change( function() {
    var isChecked = this.checked;
    if(isChecked) {
    	$('.o5').prop("disabled",false); 
    	$('.Phychange').text("Visual Signs"); 
    	
    } else {
    	$('.o5').prop("disabled",true); 
    	$('.o5').attr("checked",false); 
    	$('.Phychange').text("Physical Property Indicators:");
    	
    }

});


$('#motivation').change( function() {
    var checked = this.checked;
    if(checked) {
    	$('.o4').prop("disabled",false); 
    	   
    } else {
    	$('.o4').prop("disabled",true);  
    	$('.con4 select').prop('selectedIndex',0);
    	
	   
    }

});
 $('#perIndicator').change( function() {
    var checked = this.checked;
    if(checked) {
    	$('.o6').prop("disabled",false);
    	$('.Perchange').text("Non-Visual Signs");
    } else {
    	$('.o6').prop("disabled",true);
    	$('.o6').attr("checked",false); 
    	$('.Perchange').text("Personal Indicators:");
    }

});
$('#driveProperty').change( function() {
    var checked = this.checked;
    if(checked) {
    	$('.o7').prop("disabled",false); 
    	
    } else {
    	$('.o7').prop("disabled",true); 
    	$('.con5 input[type="date"]').val('');
    	$('.con6 select').prop('selectedIndex',0);
    	$('textarea').val('');
    	
    }

});
</script>

		<br>
		<br>
</body>

<script>
function addFile(){
	var fileIndex = $('#fileDiv').children().length 
	if(fileIndex<10){
var	input = jQuery('<div class="col-sm-6" style="margin-top: 7px;"><input type="file" name="file"></div>');
jQuery('#fileDiv').append(input);
	}
}
</script>
</html>