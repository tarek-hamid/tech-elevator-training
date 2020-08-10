<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
<!-- Form goes here -->
<c:url var="formAction" value="/searchActors" />
<form method="GET" action="${formAction}">
    <div class="formInputGroup">
        <label for="searchName">Name:</label>
        <input type="text" name="searchName" id="searchName" />
    </div>
    <input class="formSubmitButton" type="submit" value="Submit" />
</form>
<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${actorListResults}" var="actor">
<tr>
    <td>${actor.firstName} ${actor.lastName} </td>
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>