<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/searchFilm" />
<form method="GET" action="${formAction}">
    <div class="formInputGroup">
        <label for="minimumLength">Minimum Length:</label>
        <input type="text" name="minimumLength" id="minimumLength" />
        <label for="maximumLength">Maximum Length:</label>
        <input type="text" name="maximumLength" id="maximumLength" />
        <label for="genre">Genre:</label>
        <select name="genre" id="genre">
            <option value="Comedy">Comedy</option>
            <option value="Action">Action</option>
            <option value="Animation">Animation</option>
            <option value="Children">Children</option>
            <option value="Documentary">Documentary</option>
        </select>
    </div>
    <input class="formSubmitButton" type="submit" value="Search" />
</form>
<table class="table">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Release Year</th>
        <th>Length</th>
        <th>Rating</th>
    </tr>
    <c:forEach items="${searchFilmResults}" var="film">
        <tr>
            <td>${film.title}</td>
            <td>${film.description}</td>
            <td>${film.releaseYear}</td>
            <td>${film.length}</td>
            <td>${film.rating}</td>
        </tr>
    </c:forEach>
</table>

<%@include file="common/footer.jspf"%>