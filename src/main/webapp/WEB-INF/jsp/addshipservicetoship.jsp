﻿<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ua.study.poject.cruise.commands.ActionStorage" %>
<%@ page import="ua.study.poject.cruise.util.StringStorage" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="${StringStorage.BANDLE_MESSAGE}"/>

<html>
<head>
    <style>
        <%@include file="/resources/css/style.css"%>
    </style>
    <title><fmt:message key="message.addshipservicetoship.title"/></title>
</head>
<body>

<c:set var="hdr">
    <c:choose>
        <c:when test="${not empty sessionScope.currentuser}">
            /WEB-INF/jsp/headers/HeaderRegistred.jsp
        </c:when>
        <c:otherwise>
            /WEB-INF/jsp/headers/HeaderUnsigned.jsp
        </c:otherwise>
    </c:choose>
</c:set>
<jsp:include page="${hdr}"/>

<br/><br/><br/>

<div class="form-style-2">
    <div class="form-style-2-heading">
        <fmt:message key="message.addshipservicetoship.announcement"/>
    </div>

    <form method="post" action="${StringStorage.ADD_SHIP_SERVICE_TO_SHIP}">
        <fmt:message key="message.addshipservicetoship.advert2"/>:
        <br/>
        <select name="${StringStorage.SELECTED_SHIP}" onchange="submit()">
            <c:if test="${sship == null}">
                <option value=""><fmt:message key="message.addshipservicetoship.advert2"/></option>
            </c:if>
            <c:if test="${sship != null}">
                <option value="${sship.id}">${sship.id}. ${sship.shipName}</option>
            </c:if>
            <c:forEach var="shipn" items="${allShips}">
                <option value="${shipn.id}">${shipn.id}. ${shipn.shipName}</option>
            </c:forEach>
        </select>
        <br/><br/><br/><br/>

        <select name="${StringStorage.SELECTED_SERVICE}">
            <option value=""><fmt:message key="message.addshipservicetoship.advert3"/></option>
            <c:forEach var="servicen" items="${allServicesInSystem}">
                <option value="${servicen.id}">${servicen.serviceName}</option>
            </c:forEach>
        </select>
        <br/><br/>
        <label><input type="radio" name="${StringStorage.PAYABLE}" value="0" checked> <fmt:message
                key="message.addshipservicetoship.free"/></label>
        <label><input type="radio" name="${StringStorage.PAYABLE}" value="1"> <fmt:message
                key="message.addshipservicetoship.payable"/></label>
        <br/>
        <br/> <input type="submit" value="<fmt:message key="message.addshipservicetoship.title"/>"/>
        <br/>
        <p style="color: red">
            <c:if test="${not empty addShipServiceToShipMessage}"><fmt:message
                    key="${addShipServiceToShipMessage}"/></c:if>
        </p>
    </form>

    <br/><br/>
    <form method="get" action="${ActionStorage.ADD_SHIP_SERVICES_TO_SYSTEM}">
        <br/> <input type="submit" value=<fmt:message key="message.addshipservicetoship.create"/>/>
    </form>
</div>

<br/><br/>
<c:if test="${allServicesOnSelectedShip != null && allServicesOnSelectedShip.size() != 0}">

    <div class="form-style-2">
        <div class="form-style-2-heading">
            <fmt:message key="message.addshipservicetoship.advert4"/>
        </div>

        <form method="post" action="${ActionStorage.DELETE_SHIP_SERVICES_FROM_SHIP}">
            <input type="hidden" name="${StringStorage.SELECTED_SHIP}" value="${sship.id}">

            <table border="1" cellpadding="3" cellspacing="0">
                <thead>
                <tr>
                    <td><fmt:message key="message.addshipservicetoship.td1"/></td>
                    <td><fmt:message key="message.addshipservicetoship.td2"/></td>
                    <td><fmt:message key="message.addshipservicetoship.td3"/></td>
                </tr>
                </thead>
                <c:forEach var="servicefromlist" items="${allServicesOnSelectedShip}">
                    <tr>
                        <td><c:out value="${servicefromlist.service.serviceName}"/></td>
                        <td>
                            <c:if test="${servicefromlist.payable == 0}"> <fmt:message
                                    key="message.addshipservicetoship.free"/> </c:if>
                            <c:if test="${servicefromlist.payable != 0}"> <fmt:message
                                    key="message.addshipservicetoship.payable"/> </c:if>
                        </td>
                        <td><input type="checkbox" name="${StringStorage.SHIP_SERVICE}"
                                   value="${servicefromlist.service.id}"></td>
                    </tr>
                </c:forEach>
            </table>
            <br/><input type="submit" value=<fmt:message key="message.addshipservicetoship.delete"/>/>
        </form>

    </div>
</c:if>
</body>
</html>
