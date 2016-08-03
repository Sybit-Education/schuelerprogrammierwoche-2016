<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
    <head>
        <c:import url="inc/header.jsp" />
        <title>Taschengeldbörse</title>

    </head>
    <body>

        <c:import url="inc/navigation.jsp" />

        <div class="container">
            <h1>Schüler-Details</h1>
            <br>
            <p>Name: ${schueler.anrede} ${schueler.vorname} ${schueler.name}</p>
            <p>E-Mail Adresse: ${schueler.email}</p>
            <p>Geburtstag: ${schueler.geburtsdatum}</p>
            <p>Wohnohrt: ${schueler.plz}, ${schueler.wohnort}</p>
        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>
