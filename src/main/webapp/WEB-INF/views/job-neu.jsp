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
            <h2>Neuen Job anlegen</h2>
         
            <c:url var = "action" value="/anbieter/jobs/neu" />
            <form:form class="form-horizontal" action="${action}" method="post"  modelAttribute="job">
            
               
                
                
                <!-- TODO: weitere Parameter des Jobs abfragen und speichern -->
                
                
                
                
                
                
                <input class="btn btn-primary pull-right" type="submit" value="Speichern" />
                <input type="hidden"	path="${_csrf.parameterName}"	value="${_csrf.token}"/>
                <form:hidden path="id" />
            </form:form>
        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>
