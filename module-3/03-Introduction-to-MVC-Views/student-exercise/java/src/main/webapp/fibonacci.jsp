<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="Fibonacci"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="numberOfItems" value="20" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="50" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="100" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>
	</ul>
</nav>

<!DOCTYPE>
<html>
	<body>
		<ul>
			<c:set var="firstDigit" value="0"/>
			<c:set var = "secondDigit" value = "1" />
			<c:set var="result" value = "0"/>
			<c:forEach begin= "1" end = "${param.max}" var = "i">
				<c:set var = "result" value = "${firstDigit + secondDigit}" />
				<c:if test ="${result < param.max}">
					<li> "${result}" </li>
					<c:set var = "firstDigit" value = "${secondDigit}" />
					<c:set var = "secondDigit" value = "${result}" />
				</c:if>
			</c:forEach>
		</ul>
	</body>
</html>
<c:import url="common/footer.jsp"></c:import>