
<!DOCTYPE html>

<html class="loading" lang="en" data-textdirection="ltr">
<!-- BEGIN: Head-->


<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
  <title>Emerging Five - Login</title>
  <link rel="icon" type="image/x-icon" href="assets/custom/images/favicon.png" />

  <!-- BEGIN: Custom CSS-->
  <link rel="stylesheet" type="text/css" href="assets/custom/css/imports.css">
  <link rel="stylesheet" type="text/css" href="assets/custom/css/login.css">

  <!-- END: Custom CSS-->  
</head>
<!-- END: Head-->

<!-- BEGIN: Body-->

<body class="horizontal-layout horizontal-menu  navbar-sticky footer-fixed  " data-open="hover"
  data-menu="horizontal-menu" data-col="">

  

  <!-- BEGIN: Content-->
  <div class="app-content content ">
    <div class="content-overlay"></div>
    <div class="header-navbar-shadow"></div>
    <div class="content-wrapper">
      <div class="content-header row">
      </div>
      <div class="content-body">
        <div class="auth-wrapper auth-v2">
          <div class="auth-inner row m-0">
           
            <!-- Left Text-->
            <div class="col-xl-8 col-lg-6 col-sm-6 pl-0 pr-0 ">
              <img class="img-fluid" src="assets/custom/images/bg1.jpg" alt="Login"/>
            </div>
            <!-- /Left Text-->
            <!-- Login-->
            <div class="d-flex col-xl-4 col-lg-6 col-sm-6  auth-bg pt-120">
              <div class="col-xl-12 col-lg-12 col-sm-12 px-xl-2 mb-110">
                <div class="text-center border-bottom">
                    <img src="assets/custom/images/logo_01.png"  alt="logo" width="150">
                    
                    <p class="card-text text-dark p-b-5">Login into your account</p>
                </div>
                <form name="loginForm" class="m-t-5 loginforms">
                    <div class="form">                       
                  <div class="form-group">
                    <label class="form-label">Email</label>                  
                    <div class="input-group ">
                      <div class="input-group-prepend ">
                        <span class="input-group-text "><i class="fas fa-user"></i></span>
                      </div>
                      <input type="text" id="email" class="form-control" placeholder="Enter Email Id">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="d-flex justify-content-between">
                      <label for="login-password">Password</label>
                    </div>                  
                    <div class="input-group ">
                      <div class="input-group-prepend ">
                        <span class="input-group-text "><i class="fas fa-key"></i></span>
                      </div>
                      <input type="password" id="password" class="form-control" placeholder="Enter Password">
                    </div>
                  </div>                 
                  <a class="btn btn-primary btn-block"  id="save"><i class="fas fa-sign-out-alt m-r-5"></i>Login </a>                
                  <a class="btn btn-success btn-block" href="signup.html" ><i class="fas fa-user-plus m-r-5"></i>Sign Up </a>                
            </div>
                </form>
         <!--    href="product"  -->
                
              </div>
            </div>
            <!-- /Login-->
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- END: Content-->



 



   <!-- BEGIN: Footer-->
   <script src="assets/custom/js/login_footer.js"></script>
   <!-- END: Footer-->
  
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

  <script src="assets/custom/plugins/bootstrap-select/bootstrap-select.js"></script>


  <!-- END: Page JS-->
  <script src="assets/custom/js/custom.js"></script>
   <script src="js/Login.js"></script>
  <script>


    $(window).on('load', function () {
      if (feather) {
        feather.replace({ width: 14, height: 14 });
      }
    })


   

    $('#username').focus();
        $(document).keypress(function (e) {
            if (e.which == 13) {
                login();
            }
        });


  </script>

</body>
<!-- END: Body-->


</html>