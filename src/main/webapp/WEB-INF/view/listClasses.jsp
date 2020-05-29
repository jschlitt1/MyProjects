<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Project List</title>
    <%@ include file="include/bootstrap.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<h1>List of all the Classes</h1>


<!-- Only show add donut button if user is logged in -->
<security:authorize access="hasRole('ADMIN')">
<button class="btn btn-success"
        onclick="window.location.href='${pageContext.request.contextPath}/class/admin/showAddClassForm'; return false;">Add Class
</button>
</security:authorize>
<br>
<br>

<!-- Project list table -->

<table class="table table-striped">
    <tr>
        <th>Name</th>
        <th>Skills</th>
        <!-- Only show table header if user is logged in -->
        <security:authorize access="hasAnyRole('USER,ADMIN')">
            <th>Action</th>
        </security:authorize>
    </tr>
    <c:forEach var="tempClass" items="${classes}">

        <!-- construct an "update" link with donut id -->
        <!-- c:url is same as JSP's response.encodeURL() -->
        <c:url var="updateLink" value="/class/admin/showUpdateClassForm">
            <c:param name="classId" value="${tempClass.id}"/>
        </c:url>

        <!-- construct a "delete" link with donut id -->
        <c:url var="deleteLink" value="/class/admin/delete">
            <c:param name="classId" value="${tempClass.id}"/>
        </c:url>

        <!-- create a link for more info on the project -->
        <c:url var="classInfoLink" value="/class/ClassInfo">
            <c:param name="classId" value="${tempClass.id}"/>
        </c:url>

        <tr>
            <td><a href="${classInfoLink}">${tempClass.className}</a></td>
            <td>
                <c:forEach var="tempSkill" items="${tempClass.skills}">
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
