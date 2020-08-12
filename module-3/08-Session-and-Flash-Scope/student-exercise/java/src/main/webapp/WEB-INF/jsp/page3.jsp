<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
    <c:param name="title" value="Favorite Season" />
</c:import>

<form method="POST">
    <label>What is your favorite season?<br>
        <span><input type="radio" name="favoriteSeason" value="Spring">Spring</span>
        <span><input type="radio" name="favoriteSeason" value="Summer">Summer</span>
        <span><input type="radio" name="favoriteSeason" value="Fall">Fall</span>
        <span><input type="radio" name="favoriteSeason" value="Winter">Winter</span>
    </label>
    <button type="submit">Next >>></button>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
