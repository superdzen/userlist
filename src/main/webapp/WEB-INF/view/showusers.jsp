<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список имен</title>
</head>
<body>
<br/>
<br/>
<a href="newUser">Добавить новое имя</a>
<hr/>
<form action="showUsersFilter" method="get">
    <input type="text" name="filter" placeholder="Введите имя для поиска"/>
    <input type="submit" value="Искать"/>
</form>
<form action="showUsers">
    <input type="submit" value="Сбросить поиск"/>
</form>
<h4>Список имен в БД:</h4>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Имя</th>
    </tr>
    <c:forEach var="tmpUser" items="${users}">
        <tr>
            <td>${tmpUser.id}</td>
            <td>${tmpUser.firstName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>