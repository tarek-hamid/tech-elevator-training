<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>Login</h2>
<c:url var="userLogin" value="/login"/>
<form:form method="POST" action="${userLogin}" modelAttribute="login">

    <div>
        <label for="emailAddress">Email Address</label>
        <form:input path="emailAddress"/>
        <form:errors path="emailAddress" cssClass="error"/>
    </div>
    <div>
        <label for="password">Password</label>
        <form:input path="password"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="Submit"/>
    </div>
</form:form>
</body>
</html>


<%@include file="common/footer.jspf" %>
