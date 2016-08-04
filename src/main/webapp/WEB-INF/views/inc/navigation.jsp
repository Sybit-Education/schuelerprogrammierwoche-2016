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
                <li class="dropdown">
                    <a href="<c:url value="/schueler"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Schüler<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <sec:authorize access="hasRole('ROLE_SCHUELER')">
                        <li><a href="<c:url value="/schueler/jobs" />">Job-Übersicht</a></li>
                        <li><a href="<c:url value="/schueler/offene-job-anfragen" />">Offene Job-Anfragen</a></li>
                        <li><a href="<c:url value="/schueler/angenommene-job-anfragen" />">Angenommene Job-Anfragen</a></li>
                        <li><hr></li>
                        </sec:authorize>
                        <li><a href="<c:url value="/registrieren/schueler" />">Registieren</a></li>
                    </ul>
                </li> 
                <li class="dropdown">
                    <a href="<c:url value="/anbieter"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Job-Anbieter <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <sec:authorize access="hasRole('ROLE_ANBIETER')">
                        <li><a href="<c:url value="/anbieter/schueler" />">Bewerber</a></li>
                        <li><a href="<c:url value="/anbieter/jobs/neu" />">Neuen Job anbieten</a></li>
                        <li><hr></li>
                        </sec:authorize>
                        <li><a href="<c:url value="/registrieren/anbieter" />">Registieren</a></li>
                    </ul>
                </li>
                <li><a href="<c:url value="/about" />">Wir über uns</a></li>
                <c:if test="${pageContext.request.userPrincipal == null}">
                    <li><a href="<c:url value="/login" />">Anmeldung</a></li>
                </c:if>
                <sec:authorize access="hasRole('ROLE_SCHUELER')">
                    <c:url value="/schueler/profil/nav" var="profilUrl">
                        <c:param name="username" value="${pageContext.request.userPrincipal.name}"/>
                    </c:url>
                    <li><a href="${profilUrl}">Mein Profil</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ANBIETER')">
                    <c:url value="/anbieter/profil/nav" var="profilUrl">
                        <c:param name="username" value="${pageContext.request.userPrincipal.name}"/>
                    </c:url>
                    <li><a href="${profilUrl}">Mein Profil</a></li>
                </sec:authorize>
            </ul>

        </div>
        <!--/.nav-collapse -->

    </div>
    <!-- closing container  -->
</nav>
<!-- closing navbar  -->


