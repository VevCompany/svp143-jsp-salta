<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../jsp/head.jsp" %>


<form action="StudentController" method="post">
<input type="hidden" name="id" value="${id}">
<input type="text" name="name" value="${name}">
<input type="text" name="group_name" value="${group_name}">
<input type="text" name="age" value="${age}">
<input type="hidden" name="newRecord" value="${newRecord}">
<input type="submit" value="${newRecord==1?'Создать':'Изменить'}">
</form>


<%@ include file="../jsp/footer.jsp" %>