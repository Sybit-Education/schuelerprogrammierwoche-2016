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
                <h1>Die Taschengeldbörse</h1>
                <h2>Jobs</h2>
                
                
                <div class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                      Filter
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <li><a href="<c:url value="/schueler/offene-job-anfragen" />">Offene Job-Anfragen</a></li>
                        <li><a href="<c:url value="/schueler/angenommene-job-anfragen" />">Angenommene Job-Anfragen</a></li>
                    </ul>
                </div>
                
                
            </div>
            
            <div class="row">
                <c:forEach var="job" items="${jobList}">
                   <div class="col-md-12">
                    
                   
                       <h3> <li><a href="<c:url value="/schueler/jobs/detail/${job.id}" />">${job.bezeichnung}</a></li></h3>
                    
                    
                   </div> 
                      
                </c:forEach>
                
                
            </div>

        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>
