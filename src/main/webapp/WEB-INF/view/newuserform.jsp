<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добавить новое имя</title>
    <link href="<c:url value="/resources/css/error.css"/>" rel="stylesheet">
</head>
<body>
<br/>
<br/>
<form:form action="processForm" modelAttribute="user" method="get">
    Имя (*): <form:input path="firstName"/>
    <input type="submit" value="Добавить"/>
    <br/>
    <form:errors path="firstName" cssClass="inputerror"/>
</form:form>
<br/>
<a href="showUsers">Посмотреть все имена в БД</a>
</body>
</html>