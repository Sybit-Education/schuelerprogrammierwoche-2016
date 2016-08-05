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
        <title>Schueler registrieren :: Taschengeldbörse</title>

    </head>
    <body>

        <c:import url="inc/navigation.jsp" />

        <div class="container">
            <div class="page-header">
                <h2>Schüler Registrierung</h2>
            </div>
            <c:if test="${addSuccess}">
                <div id="successMessage" class="alert alert-success" role="alert"> 
                    Der Schüler wurde erfolgreich angelegt.    
                </div>
                <meta http-equiv="refresh" content="3; URL=${redirect}">
            </c:if>
            <c:if test="${addFail}">
                <div id="errorMessage" class="alert alert-danger" role="alert"> 
                    Der Schüler konnte nicht angelegt werden.    
                </div>
            </c:if>
            <c:if test="${addEmailFail}">
                <div id="errorEmail" class="alert alert-danger" role="alert"> 
                    ${emailMessage}
                </div>
            </c:if>
            <br>
            <c:url var = "action" value="/registrieren/schueler" />
            <form:form class="form-horizontal" action="${action}" method="post"  modelAttribute="schueler">
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="anrede" class="col-md-3 control-label">Anrede <span class="star">*</span>: </label>
                        <div class="col-md-9">
                            <select id="anrede" name="anrede" class="form-control" required>
                                <option value="Herr">Herr</option>
                                <option value="Frau">Frau</option>
                            </select>
                        </div>
                    </div>
                </div>          

                <!-- TODO: weitere Parameter des Schülers abfragen und speichern -->           
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="vorname" class="col-md-3 control-label">Vorname <span class="star">*</span>: </label>   
                        <div class="col-md-9">
                            <input id="vorname" name="vorname" value="${schueler.vorname}" class="form-control" required/>
                        </div>    
                    </div>             
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="name" class="col-md-3 control-label">Nachname <span class="star">*</span>: </label>   
                        <div class="col-md-9">
                            <input id="name" name="name" value="${schueler.name}" class="form-control" required/>
                        </div>    
                    </div>             
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label">Geburtsdatum <span class="star">*</span>: </label>   
                        <div class="col-md-3">
                            <select class="form-control" name="DOBMonth" required>
                                <option value=""> - Tag - </option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                <option value="17">17</option>
                                <option value="18">18</option>
                                <option value="19">19</option>
                                <option value="20">20</option>
                                <option value="21">21</option>
                                <option value="22">22</option>
                                <option value="23">23</option>
                                <option value="24">24</option>
                                <option value="25">25</option>
                                <option value="26">26</option>
                                <option value="27">27</option>
                                <option value="28">28</option>
                                <option value="29">29</option>
                                <option value="30">30</option>
                                <option value="31">31</option>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <select class="form-control" name="DOBDay" required>
                                <option value=""> - Monat - </option>
                                <option value="January">Januar</option>
                                <option value="Febuary">Februar</option>
                                <option value="March">März</option>
                                <option value="April">April</option>
                                <option value="May">Mai</option>
                                <option value="June">Juni</option>
                                <option value="July">Juli</option>
                                <option value="August">August</option>
                                <option value="September">September</option>
                                <option value="October">Oktober</option>
                                <option value="November">November</option>
                                <option value="December">Dezember</option>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <select class="form-control" name="DOBYear" required>
                                <option value=""> - Jahr - </option>                           
                                <option value="1993">2003</option>
                                <option value="1992">2002</option>
                                <option value="1991">2001</option>
                                <option value="1990">2000</option>
                                <option value="1989">1999</option>
                                <option value="1993">1998</option>
                                <option value="1992">1997</option>
                                <option value="1991">1996</option>
                                <option value="1990">1995</option>
                                <option value="1989">1994</option>
                                <option value="1993">1993</option>
                                <option value="1992">1992</option>
                                <option value="1991">1991</option>
                                <option value="1990">1990</option>
                                <option value="1989">1989</option>
                            </select>
                        </div>
                    </div>    
                </div>                         

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="plz" class="col-md-3 control-label">Plz:</label>   
                        <div class="col-md-9">
                            <input id="plz" name="plz" value="${schueler.plz}" class="form-control col-sm-2"/>
                        </div>    
                    </div>             
                </div>                      

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="wohnort" class="col-md-3 control-label">Wohnort:</label>   
                        <div class="col-md-9">
                            <input id="wohnort" name="wohnort" value="${schueler.wohnort}" class="form-control col-sm-4"/>
                        </div>    
                    </div>             
                </div>                           

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="email" class="col-md-3 control-label">E-Mail <span class="star">*</span>: </label>   
                        <div class="col-md-9">
                            <input id="email" name="email" value="${schueler.email}" class="form-control" required/>
                        </div>    
                    </div>             
                </div>         
                        
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="password" class="col-md-3 control-label">Passwort <span class="star">*</span>:</label>   
                        <div class="col-md-9">
                            <input type="password" id="password" name="password" class="form-control col-sm-4" required/>
                        </div>    
                    </div>             
                </div>                           

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="passwordWdh" class="col-md-3 control-label">Passwort Wiederholen <span class="star">*</span>:</label>   
                        <div class="col-md-9">
                            <input type="password" id="passwordWdh" name="passwordWdh" class="form-control col-sm-4" required/>
                        </div>    
                    </div>             
                </div>              

                <input class="btn btn-primary pull-right" type="submit" value="Speichern" id="buttonRegistrieren" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form:form> 

        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>
