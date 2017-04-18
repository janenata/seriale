<%--
  Created by IntelliJ IDEA.
  User: Nathalie
  Date: 14.04.2017
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <title>IzaNatSeries ${user.login}</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">IzaNatSeries</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/user"><span class="glyphicon glyphicon-check"></span> ${user.login}</a></li>
            <li><a href="/editSeries"><span class="glyphicon glyphicon-pencil"></span> Edit series</a></li>
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class= "main col-xs-9">
        <c:if test="${empty userSeries}">
            <h3>You aren't observing any series.<br> It's time to change it!!!</h3>
            <h3> <a href="/editSeries"><span class="glyphicon glyphicon-pencil"></span> Edit series</a><br></h3>
        </c:if>
            <c:if test="${not empty userSchedule}">
            <h3>Your schedule</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>Series</th>
                    <th style="text-align: center">Air date</th>
                    <th style="text-align: center">Air time</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="listValue" items="${userSchedule}">

                        <tr>
                            <th scope="row" style="vertical-align: middle">
                                <a href=${listValue.series.seriesWebsite} target="_blank">
                                    <img src="${listValue.series.imageLink}" height="132" width="100"/> &nbsp;${listValue.series.title}
                                </a>

                            </th>
                            <td style="vertical-align: middle; text-align: center">
                                   <p>${listValue.day}<br><br>
                                     ${listValue.airDate}
                                   </p>

                            </td>
                            <td style="vertical-align: middle; text-align: center">
                                    ${listValue.airTime}
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
            <c:if test="${empty userSchedule && not empty userSeries}">
                <img src="https://image.freepik.com/free-icon/crying-emoticon-face_318-48236.jpg" width="300" height="300" style="align-items: center;">
                <h3>We are sorry to inform you that you have no series to watch</h3>
            </c:if>
            <br>
            <c:if test="${not empty userSeries}">
            <h3>Your subscriptions</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Rating</th>
                    <th>Station</th>
                    <th>Rate</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="listValue" items="${userSeries}">

                        <tr>
                            <th scope="row">

                                <a href=${listValue.seriesWebsite} target="_blank">
                                    <img src="${listValue.imageLink}" height="132" width="100"/> &nbsp;${listValue.title}
                                </a>
                            </th>
                            <td style="vertical-align: middle">
                                <c:forEach begin="1" end="${listValue.rating}" varStatus="loop">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                </c:forEach>
                                <c:forEach begin="${listValue.rating}" end="9" varStatus="loop">
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                </c:forEach>
                            </td>
                            <td style="vertical-align: middle">${listValue.station}</td>
                            <td style="vertical-align: middle">
                                Rate
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>

        </div>
        <div class="sidebar col-xs-3">
            <div class="well">
                <c:if test="${not empty youMightLike}">
                    <ul class="nav">
                        <li class="nav-header">You also might like</li>
                        <c:forEach var="listValue" items="${youMightLike}">
                            <li>
                                <a href=${listValue.seriesWebsite} target="_blank">
                                        ${listValue.title}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
                <c:if test="${not empty mostPopular}">
                    <ul class="nav">
                        <li class="nav-header">Most popular series</li>
                        <c:forEach var="listValue" items="${mostPopular}">
                            <li>
                                <a href=${listValue.seriesWebsite} target="_blank">
                                        ${listValue.title}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
                <c:if test="${not empty topRated}">
                    <ul class="nav">
                        <li class="nav-header">Top rated series</li>
                        <c:forEach var="listValue" items="${topRated}">
                            <li>
                                <a href=${listValue.seriesWebsite} target="_blank">
                                        ${listValue.title}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
        </div>
    </div>
</div>

<script src="webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
