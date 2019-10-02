<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ua.study.poject.cruise.commands.ActionStorage" %>
<%@ page import="ua.study.poject.cruise.util.StringStorage" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="${StringStorage.BANDLE_MESSAGE}"/>

<!DOCTYPE html>
<html>
<head>
    <style>
        <%@include file="/resources/css/style.css"%>
    </style>
    <title><fmt:message key="message.startpage.title"/></title>
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
        <fmt:message key="message.startpage.availcruises"/>
    </div>

        <c:forEach var="cruisefromlist" items="${allCruises}">

            <table border="1" cellpadding="3" cellspacing="0">
                <thead>
                <tr>
                    <td colspan="5">
                        <fmt:message key="message.viewcart.cruisenum"/><b> ${cruisefromlist.cruise.id}&nbsp;</b>
                        <br/> <fmt:message key="message.viewcart.shipname"/><b> ${cruisefromlist.cruise.ship.shipName}</b>
                    </td>
                </tr>
                <tr>
                    <td><fmt:message key="message.viewcruise.country"/></td>
                    <td><fmt:message key="message.viewcruise.city"/></td>
                    <td><fmt:message key="message.viewcruise.arrival"/></td>
                    <td><fmt:message key="message.viewcruise.departure"/></td>
                    <td><fmt:message key="message.viewcruise.details"/></td>
                </tr>
                </thead>

                <c:forEach var="cruisePorts" items="${cruisefromlist.cruisePortsList}">
                    <tr>
                        <td><c:out value="${cruisePorts.port.country}"/></td>
                        <td><c:out value="${cruisePorts.port.city}"/></td>
                        <td><c:out value="${cruisePorts.dateIn}"/></td>
                        <td><c:out value="${cruisePorts.dateOut}"/></td>
                        <td>
                            <form method="get" action="${ActionStorage.VIEW_PORT}">
                                <input type="hidden" name="${StringStorage.SELECTED_PORT_ID}" value="${cruisePorts.port.id}">
                                <br/><input type="submit" value="<fmt:message key="message.viewcart.moredetails"/>">
                            </form>
                        </td>
                    </tr>
                </c:forEach>

            </table>

            <form method="get" action="${ActionStorage.VIEW_CRUISE}">
                <input type="hidden" name="${StringStorage.SELECTED_CRUISE_ID}" value="${cruisefromlist.cruise.id}">
                <br/><input type="submit" value="<fmt:message key="message.viewcart.moredetails"/>">
            </form>
            <br/><br/><br/><br/>
        </c:forEach>


</div>

<p style="color: red">
    <c:if test="${not empty startpageMessage}"><fmt:message key="${startpageMessage}"/></c:if>
</p>
</body>
</html>
