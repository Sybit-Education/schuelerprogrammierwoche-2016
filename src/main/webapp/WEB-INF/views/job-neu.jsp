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

        <c:url var = "action" value="/anbieter/jobs/neu" />
        <form:form class="form-horizontal" action="${action}" method="post"  modelAttribute="job">
                <div class="form-group">
                    <label for="bezeichnung" class="col-md-3 control-label"> Job<font color="red">*</font>: </label>
                    <div class="col-md-9">
                        <input id="bezeichnung" name="bezeichnung" type="text" class="form-control" value="" required />
                    </div>
                </div>
                <div class="form-group">
                    <label for="details" class="col-md-3 control-label"> Details/Beschreibung: </label>
                    <div class="col-md-9">
                        <textarea id="details" name="details" class="form-control" rows="3"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="datum" class="col-md-3 control-label"> Datum <font color="red">*</font>: </label>
                    <div class="col-md-9">
                        <select name="DOBMonth">
                            <option> - Monat - </option>
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

                        <select name="DOBDay">
                            <option> - Tag - </option>
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

                        <select name="DOBYear">
                            <option> - Jahr - </option>
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
                        <input name="uhrzeit" id="uhrzeit" class="form-control" type="text" value="" required />
                    </div>
                </div>
                <div class="form-group">
                    <label for="entlohnung" class="col-md-3 control-label"> Lohn <font color="red">*</font>: </label>
                    <div class="col-md-9">
                        <div class="input-group">
                            <input name="entlohnung" class="form-control" id="entlohnung" type="number" value="" required />
                            <div class="input-group-addon">€</div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="anforderung" class="col-md-3 control-label"> Anforderung:  </label>
                    <div class="col-md-9">
                        <input name="anforderung" class="form-control" id="anforderung" type="text" value="" /> 
                    </div>
                </div>
                <div class="form-group">
                    <label for="zeitaufwand" class="col-md-3 control-label">Zeitaufwand<font color="red">*</font>: </label>
                    <div class="col-md-9">
                        <input name="zeitaufwand" class="form-control" id="zeitaufwand" type="text" value="" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3 control-label">
                        <input type="radio" id="turnus1" name="turnus" value="Regelmäßig"> <label for="turnus1"> Regelmäßig</label><br>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3 control-label">
                        <input type="radio" id="turnus2" name="turnus" value="Einmalig<"> <label for="turnus2"> Einmalig</label><br>
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
