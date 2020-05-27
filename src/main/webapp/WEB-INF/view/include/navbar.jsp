<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<%= request.getContextPath()%>/">Jessie's Projects</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="<%= request.getContextPath()%>/">Home</a></li>
            <li><a href="<%= request.getContextPath()%>/project/list">Projects</a></li>
            <li><a href="<%= request.getContextPath()%>/class/list">Classes</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <c:choose>

                    <c:when test="${pageContext.request.userPrincipal != null}">
                        Hello <strong>${pageContext.request.userPrincipal.name}</strong>
                        &nbsp;|&nbsp;
                        <a href="${pageContext.request.contextPath}/logout">Logout</a>
                    </c:when>

                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/showLoginForm">Login</a>
                    </c:otherwise>

                </c:choose>
            </li>
        </ul>
    </div>
</nav>

