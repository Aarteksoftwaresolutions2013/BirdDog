function ifStateNotSelected(field, rules, i, options) {
	var a = document.getElementById('stateId').value;
	if (a == 0) {
		return "*Please select an option, this field is required";
	}
}

function ifCountyNotSelected(field, rules, i, options) {
	var b = document.getElementById('countyId').value;
	if (b == 0) {
		return "*Please select an option, this field is required";
	}
}

function ifCityNotSelected(field, rules, i, options) {
	var c = document.getElementById('cityId').value;
	if (c == 0) {
		return "*Please select an option, this field is required";
	}
}
function ifConstructionTypeNotSelected(field, rules, i, options) {
	var d = document.getElementById('consType').value;
	if (d == 0) {
		return "*This field is required";
	}
}

function ifRoofConstructionTypeNotSelected(field, rules, i, options) {
	var e = document.getElementById('roofConstructionType').value;
	if (e == 0) {
		return "*This field is required";
	}
}
function ifPoolNotSelected(field, rules, i, options) {
	var f = document.getElementById('roofConstructionType').value;
	if (f == 0) {
		return "*This field is required";
	}
}
function ifbedRoomsNotSelected(field, rules, i, options) {
	var g = document.getElementById('bedRooms').value;
	if (g == 0) {
		return "*This field is required";
	}
}
function ifbathRoomsNotSelected(field, rules, i, options) {
	var g = document.getElementById('bathRooms').value;
	if (g == 0) {
		return "*This field is required";
	}
}
function ifbYearNotSelected(field, rules, i, options) {
	var h = document.getElementById('bYear').value;
	if (h == 0) {
		return "*This field is required";
	}
}
function ifSellerNotSelected(field, rules, i, options) {
	var h = document.getElementById('sellMov').value;
	if (h == 0) {
		return "*This field is required";
	}
}

function ifVerifyNotSelected(field, rules, i, options) {
	var h = document.getElementById('verigyOcc').value;
	if (h == 0) {
		return "*This field is required";
	}
}


