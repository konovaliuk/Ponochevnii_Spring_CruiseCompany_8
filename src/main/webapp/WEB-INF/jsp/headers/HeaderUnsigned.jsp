﻿<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="ua.study.poject.cruise.commands.ActionStorage"%>
<%@ page import="ua.study.poject.cruise.util.StringStorage"%>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="${StringStorage.BANDLE_MESSAGE}"/>

<html>
<head>
    <title></title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="header-form">
    <form class="header-button-left" method="post" action="${ActionStorage.CHANGE_LANGUAGE}">

        <select name="${StringStorage.LANGUAGE}" onchange="submit()">
            <option value="en" <c:if test="${language == 'en'}">selected</c:if> >En</option>
            <option value="ru" <c:if test="${language == 'ru'}">selected</c:if> >Ru</option>
            <option value="ua" <c:if test="${language == 'ua'}">selected</c:if> >Ua</option>
            <option value="es" <c:if test="${language == 'es'}">selected</c:if> >Es</option>
        </select>
    </form>

    <form class="header-button-left" method="get" action="${ActionStorage.START_PAGE}">
        <input type="submit" value="<fmt:message key="message.headerregistred.startpage"/>"/>
    </form>

    <div class="header-button-div">
        <form style="float: right" method="get" action="${ActionStorage.SIGN_IN}">
            <input type="submit" value="<fmt:message key="message.headerunregistred.signin"/>"/>
        </form>
    </div>

    <div class="header-button-div">
        <form style="float: right" method="get" action="${ActionStorage.SIGN_UP}">
            <input type="submit" value="<fmt:message key="message.headerunregistred.signup"/>"/>
        </form>
    </div>
</div>
</body>
</html>
