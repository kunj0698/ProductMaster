

let editid = undefined;


$(document).ready(function() {
	//  $("#fileUploadForm").on("change", image);
	loadTable1();
	clear();

});

$('#manufactureDate').closest('div').datepicker({
	autoclose: true,
	todayHighlight: true,
	format: "dd/mm/yyyy",
	clearBtn: true
});
$('#validfrom_date').closest('div').datepicker({
	autoclose: true,
	todayHighlight: true,
	format: "dd/mm/yyyy",
	clearBtn: true
});
$('#validto_date').closest('div').datepicker({
	autoclose: true,
	todayHighlight: true,
	format: "dd/mm/yyyy",
	clearBtn: true
});


function hasBlankSpaces(productName) {
	return productName === "" || productName.match(/^\s+$/) !== null;
}
function hasBlankSpace(discription) {
	return discription === "" || discription.match(/^\s+$/) !== null;
}


//ADD
var productId = productId;
$('#save').click(function() {

	var productName = $("#proName").val();
	if (hasBlankSpace(productName)) {
		alert("PLEASE ENTER CATEGORY PRODUCTNAME");
		return false;
	}

	var categoryName = $("#catName2").val();
	if (categoryName == "") {
		alert("PLEASE SELECT CATEGORY NAME");
		return false;
	}

	var subCategoryName = $("#subCat").val();
	if (subCategoryName == "") {
		alert("PLEASE SELECT SUBCATEGORY NAME");
		return false;
	}

	var discription = $("#Discription").val();
	if (hasBlankSpace(discription)) {
		alert("PLEASE ENTER DISCRIPTION");
		return false;
	}
	var price = $("#price").val();
	if (price == "") {
		alert("PLEASE ENTER PRICE");
		return false;
	}

	var manufactureDate = $("#manufactureDate").val();
	if (manufactureDate == "") {
		alert("PLEASE SELECT MANUFACTURE DATE");
		return false;
	}

	var productSerialNo = $("#slNo").val();
	if (productSerialNo == "") {
		alert("PLEASE ENTER PRODUCT SL NO.");
		return false;
	}

	var warrantyAndSupport = $("#warrantyAndSupport").val();
	if (warrantyAndSupport == "") {
		alert("PLEASE ENTER WARRANTY & SUPPORT");
		return false;
	}

	//var imageUpload=$("[name=image]").val();
	//var imageUpload = $("#image").val();
	//var productCondition = $("#productCondition");
	var productCondition = document.getElementsByName("optradio");
	var condition = "";
	var i;
	for (i = 0; i < productCondition.length; i++) {
		if (productCondition[i].checked) {
			condition = condition + productCondition[i].value;
		}
	}
	if (condition == "") {
		alert("PLEASE SELECT PRODUCT CONDITION");
		return false;
	}

	//var productColour = $("#productColour");
	var productColour = document.getElementsByName("option1");
	var ans = "";
	for (var i = 0; i < productColour.length; i++) {
		if (productColour[i].checked) {
			ans = ans + productColour[i].value + ",";
			var colour = ans.slice(0, - 1);
		}
	}
	if (ans == "") {
		alert("PLEASE SELECT PRODUCT COLOUR");
		return false;
	}

	var discount = $("#discount").val();
	if (discount == "") {
		alert("PLEASE ENTER DISCOUNT");
		return false;
	}

	var dateFrom = $("#validfrom_date").val();
	if (dateFrom == "") {
		alert("PLEASE ENTER  DATE")
		return false;
	}
	var dateTo = $("#validto_date").val();
	if (dateTo == "") {
		alert("PLEASE ENTER  DATE")
		return false;
	}
	let DateF = dateFrom.split("/");
	console.log(DateF[0])
	let DayF = DateF[0];
	let MonthF = DateF[1];
	let YearF = DateF[2];

	let DateT = dateTo.split("/");
	let DayT = DateT[0];
	let MonthT = DateT[1];
	let YearT = DateT[2];
	if (YearT <= YearF && MonthT < MonthF   ) {
		alert("PLEASE ENTER VALID DATE");
		return false;
	}
 else if( YearT <= YearF && MonthT == MonthF && DayT <= DayF ) {
		alert("PLEASE ENTER VALID DATE");
		return false;
	}
	 else if( YearT < YearF && MonthT == MonthF && DayT >= DayF ) {
		alert("PLEASE ENTER VALID DATE");
		return false;
	}
	else if( YearT < YearF  && MonthT > MonthF ) {
		alert("PLEASE ENTER VALID DATE");
		return false;
	}
	else if( YearT == YearF  &&  MonthT == MonthF && DayT <= DayF) {
		alert("PLEASE ENTER VALID DATE");
		return false;
	}
	 
	/*else if( YearT > YearF  && MonthT == MonthF) {
		alert("PLEASE ENTER VALID DATE");
		return false;
	}
*/


	var active = $("#active").prop("checked");



	let proData = {};

	proData.productName = productName;
	proData.categoryName = categoryName;
	proData.subCategoryName = subCategoryName;
	proData.discription = discription;
	proData.price = price;
	proData.manufactureDate = manufactureDate;
	proData.productSerialNo = productSerialNo;
	proData.warrantyAndSupport = warrantyAndSupport;
	//	proData.imageUpload = imageUpload;
	proData.productCondition = condition;
	proData.productColour = colour;
	proData.discount = discount;
	proData.dateFrom = dateFrom;
	proData.dateTo = dateTo;
	proData.active = active;
	

	if (editid) {
		console.log(editid)
		proData.productId = editid;
	} else {
		active = true
	}
	if (active == true) {
		proData.active = 1;
	} else {
		proData.active = 0;
	}

	let formData = new FormData();
	formData.append("imageUpload", $('input[type=file]')[0].files[0]);
	formData.append("proDto", new Blob([JSON.stringify(proData)], { type: "application/JSON;charset=UTF-8" }));


	console.log(formData);
	for (var obj of formData) {
		console.log(obj);
	}

	if (active == true) {
		formData.active = 1;
	} else {
		formData.active = 0;
	}

	//  var form = $('#fileUploadForm')[0];



	$.ajax({
		method: "POST",
		url: "/AddProduct",
		enctype: "multipart/form-data",
		//dataType:'JSON',
		data: formData,
		processData: false,
		contentType: false,
		success: function(formData)
		 {
			if(formData=="DATA EXIST")
			{
			 alert(formData)
			}
			else{
				alert("DATA SAVED")
				$("#close").click();
			}
			loadTable1();

		},
		
		
	});

});



$.ajax({

	method: "GET",
	url: "/categoryList",
	//dataType:'JSON',

	success: function(formData) {

		for (var index = 0; index < formData.length; index++) {

			$("#catName2").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
		}

		$("#catName2").selectpicker('refresh');
	}
});


$(document).on("change", "#catName2", function() {

	let categoryId = $(this).val();


	$.ajax({
		method: "GET",
		url: "/subDrop",
		//dataType:'JSON',
		data: { categoryId: categoryId },
		success: function(formData) {
			console.log("data: " + formData)
			$("#subCat").empty().selectpicker("refresh");
			for (var index = 0; index < formData.length; index++) {

				$("#subCat").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
			}
			if (editisubcat) {
				console.log(editisubcat)
				$("#subCat").val(editisubcat);
				editisubcat = undefined;
			}

			$("#subCat").selectpicker('refresh');
		}
	});
});



var Data = "";
/*
function loadTable1() {
	$.ajax({
		method: "GET",
		url: "/load",
		success: function(response) {
			Data = response

			$('.tr').remove();
			for (var i = 0; i < Data.length; i++) {
				$("#product_table").append(

					`<tr class="tr">
     <td class="text-center">
     <span data-toggle="modal" data-target=".addmodal">
        <a class=" " data-toggle="tooltip" data-placement="bottom" data-original-title="Edit"
                  href="javascript:void(0);" onclick="editProduct(`+ Data[i][3] + `)">
                  <i class="fas fa-edit m-r-5 text-success"></i>
                  </a>
                </span>
                <a class=" delete_alert " data-toggle="tooltip" data-placement="bottom" data-original-title="Delete"
                href="javascript:void(0);" onclick=" delProduct(`+ Data[i][3] + `)">
                <i class="far fa-trash-alt  text-danger"></i>
                </a>
                </td>
  //active
                   <td >` + Data[i][1] + `</td>
                     <span class="badge badge-danger"> NO </span>
		      <td class="text-center"><a href="javascript:void(0)"
							data-toggle="popover" data-trigger="hover" data-html="true"
							data-placement="right"
							data-template='<div class="popover fade bs-popover-right" role="tooltip" x-placement="right"><div class="arrow"></div><h3 class="popover-header p-0 border_radius6"></h3></div>'
							data-title="<img src='pictures/${Data[i][2]}' height='150' class='border_radius6'>">
								<img src="pictures/${Data[i].imageUpload}" alt="" width="25"
								height="25">
					</a></td>
					//productid	
              <td>` + Data[i][3] + `</td>
               //productname 
             <td>`+ Data[i][4] + `</td>
             //discription
              <td>`+ Data[i][5] + `</td> 
              //categoryName
              <td>`+ Data[i][0] + `</td>
              //price
              <td>`+ Data[i][6] + `</td>
              //discount
              <td>`+ Data[i][7] + `</td>
		
          
   </tr>`);
			}
		},
		error: function(err) {
			alert("error is" + err)
		}
	});
}*/

function loadTable1() {
	$.ajax({
		url: "/load",
		type: "GET",

		success: function(data) {
			$(window).on('load', function() {
				if (feather) {
					feather.replace({ width: 14, height: 14 });
				}
			})
			$("#product_table").dataTable(

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
							          <a class="" data-toggle="tooltip" data-placement="bottom"  onclick=editProduct(${data['3']}) data-original-title="Edit"
							              href="javascript:void(0);">
							              <i class="fas fa-edit m-r-5 text-success"></i>
						              </a>
							        </span>
						        	<a class=" delete_alert " data-toggle="tooltip" data-placement="bottom"  onclick=delProduct(${data["3"]}) data-original-title="Delete"
            						  	href="javascript:void(0);">
               						  	<i class="far fa-trash-alt  text-danger"></i>
          						    </a>`;

							}

						},
						{
							data: "1",
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
					{	
						data: '2',
							render: function(data) {
					return	`<td class="text-center"><a href="javascript:void(0)"
							data-toggle="popover" data-trigger="hover" data-html="true"
							data-placement="right"
							data-template='<div class="popover fade bs-popover-right" role="tooltip" x-placement="right"><div class="arrow"></div><h3 class="popover-header p-0 border_radius6"></h3></div>'
							data-title="<img src= pictures/`+ data +` height='150' class='border_radius6'>">
								<img src= pictures/`+ data +` alt="" width="25"
								height="25">
					</a></td>`;
					}
						},
						{ data: '3' },
						{ data: '4' },
						{ data: '5' },
						{ data: '0' },
						{ data: '6' },
						{ data: '7' },
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

let editisubcat = undefined;
function editProduct(productId) {

	console.log(productId)
	editid = productId

	$.ajax({
		type: "GET",
		url: "getId/" + productId,

		success: function(formData) {

			$(".activediv").show();

			$('#catName2').val(formData.categoryName),
				editisubcat = formData.subCategoryName;
			console.log(editisubcat)
			$('#Discription').val(formData.discription),

				//	$('#subCat').val(formData.subCategoryName),

				$("#proName").val(formData.productName),
				$("#price").val(formData.price),
				$("#manufactureDate").val(formData.manufactureDate),
				$("#slNo").val(formData.productSerialNo),
				$("#warrantyAndSupport").val(formData.warrantyAndSupport),
				//$("#image").val(formData.image),
				$('input[type=file]'),
				$("#discount").val(formData.discount),
				$("#validfrom_date").val(formData.dateFrom),
				$("#validto_date").val(formData.dateTo),

				$('#catName2').trigger("change").selectpicker('refresh');


			$('#subCat').selectpicker('refresh');

			//PRODUCT CONDITION
			let r = (formData.productCondition).split(",");
			console.log(r)
			var productCondition1 = document.getElementsByName("optradio");
			for (var j = 0; j < r.length; j++) {
				$("[name=optradio]").selectpicker("refresh");
				for (var i = 0; i < productCondition1.length; i++) {
					if (r[j] == productCondition1[i].value) {
						(productCondition1[i].checked = true)

					}
					//$("[name=optradio]").selectpicker("refresh");
				}
			}
			//$("[name=optradio]").val(formData.productCondition1)

			//PRODUCT COLOUR		
			let c = (formData.productColour).split(",");
			console.log(c)

			var productColour1 = document.getElementsByName("option1");
			for (var j = 0; j < c.length; j++) {
				$("[name=option1]").selectpicker("refresh");
				for (var i = 0; i < productColour1.length; i++) {
					if (c[j] == productColour1[i].value) {
						(productColour1[i].checked = true)

					}
					//$("[name=option1]").selectpicker("refresh");
				}
			}

			//	$("[name=option1]").val(formData.productColour1)



			if (formData.active == 1) {
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

function delProduct(productId) {
	console.log(productId)

	if (confirm("ARE YOU SURE YOU WANT TO DELETE?")) {
		$.ajax({

			method: 'DELETE',
			url: "Prodelete/" + productId,

			success: function(response) {

				loadTable1();

			},
			error: function(err) {
				alert(err)
			}
		});
	}
}




function clear() {
	$(".activediv").hide();

	document.getElementById("catName2").value = "";
	$('#catName2').selectpicker('refresh');
	document.getElementById("Discription").value = "";
	document.getElementById("subCat").value = "";
	$("#subCat").empty().selectpicker("refresh");
	document.getElementById("proName").value = "";
	document.getElementById("price").value = "";
	document.getElementById("manufactureDate").value = "";
	document.getElementById("slNo").value = "";
	document.getElementById("warrantyAndSupport").value = "";
	//document.getElementById("file").value = "";
	$("#remove").trigger("click");

	//var productCondition = $("#productCondition");
	var productCondition = document.getElementsByName("optradio");
	var i;
	for (i = 0; i < productCondition.length; i++) {
		productCondition[i].checked = false;
	}

	//var productColour = $("#productColour");
	var productColour = document.getElementsByName("option1");
	for (var i = 0; i < productColour.length; i++) {
		productColour[i].checked = false;
	}
	document.getElementById("discount").value = "";
	document.getElementById("validfrom_date").value = "";
	document.getElementById("validto_date").value = "";

}


$(document).on('click', '#add', function() {
	editid = undefined;
	$(".activediv").hide();

	clear();
});



function clearInput() {
	$('#form')[0].reset();
	document.getElementById("catName2").value = "";
	document.getElementById("Discription").value = "";
	document.getElementById("subCat").value = "";
	$('#subCat').selectpicker('refresh');
	$("#subCat").empty().selectpicker("refresh");
	//document.getElementById("Form").reset();
	document.getElementById("proName").value = "";
	document.getElementById("price").value = "";
	document.getElementById("manufactureDate").value = "";
	document.getElementById("slNo").value = "";
	document.getElementById("warrantyAndSupport").value = "";
	$("#remove").trigger("click");

	//var productCondition = $("#productCondition");
	var productCondition = document.getElementsByName("optradio");
	var i;
	for (i = 0; i < productCondition.length; i++) {
		productCondition[i].checked = false;
	}

	//var productColour = $("#productColour");
	var productColour = document.getElementsByName("option1");
	for (var i = 0; i < productColour.length; i++) {
		productColour[i].checked = false;
	}
	document.getElementById("discount").value = "";
	document.getElementById("validfrom_date").value = "";
	document.getElementById("validto_date").value = "";

}


