<%@page import="utils.CookieUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<style>
	.submit{
		text-align: center;
		justify-content: center;
	}
	.submit button, a{
		width: 100%
	}
	.submit a{
		text-decoration:none;
	}
</style>
<body>
	<%
		String userName = CookieUtils.get("cookuser", request);
		String password = CookieUtils.get("cookpass", request);
		String rememberVal = CookieUtils.get("cookrem", request);
	%>
	<div class="offset-3 col-6">
		<br> <br>
		<div class="row"><a href="/"><i style="font-size:30px" class="fas fa-home"></i></a></div>
		<br>
		<p class="h3">Login</p>
		<form action="/login" method="POST">
			<span style="color:red"><%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%></span>
			<div class="form-group">
				<label for="exampleInputEmail1">Email</label> <input
					type="text" class="form-control" name="username" autocomplete="off"
					value="<%=userName%>"/>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" name="password" size="50"
					autocomplete="off" value="<%=password%>" />
			</div>
			<div class="">
				<input type="checkbox" class="" name="remember"
					value="1"
					<%="1".equals(rememberVal.trim()) ? "checked=\"checked\"" : ""%> />
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>	
			</div><br>
			<div class="submit">
				<button type="submit" class="btn btn-primary">Login</button><br><br>
				<p>You don't have account? <a href="/register"> Đăng ký</a></p>
			</div>
		</form>
		
	</div>
</body>
</html>