<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
    <head>
        <c:import url="inc/header.jsp" />
        <title>Job Details :: Taschengeldbörse</title>

    </head>
    <body>

        <c:import url="inc/navigation.jsp" />

        <div class="container">

            <div class="row">
                
                <div class="col-md-12">
                    <h2>vergebener Job: ${job.bezeichnung}</h2>
                </div>

                <div  class="col-md-6">

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
                    <div class="row">
                        <div class="col-xs-6 col-md-3">
                            <p>Name: ${schueler.anrede} ${schueler.vorname} ${schueler.name}</p>
                            <p>E-Mail Adresse: ${schueler.email}</p>
                            <p>Geburtstag: ${schueler.geburtsdatum}</p>
                            <p>Wohnort: ${schueler.plz}, ${schueler.wohnort}</p>
                        </div>
                    </div>
                </div>
            </div>
                
                <br>
                
            <div class="row">

                <button class="btn btn-large btn-primary" onclick="window.location.href = '<c:url value="/anbieter/jobs/" />'">Zurück</button>

            </div>

        </div> 
        <c:import url="inc/footer.jsp" />
    </body>
</html>
