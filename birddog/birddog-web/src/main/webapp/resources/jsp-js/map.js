$(document).ready(function() {
	$.ajax({
		url : "getAllLeadListByBirddog",
		type : 'POST',
		dataType : 'json',
		contentType : 'application/json',
		mimeType : 'application/json',                                  
		success : function(data) {
 			var markers=data;
			var mapOptions = {
					center: new google.maps.LatLng(markers[0].address.latitude, markers[0].address.latitude),
					zoom: 10,
					mapTypeId: google.maps.MapTypeId.ROADMAP
					};
					var map = new google.maps.Map(document.getElementById("dvMap"), mapOptions);
					var infoWindow = new google.maps.InfoWindow();
					var lat_lng = new Array();
					var latlngbounds = new google.maps.LatLngBounds();
					for (i = 0; i < markers.length; i++) {
					var data = markers[i]
					var myLatlng = new google.maps.LatLng(data.address.latitude, data.address.longitude);
					lat_lng.push(myLatlng);
					var marker = new google.maps.Marker({
					position: myLatlng,
					map: map,
					address1: data.address.address1
					});
					latlngbounds.extend(marker.position);
					(function (marker, data) {
					google.maps.event.addListener(marker, "click", function (e) {
					infoWindow.setContent("<b>Owner Name:&nbsp;</b>"+data.ownerFirstName+"<b></br>Address:&nbsp;</b>"+data.address.address1+"</br><b>Contact No:&nbsp;</b>"+data.birddog.contactNo+"");
					infoWindow.open(map, marker);
					});
					})(marker, data);
					}
					map.setCenter(latlngbounds.getCenter());
					map.fitBounds(latlngbounds);
		},
		error : function(data, status, er) {
			alert("error: " + data + " status: " + status
					+ " er:" + er);
		}
	});
});