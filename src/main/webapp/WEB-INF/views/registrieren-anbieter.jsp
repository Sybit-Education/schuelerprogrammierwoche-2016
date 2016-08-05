<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
    <head>
        <c:import url="inc/header.jsp" />
        <script type="text/javascript" src="<c:url value="/resources/js/script.js" />"></script>
        <title>Jobübersicht :: Taschengeldbörse</title>

    </head>
    <body>

        <c:import url="inc/navigation.jsp" />

        <div class="container">
            <div class="page-header">
                <h2>Job-Anbieter Registrierung</h2>
            </div>
            <div class="col-md-3"></div>
            <c:if test="${addSuccsess}">
                <div id="successMessage" class="col-md-9 alert alert-success" role="alert">
                    <center><b>Der Anbieter wurde erfolgreich angelegt.</b></center>
                </div>
                <meta http-equiv="refresh" content="3; URL=${redirect}">
            </c:if>
                
            <c:if test="${addFail}">
                <div id="successMessage" class="col-md-9 alert alert-danger" role="alert">
                    <center><b>Der Anbieter konnte nicht angelegt werden.</b></center>
                </div>
            </c:if>
                
            <c:if test="${addEmailFail}">
                <div id="successMessage" class="col-md-9 alert alert-danger" role="alert">
                    <center><b>${emailMessage}</b></center>
                </div>
            </c:if>
            
            <c:url var = "action" value="/registrieren/anbieter" />
            <form:form class="form-horizontal" action="${action}" method="post"  modelAttribute="anbieter">
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="anrede" class="col-md-3 control-label">Anrede <span class="star">*</span>: </label>
                            <div class="col-md-9">
                                <select id="anrede" name="anrede" class="form-control" required>
                                <option value="">- Auswählen -</option>
                                <option value="Herr">Herr</option>
                                <option value="Frau">Frau</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="vorname" class="col-md-3 control-label">Vorname <span class="star">*</span>: </label>
                            <div class="col-md-9">
                            <input id="vorname" name="vorname" class="form-control" value="${anbieter.vorname}" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="name" class="col-md-3 control-label">Nachname <span class="star">*</span>: </label>
                            <div class="col-md-9">
                            <input id="name" name="name" class="form-control" value="${anbieter.name}" required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="strasse" class="col-md-3 control-label">Straße/Nr. <span class="star">*</span>: </label>
                            <div class="col-md-9">
                                <input id="strasse" name="strasse" class="form-control" value="${anbieter.strasse}" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="plz" class="col-md-3 control-label">Plz <span class="star">*</span>: </label>
                            <div class="col-md-9">
                                <input id="plz" name="plz" class="form-control" value="${anbieter.plz}" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="wohnort" class="col-md-3 control-label">Wohnort <span class="star">*</span>: </label>
                            <div class="col-md-9">
                                <input id="wohnort" name="wohnort" class="form-control" value="${anbieter.wohnort}" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="telefon" class="col-md-3 control-label">Telefonnummer:</label>
                        <div class="col-md-9">
                            <input type="tel" id="telefon" class="form-control" value="${anbieter.telefon}" name="telefon"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="email" class="col-md-3 control-label">E-Mail <span class="star">*</span>: </label>
                            <div class="col-md-9">
                            <input id="email" name="email" class="form-control" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="password" class="col-md-3 control-label">Passwort <span class="star">*</span>: </label>
                            <div class="col-md-9">
                                <input type="password" id="password" class="form-control" name="password" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="passwordWdh" class="col-md-3 control-label">Passwort-Wdh. <span class="star">*</span>: </label>
                            <div class="col-md-9">
                                <input type="password" id="passwordWdh" class="form-control" name="passwordWdh" required/>
                        </div>
                    </div>
                </div>
                            
                <input class="btn btn-primary pull-right" type="submit" value="Speichern" id="buttonRegistrieren"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form:form>
        </div>
        
        <c:import url="inc/footer.jsp" />
    </body>
</html>
