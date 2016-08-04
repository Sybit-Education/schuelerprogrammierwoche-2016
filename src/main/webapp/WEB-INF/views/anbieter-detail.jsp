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
                
            <c:choose>
                <c:when test="${isUser}">
                    <div class="row">
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src="<c:url value="/anbieter/profil/image?id="/>${anbieter.id}" alt="...">
                            </a>
                        </div>
                    </div>
                            
                    <div class="row">
                        <div class="col-xs-6 col-md-12">
                            <c:url var = "action" value="/anbieter/profil/bearbeitet">
                                <c:param name="id" value="${anbieter.id}"/>
                            </c:url>
                            <form:form class="form-horizontal" action="${action}" method="post"  modelAttribute="anbieter">
                                <div class="form-group">
                                    <label for="vorname" class="col-md-3 control-label"> Vorname<font color="red">*</font>: </label>
                                    <div class="col-md-9">
                                        <form:input id="vorname" type="text" class="form-control" path="vorname" required="true" />
                                    </div>
                                    <label for="nachname" class="col-md-3 control-label"> Nachname<font color="red">*</font>: </label>
                                    <div class="col-md-9">
                                        <form:input id="nachname" type="text" class="form-control" path="name" required="true" />
                                    </div>
                                    <label for="anrede" class="col-md-3 control-label"> Anrede<font color="red">*</font>: </label>
                                    <div class="col-md-9">
                                        <form:input id="anrede" type="text" class="form-control" path="anrede" required="true" />
                                    </div>
                                    <%--<label for="email" class="col-md-3 control-label"> Email<font color="red">*</font>: </label>
                                    <div class="col-md-9">
                                        <form:input id="email" type="hidden" class="form-control" path="email" required="true" />
                                    </div> --%>
                                    <label for="plz" class="col-md-3 control-label"> PLZ<font color="red">*</font>: </label>
                                    <div class="col-md-9">
                                        <form:input id="plz" type="text" class="form-control" path="plz" required="true" />
                                    </div>
                                    <label for="wohnort" class="col-md-3 control-label"> Wohnort<font color="red">*</font>: </label>
                                    <div class="col-md-9">
                                        <form:input id="wohnort" type="text" class="form-control" path="wohnort" required="true" />
                                    </div>
                                    <label for="strasse" class="col-md-3 control-label"> Straße<font color="red">*</font>: </label>
                                    <div class="col-md-9">
                                        <form:input id="strasse" type="text" class="form-control" path="strasse" required="true"/>
                                    </div>
                                </div>

                                <input class="btn btn-primary pull-right" type="submit" value="Speichern" />
                                <input type="hidden" path="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <form:hidden path="id" />
                            </form:form>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
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
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>      
        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>
