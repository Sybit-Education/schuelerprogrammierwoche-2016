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
            <c:set var="message" value="${message}"/>
            <c:set var="canRequest" value="${canRequest}"/>
            <c:set var="successMessage" value="Deine Bewerbung wurde erfolgreich abgeschickt."/>
            <c:if test="${not empty message}">
                <c:choose>
                    <c:when test="${message == successMessage}">
                        <br>
                        <br>
                        <div class="alert alert-success" style="text-align: center">
                            <center><b>${message}</b></center>
                            <meta http-equiv="refresh" content="3; URL=${redirect}">
                        </div>
                    </c:when>
                    <c:otherwise>
                        <br>
                        <br>
                        <div class="alert alert-danger" style="text-align: center">
                            <center><b>${message}</b></center>
                            <meta http-equiv="refresh" content="3; URL=${redirect}">
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:if>

            <h2>Job-Details: ${job.bezeichnung}</h2>

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
        <br>
        <br>
        <c:url var="action" value="/schueler/jobs/${id}/bewerben" />
        <form id="bewerbenForm" action="${action}" method="get"></form>
        <div class="container">
            <c:if test="${canRequest}">
                <button class="btn btn-large btn-primary" onclick="abfrage()">Bewerbung abschicken</button>
            </c:if>
            <br>
            <br>
            <button class="btn btn-large btn-primary" onclick="window.location.href = '<c:url value="/schueler/jobs/" />'">Zurück</button>

        </div>


        <script>
            function abfrage() {
                var result = confirm("Willst du dich wirklich für den Job \"${job.bezeichnung}\" bewerben?");
                console.log("go " + result);
                if (result === true) {
                    console.log("go1 " + result);
                    document.getElementById("bewerbenForm").submit();
                }
            }
        </script>
        <c:import url="inc/footer.jsp" />
    </body>
</html>
