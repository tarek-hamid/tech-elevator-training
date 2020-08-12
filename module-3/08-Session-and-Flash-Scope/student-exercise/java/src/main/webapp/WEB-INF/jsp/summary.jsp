<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
    <c:param name="title" value="Summary" />
</c:import>

<div class='summaryElement'>
    <b><span class='summaryElementHeader'>Favorite Color: </span></b>
    <c:out value="${favoriteThings.color}" /><br>
    <b><span class='summaryElementHeader'>Favorite Food: </span></b>
    <c:out value="${favoriteThings.food}" /><br>
    <b><span class='summaryElementHeader'>Favorite Season: </span></b>
    <c:out value="${favoriteThings.season}" /><br>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />
