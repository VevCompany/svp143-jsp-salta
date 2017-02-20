<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../jsp/head.jsp" %>

<h1>${title}</h1>
<form action="StudentController" method="post">
<input type="text" name="name">
<input type="submit" value="Submit">
</form>

<table>
<tr>
<th>ФИО</th>
</tr>
<tr>
<th>Группа</th>
</tr>
<c:forEach var="student" items="${students}">
	<tr>
		<td><c:out value="${student.name}"/></td>
	</tr>
	<tr>
		<td><c:out value="${student.groupName}"/></td>
	</tr>
</c:forEach>
<c:if test="${empty students }">
	<p>Данных нет</p>
</c:if>
</table>


<%@ include file="../jsp/footer.jsp" %>