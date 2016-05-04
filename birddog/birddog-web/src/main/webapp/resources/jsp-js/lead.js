$(function() {
  $("#stateId").change(
      function() {
        $("#countyId").text(""), $("#countyId").append(
            $("<option value='0'></option>").text("--Select--"));
        var stateId = $("#stateId").val();
        $.ajax({
            url : "countyByStateId?stateId=" + stateId,
            type : "GET",
            contentType : "application/json; charset=utf-8",
            success : function(response) {
              for (i = 0; i < response.length; i++)
                $("#countyId").append(
                    $("<option value='" + response[i].id + "'></option>").text(
                        response[i].countyName))
            },
            error : function() {
            }
        })
      }), $("#countyId").change(
      function() {
        $("#cityId").text(""), $("#cityId").append(
            $("<option value='0'></option>").text("--Select--"));
        var countyId = $("#countyId").val();
        $.ajax({
            url : "cityByCountyId?countyId=" + countyId,
            type : "GET",
            contentType : "application/json; charset=utf-8",
            success : function(response) {
              for (i = 0; i < response.length; i++)
                $("#cityId").append(
                    $("<option value='" + response[i].id + "'></option>")
                        .text(response[i].cityName))
            },
            error : function() {
            }
        })
      })
});