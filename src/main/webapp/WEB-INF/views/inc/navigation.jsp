<%-- 
    Document   : navigation
    Created on : 21.09.2015, 18:04:12
    Author     : ssr
    DIe navigationsleiste
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<nav class="navbar navbar-inverse hidden-print">


    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/"/>"> 
                <img alt="Taschengeldbörse" src="<c:url value="/resources/img/app.png" />" />
            </a>
            <a class="navbar-brand" href="<c:url value="/" />">Taschengeldbörse</a>

            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#navbar" aria-expanded="false"
                    aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span> 
                <span class="icon-bar"></span> 
                <span class="icon-bar"></span> 
                <span class="icon-bar"></span>
            </button>
        </div>

        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal == null}">
                        <li class="dropdown">
                            <a href="<c:url value="/schueler"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Schüler<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="<c:url value="/registrieren/schueler" />">Registieren</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="<c:url value="/anbieter"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Job-Anbieter <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="<c:url value="/registrieren/anbieter" />">Registieren</a></li>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <sec:authorize access="hasRole('ROLE_SCHUELER')">
                            <li class="dropdown">
                                <a href="<c:url value="/schueler"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Schüler<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="<c:url value="/schueler/jobs" />">Verfügbare Jobs</a></li>
                                    <li><a href="<c:url value="/schueler/offene-job-anfragen" />">Meine offenen Job-Anfragen</a></li>
                                    <li><a href="<c:url value="/schueler/angenommene-job-anfragen" />">Meine angenommenen Job-Anfragen</a></li>
                                </ul>
                            </li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_ANBIETER')">
                            <li class="dropdown">
                                <a href="<c:url value="/anbieter"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Job-Anbieter <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="<c:url value="/anbieter/bewerbungen" />">Offene Jobs</a></li>
                                    <li><a href="<c:url value="/anbieter/jobs" />">Vergebene Jobs</a></li>
                                    <li><a href="<c:url value="/anbieter/jobs/neu" />">Neuen Job anbieten</a></li>
                                </ul>
                            </li>
                        </sec:authorize>
                    </c:otherwise>
                </c:choose>

                <%--<li><a href="<c:url value="/about" />">Wir über uns</a></li>--%>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal == null}">
                        <li><a href="<c:url value="/login" />">Anmeldung</a></li>
                    </c:when>
                    <c:otherwise>
                        <sec:authorize access="hasRole('ROLE_SCHUELER')">
                            <c:url value="/schueler/profil/nav" var="profilUrl">
                                <c:param name="username" value="${pageContext.request.userPrincipal.name}"/>
                            </c:url>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_ANBIETER')">
                            <c:url value="/anbieter/profil/nav" var="profilUrl">
                                <c:param name="username" value="${pageContext.request.userPrincipal.name}"/>
                            </c:url>
                        </sec:authorize>
                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Hallo ${pageContext.request.userPrincipal.name}<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="${profilUrl}">Meine Daten</a></li>
                                    <li><a href="javascript:formSubmit()">Logout</a></li>
                                </ul>
                            </li>
                    </c:otherwise>
                </c:choose>
            </ul>

        </div>
        <!--/.nav-collapse -->

        <c:url value="/logout" var="logoutUrl" />
        <!-- csrt for log out-->
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </div>
    <!-- closing container  -->
</nav>
<!-- closing navbar  -->


