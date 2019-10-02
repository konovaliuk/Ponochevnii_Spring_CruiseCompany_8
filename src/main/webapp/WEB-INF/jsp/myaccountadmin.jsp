<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <title><fmt:message key="message.myaccount.title"/></title>
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

    </div>
    <br/>

    <form method="get" action="${ActionStorage.CREATE_SHIP}">
        <br/> <input type="submit" value="<fmt:message key="message.myaccount.createship"/>"/>
    </form>

    <form method="get" action="${ActionStorage.CREATE_PORT}">
        <br/> <input type="submit" value="<fmt:message key="message.myaccount.createport"/>"/>
    </form>

    <form method="get" action="${ActionStorage.CREATE_EXCURSION}">
        <br/> <input type="submit" value="<fmt:message key="message.myaccount.createexcursion"/>"/>
    </form>

    <form method="get" action="${ActionStorage.EDIT_ACCOUNT}">
        <br/> <input type="submit" value="<fmt:message key="message.myaccount.editaccountbtn"/>"/>
    </form>

    <form method="get" action="${ActionStorage.CREATE_CRUISE}">
<%--        <input type="hidden" name="${ActionStorage.COMMAND}" value="${ActionStorage.CREATE_CRUISE}"/>--%>
        <br/> <input type="submit" value="<fmt:message key="message.myaccount.createcruise"/>"/>
    </form>

    <form method="get" action="${ActionStorage.CHANGE_USER_ROLE}">
<%--        <input type="hidden" name="${ActionStorage.COMMAND}" value="${ActionStorage.CHANGE_USER_ROLE}"/>--%>
        <br/> <input type="submit" value="<fmt:message key="message.myaccount.changeuserrole"/>"/>
    </form>

    <form method="get" action="${ActionStorage.ADD_SHIP_SERVICES_TO_SYSTEM}">
<%--        <input type="hidden" name="${ActionStorage.COMMAND}" value="${ActionStorage.ADD_SHIP_SERVICES_TO_SYSTEM}"/>--%>
        <br/> <input type="submit" value="<fmt:message key="message.myaccount.addservicestosystem"/>"/>
    </form>

    <form method="get" action="${ActionStorage.ADD_SHIP_SERVICES_TO_SHIP}">
<%--        <input type="hidden" name="${ActionStorage.COMMAND}" value="${ActionStorage.ADD_SHIP_SERVICES_TO_SHIP}"/>--%>
        <br/> <input type="submit" value="<fmt:message key="message.myaccount.addremoveservicestoship"/>"/>
    </form>

</div>


</body>
</html>
