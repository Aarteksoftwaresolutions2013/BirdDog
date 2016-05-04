$(document).on('click', '.ppClose', function() {
	$(".msgPopupCont").css("display", "none");
});




$(function() {
	$("#chkPassport").click(function() {
		if ($(this).is(":checked")) {
			$("#dvPassport").show();
		} else {
			$("#dvPassport").hide();
		}
	});
});

$(function() {
	$("#notListed").click(
			function() {
				var isChecked = $("#notListed").is(":checked");
				if (isChecked) {
					$("#ppContent").html(
							"We will only Pay for NON-LISTED Properties!");
					$(".msgPopupCont").css("display", "block");
				}
			});
});

$(function () {
    $("#auctions").click(function () {
        var isChecked = $("#auctions").is(":checked");
        if (isChecked) {
        	$("#ppContent").html("We will not Pay for ANYAuction Type Properties!");
        	$(".msgPopupCont").css("display","block");
         } 
    });
});

$(function () {
    $("#wholeseller").click(function () {
        var isChecked = $("#wholeseller").is(":checked");
        if (isChecked) {
            $("#ppContent").html("NO WHOLESALERS!  If Corporate/Trust Owned YOU are Verifying YOU Spoke to the Principle.");
        	$(".msgPopupCont").css("display","block");
        } 
    });
});

function myFunction(x) {
    var checkoutHistory = document.getElementById('per').checked;
    if (checkoutHistory==false) {
        $("#ppContent").html("Please first select the checkbox for verify");
    	$(".msgPopupCont").css("display","block");
    	return false;
    } 
}

function saleDate(y) {
    var saleDate = document.getElementById('lastDate').checked;
    if (saleDate==false) {
        $("#ppContent").html("Please first select the checkbox for verify");
    	$(".msgPopupCont").css("display","block");
    } 
}

function salePrice(z) {
    var lastPrice = document.getElementById('lastPrice').checked;
    if (lastPrice==false) {
        $("#ppContent").html("Please first select the checkbox for verify");
    	$(".msgPopupCont").css("display","block");
    } 
}

function salePrice(z) {
    var lastPrice = document.getElementById('lastPrice').checked;
    if (lastPrice==false) {
        $("#ppContent").html("Please first select the checkbox for verify");
    	$(".msgPopupCont").css("display","block");
    } 
}

function myMotivation(i) {
    var motivation = document.getElementById('motivation').checked;
    if (motivation==false) {
        $("#ppContent").html("Please first select the checkbox for verify");
    	$(".msgPopupCont").css("display","block");
    	return false;
    } 
}

function physical(j) {
    var phyProperty = document.getElementById('phyProperty').checked;
    if (phyProperty==false) {
        $("#ppContent").html("Please first select the checkbox for verify");
    	$(".msgPopupCont").css("display","block");
    	return false;
    } 
}

function indicator(k) {
    var perIndicator = document.getElementById('perIndicator').checked;
    if (perIndicator==false) {
        $("#ppContent").html("Please first select the checkbox for verify");
    	$(".msgPopupCont").css("display","block");
    	return false;
    } 
}

function drive(l) {
    var driveProperty = document.getElementById('driveProperty').checked;
    if (driveProperty==false) {
        $("#ppContent").html("Please first select the checkbox for verify");
    	$(".msgPopupCont").css("display","block");
    	return false;
    } 
}

function submitForm() { 
        if(!confirm("Any Incomplete Lead Submission will not be APPROVED for Payment!  Are you want to submit form"))
    	{
        	return false;
    	}
    
}

$(function () {
    $("#lastDate").click(function () {
        var isChecked = $("#lastDate").is(":checked");
        if (isChecked) {
        	$("#ppContent").html("YOU MUST VERIFY THIS INFORMATION!");
        	$(".msgPopupCont").css("display","block");
         } 
    });
});

$(function () {
    $("#lastPrice").click(function () {
        var isChecked = $("#lastPrice").is(":checked");
        if (isChecked) {
        	$("#ppContent").html("YOU MUST VERIFY THIS INFORMATION!");
        	$(".msgPopupCont").css("display","block");
         } 
    });
});

$(function () {
    $("#driveProperty").click(function () {
        var isChecked = $("#driveProperty").is(":checked");
        if (isChecked) {
        	$("#ppContent").html("We will not Pay for ANYAuction Type Properties!");
        	$(".msgPopupCont").css("display","block");
         } 
    });
});

