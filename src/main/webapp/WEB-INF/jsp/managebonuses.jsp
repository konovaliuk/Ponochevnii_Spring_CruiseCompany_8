<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ua.study.poject.cruise.commands.ActionStorage" %>
<%@ page import="ua.study.poject.cruise.util.StringStorage" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="${StringStorage.BANDLE_MESSAGE}"/>

<html>
<head>
    <title><fmt:message key="message.managebonuses.titel"/></title>
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
        <fmt:message key="message.managebonuses.addbonuses"/>
    </div>
    <form method="get" action="${ActionStorage.SELECTED_CRUISE}">
        <fmt:message key="message.managebonuses.selectcruise"/><br/>
        <select name="${StringStorage.SELECTED_CRUISE}" onchange="submit()">
            <c:if test="${scruise == null}">
                <option value=""><fmt:message key="message.managebonuses.selectcruisemess"/></option>
            </c:if>
            <c:if test="${scruise != null}">
                <option value="${scruise.id}">
                    <fmt:message key="message.managebonuses.cruiseid"/> ${scruise.id}.
                    <fmt:message key="message.managebonuses.shipname"/> ${scruise.ship.shipName}
                </option>
            </c:if>
            <c:forEach var="cruisen" items="${cruiseListBonuse}">
                <option value="${cruisen.id}">
                    <fmt:message key="message.managebonuses.cruiseid"/> ${cruisen.id}.
                    <fmt:message key="message.managebonuses.shipname"/> ${cruisen.ship.shipName}
                </option>
            </c:forEach>
        </select>
    </form>
    <br/><br/><br/><br/>

    <form method="post" action="${ActionStorage.ADD_BONUSES}">
        <fmt:message key="message.managebonuses.selectticketclass"/><br/>
        <select name="${StringStorage.SELECTED_TICKETCLASS}">
            <c:if test="${sticketclass == null}">
                <option value=""><fmt:message key="message.managebonuses.selectticketclass0"/></option>
            </c:if>
            <c:if test="${sticketclass != null}">
                <option value="${sticketclass.id}"><fmt:message
                        key="message.managebonuses.ticketclass"/> ${sticketclass.ticketclassName}</option>
            </c:if>
            <c:forEach var="ticketclassn" items="${ticketclassList}">
                <option value="${ticketclassn.id}"><fmt:message
                        key="message.managebonuses.ticketclass"/> ${ticketclassn.ticketclassName}</option>
            </c:forEach>


        </select>
        <br/><br/>
        <fmt:message key="message.managebonuses.selectservice"/><br/>
        <select name="${StringStorage.SELECTED_SHIPSERVICE_ID}">
            <option value=""><fmt:message key="message.managebonuses.selectservice0"/></option>
            <c:forEach var="shipservicen" items="${shipserviceList}">
                <c:if test="${shipservicen.payable != 0}">
                    <option value="${shipservicen.id}">${shipservicen.service.serviceName}</option>
                </c:if>
            </c:forEach>
        </select>

        <br/>
        <br/> <input type="submit" value="<fmt:message key="message.managebonuses.makeabonus"/>"/>
        <br/>
        <p style="color: red">
            <c:if test="${not empty addBonusesMessage}"><fmt:message key="${addBonusesMessage}"/></c:if>
        </p>
    </form>

</div>

<c:if test="${shipserviceList != null && shipserviceList.size() != 0}">
    <br/><br/>
    <div class="form-style-2">
        <div class="form-style-2-heading">
            <fmt:message key="message.managebonuses.allavailableserv"/>
        </div>
        <table border="1" cellpadding="3" cellspacing="0">
            <thead>
            <tr>
                <td><fmt:message key="message.addshipservicetoship.td1"/></td>
                <td><fmt:message key="message.addshipservicetoship.td2"/></td>
            </tr>
            </thead>
            <c:forEach var="shipservicen" items="${shipserviceList}">
                <tr>
                    <td><c:out value="${shipservicen.service.serviceName}"/></td>
                    <td>
                        <c:if test="${shipservicen.payable == 0}"> <fmt:message
                                key="message.addshipservicetoship.free"/>
                        </c:if>
                        <c:if test="${shipservicen.payable != 0}"> <fmt:message
                                key="message.addshipservicetoship.payable"/>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>

<c:if test="${allBonusesForTicketClass1 != null && allBonusesForTicketClass1.size() != 0}">
    <br/><br/>
    <div class="form-style-2">
        <div class="form-style-2-heading">
            <fmt:message key="message.managebonuses.bforfirstclass"/>
        </div>
        <form method="post" name="deletebonuses1Form" action="${ActionStorage.DELETE_BONUSES}">
            <table border="1" cellpadding="3" cellspacing="0">
                <thead>
                <tr>
                    <td><fmt:message key="message.addshipservicetoship.td1"/></td>
                    <td><fmt:message key="message.addshipservicetoship.td3"/></td>
                </tr>
                </thead>
                <c:forEach var="bonuseForTicketClass1" items="${allBonusesForTicketClass1}">
                    <tr>
                        <td><c:out value="${bonuseForTicketClass1.shipService.service.serviceName}"/></td>
                        <td><input type="checkbox" name="${StringStorage.BONUSES}"
                                   value="${bonuseForTicketClass1.id}">
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br/><input type="submit" value="<fmt:message key="message.managebonuses.deletebon"/>"/>
        </form>
        <hr/>
    </div>
</c:if>


<c:if test="${allBonusesForTicketClass2 != null && allBonusesForTicketClass2.size() != 0}">
    <br/><br/>
    <div class="form-style-2">
        <div class="form-style-2-heading">
            <fmt:message key="message.managebonuses.bforsecclass"/>
        </div>
        <form method="post" name="deletebonuses2Form" action="${ActionStorage.DELETE_BONUSES}">
            <table border="1" cellpadding="3" cellspacing="0">
                <thead>
                <tr>
                    <td><fmt:message key="message.addshipservicetoship.td1"/></td>
                    <td><fmt:message key="message.addshipservicetoship.td3"/></td>
                </tr>
                </thead>
                <c:forEach var="bonuseForTicketClass2" items="${allBonusesForTicketClass2}">
                    <tr>
                        <td><c:out value="${bonuseForTicketClass2.shipService.service.serviceName}"/></td>
                        <td><input type="checkbox" name="${StringStorage.BONUSES}"
                                   value="${bonuseForTicketClass2.id}">
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br/><input type="submit" value="<fmt:message key="message.managebonuses.deletebon"/>"/>
        </form>
        <hr/>
    </div>
</c:if>


<c:if test="${allBonusesForTicketClass3 != null && allBonusesForTicketClass3.size() != 0}">
    <br/><br/>
    <div class="form-style-2">
        <div class="form-style-2-heading">
            <fmt:message key="message.managebonuses.bforthirdclass"/>
        </div>
        <form method="post" name="deletebonuses3Form" action="${ActionStorage.DELETE_BONUSES}">
            <table border="1" cellpadding="3" cellspacing="0">
                <thead>
                <tr>
                    <td><fmt:message key="message.addshipservicetoship.td1"/></td>
                    <td><fmt:message key="message.addshipservicetoship.td3"/></td>
                </tr>
                </thead>
                <c:forEach var="bonuseForTicketClass3" items="${allBonusesForTicketClass3}">
                    <tr>
                        <td><c:out value="${bonuseForTicketClass3.shipService.service.serviceName}"/></td>
                        <td><input type="checkbox" name="${StringStorage.BONUSES}"
                                   value="${bonuseForTicketClass3.id}">
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br/><input type="submit" value="<fmt:message key="message.managebonuses.deletebon"/>"/>
        </form>
        <hr/>
    </div>
</c:if>


<c:if test="${allBonusesForTicketClass4 != null && allBonusesForTicketClass4.size() != 0}">
    <br/><br/>
    <div class="form-style-2">
        <div class="form-style-2-heading">
            <fmt:message key="message.managebonuses.bforfourclass"/>
        </div>
        <form method="post" name="deletebonuses4Form" action="${ActionStorage.DELETE_BONUSES}">
            <table border="1" cellpadding="3" cellspacing="0">
                <thead>
                <tr>
                    <td><fmt:message key="message.addshipservicetoship.td1"/></td>
                    <td><fmt:message key="message.addshipservicetoship.td3"/></td>
                </tr>
                </thead>
                <c:forEach var="bonuseForTicketClass4" items="${allBonusesForTicketClass4}">
                    <tr>
                        <td><c:out value="${bonuseForTicketClass4.shipService.service.serviceName}"/></td>
                        <td><input type="checkbox" name="${StringStorage.BONUSES}"
                                   value="${bonuseForTicketClass4.id}">
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br/><input type="submit" value="<fmt:message key="message.managebonuses.deletebon"/>"/>
        </form>
        <hr/>
    </div>
</c:if>


</body>
</html>
