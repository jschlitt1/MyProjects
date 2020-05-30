<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <%@ include file="include/bootstrap.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<h1>Error:</h1>
<p>sorry an error occurred</p>
<p><strong>${errorMessage}</strong></p>
<security:authorize access="hasRole('ADMIN')">
<h2>specific server info</h2>
    <c:forEach items="${exception.stackTrace}" var="element">
        <c:out value="${element}"/>
    </c:forEach>
</security:authorize>
<%@ include file="include/footer.jsp" %>
