  
  $(document).ready(function() {
	clear();
});

function EmailValid(email){
	return email.match( /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
	}

function hasBlankSpaces(password) {
	return password === "" || password.match(/^\s+$/) !== null;
}

  $('#save').click(function(){
	  debugger
	  var email=$("#email").val();
	  if(!EmailValid(email)){
		alert("PLEASE ENTER VALID EMAIL")
		return false;
	}
	  var password=$("#password").val();
	  if(hasBlankSpaces(password) ){
		alert("PLEASE ENTER PASSWORD")
		return false;
	}
	  let logData={};
	  logData.email=email;
	  logData.password=password;
	  
	  $.ajax({
		method: "POST",
		url: "/enter",
		//dataType:'JSON',
		data: logData,
		
		success: function(logData) {
			/*loadTable1();*/
		 
			if(logData=="USER DOES NOT EXIST")
			{
			 alert(logData)
			}
			else{
				alert("LOGEIN SUCCESSFULLY")
			clear();
			}
			
			

		},
		
	});
	  
  });
  
  function clear(){
	  
	  document.getElementById("email").value="";
	    document.getElementById("password").value="";
  }