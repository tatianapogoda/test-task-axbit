<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>AUTHORS</title>
</head>
<body>

<h2>Authors</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>patronymic</th>
        <th>birthday</th>
        <th>books</th>
    </tr>
    <c:forEach var="author" items="${authorsList}">
        <tr>
            <td>${author.id}</td>
            <td>${author.name}</td>
            <td>${author.surname}</td>
            <td>${author.patronymic}</td>
            <td>${author.birthday}</td>
            <td>${author.books}</td>
            <td>
                <a href="/edit/${author.id}">edit</a>
                <a href="/delete/${author.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new author</a>
</body>
</html>