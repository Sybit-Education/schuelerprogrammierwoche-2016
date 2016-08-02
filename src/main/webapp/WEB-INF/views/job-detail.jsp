<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
    <head>
        <c:import url="inc/header.jsp" />
        <title>Job anlegen :: Taschengeldbörse</title>

    </head>
    <body>

        <c:import url="inc/navigation.jsp" />

        
        <div class="container">
            <h1>Die Taschengeldbörse</h1>
            <h2>Job-Details: ${job.bezeichnung}</h2>
         
            <h3>Details:</h3> ${job.zusaetzliche_infos}
           
            <h3>Uhrzeit:</h3> ${job.uhrzeit}
            
            <h3>Datum:</h3> ${job.datum}
            
            <h3>Zeitaufwand:</h3> ${job.zeitaufwand}
            
            <h3>Lohn:</h3> ${job.entlohnung}
            
            <h3>Turnus:</h3> 
            <c:choose>
                <c:when test="${job.turnus}">
                    regelmäßig
                </c:when>
                <c:otherwise>
                    einmalig
                </c:otherwise>
            </c:choose>
            
            <h3>Anforderungen:</h3> ${job.anforderungen}
            <h4><li><a href="<c:url value="/schueler/jobs/" />">Zurück</a></li></h4>
        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>
