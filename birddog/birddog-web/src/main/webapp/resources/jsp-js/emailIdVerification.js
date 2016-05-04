   function emailVarification(email) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	   var emailId =email.value;
	     $.ajax({
	  		url : "verifyUserEmailId?emailId=" + emailId,
	  		type : "GET",
	  		contentType : "application/json; charset=utf-8",
	  		
	  		success : function(t) {
	  			if(t){
	  			 	document.getElementById("email").value="";  
	  			 document.getElementById("msg").innerHTML = "your emailId already existed!";
	  			}
	  		
	  		},
	  		error : function() {
	  		}
	  	})
	  }  