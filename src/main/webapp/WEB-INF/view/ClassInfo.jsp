<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Project List</title>
    <%@ include file="include/bootstrap.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<h1>${aClass.className}'s info page</h1>
<h2>Description</h2>
<p>${aClass.classDescription}</p>
<h2>Location</h2>
<p>${aClass.location.name}</p>
<h2>Project(s):</h2>
<ul>
    <c:forEach var="tempProject" items="${aClass.projects}">
        <!-- create a link for more info on the project -->
        <c:url var="projectInfoLink" value="/project/ProjectInfo">
            <c:param name="projectId" value="${tempProject.id}"/>
        </c:url>
        <li><a href="${projectInfoLink}">${tempProject.name}</a></li>
    </c:forEach>
</ul>
<h2>Skill(s):</h2>
<ul>
    <c:forEach var="tempSkill" items="${aClass.skills}">
        <!-- create a link for more info on the skill (removed)-->
        <li>${tempSkill.name}</li>
    </c:forEach>
</ul>



<%@ include file="include/footer.jsp" %>
