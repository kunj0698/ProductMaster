<!DOCTYPE html>

<html class="loading" lang="en" data-textdirection="ltr">
<!-- BEGIN: Head-->


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
<title>Emerging Five - User Master</title>
<link rel="icon" type="image/x-icon"
	href="assets/custom/images/favicon.png" />


<!-- BEGIN: Custom CSS-->
<link rel="stylesheet" type="text/css"
	href="assets/custom/css/imports.css">

<!-- END: Custom CSS-->
<style>
/* .popover { 
        pointer-events: none !important;
    } */
</style>
</head>
<!-- END: Head-->

<!-- BEGIN: Body-->

<body
	class="horizontal-layout horizontal-menu  navbar-sticky footer-fixed  "
	data-open="hover" data-menu="horizontal-menu" data-col="">

	<div class="preloader"></div>

	<!-- BEGIN: Header-->
	<script src="assets/custom/js/header.js"></script>
	<script language="javascript" type="text/javascript">
    document.getElementById('product_master').className = "active";
  </script>
	<!-- END: Header-->




	<!-- BEGIN: Content-->
	<div class="app-content content ">
		<div class="content-overlay"></div>
		<div class="row pl-1 pr-1 p-b-5">
			<div class="col-xl-6 col-lg-6 col-sm-6 colmspadding padding0 width50">
				<div class="font-20">
					<span class="text-primary font-weight-700">Product Master</span>
				</div>
			</div>
			<div
				class="col-xl-6 col-lg-6 col-sm-6 colmspadding padding0 width50 text-right">
				<a href="ProductExcel" class="btn  btn-success m-r-5"> <i
					class="fas fa-file-excel m-r-5"></i> Excel

				</a> <a class="btn btn-primary" data-toggle="modal"
					data-target=".addmodal" id="add" onclick="clear()"> <i class="fas fa-plus m-r-5"></i> Add
				</a>
			</div>
		</div>
		</div>
		<div class="datatable-design mb-0 pt-1 bg-white resize_wrapper">
			<table id="product_table" class="table table-striped table-custom-hover nowrap  display " style="width: 100%;">
				<thead>
					<tr>

						<th class="text-center" width="5%">Action</th>
						<th width="5%">Active</th>
						<th width="5%" class="text-center">Image</th>
						<th>Product Id</th>
						<th>Product Name</th>
						<th width="30%">Description</th>
						<th>Category</th>
						<th class="text-right">Price</th>
						<th class="text-right">Discount</th>
					</tr>
				</thead>
		
				<%-- <tbody>
					<tr>

						<td class="text-center"><span data-toggle="modal"
							data-target=".addmodal"> <a class=" "
								data-toggle="tooltip" data-placement="bottom"
								data-original-title="Edit" href="javascript:void(0);"> <i
									class="fas fa-edit m-r-5 text-success"></i>
							</a>
						</span> <a class=" delete_alert " data-toggle="tooltip"
							data-placement="bottom" data-original-title="Delete"
							href="javascript:void(0);"> <i
								class="far fa-trash-alt  text-danger"></i>
						</a></td>
						<td class=""><span class="badge badge-success">Yes</span></td>


						<td class="text-center"><a href="javascript:void(0)"
							data-toggle="popover" data-trigger="hover" data-html="true"
							data-placement="right"
							data-template='<div class="popover fade bs-popover-right" role="tooltip" x-placement="right"><div class="arrow"></div><h3 class="popover-header p-0 border_radius6"></h3></div>'
							data-title="<img src='assets/custom/images/noimage.png' height='150' class='border_radius6'>">
								<img src="assets/custom/images/noimage.png" alt="" width="25"
								height="25">
						</a></td>
						<td>1</td>
						<td>Bag</td>
						<td>Details of Bag</td>
						<td>Bag</td>
						<td class="text-right">139.00 INR</td>
						<td class="text-right">5 %</td>
					</tr>


					<tr>

						<td class="text-center"><span data-toggle="modal"
							data-target=".addmodal"> <a class=" "
								data-toggle="tooltip" data-placement="bottom"
								data-original-title="Edit" href="javascript:void(0);"> <i
									class="fas fa-edit m-r-5 text-success"></i>
							</a>
						</span> <a class=" delete_alert " data-toggle="tooltip"
							data-placement="bottom" data-original-title="Delete"
							href="javascript:void(0);"> <i
								class="far fa-trash-alt  text-danger"></i>
						</a></td>
						<td class=""><span class="badge badge-danger">No</span></td>


						<td class="text-center"><a href="javascript:void(0)"
							data-toggle="popover" data-trigger="hover" data-html="true"
							data-placement="right"
							data-template='<div class="popover fade bs-popover-right" role="tooltip" x-placement="right"><div class="arrow"></div><h3 class="popover-header p-0 border_radius6"></h3></div>'
							data-title="<img src='assets/custom/images/noimage.png' height='150' class='border_radius6'>">
								<img src="assets/custom/images/noimage.png" alt="" width="25"
								height="25">
						</a></td>
						<td>2</td>
						<td>Pouch</td>
						<td>Details of Pouch</td>
						<td>Organizer</td>
						<td class="text-right">250.00 INR</td>
						<td class="text-right">8 %</td>
					</tr>


					<tr>

						<td class="text-center"><span data-toggle="modal"
							data-target=".addmodal"> <a class=" "
								data-toggle="tooltip" data-placement="bottom"
								data-original-title="Edit" href="javascript:void(0);"> <i
									class="fas fa-edit m-r-5 text-success"></i>
							</a>
						</span> <a class=" delete_alert " data-toggle="tooltip"
							data-placement="bottom" data-original-title="Delete"
							href="javascript:void(0);"> <i
								class="far fa-trash-alt  text-danger"></i>
						</a></td>
						<td class=""><span class="badge badge-success">Yes</span></td>


						<td class="text-center"><a href="javascript:void(0)"
							data-toggle="popover" data-trigger="hover" data-html="true"
							data-placement="right"
							data-template='<div class="popover fade bs-popover-right" role="tooltip" x-placement="right"><div class="arrow"></div><h3 class="popover-header p-0 border_radius6"></h3></div>'
							data-title="<img src='assets/custom/images/noimage.png' height='150' class='border_radius6'>">
								<img src="assets/custom/images/noimage.png" alt="" width="25"
								height="25">
						</a></td>
						<td>3</td>
						<td>Purse</td>
						<td>Details of Purse</td>
						<td>Purse</td>
						<td class="text-right">1000.00 INR</td>
						<td class="text-right">10 %</td>
					</tr>
					<tr>

						<td class="text-center"><span data-toggle="modal"
							data-target=".addmodal"> <a class=" "
								data-toggle="tooltip" data-placement="bottom"
								data-original-title="Edit" href="javascript:void(0);"> <i
									class="fas fa-edit m-r-5 text-success"></i>
							</a>
						</span> <a class=" delete_alert " data-toggle="tooltip"
							data-placement="bottom" data-original-title="Delete"
							href="javascript:void(0);"> <i
								class="far fa-trash-alt  text-danger"></i>
						</a></td>
						<td class=""><span class="badge badge-success">Yes</span></td>


						<td class="text-center"><a href="javascript:void(0)"
							data-toggle="popover" data-trigger="hover" data-html="true"
							data-placement="right"
							data-template='<div class="popover fade bs-popover-right" role="tooltip" x-placement="right"><div class="arrow"></div><h3 class="popover-header p-0 border_radius6"></h3></div>'
							data-title="<img src='assets/custom/images/noimage.png' height='150' class='border_radius6'>">
								<img src="assets/custom/images/noimage.png" alt="" width="25"
								height="25">
						</a></td>
						<td>4</td>
						<td>Bottle</td>
						<td>Details of Bottle</td>
						<td>Others</td>
						<td class="text-right">900.00 INR</td>
						<td class="text-right">15 %</td>
					</tr>

				</tbody>--%>
			</table> 
	


	</div>
	<!-- END: Content-->

 <form id="form">
 
	<div class="modal modal-right fade addmodal" data-keyboard="false"
		data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby=""
		aria-hidden="true">
		<div
			class="modal-dialog modal-right-full-width  modal-dialog-scrollable"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<label class="modal-title " id="">Add/Edit Product Master</label>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"  id="addEdit" onclick="clearInput()">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body ">
					<div class="card m-b-5">
						<div class="header">
							<h6 class="mb-0">
								<span class="text-blue font-20">Basic </span><span
									class="font-20">Details</span>
							</h6>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-xl-4 col-lg-12 col-sm-12 mb-2">
									<label class=" lable-align">Product Name</label> <input
										type="text" class="form-control fieldmandatory"
										placeholder="Enter Product Name" id="proName"
										name="ProductName">
								</div>
								<div class="col-xl-8 col-lg-12 col-sm-12 mb-2">
									<label class="lable-align">Description</label>
									<textarea class="form-control fieldmandatory textareasize" placeholder="Enter Description" id="Discription" name="Discription"></textarea>
								</div>
								<div class="col-xl-2 col-lg-12 col-sm-12 mb-2">
									<label class="lable-align">Category</label> <select
										class="selectpicker form-control typecombo"
										data-title="Select Category"
										data-style=" bg-transfer fieldmandatory"
										data-live-search="true" data-size="5" id="catName2"
										name="CategoryName">
										<!--  <option value="1">Electronics</option>
                    <option value="2">Men's Fashion</option>
                    <option value="3">Women's Fashion</option> -->
									</select>
								</div>
								<div class="col-xl-2 col-lg-12 col-sm-12 mb-2">
									<label class="lable-align">Sub Category</label> <select
										class="selectpicker form-control typecombo"
										data-title="Select Sub Category"
										data-style=" bg-transfer fieldmandatory"
										data-live-search="true" data-size="5" id="subCat"
										name="SubCategoryName">
										<!-- <option value="1">TV</option>
                    <option value="2">Speakers</option>
                    <option value="3">Washing Machine</option> -->
									</select>
								</div>
								<div class="col-xl-2 col-lg-12 col-sm-12 mb-2">
									<label class=" lable-align">Price</label>
									<div class="input-group ">
										<div class="input-group-prepend ">
											<span class="input-group-text fieldmandatory"><i
												class="fas fa-rupee-sign"></i></span>
										</div>
										<input type="text" class="form-control"
											placeholder="Enter Price" id="price" name="Price">
									</div>
								</div>
								<div class="col-xl-2 col-lg-12 col-sm-12 mb-2">
									<label class=" lable-align">Manufacture Date</label>
									<div class="input-group date">
										<input type="text" class="form-control fieldmandatory"
											id="manufactureDate" name="ManufactureDate" placeholder="Select Date"> <span
											class="input-group-addon inputgroups"> <i
											class="far fa-calendar-alt"></i>
										</span>
									</div>
								</div>
								<div class="col-xl-4 col-lg-12 col-sm-12 mb-2">
									<label class=" lable-align">Product Serial No.</label> <input
										type="text" class="form-control fieldmandatory"
										placeholder="Enter Product Serial No." id="slNo"
										Name="ProductSerialNo">
								</div>
								<div class="col-xl-4 col-lg-12 col-sm-12 mb-2">
									<label class="lable-align">Warranty & Support</label>
									<textarea class="form-control fieldmandatory textareasize"
										placeholder="Enter Warranty & Support" id="warrantyAndSupport"
										name="WarrantyAndSupport"></textarea>
								</div>
								<div class="col-xl-4 col-lg-12 col-sm-12 mb-2" >
									<label class="lable-align">Image Upload</label>
									<div class="form-group mb-0 width300">
										<div class="fileinput fileinput-new input-groups"
											data-provides="fileinput">
											<div class="form-control fieldmandatory"
												data-trigger="fileinput" >
												<i class="fa fa-file fileinput-exists mr-1 m-t-4"
													aria-hidden="true" id="image" ></i> <span
													class="fileinput-filename"></span>
											</div>

											<span
												class="input-groups-addon fileupload btn btn-success btn-anim btn-file waves-effect waves-float waves-light"><i
												class="fa fa-upload"></i> <span
												class="fileinput-new btn-text">Select file</span> <span
												class="fileinput-exists btn-text">Change</span> <input
												type="file" name="file" accept="image/*" id="file"> </span>

											<a href="javascript:void(0)"
												class="input-groups-addon btn btn-secondary btn-anim fileinput-exists waves-effect waves-float waves-light"
												data-dismiss="fileinput" id="remove"><i
												class="fa fa-trash"></i><span class="btn-text">
													Remove</span></a>
										</div>
									</div>
								</div>

							</div>

							<div class="row">
								<div class="col-xl-4 col-lg-12 col-sm-12">
									<label class=" lable-align">Product Condition</label>
									<div class="d-flex">
										<div class="form-check mr-1" >
											<input type="radio" class="form-check-input" id="old"
												name="optradio" value="Old"> <label
												class="form-check-label" for="radio1">Old</label>
										</div>
										<div class="form-check mr-1">
											<input type="radio" class="form-check-input" id="new"
												name="optradio" value="New"> <label
												class="form-check-label" for="radio2">New</label>
										</div>
										<div class="form-check">
											<input type="radio" class="form-check-input" id="refurbished"
												name="optradio" value="Refurbished"> <label
												class="form-check-label" for="radio3">Refurbished</label>
										</div>
									</div>
								</div>
								<div class="col-xl-4 col-lg-12 col-sm-12">
									<label class=" lable-align">Product Colour</label>
									<div class="d-flex">
										<div class="form-check mr-1" id="productColour" name="ProductColour">
											<input class="form-check-input" type="checkbox" id="red"
												name="option1" value="Red"> <label
												class="form-check-label" for="check1">Red</label>
										</div>
										<div class="form-check mr-1">
											<input class="form-check-input" type="checkbox" id="black"
												name="option1" value="Black"> <label
												class="form-check-label" for="check2">Black</label>
										</div>
										<div class="form-check mr-1">
											<input class="form-check-input" type="checkbox" id="gold"
												name="option1" value="Gold"> <label
												class="form-check-label" for="check3">Gold</label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="checkbox" id="blue"
												name="option1" value="Blue"> <label
												class="form-check-label" for="check4">Blue</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="card">
						<div class="header">
							<h6 class="mb-0">
								<span class="text-blue font-20">Product </span><span
									class="font-20">Discount</span>
							</h6>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-xl-2 col-lg-12 col-sm-12 mb-1">
									<label class=" lable-align">Discount</label> <input type="text"
										class="form-control fieldmandatory"
										placeholder="Enter Discount" id="discount" name="Discount">
								</div>
								<div class="col-xl-2 col-lg-12 col-sm-12 mb-1">
									<label class=" lable-align">Valid From</label>
									<div class="input-group date">
										<input type="text" class="form-control fieldmandatory"
											id="validfrom_date" name="DateFrom" placeholder="Select Date"> <span
											class="input-group-addon inputgroups"> <i
											class="far fa-calendar-alt"></i>
										</span>
									</div>
								</div>
								<div class="col-xl-2 col-lg-12 col-sm-12 mb-1">
									<label class=" lable-align">Valid To</label>
									<div class="input-group date">
										<input type="text" class="form-control fieldmandatory"
											id="validto_date" name="DateTo" placeholder="Select Date"> <span
											class="input-group-addon inputgroups"> <i
											class="far fa-calendar-alt"></i>
										</span>
									</div>
								</div>
							</div>
						</div>
					</div>


				</div>
				<div class="modal-footer">
					<div class="row">
						<div
							class="col-xl-6 col-lg-6 col-sm-6 text-right colmspadding width50">
							<div class="form-check float-left activediv" style="display: none;">
								<input type="checkbox" class="form-check-input " id="active">
								<label class="form-check-label mb-0" for="active">Active</label>
							</div>
						</div>
						<div
							class="col-xl-6 col-lg-6 col-sm-6 text-right colmspadding width50">
							<a href="javascript:void(0)" class="btn btn-success  m-r-5"
							 id="save"> <i class="far fa-save m-r-5"></i>
								Save
							</a> <a href="javascript:void(0)" class="btn btn-secondary "
								data-dismiss="modal" id="close" onclick="clearInput()"> <i class="fas fa-times m-r-5 "></i>
								Close
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
 </form>

	<!-- BEGIN: Footer-->
	<script src="assets/custom/js/footer.js"></script>
	<!-- END: Footer-->


	<!-- BEGIN: Vendor JS-->
	<script src="assets/vendors/js/vendors.min.js"></script>
	<!-- BEGIN Vendor JS-->

	<!-- BEGIN: Page Vendor JS-->
	<script src="assets/vendors/js/ui/jquery.sticky.js"></script>


	<!-- END: Page Vendor JS-->

	<!-- BEGIN: Theme JS-->
	<script src="assets/js/core/app-menu.min.js"></script>
	<script src="assets/js/core/app.min.js"></script>
	<script src="assets/js/scripts/customizer.min.js"></script>
	<!-- END: Theme JS-->

	<!-- BEGIN: Page JS-->
	<script src="assets/custom/plugins/jquery-ui/jquery-ui.min.js"></script>
	<script src="assets/custom/plugins/datatables/js/datatables.min.js"></script>
	<script
		src="assets/custom/plugins/datatables/js/dataTables.responsive.min.js"></script>
	<script src="assets/custom/plugins/datatables/js/dataTables.colVis.js"></script>
	<script
		src="assets/custom/plugins/datatables/js/dataTables.scrollResize.js"></script>
	<script src="assets/custom/plugins/scrollable/js/scrollabar.min.js"></script>
	<script src="assets/custom/plugins/scrollable/js/scrollable.js"></script>
	<script
		src="assets/custom/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
	<script
		src="assets/custom/plugins/bootstrap-select/bootstrap-select.js"></script>
	<script
		src="assets/custom/plugins/jquery_confirm_v3/jquery-confirm.min.js"></script>
	<script
		src="assets/custom/plugins/jasny-bootstrap/dist/js/jasny-bootstrap.min.js"></script>
	<script src="assets/custom/plugins/img_cropper/js/cropper_min.js"></script>
	<script
		src="assets/custom/plugins/jquery_confirm_v3/jquery-confirm-custom.js"></script>
	<script src="assets/custom/plugins/jquery_toastr/jquery.toast.min.js"></script>
	<!-- END: Page JS-->
	<script src="assets/custom/js/custom.js"></script>

	<script>


    $(window).on('load', function () {
      if (feather) {
        feather.replace({ width: 14, height: 14 });
      }
    })


    $('#product_table').DataTable({
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
      "columnDefs": [{
        "targets": [0],
        "orderable": false,
        // "width": "2%",
      }],
      "pageLength": 15,

      fixedColumns: {
        rightColumns: 0,
        leftColumns: 0
      },
      language: {
        paginate: {
          next: '<i class="fa fa-angle-double-right">',
          previous: '<i class="fa fa-angle-double-left">'
        }
      },
      dom:
        "<'row pl-0 pr-1'<'col-xl-9 col-lg-8 col-sm-8'pi><'col-xl-3 col-lg-4 col-sm-4'f>>" +
        "<'row pl-1 pr-1'<'col-xl-12 col-lg-12 col-sm-12'tr>>"

    });

    /* $('#start_date').closest('div').datepicker({
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
        }); */
  </script>
   <script src="js/ProductMaster.js"></script>
</body>
<!-- END: Body-->


</html>