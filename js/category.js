
let editid = undefined;


$(document).ready(function() {

     getAllrecord();
	clear();
	//$('#saveStudent').show();
	//	$('#updateStudent').hide();
	//	$('#idfield').hide();

});

function hasBlankSpaces(categoryName){
     return categoryName === "" ||  categoryName.match(/^\s+$/) !== null;
}
function hasBlankSpace(discription){
     return discription === "" || discription.match(/^\s+$/) !== null;
}

//save 
var categoryId = categoryId;

$('#save').click(function() {

var categoryName = $("#catname").val();
         if (hasBlankSpaces(categoryName)){
				 alert("PLEASE ENTER CATEGORY NAME");
				 return false;
			}
	var discription = $("#Discription").val();
	if (hasBlankSpace(discription)){
				 alert("PLEASE ENTER DESCRIPTION");
				 return false;
			}
	
	var active = $("#active").prop("checked");

	let catData = {
		"categoryName": categoryName,
		"discription": discription
	}

	if (editid ) {
		console.log(editid)
		catData.CategoryId = editid;
	}else{
		active = true
		}
	if (active == true) {
		catData.active = 1;
	} else {
		catData.active = 0;
	}

	$.ajax({
		method: "POST",
		url: "/insertProduct",
		//dataType:'JSON',
		data: catData,
		success: function(catData) {

			getAllrecord();
			console.log(catData)
		alert(catData)
          	clear();
		
			//$(".activediv").show();
		},
		error: function(err) {
			alert("ERROR"+err)
		}
	});

});





var Data = "";
function getAllrecord() {
	/*$
		.ajax({
			method: "GET",
			url: "/listAll",
			success: function(response) {
				Data = response

				$('.tr').remove();
				for (var i = 0; i < Data.length; i++) {
					$("#category_table").append(

						`<tr class="tr">
     <td class="text-center">
     <span data-toggle="modal" data-target=".addmodal">
        <a class=" " data-toggle="tooltip" data-placement="bottom" data-original-title="Edit"
                  href="javascript:void(0);" onclick="editProduct(`+ Data[i].categoryId + `)">
                  <i class="fas fa-edit m-r-5 text-success"></i>
                  </a>
                </span>
                <a class=" delete_alert " data-toggle="tooltip" data-placement="bottom" data-original-title="Delete"
                href="javascript:void(0);" onclick="delProduct(`+ Data[i].categoryId + `)">
                <i class="far fa-trash-alt  text-danger"></i>
                </a>
                </td>
  
                   <td >` + Data[i].active  + `</td>
                     <span class="badge badge-danger"> NO </span>
				 	 
              <td>` + Data[i].categoryId + `</td>
              <td>`+ Data[i].categoryName + `</td>
			  <td>`+ Data[i].discription + `</td> 
          
   </tr>`);
				}
			},
			error: function(err) {
				alert("error is" + err)
			}
		});
}
*/
$.ajax({
		url: "/listAll",
		type: "GET",

		success: function(data) 
		{
			$(window).on('load', function() 
			{
				if (feather) 
				{
					feather.replace({ width: 14, height: 14 });
				}
			})
			$("#category_table").dataTable(

				{
					destroy: true,
					scrollResize: true,
					scrollX: true,
					// scrollY: 100,
					scrollCollapse: true,
					paging: true,
					// lengthChange: false,
					// scrollX: true,
					"bAutoWidth": true,
					// paging: true,
					"bLengthChange": true,
					// fixedColumns: true,
					"data": data,

					"columns": [
						{
							data: null,
							render: function(data, type, meta) 
							{

								return `<span data-toggle="modal" data-target=".addmodal">
							          <a class="" data-toggle="tooltip" data-placement="bottom" id="editBtn" onclick=editProduct(${meta.categoryId}) data-original-title="Edit"
							              href="javascript:void(0);">
							              <i class="fas fa-edit m-r-5 text-success"></i>
						              </a>
							        </span>
						        	<a class=" delete_alert " data-toggle="tooltip" data-placement="bottom"  onclick=delProduct(${meta.categoryId}) data-original-title="Delete"
            						  	href="javascript:void(0);">
               						  	<i class="far fa-trash-alt  text-danger"></i>
          						    </a>`;
              						
							}

						},
						{
							data: 'active',
							render: function(data) 
							{
								if (data == 1) 
								{
									return `<td class="">
              								<span class="badge badge-success">Yes</span>
           	 							    </td>`;
								} 
								else 
								{
									return `<td class="">
              								<span class="badge badge-danger">No</span>
           	 							    </td>`;
								}
							}
						},
						{ data: 'categoryId' },
						{ data: 'categoryName' },
						{ data: 'discription' },
					],
					"columnDefs": 
					[{
						"targets": [0],
						"orderable": false,
						// "width": "2%",
					}],
					"pageLength": 6,

					fixedColumns:
					 {
						rightColumns: 0,
						leftColumns: 0
					},
					language: 
					{
						paginate: 
						{
							next: '<i class="fa fa-angle-double-right">',
							previous: '<i class="fa fa-angle-double-left">'
						}
					},
					dom: "<'row pl-0 pr-1'<'col-xl-9 col-lg-8 col-sm-8'pi><'col-xl-3 col-lg-4 col-sm-4'f>>"
						+ "<'row pl-1 pr-1'<'col-xl-12 col-lg-12 col-sm-12'tr>>"

				});
		}

	})
}

		
		
function editProduct(categoryId) {

	console.log(categoryId)
	editid = categoryId

	$.ajax({
		type: "GET",
		url: "getById/" + categoryId,
		success: function(catData) {
			//alert("student--"+response.id);
			//location.reload();
			$(".activediv").show();
			//$("#active").val(catData.active),
			$('#catname').val(catData.categoryName),
			$('#Discription').val(catData.discription)
				
			if (catData.active == 1) {
				$("#active").prop("checked", true);
			}else{
				$("#active").prop("checked", false);
			}
		},
		error: function(err) {
			alert("error is" + err)
		}
	});

}



function delProduct(categoryId) {
	console.log(categoryId)
    if(confirm("ARE YOU SURE YOU WANT TO DELETE?")){    
	$.ajax({
		
		method:'POST',
		url: "delById/"+ categoryId,
		
		success: function(catData) {
			
			getAllrecord();
		},
		error: function(err) {
			//confirm("ARE YOU SURE YOU WANT TO DELETE?")
			alert("error: " + categoryId)
		}
	});
}
}

/*let c=document.getElementById("add");
c.addEventListener("click",clear());
	function clear(){
		 $(".activediv").hide();
	document.getElementById("catname").value="";
	document.getElementById("Discription").value="";
	
	}*/



function clear() {
	$(".activediv").show();
	document.getElementById("catname").value = "";
	document.getElementById("Discription").value = "";

}

$(document).on('click', '#add', function() {
	editid = undefined;
	$(".activediv").hide();
});



function clearInput() {
	$('#form')[0].reset();
	document.getElementById("catname").value = "";
	document.getElementById("Discription").value = "";
	//document.getElementById("Form").reset();
}

/*$('#close').click(function(){
	$('#form')[0].reset();
		document.getElementById("catname").value="";
		document.getElementById("Discription").value="";
	});*/
/*	$(document).on("click","#close",function(){
	clear();
});*/



/*var act= document.getElementById("active");
ans="";

	if(act.checked=true){
		catData.active=1;
	}else{
		catData.active=0;
	}*/
function excel(){
	$.ajax({
		method:'GET',
		url: "/export-to-excel",
		success: function(response) {
		
		},
		error: function(err) {
			
		}
	});
	
}