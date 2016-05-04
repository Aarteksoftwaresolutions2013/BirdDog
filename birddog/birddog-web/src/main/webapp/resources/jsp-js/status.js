function saveStatus(id,value){
	
	alert(id+" "+value);
    $.ajax({
        url : "updateLeadStatus?leadId=" + id+"&status="+value,
        type : "GET",
        contentType : "application/json; charset=utf-8",
        success : function(response) {
        	alert("success");
//          for (i = 0; i < response.length; i++)
//            $("#cityId").append(
//                $("<option value='" + response[i].id + "'></option>")
//                    .text(response[i].cityName))
        },
        error : function() {
        }
    })
}