<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
    <head>
        <c:import url="inc/header.jsp" />
        <title>Job Detail :: Taschengeldbörse</title>

    </head>
    <body>

        <c:import url="inc/navigation.jsp" />

        <div class="container">
            <div class="row">
                <h1>${job.bezeichnung}</h1>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <h2>Job-Details</h2>

                    <h3>Details:</h3> ${job.zusaetzliche_infos}

                    <h3>Uhrzeit:</h3> ${job.uhrzeit}

                    <h3>Datum:</h3> ${job.datum}

                    <h3>Zeitaufwand:</h3> ${job.zeitaufwand}

                    <h3>Lohn:</h3> ${job.entlohnung}€

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
                </div>
                <div class="col-md-6">
                    <h2>Bewerber</h2>
                    <c:forEach var="bewerber" items="${bewerberListe}">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                ${bewerber.vorname}         
                                ${bewerber.nachname}
                                <br>
                                Bewerbungsdatum: ${bewerber.timestamp}
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="row">
                <button class="btn btn-large btn-primary" onclick="window.location.href = '<c:url value="/anbieter/bewerbungen" />'">Zurück</button>
            </div>
        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>
