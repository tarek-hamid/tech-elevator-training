<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<c:url var="formAction" value="" />
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Hello, <c:out value="${param.name}" />!</h1>
	</body>
</html>