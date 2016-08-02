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

            <c:url var = "action" value="/registrieren/anbieter" />
            <form:form class="form-horizontal" action="${action}" method="post"  modelAttribute="anbieter">
                <div class="row">
                    <div class="form-group col-sm-12">
                        <form:label path="anrede" class="col-sm-2 control-label">Anrede <span class="star">*</span> </form:label>
                            <div class="col-sm-2">
                            <form:select path="anrede" class="form-control col-sm-2">
                                <form:option value="Herr">Herr</form:option>
                                <form:option value="Frau">Frau</form:option>
                            </form:select>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12">
                        <form:label path="vorname" class="col-sm-2 control-label">Vorname <span class="star">*</span> </form:label>
                            <div class="col-sm-2">
                            <form:input path="vorname" />
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <form:label path="name" class="col-sm-2 control-label">Nachname <span class="star">*</span> </form:label>
                            <div class="col-sm-2">
                            <form:input path="name" />
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <form:label path="email" class="col-sm-2 control-label">E-Mail <span class="star">*</span> </form:label>
                            <div class="col-sm-2">
                            <form:input path="email" />
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <form:label path="password" class="col-sm-2 control-label">Passwort <span class="star">*</span> </form:label>
                            <div class="col-sm-2">
                            <form:input path="password" />
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <form:label path="passwordwdh" class="col-sm-2 control-label">Passwort-Wdh. <span class="star">*</span> </form:label>
                            <div class="col-sm-2">
                            <form:input path="passwordwdh" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12">
                        <form:label path="strasse" class="col-sm-2 control-label">Straße/Nr. <span class="star">*</span> </form:label>
                            <div class="col-sm-2">
                            <form:input path="strasse" />
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <form:label path="wohnort" class="col-sm-2 control-label">PLZ/Wohnort <span class="star">*</span> </form:label>
                            <div class="col-sm-2">
                            <form:input path="wohnort" />
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="form-group col-sm-12">
                        <form:label path="telefon" class="col-sm-2 control-label">Telefonnummer</form:label>
                        <div class="col-sm-2">
                            <form:input type="tel" path="telefon" />
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