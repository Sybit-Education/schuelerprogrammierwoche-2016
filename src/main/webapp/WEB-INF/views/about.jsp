<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
    <head>
        <c:import url="inc/header.jsp" />
        <title>Wir über uns :: Taschengeldbörse</title>

    </head>
    <body>

        <c:import url="inc/navigation.jsp" />

        <div class="container">
            <h1>Wir über uns</h1>
            <div class="row">
                <div class="col-md-12">

                    <div id="homeSlider" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#homeSlider" data-slide-to="0" class="active"></li>
                            <li data-target="#homeSlider" data-slide-to="1"></li>
                            <li data-target="#homeSlider" data-slide-to="2"></li>
                            <li data-target="#homeSlider" data-slide-to="3"></li>
                            <li data-target="#homeSlider" data-slide-to="4"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">


                            <div class="item active">
                                <img src="<c:url value="/resources/img/wir/IMG_3936.JPG" />" alt="Wir über uns" />
                                <div class="carousel-caption">
                                    Schülerprojektwoche 2016 bei Sybit
                                </div>
                            </div>
                            <div class="item">
                                <img src="<c:url value="/resources/img/wir/IMG_3969.JPG" />" alt="Wir" />
                                <div class="carousel-caption">
                                    Schülerprojektwoche 2016 bei Sybit
                                </div>
                            </div>
                            <div class="item">
                                <img src="<c:url value="/resources/img/wir/IMG_3991.JPG" />" alt="" />
                                 <div class="carousel-caption">
                                    Schülerprojektwoche 2016 bei Sybit
                                </div>                               
                            </div>
                            <div class="item">
                                <img src="<c:url value="/resources/img/wir/IMG_3936.JPG" />" alt="" />
                                 <div class="carousel-caption">
                                    Schülerprojektwoche 2016 bei Sybit
                                </div>
                            </div>
                            <div class="item">
                                <img src="<c:url value="/resources/img/wir/IMG_4010.JPG" />" alt="" />
                                 <div class="carousel-caption">
                                    Schülerprojektwoche 2016 bei Sybit
                                </div>
                            </div>

                            <!-- Left and right controls -->
                            <a class="left carousel-control" href="#homeSlider" role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control" href="#homeSlider" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <c:import url="inc/footer.jsp" />
    </body>
</html>
