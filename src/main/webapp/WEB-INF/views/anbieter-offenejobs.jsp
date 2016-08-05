<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
    <head>
        <c:import url="inc/header.jsp" />
        <title>Meine Jobs</title>

    </head>
    <body>

        <c:import url="inc/navigation.jsp" />

        <div class="container">

            <div class="page-header">
                <h2>Meine offenen Jobs</h2>
            </div>

            <c:forEach items="${jobs}" var="job">
                    <div class="col-md-12">
                        <div class="row">
                            <div class="col-md-4">
                                <a href="<c:url value="/anbieter/jobs/detail/${job.id}" />">
                                    <ul class="list-group">
                                        <li class="list-group-item">
                                            <span class="badge">14</span>
                                            ${job.bezeichnung}
                                        </li>
                                    </ul>
                                </a>
                            </div>
                        </div>
                    </div>
            </c:forEach>  
        </div>



        <c:import url="inc/footer.jsp" />
    </body>
</html>
<!--<table class="table">
                            <tbody>
                                <tr>
                                    <td>Icon</td>
                                    <td><a href="/schueler/profil?id=${job.id}">Jonas</a></td>
                                    <td><button type="button" class="btn btn-success" onclick="clickAcceptButton('Jonas')">Accept</button></td>
                                </tr>
                                <tr>
                                    <td>Icon1</td>
                                    <td><a href="/schueler/profil?id=${job.id}">Test</a></td>
                                    <td><button type="button" class="btn btn-success" onclick="clickAcceptButton('Test')">Accept</button></td>                            
                                </tr>
                            </tbody>
                        </table>
 <form type="hidden" action="POST">
            <input type="hidden" value="${job.id}">
        </form>
<script>
            function clickAcceptButton(schuelerName) {
                var result = confirm("Willst du " + schuelerName + " den Job geben?");

                if (result === true) {

                }
            }
        </script>--!>
