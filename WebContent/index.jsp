<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="scripts/tools.js"></script>
<title>Login</title>

<script>
	<c:if test="${not empty registrationFail}">
		$(document).ready(function() {
			$('#loginbox').hide();
			$('#signupbox').show();
			$('#signupalert').show();
		});
	</c:if>
	<c:if test="${not empty loginFail}">
		$(document).ready(function() {
			$('#login-alert').show();
		});
	</c:if>
</script>


</head>
<body>
	
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
				</div>
				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert" class="alert alert-danger col-sm-12">
						<c:if test="${not empty loginFail}">
							<c:out value="${loginFail}"></c:out>			
						</c:if>
					</div>
					
					<c:if test="${not empty registrationSuccess}">					
						<div class="alert alert-success col-sm-12">
							<c:out value="${registrationSuccess}"></c:out>
						</div>					
					</c:if>
					
					<form id="loginform" class="form-horizontal" role="form" action="Login" method="post">
						<input type="hidden" name="pageName" value="loginform"/>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control" name="username" value=""
								placeholder="username">
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="password"
								placeholder="password">
						</div>



						<div class="input-group">
							<div class="checkbox">
								<label> <input id="login-remember" type="checkbox"
									name="remember" value="1"> Remember me
								</label>
							</div>
						</div>


						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">
								<a id="btn-login" onclick="document.getElementById('loginform').submit();" class="btn btn-success">Login </a>
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
									Don't have an account! <a href="#"
										onClick="$('#loginbox').hide(); $('#signupbox').show()">
										Sign Up Here </a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="signupbox" style="display: none; margin-top: 50px"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign Up</div>
					<div
						style="float: right; font-size: 85%; position: relative; top: -10px">
						<a id="signinlink" href="#"
							onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign
							In</a>
					</div>
				</div>
				<div class="panel-body">
					<form id="signupform" class="form-horizontal" role="form" action="Login" method="post">
						<input type="hidden" name="pageName" value="signupform"/>
						<div id="signupalert" style="display: none"	class="alert alert-danger">
							<c:if test="${not empty registrationFail}">
								<c:out value="${registrationFail}"></c:out>			
							</c:if>
						</div>



						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Username</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="username" id="signup-username"
									placeholder="Username max 45 characters" onkeyup="validerSaisie('signup-username')">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password</label>
							<div class="col-md-9">
								<input type="password" id="signup-password" class="form-control" name="password"
									placeholder="Password" onkeyup="validerSaisie('signup-password')">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Confirm password</label>
							<div class="col-md-9">
								<input type="password" id="signup-password-confirm" class="form-control" name="password"
									placeholder="Password" onkeyup="validerSaisie('signup-password-confirm')">
							</div>
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-signup" type="submit" class="btn btn-info" disabled>
									<i class="icon-hand-right"></i> &nbsp; Sign Up
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	
					
	<script>
		function validerSaisie(champs) {
			var div = document.getElementById('signupalert');
			if (getText(champs) && !getText(champs).match(/^[0-9a-zA-Z]+$/)) {
				div.innerHTML = 'Please enter only alphanumeric characters';
				$('#signupalert').show();
			}else{
				div.innerHTML = '';
				$('#signupalert').hide();
			}
			if(champs == "signup-username"){
				if(getText(champs).length > 45){
					if(div.innerHTML){
						div.innerHTML = div.innerHTML + '<br />Username can not exceed 45 characters';						
					}
					else{
						div.innerHTML = 'Username can not exceed 45 characters';
					}
					$('#signupalert').show();					
				}
			}
			$('#btn-signup').prop('disabled', true);
			if(getText('signup-password') && getText('signup-password-confirm')){
				if(getText('signup-password') != getText('signup-password-confirm')){
					if(div.innerHTML){
						div.innerHTML = div.innerHTML + '<br />Passwords don\'t match';						
					}
					else{
						div.innerHTML = 'Passwords don\'t match';
					}
					$('#signupalert').show();
				}
				else{
					if(getText('signup-username') && getText('signup-username').match(/^[0-9a-zA-Z]+$/)){
						$('#btn-signup').prop('disabled', false);						
					}
				}
			}				
		}
	</script>
</body>
</html>