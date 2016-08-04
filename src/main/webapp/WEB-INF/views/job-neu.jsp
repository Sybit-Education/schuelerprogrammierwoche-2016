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
        <h2>Neuen Job anlegen</h2>
        
        <c:set var="message" value="${message}"/>
        <c:set var="successMessage" value="Job erfolgreich gespeichert."/>
        
        <div class="row">
            <div class="col-md-3"></div>
            <c:if test="${not empty message}">
            <c:choose>
                <c:when test="${message == successMessage}">
                    <div class="col-md-9 alert alert-success" style="text-align: center">
                        <center><b>${message}</b></center>
                        <meta http-equiv="refresh" content="3; URL=${redirect}">
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="col-md-9 alert alert-danger">
                        <center><b>${message}</b></center>
                    </div>
                </c:otherwise> 
            </c:choose>
        </c:if>
        </div> 

        <c:url var = "action" value="/anbieter/jobs/neu" />
        <form:form class="form-horizontal" action="${action}" method="post"  modelAttribute="job">
                <div class="form-group">
                    <label for="bezeichnung" class="col-md-3 control-label"> Job<font color="red">*</font>: </label>
                    <div class="col-md-9">
                        <form:input id="bezeichnung" name="bezeichnung" type="text" class="form-control" path="bezeichnung" required="true" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="zusaetzliche_infos" class="col-md-3 control-label"> Details/Beschreibung: </label>
                    <div class="col-md-9">
                        <form:textarea id="zusaetzliche_infos" name="zusaetzliche_infos" class="form-control" rows="3" path="zusaetzliche_infos"></form:textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="datum" class="col-md-3 control-label"> Datum <font color="red">*</font>: </label>
                            <c:set var="datum" value="${job.datum}"/>
                            <c:set var="datumArray" value="${fn:split(datum, '.')}" />
                            <div class="col-md-3">
                                <select class="form-control" name="DOBDay">
                                    <c:choose>
                                        <c:when test="${fn:length(datumArray) gt 0  && not empty datumArray[0]}">
                                            <option>${datumArray[0]}</option>
                                        </c:when> 
                                        <c:otherwise>
                                           <option> - Tag - </option>
                                        </c:otherwise>
                                    </c:choose>
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
                                <select class="form-control" name="DOBMonth">
                                    <c:choose>
                                        <c:when test="${fn:length(datumArray) gt 0  && not empty datumArray[0]}">
                                            <option>${datumArray[1]}</option>
                                        </c:when> 
                                        <c:otherwise>
                                           <option> - Monat - </option>
                                        </c:otherwise>
                                    </c:choose>
                                    <option value="Januar">Januar</option>
                                    <option value="Febuar">Febuar</option>
                                    <option value="März">März</option>
                                    <option value="April">April</option>
                                    <option value="Mai">Mai</option>
                                    <option value="Juni">Juni</option>
                                    <option value="Juli">Juli</option>
                                    <option value="August">August</option>
                                    <option value="September">September</option>
                                    <option value="Oktober">Oktober</option>
                                    <option value="November">November</option>
                                    <option value="Dezember">Dezember</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <select class="form-control" name="DOBYear">
                                    <c:choose>
                                        <c:when test="${fn:length(datumArray) gt 0  && not empty datumArray[0]}">
                                            <option>${datumArray[2]}</option>
                                        </c:when> 
                                        <c:otherwise>
                                           <option> - Jahr - </option>
                                        </c:otherwise>
                                    </c:choose>
                                    <option value="2016">2016</option>
                                    <option value="2017">2017</option>
                                    <option value="2018">2018</option>
                                    <option value="2019">2019</option>
                                    <option value="2020">2020</option>
                                </select>
                            </div>
                </div>
                <div class="form-group">
                    <label for="uhrzeit" class="col-md-3 control-label"> Uhrzeit <font color="red">*</font>: </label>
                    <div class="col-md-9">
                        <form:input path="uhrzeit" name="uhrzeit" id="uhrzeit" class="form-control" type="text" required="true" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="entlohnung" class="col-md-3 control-label"> Lohn <font color="red">*</font>: </label>
                    <div class="col-md-9">
                        <div class="input-group">
                            <form:input path="entlohnung" name="entlohnung" class="form-control" id="entlohnung" type="number" required="true" />
                            <div class="input-group-addon">€</div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="anforderungen" class="col-md-3 control-label">Anforderung:  </label>
                    <div class="col-md-9">
                        <form:input path="anforderungen" name="anforderungen" class="form-control" id="anforderungen" type="text"/> 
                    </div>
                </div>
                <div class="form-group">
                    <label for="zeitaufwand" class="col-md-3 control-label">Zeitaufwand<font color="red">*</font>: </label>
                    <div class="col-md-9">
                        <form:input path="zeitaufwand" name="zeitaufwand" class="form-control" id="zeitaufwand" type="text" required="true"/>
                    </div>
                </div>
               
                <div class="form-group">
                    <label class="control-label col-md-3">Turnus: </label>
                    <div class="col-md-9">
                        <form:checkbox id="turnus" name="turnus" path="turnus" /> <label for="turnus"> Regelmäßig</label>
                    </div>
                </div>
                <input class="btn btn-primary pull-right" type="submit" value="Speichern" />
                <input type="hidden" path="${_csrf.parameterName}" value="${_csrf.token}"/>
                <form:hidden path="id" />
        </form:form>
                
        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>
