
let editid = undefined;


$(document).ready(function() {

	loadTable();
	clear();
	//$('#saveStudent').show();
	//	$('#updateStudent').hide();
	//	$('#idfield').hide();

});

function hasBlankSpaces(subCategoryName) {
	return subCategoryName === "" || subCategoryName.match(/^\s+$/) !== null;
}
function hasBlankSpace(discription) {
	return discription === "" || discription.match(/^\s+$/) !== null;
}


function hasBlankSpaces(categoryName) {
	return categoryName === "" || categoryName.match(/^\s+$/) !== null;
}
//save 

var subCategoryId = subCategoryId;
$('#save').click(function() {

	var categoryName = $("#catname1").val();
	if (hasBlankSpace(categoryName)) {
		alert("PLEASE ENTER CATEGORY NAME");
		return false;
	}

	var subCategoryName = $("#subcat").val();
	if (hasBlankSpaces(subCategoryName)) {
		alert("PLEASE ENTER  SUB CATEGORY NAME");
		return false;
	}

	var discription = $("#Discription").val();
	if (hasBlankSpace(discription)) {
		alert("PLEASE ENTER DESCRIPTION");
		return false;
	}

	var active = $("#active").prop("checked");
	let catData = {
		"categoryName": categoryName,
		"subCategoryName": subCategoryName,
		"discription": discription

	}
	if (editid) {

		catData.subCategoryId = editid;
	} else {
		active = true
	}
	if (active == true) {
		catData.active = 1;
	} else {
		catData.active = 0;
	}



	$.ajax({
		method: "POST",
		url: "/insertSubProduct",
		//dataType:'JSON',
		data: catData,
		success: function(catData) {

			loadTable();
			clear();
			console.log(catData)
			alert(catData)

		},
		error: function(err) {
			alert("Please Enter Data")
		}
	});

});

$.ajax({

	method: "GET",
	url: "/subList",
	//dataType:'JSON',

	success: function(catData) {

		for (var index = 0; index < catData.length; index++) {

			$("#catname1").append('<option value="' + catData[index][0] + '">' + catData[index][1] + ' </option>');
		}

		$("#catname1").selectpicker('refresh');
	}
});





var Data = "";

/*$
	.ajax({
		method: "GET",
		url: "/loadAll",
		success: function(response) {
			Data = response

			$('.tr').remove();
			for (var i = 0; i < Data.length; i++) {
				$("#subcategory_table").append(

					`<tr class="tr">
 <td class="text-center">
 <span data-toggle="modal" data-target=".addmodal">
	<a class=" " data-toggle="tooltip" data-placement="bottom" data-original-title="Edit"
			  href="javascript:void(0);" onclick="editProduct(`+ Data[i].subCategoryId + `)">
			  <i class="fas fa-edit m-r-5 text-success"></i>
			  </a>
			</span>
			<a class=" delete_alert " data-toggle="tooltip" data-placement="bottom" data-original-title="Delete"
			href="javascript:void(0);" onclick=" delProduct(`+ Data[i].subCategoryId + `)">
			<i class="far fa-trash-alt  text-danger"></i>
			</a>
			</td>
 
			   <td >` + Data[i].active  + `</td>
				 <span class="badge badge-danger"> NO </span>
				   
		  <td>` + Data[i].subCategoryId + `</td>
		  <td>`+ Data[i].categoryName + `</td>
		  <td>`+ Data[i].subCategoryName + `</td>
		  <td>`+ Data[i].discription + `</td> 
	  
</tr>`);
			}
		},
		error: function(err) {
			alert("error is" + err)
		}
	});
}*/
function loadTable() {
	$.ajax({
		url: "/loadAll",
		type: "GET",

		success: function(data) {
			$(window).on('load', function() {
				if (feather) {
					feather.replace({ width: 14, height: 14 });
				}
			})
			$("#subcategory_table").dataTable(

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
							render: function(data, type, meta) {

								return `<span data-toggle="modal" data-target=".addmodal">
							          <a class="" data-toggle="tooltip" data-placement="bottom" id="editBtn" onclick=editProduct(${meta.subCategoryId}) data-original-title="Edit"
							              href="javascript:void(0);">
							              <i class="fas fa-edit m-r-5 text-success"></i>
						              </a>
							        </span>
						        	<a class=" delete_alert " data-toggle="tooltip" data-placement="bottom"  onclick=delProduct(${meta.subCategoryId}) data-original-title="Delete"
            						  	href="javascript:void(0);">
               						  	<i class="far fa-trash-alt  text-danger"></i>
          						    </a>`;

							}

						},
						{
							data: 'active',
							render: function(data) {
								if (data == 1) {
									return `<td class="">
              								<span class="badge badge-success">Yes</span>
           	 							    </td>`;
								}
								else {
									return `<td class="">
              								<span class="badge badge-danger">No</span>
           	 							    </td>`;
								}
							}
						},
						{ data: 'subCategoryId' },
						{ data: 'categoryName' },
						{ data: 'subCategoryName' },
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




function editProduct(subCategoryId) {

	console.log(subCategoryId)
	editid = subCategoryId

	$.ajax({
		type: "GET",
		url: "editById/" + subCategoryId,
		success: function(catData) {
			//alert("student--"+response.id);
			//location.reload();
			$(".activediv").show();
			//$("#active").val(catData.active),
			$('#catname1').val(catData.categoryName),
				$('#Discription').val(catData.discription),
				$('#subcat').val(catData.subCategoryName)
			//	$('#catname1').trigger('change').selectpicker('refresh');
			$('#catname1').selectpicker('refresh');

			if (catData.active == 1) {
				$("#active").prop("checked", true);
			} else {
				$("#active").prop("checked", false);
			}
		},
		error: function(err) {
			alert("error is" + err)
		}
	});

}



function delProduct(subCategoryId) {
	console.log(subCategoryId)

	if (confirm("ARE YOU SURE YOU WANT TO DELETE?")) {
		$.ajax({

			method: 'DELETE',
			url: "delete/" + subCategoryId,

			success: function(response) {

				loadTable();

			},
			error: function(err) {
				alert(err)
			}
		});
	}
}



function clear() {
	//$(".activediv").hide();
	document.getElementById("catname1").value = "";
	$('#catname1').selectpicker('refresh');
	document.getElementById("Discription").value = "";
	document.getElementById("subcat").value = "";

}

$(document).on('click', '#add', function() {
	editid = undefined;
	$(".activediv").hide();
});



function clearInput() {
	$('#form')[0].reset();
	document.getElementById("catname1").value = "";
	document.getElementById("Discription").value = "";
	document.getElementById("subcat").value = "";
	$('#catname1').selectpicker('refresh');
	//document.getElementById("Form").reset();
}


