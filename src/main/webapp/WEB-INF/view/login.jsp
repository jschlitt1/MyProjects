<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Login</title>
    <!-- The tag libs are here -->
    <%@ include file="include/bootstrap.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<div id="container">
    <div id="content">
        <h3>Login</h3>
        <form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
            <table>
                <!-- Only show this message if the user has been logged out -->
                <c:if test="${param.logout != null}">
                    <tr>
                        <td></td>
                        <td>You have been logged out</td>
                    </tr>
                </c:if>
                <tr>
                    <td><label>Username</label></td>
                    <!-- Spring expects this to have name="username" -->
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td><label>Password</label></td>
                    <!-- Spring expects this to have name="password" -->
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></td>
                </tr>
                <!-- Only show this row if there was a login error -->
                <c:if test="${param.error != null}">
                    <tr>
                        <td></td>
                        <td class="error">Invalid login</td>
                    </tr>
                </c:if>
            </table>
        </form:form>
    </div>
</div>
<%@ include file="include/footer.jsp" %>