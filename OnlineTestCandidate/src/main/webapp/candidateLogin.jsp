<!DOCTYPE html>
<html>
<head>
	<title>Login | Xenture</title>
	<link rel="shortcut icon" type="image/png" href="assets/img/favicon.png" />

	<meta charset="UTF-8">
	<meta name="description" content="smart recuritment,job search">
	<meta name="keywords" content="trabaajo.com,Trabaajo,smart recuritment,job search">
	<meta name="author" content="Trabaajo">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	

	<link rel="stylesheet" type="text/css" href="assets/css/generic.css">
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="assets/css/material-kit.css">
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-custom.css">
	<link rel="stylesheet" type="text/css" href="assets/css/media.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body class="login-page">

	<header>
		<nav class="navbar navbar-primary navbar-transparent navbar-absolute">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>                        
					</button>
					<a class="navbar-brand" href="#">
						<img src="assets/img/logo.png" alt="logo">
					</a>
				</div>
			</div>
		</nav>
	</header> 
	<!-- ./header end -->

	<!-- ./header start -->
	<div class="body-bg page-header header-filter">
		<!-- ./section start -->
		<section class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
					<div class="card card-signup">
						<form class="form" method="POST" action="CandidateLoginController">
							<div class="header header-primary header-primary-custom text-center">
								<h4 class="card-title">Let's start to being part of Xenture !</h4>
							</div>
							<div class="row">
								    <div class="alert alert-success">
									  <div class="alert-icon">
										<i class="material-icons">check</i>
									  </div>
									  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">
												<i class="material-icons">clear</i>
											</span>
									  </button>
								      <p>Successfully Registered !!</p>
								    </div>
								</div>
							<div class="card-content">
								<div class="input-group">
									<span class="input-group-addon">
										<i class="material-icons">email</i>
									</span>
									<div class="form-group is-empty">
										<input type="text" name="candidateEmail" class="form-control" placeholder="Email...">
										<span class="material-input"></span>
									</div>
								</div>

								<div class="input-group">
									<span class="input-group-addon">
										<i class="material-icons">lock_outline</i>
									</span>
									<div class="form-group is-empty">
										<input type="password" name="candidatePassword" placeholder="Password..." class="form-control">
										<span class="material-input"></span>
									</div>
								</div>

   <%  String message = (String) session.getAttribute("message");
    if (message == null) 
    {
       message = null;
    }
    %>
    <%
    if (message != null)
    {
    %>
    <br>
    <div class="col-lg-12 col-md-12 col-sm-12 center-block">
    <div id="change-pwd" style="color: #ac2925; text-align: center;"><%=message%></div>
    </div>
    <%
     }
      request.getSession().removeAttribute("message");
    %>
								<div class="footer text-center">
									<button type="submit" class="btn btn-primary btn-round btn-wd btn-lg">		Login
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
		<!-- ./section body end -->

		<!-- ./footer start -->
		<footer class="footer">
	        <div class="container">
	            <div class="copyright">
	                &copy; 
	                <script type="text/javascript" async="" src="http://www.google-analytics.com/ga.js"></script>
	                <script>document.write(new Date().getFullYear())</script>, Copyright
	                	<a href="http://www.xenture.co/" target="_blank">Xenture Inc.</a>
	            </div>
	        </div>
	    </footer>
		<!-- ./footer end -->
	</div>

	<script type="text/javascript" src="assets/js/jquery.min.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/custom.js"></script>
	<script type="text/javascript" src="assets/js/material.min.js"></script>
	<script type="text/javascript" src="assets/js/material-kit.js"></script>
	<script type="text/javascript" src="assets/js/nouislider.min.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>
</body>
</html>