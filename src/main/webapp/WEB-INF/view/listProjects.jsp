<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Project List</title>
    <%@ include file="include/bootstrap.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<h1>List of all the projects</h1>

<security:authorize access="hasRole('ADMIN')">
<button class="btn btn-success"
        onclick="window.location.href='${pageContext.request.contextPath}/project/admin/showAddProjectForm'; return false;">Add Project
</button>
</security:authorize>
<br>
<br>
<!-- search form -->
<form:form action="project/search" method="GET">
Search Projects: <input type="search" name="searchTerm"/>
<input type="submit" value="Search" class="add-button"/>
</form:form>

<br>
<br>
<!-- Project list table -->

<table class="table table-striped">
    <tr>
        <th>Name</th>
        <th>Class</th>
        <th>Skills</th>
        <!-- Only show table header if user is logged in -->
        <security:authorize access="hasAnyRole('USER,ADMIN')">
            <th>Action</th>
        </security:authorize>
    </tr>
    <c:forEach var="tempProject" items="${projects}">

        <!-- construct an "update" link with donut id -->
        <!-- c:url is same as JSP's response.encodeURL() -->
        <c:url var="updateLink" value="/project/admin/showUpdateProjectForm">
            <c:param name="projectId" value="${tempProject.id}"/>
        </c:url>

        <!-- construct a "delete" link with donut id -->
        <c:url var="deleteLink" value="/project/admin/delete">
            <c:param name="projectId" value="${tempProject.id}"/>
        </c:url>

        <!-- create a link for more info on the project -->
        <c:url var="projectInfoLink" value="/project/ProjectInfo">
            <c:param name="projectId" value="${tempProject.id}"/>
        </c:url>

        <tr>
            <td><a href="${projectInfoLink}">${tempProject.name}</a></td>
            <td>
                <c:forEach var="tempClass" items="${tempProject.detail.classes}">
                    ${tempClass.className}<br/>
                </c:forEach>
            </td> <!--jstl loop-->
            <td>
                <c:forEach var="tempSkill" items="${tempProject.detail.skills}">
                    ${tempSkill.name}
                </c:forEach>
            </td>
            <!-- Only show this last cell if the user is logged in -->
            <security:authorize access="hasAnyRole('USER,ADMIN')">
                <td>
                    <!-- display the update link -->
                    <a href="${updateLink}" class="btn btn-info">Update</a>
                    <!-- only display the delete link if user is admin-->
                    <security:authorize access="hasRole('ADMIN')">
                        |
                        <a href="${deleteLink}" class="btn btn-danger"
                           onclick="if (!confirm('Are you sure?')) return false">Delete</a>
                    </security:authorize>
                </td>
            </security:authorize>
        </tr>
    </c:forEach>
</table>
<%@ include file="include/footer.jsp" %>
