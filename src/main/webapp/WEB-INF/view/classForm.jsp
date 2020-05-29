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
<form:form action="${pageContext.request.contextPath}/class/admin/save" modelAttribute="aClass" enctype="multipart/form-data"
           method="post">
    <form:hidden path="id" value="${aClass.id}"/>

<table>
    <tr>
        <td><label>Name</label></td>
        <td><form:input path="className"/>
            <form:errors path="className" cssClass="error"/></td>
    </tr>
    <tr>
        <td><label>Description</label></td>
        <td><form:input path="classDescription"/>
            <form:errors path="classDescription" cssClass="error"/></td>
    </tr>
    <tr>
        <td><label>School</label></td>
        <td>
            <form:select path="location" items="${locations}" itemLabel="name" itemValue="id"
                         cssClass="select-css">
            </form:select>
            <form:errors path="location" cssClass="error"/>
        </td>
    </tr>
    <tr>
        <td><label>Skills</label></td>
        <td>
            <form:select path="skills" items="${skills}" itemLabel="name" itemValue="id"
                         cssClass="select-css">
            </form:select>
            <form:errors path="skills" cssClass="error"/>
        </td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save" class="btn btn-success"></td>
    </tr>
</table>
</form:form>

<%@ include file="include/footer.jsp" %>
