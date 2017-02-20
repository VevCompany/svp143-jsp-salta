<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../jsp/head.jsp" %>

<div class="row">
<div class="col-md-6">
<h1>${title}</h1>
</div>
</div>


<div class="row">
<div class="col-md-6">
<form action="StudentController" method="post">
<input class="form-control" type="text" name="name">
<button type="submit" class="btn btn-primary">Search</button>
</form>


<form class="form-inline">
  <div class="form-group has-success has-feedback">
    <input type="text" class="form-control" id="studentSearch" aria-describedby="studentSearchStatus" name="name">
    <span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true"></span>
    <span id="studentSearchStatus" class="sr-only">(success)</span>
  </div>
</form>

</div>
</div>


<div class="row">
<div class="col-md-6">
<table class="table table-striped table-hover"">
<thead>
<tr>
<th>ФИО</th>
<th>Группа</th>
</tr>
</thead>
<tbody>
<c:forEach var="student" items="${students}">
	<tr>
		<td><c:out value="${student.name}"/></td>
		<td><c:out value="${student.groupName}"/></td>
	</tr>
</c:forEach>
<c:if test="${empty students }">
	<p>Данных нет</p>
</c:if>
</tbody>
</table>
</div>
</div>




<%@ include file="../jsp/footer.jsp" %>