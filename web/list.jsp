<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Saved Persons</title>
</head>
<body>
<h2>Saved Persons:</h2>
<ul>
    <c:forEach items="${persons}" var="person">
        <li><c:out value="${person}" /></li>
    </c:forEach>
</ul>
</body>
</html>