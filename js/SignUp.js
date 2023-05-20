
$(document).ready(function() {
	clear();
});

function EmailValid(email){
	return email.match( /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
	}

function hasBlankSpaces(username) {
	return username === "" || username.match(/^\s+$/) !== null;
}

function hasBlankSpaces(password) {
	return password === "" || password.match(/^\s+$/) !== null;
}

$('#save').click(function(){
	
	var username=$("#username").val();
	if(hasBlankSpaces(username)){
		alert("PLEASE ENTER USERNAME")
		return false;
	}
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
	
	var confirmpassword=$("#confirmpassword").val();
	if(confirmpassword==""){
		alert("PLEASE ENTER  CONFIRM PASSWORD")
		return false;
	}
	if(password!=confirmpassword){
		alert("PLEASE ENTER CORRECT PASSWORD")
		return false;
	}

    let sData = {};
   sData.userName=username;
   sData.emailId=email;
   sData.password=password;

$.ajax({
		method: "POST",
		url: "/signup",
		//dataType:'JSON',
		data: sData,
		
		success: function(sData) {
			/*loadTable1();*/
			clear();
			alert(sData)

		},
		error: function(err) {
			alert(err)

		}
	});
});

function clear(){
	document.getElementById("username").value="";
	document.getElementById("email").value="";
	document.getElementById("password").value="";
	document.getElementById("confirmpassword").value="";
	
}

