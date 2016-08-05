<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
    <head>
        <c:import url="inc/header.jsp" />
        <title>Jobübersicht :: Taschengeldbörse</title>

    </head>
    <body>

        <c:import url="inc/navigation.jsp" />

        <div class="container">
            
            <div class="page-header">
                <h2>Meine offenen Job-Anfragen</h2>
            </div>
            
            <div class="row">
                <c:forEach var="job" items="${jobList}">
                   <div class="col-md-12">
                       <h3> <li><a href="<c:url value="/schueler/jobs/detail/${job.id}" />">${job.bezeichnung}</a></li></h3>
                   </div> 
                   <div class="col-md-12">
                       <h3> <li><a href="<c:url value="/schueler/jobs/detail/${job.id}" />">${job.bewerbung}</a></li></h3>
                   </div> 
                      
                </c:forEach>

            </div>

        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>
