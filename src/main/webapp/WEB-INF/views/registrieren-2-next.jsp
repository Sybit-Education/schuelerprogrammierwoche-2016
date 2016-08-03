<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
    <head>
        <c:import url="inc/header.jsp" />
        <title>Registrieren :: Taschengeldbörse</title>
    </head>
    <body>

        <c:import url="inc/navigation.jsp" />

        <div class="container">

            <h2>Registrieren: Schüler oder Anbieter?</h2>

            <div class="row">
                <div class="col-sm-6">
                    <a role="button" class="btn btn-large btn-primary" href="<c:url value="/registrieren/schueler" />">Schüler</a>                    
                </div>
                <div class="col-sm-6">
                    <a class="btn btn-large btn-primary" role="button" href="<c:url value="/registrieren/anbieter" />">Anbieter</a>             
                </div>                
            </div>



        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>