<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../jsp/head.jsp" %>

<c:url var="createStudentUrl" value="StudentController?newRecord=1" />
<c:url var="updateStudentUrl" value="StudentController?newRecord=0&id=" />

<div class="row">
<h1>${title}</h1>
</div>

<div class="row">
<form action="StudentController" method="post">
<input type="text" name="name">
<button type="submit">Search</button>
</form>
</div>

<a href="${createStudentUrl}" class="sa-button-create">Добавить</a>
<div class="row">
<table class="sa-table">
<thead class="sa-table-header">
<tr>
<th>ID</th>
<th>ФИО</th>
<th>Группа</th>
<th>Возраст</th>
<th>Операции</th>
</tr>
</thead>
<tbody class="sa-table-body">
<c:forEach var="student" items="${students}">
	<tr>
		<td><c:out value="${student.id}"/></td>
		<td><c:out value="${student.name}"/></td>
		<td><c:out value="${student.groupName}"/></td>
		<td><c:out value="${student.age}"/></td>
		<td><div><a href="${updateStudentUrl}${student.id}">Изменить</a></div>
		<div><a href="#">Удалить</a></div></td>
	</tr>
</c:forEach>
<c:if test="${empty students }">
	<p>Данных нет</p>
</c:if>
</tbody>
</table>
</div>




<%@ include file="../jsp/footer.jsp" %>