<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    String id = request.getParameter("ques_id");
	String driverName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String dbName = "xenture_online_test";
	String userId = "root";
	String password = "";
	
	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
	<title>Online Test | Xenture</title>
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
	<!-- =============== header start ================= -->
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
	<!-- =============== header end ================= -->

	<!-- =============== page-header start ================= -->
	<div class="body-bg page-header header-filter">
		<!-- =============== section start ================= -->
		<section class="container">
			<!-- =============== row start ================= -->
			<div class="row">
				<!-- =============== col-md-12 Start ================= -->
				<div class="col-md-12">
					<!-- =============== card start ================= -->
					<div class="card card-signup">
						<!-- =============== card-header start ================= -->
						<div class="header header-primary header-primary-custom text-center">
							<h4 class="card-title">Name Of Candidate - Shubham Sharma</h4>
							<div class="timer-div">Time left = <span id="timer"></span></div>
						</div>
						<!-- =============== card-header End ================= -->
<%
	try{	
		connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
		statement=connection.createStatement();
		String sql ="SELECT * FROM question";

		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
%>						
						<!-- =============== card-content start ================= -->	
						<div class="card-content exam-box">
							<!-- =============== Question wrapper start ================= -->
							<div id="q0" class="question active">
								<!-- =============== Question box start ================= -->
								<div class="question-box">
									<span class="sr-no"><%=resultSet.getString("ques_id") %></span>
									<p class="q-txt dib">
										<%=resultSet.getString("ques_question") %>
									</p>
								</div>
								<!-- ================ Question box end ================== -->
								<!-- =============== Option box start ================= -->
								<div class="option-box">
									<ul>
										<!-- =============== Option1 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													<%=resultSet.getString("quest_ans_opt1") %>
												</label>
											</div>
										</li>
										<!-- =============== Option1 end ================= -->
										<!-- =============== Option2 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													<%=resultSet.getString("quest_ans_opt2") %>
												</label>
											</div>
										</li>
										<!-- =============== Option2 end ================= -->
										<!-- =============== Option3 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													<%=resultSet.getString("quest_ans_opt3") %>
												</label>
											</div>
										</li>
										<!-- =============== Option3 end ================= -->
										<!-- =============== Option4 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													<%=resultSet.getString("quest_ans_opt4") %>
												</label>
											</div>
										</li>
										<!-- =============== Option4 end ================= -->
									</ul>
								</div>
								<!-- =============== Option box end ================= -->
							</div>

							<!-- =============== Question wrapper End ================= -->
							<!-- =============== Question wrapper start ================= -->
							<div id="q1" class="question">
								<!-- =============== Question box start ================= -->
								<div class="question-box">
									<span class="sr-no">2.</span>
									<p class="q-txt dib">
									   The language spoken by the people by Pakistan is ?
									</p>
								</div>
								<!-- ================ Question box end ================== -->
								<!-- =============== Option box start ================= -->
								<div class="option-box">
									<ul>
										<!-- =============== Option1 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Hindi
												</label>
											</div>
										</li>
										<!-- =============== Option1 end ================= -->
										<!-- =============== Option2 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Palauan
												</label>
											</div>
										</li>
										<!-- =============== Option2 end ================= -->
										<!-- =============== Option3 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Sindhi
												</label>
											</div>
										</li>
										<!-- =============== Option3 end ================= -->
										<!-- =============== Option4 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Nauruan
												</label>
											</div>
										</li>
										<!-- =============== Option4 end ================= -->
									</ul>
								</div>
								<!-- =============== Option box end ================= -->
							</div>
							<!-- =============== Question wrapper End ================= -->
							<!-- =============== Question wrapper start ================= -->
							<div id="q2" class="question">
								<!-- =============== Question box start ================= -->
								<div class="question-box">
									<span class="sr-no">3.</span>
									<p class="q-txt dib">
										The language spoken by the people by Pakistan is ?
									</p>
								</div>
								<!-- ================ Question box end ================== -->
								<!-- =============== Option box start ================= -->
								<div class="option-box">
									<ul>
										<!-- =============== Option1 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Hindi
												</label>
											</div>
										</li>
										<!-- =============== Option1 end ================= -->
										<!-- =============== Option2 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Palauan
												</label>
											</div>
										</li>
										<!-- =============== Option2 end ================= -->
										<!-- =============== Option3 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Sindhi
												</label>
											</div>
										</li>
										<!-- =============== Option3 end ================= -->
										<!-- =============== Option4 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Nauruan
												</label>
											</div>
										</li>
										<!-- =============== Option4 end ================= -->
									</ul>
								</div>
								<!-- =============== Option box end ================= -->
							</div>
							<!-- =============== Question wrapper End ================= -->
							<!-- =============== Question wrapper start ================= -->
							<div id="q3" class="question">
								<!-- =============== Question box start ================= -->
								<div class="question-box">
									<span class="sr-no">4.</span>
									<p class="q-txt dib">
										The language spoken by the people by Pakistan is ?
									</p>
								</div>
								<!-- ================ Question box end ================== -->
								<!-- =============== Option box start ================= -->
								<div class="option-box">
									<ul>
										<!-- =============== Option1 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Hindi
												</label>
											</div>
										</li>
										<!-- =============== Option1 end ================= -->
										<!-- =============== Option2 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Palauan
												</label>
											</div>
										</li>
										<!-- =============== Option2 end ================= -->
										<!-- =============== Option3 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Sindhi
												</label>
											</div>
										</li>
										<!-- =============== Option3 end ================= -->
										<!-- =============== Option4 start ================= -->
										<li>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios">
													Nauruan
												</label>
											</div>
										</li>
										<!-- =============== Option4 end ================= -->
									</ul>
								</div>
								<!-- =============== Option box end ================= -->
							</div>
							<!-- =============== Question wrapper End ================= -->
							<!-- =============== Next Button Start ================= -->
							<div class="footer text-center">
								<button type="submit" onclick="next()" class="btn btn-primary btn-round btn-wd btn-lg next">		
									Next
								</button>
							</div>
							<!-- =============== Next Button End ================= -->
						</div>
						<!-- =============== card-content End ================= -->
					</div>
					<!-- =============== card End ================= -->
				</div>
				<!-- =============== col-md-12 End ================= -->
			</div>
<%		
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
			<!-- =============== row End ================= -->
		</section>
		<!-- =============== section end ================= -->

		<!-- =============== footer start ================= -->
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
		<!-- =============== footer end ================= -->
	</div>
	<!-- =============== page-header end ================= -->

	<script type="text/javascript" src="assets/js/jquery.min.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/custom.js"></script>
	<script type="text/javascript" src="assets/js/material.min.js"></script>
	<script type="text/javascript" src="assets/js/material-kit.js"></script>
	<script type="text/javascript" src="assets/js/nouislider.min.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>
</body>
</html>