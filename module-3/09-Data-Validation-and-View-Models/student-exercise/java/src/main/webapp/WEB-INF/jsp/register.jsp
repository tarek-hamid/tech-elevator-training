<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>New User Registration</h2>
<c:url var="userRegistration" value="/register"/>
<form:form method="POST" action="${userRegistration}" modelAttribute="registration">

    <div>
        <label for="firstName">First Name</label>
        <form:input path="firstName"/>
        <form:errors path="firstName" cssClass="error"/>
    </div>
    <div>
        <label for="lastName">Last Name</label>
        <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
    </div>
    <div>
        <label for="email">Email</label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>
    <div>
        <label for="emailConfirm">Confirm Email</label>
        <form:input path="emailConfirm"/>
        <form:errors path="emailConfirm" cssClass="error"/>
        <form:errors path="emailMatching" cssClass="error"/>
    </div>
    <div>
        <label for="password">Password</label>
        <form:input path="password"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <div>
        <label for="passwordConfirm">Confirm Password</label>
        <form:input path="passwordConfirm"/>
        <form:errors path="passwordConfirm" cssClass="error"/>
        <form:errors path="passwordMatching" cssClass="error"/>
    </div>
    <div>
        <label for="birthdate">Birthday</label>
        <form:input path="birthdate"/>
        <form:errors path="birthdate" cssClass="error"/>
    </div>
    <div>
        <label for="numberOfTickets"># of Tickets</label>
        <form:input path="numberOfTickets"/>
        <form:errors path="numberOfTickets" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="Submit"/>
    </div>
</form:form>
</body>
</html>


<%@include file="common/footer.jspf" %>