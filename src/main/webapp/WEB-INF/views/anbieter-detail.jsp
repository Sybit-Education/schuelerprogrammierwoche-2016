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
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h1>${anbieter.vorname} ${anbieter.name}</h1>
                </div>

            </div>
            <div class="row">
                <div class="col-xs-6 col-md-3">
                    <a href="#" class="thumbnail">
                        <img src="<c:url value="/anbieter/profil/image?id="/>${anbieter.id}" alt="...">
                    </a>
                </div>
                <div class="col-xs-6 col-md-3">
                    <p>Geschlecht: <c:choose>
                        <c:when test="${anbieter.anrede eq 'Herr'}">
                            Männlich
                        </c:when>
                        <c:otherwise>
                            Weiblich
                        </c:otherwise>
                    </c:choose>
                    </p>
                    <p>E-Mail Adresse: ${anbieter.email}</p>
                    <p>Wohnohrt: ${anbieter.plz}, ${anbieter.wohnort}</p>
                    <p>Straße: ${anbieter.strasse}</p>
                    <p>Telefon: ${anbieter.telefon}</p>
                </div>
            </div>
            <br>


        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>
