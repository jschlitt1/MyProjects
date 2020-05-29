<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Project List</title>
    <%@ include file="include/bootstrap.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<h1>${aProject.name}'s info page</h1>
<h2>Description</h2>
<p>${aProject.detail.description}</p>
<h2>Reason</h2>
<p>${aProject.detail.reason}</p>
<h2>For Class(es):</h2>
<ul>

    <c:forEach var="tempClass" items="${aProject.detail.classes}">
        <c:url var="classInfoLink" value="/class/ClassInfo">
            <c:param name="classId" value="${tempClass.id}"/>
        </c:url>
        <li><a href="${classInfoLink}">${tempClass.className}</a></li>
    </c:forEach>
</ul>
<h2>Skill(s):</h2>
<ul>
    <c:forEach var="tempSkill" items="${aProject.detail.skills}">
        <!-- create a link for more info on the skill (removed)-->
        <li>${tempSkill.name}</li>
    </c:forEach>
</ul>



<%@ include file="include/footer.jsp" %>
