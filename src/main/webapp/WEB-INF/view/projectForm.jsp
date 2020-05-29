<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Create or Edit a project</title>
    <%@ include file="include/bootstrap.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<br>
<br>
<br>
<form:form action="${pageContext.request.contextPath}/project/admin/save" modelAttribute="aProject" enctype="multipart/form-data"
           method="post">
    <form:hidden path="id" value="${aProject.id}"/>
    <form:hidden path="detail.id" value="${aProject.detail.id}"/>

<table>
    <tr>
        <td><label>Name</label></td>
        <td><form:input path="name"/>
            <form:errors path="name" cssClass="error"/></td>
    </tr>
    <tr>
        <td><label>Reason</label></td>
        <td><form:input path="detail.reason"/>
            <form:errors path="detail.reason" cssClass="error"/></td>
    </tr>
    <tr>
        <td><label>Description</label></td>
        <td><form:input path="detail.description"/>
            <form:errors path="detail.description" cssClass="error"/></td>
    </tr>
    <tr>
        <td><label>Class</label></td>
        <td>
            <form:select path="detail.classes" items="${classes}" itemLabel="className" itemValue="id"
                         cssClass="select-css">
            </form:select>
            <form:errors path="detail.classes" cssClass="error"/>
        </td>
    </tr>
    <tr>
        <td><label>Skills</label></td>
        <td>
            <form:select path="detail.skills" items="${skills}" itemLabel="name" itemValue="id"
                         cssClass="select-css">
            </form:select>
            <form:errors path="detail.skills" cssClass="error"/>
        </td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save" class="save"></td>
    </tr>
</table>
</form:form>

<%@ include file="include/footer.jsp" %>
