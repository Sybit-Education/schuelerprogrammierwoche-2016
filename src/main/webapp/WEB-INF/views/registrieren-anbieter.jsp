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

            <h2>Job-Anbieter Registrierung</h2>
            
            <c:if test="${addSuccess}">
                <div id="successMessage" class="alert alert-success" role="alert">Der Abieter wurde erfolgreich angelegt.</div>
            </c:if>
                
            <c:if test="${addFail}">
                <div id="successMessage" class="alert alert-danger" role="alert">Der Anbieter konnte nicht angelegt werden.</div>
            </c:if>
                
            <c:if test="${addEmailFail}">
                <div id="successMessage" class="alert alert-danger" role="alert">${emailMessage}</div>
            </c:if>
            
            <c:url var = "action" value="/registrieren/anbieter" />
            <form:form class="form-horizontal" action="${action}" method="post"  modelAttribute="anbieter">
                <div class="row">
                    <div class="form-group col-sm-12">
                        <label for="anrede" class="col-sm-2 control-label">Anrede <span class="star">*</span> </label>
                            <div class="col-sm-2">
                                <select id="anrede" name="anrede" class="form-control col-sm-2" required>
                                <option value="">- Auswählen -</option>
                                <option value="Herr">Herr</option>
                                <option value="Frau">Frau</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12">
                        <label for="vorname" class="col-sm-2 control-label">Vorname <span class="star">*</span> </label>
                            <div class="col-sm-2">
                            <input id="vorname" name="vorname" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <label for="name" class="col-sm-2 control-label">Nachname <span class="star">*</span> </label>
                            <div class="col-sm-2">
                            <input id="name" name="name" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <label for="email" class="col-sm-2 control-label">E-Mail <span class="star">*</span> </label>
                            <div class="col-sm-2">
                            <input id="email" name="email" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <label for="password" class="col-sm-2 control-label">Passwort <span class="star">*</span> </label>
                            <div class="col-sm-2">
                                <input type="password" id="password" name="password" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <label for="passwordwdh" class="col-sm-2 control-label">Passwort-Wdh. <span class="star">*</span> </label>
                            <div class="col-sm-2">
                                <input type="password" id="passwordwdh" name="passwordwdh" required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12">
                        <label for="strasse" class="col-sm-2 control-label">Straße/Nr. <span class="star">*</span> </label>
                            <div class="col-sm-2">
                                <input id="strasse" name="strasse" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <label for="plz" class="col-sm-2 control-label">Plz <span class="star">*</span> </label>
                            <div class="col-sm-2">
                                <input id="plz" name="plz" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <label for="wohnort" class="col-sm-2 control-label">Wohnort <span class="star">*</span> </label>
                            <div class="col-sm-2">
                                <input id="wohnort" name="wohnort" required/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <label for="telefon" class="col-sm-2 control-label">Telefonnummer</label>
                        <div class="col-sm-2">
                            <input type="tel" id="telefon" name="telefon"/>
                        </div>
                    </div>
                </div>
                            
                <input class="btn btn-primary pull-right" type="submit" value="Speichern" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form:form>

        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>