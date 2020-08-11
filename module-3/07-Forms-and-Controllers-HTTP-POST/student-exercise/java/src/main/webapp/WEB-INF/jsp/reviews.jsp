<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Squirrel Cigar Parties</title>
	</head>
	<body>
	<a href = "reviewInput" type="surveyInput">Submit a review</a>
		<h1>All Reviews:</h1>
		<table class = "table">
				<tr>
					<th>Username</th>
					<th>Rating</th>
					<th>Title</th>
					<th>Date Submitted</th>
					<th>Text</th>
				</tr>
			<c:forEach items="${allReviews}" var="review">
				<tr>
					<td>${review.username}</td>
					<td>${review.rating}</td>
					<td>${review.title}</td>
					<td>${review.dateSubmitted}</td>
					<td>${review.text}</td>
				</tr>
			</c:forEach>

		</table>
	</body>
</html>