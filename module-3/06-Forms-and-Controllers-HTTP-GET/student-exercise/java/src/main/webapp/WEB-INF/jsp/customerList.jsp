<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>
<c:url var="formAction" value="/searchCustomers" />
<form method="GET" action="${formAction}">
    <div class="formInputGroup">
        <label for="searchName"></label>
        <input type="text" name="searchName" id="searchName" />
    </div>
    <select name="sortBy" id="sortBy">
        <option value="First Name">First Name</option>
        <option value="Last Name">Last Name</option>
    </select>
    <input class="formSubmitButton" type="submit" value="Search" />
</form>
<table class="table">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Active</th>
    </tr>
    <c:forEach items="${customerListResults}" var="customer">
        <tr>
            <td>${customer.firstName} ${customer.lastName} </td>
            <td>${customer.email}</td>
            <td>
            <c:choose>
                <c:when test ="${customer.active}">
                    <c:out value="Yes"/>
                </c:when>
                <c:otherwise>
                    <c:out value="No"/>
                </c:otherwise>
            </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="common/footer.jspf"%>