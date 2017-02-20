<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../jsp/head.jsp" %>
<div class="row">
	<div class="col-md-3 col-md-offset-4">
		<h1>${title}</h1>
	</div>
</div>
<div class="row">
	<div class="col-md-3 col-md-offset-4" style="top:150px;">
		<form action="LoginController" method="post">
			<label for="username">Username</label>
			<input class="form-control" id="username" type="text" name="username" required placeholder="Username">
			<label for="password">Password</label>
			<input class="form-control" id="password" type="password" name="password" required placeholder="password">
			<button type="submit" class="btn btn-success">Log In</button>
		</form>
	</div>
</div>

<%@ include file="../jsp/footer.jsp" %>