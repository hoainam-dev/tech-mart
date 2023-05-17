<%@page import="utils.CookieUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Register</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<style>
	.submit{
		text-align: center;
		justify-content: center;
	}
	
	.submit button{
		width: 100%;
	}
</style>
<body>
	<div class="container">
		<div class="offset-3 col-6">
			<br><br>
			<div class="row">
				<div class="col-1">
					<a href="/login"><i style="font-size:30px" class="fas fa-arrow-left"></i></a>
				</div>
				<div class="col-1">
					<a href="/"><i style="font-size:30px" class="fas fa-home"></i></a>
				</div>
			</div><br>
			<p class="h3">Register</p><br>
			<form action="register" method="POST">
			<%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>
				<div class="form-group">
					<label for="exampleInputFirstName1">First Name</label> <input
						type="text" class="form-control" name="firstName" autocomplete="off"/>
				</div>
				<div class="form-group">
					<label for="exampleInputLastName1">Last Name</label> <input
						type="text" class="form-control" name="lastName" autocomplete="off"/>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						type="text" class="form-control" name="email" autocomplete="off"/>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" name="password" size="50"
						autocomplete="off"/>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Confirm Password</label> <input
						type="password" class="form-control" name="confirmpassword" size="50"
						autocomplete="off"/>
				</div>
				<div class="submit">
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>