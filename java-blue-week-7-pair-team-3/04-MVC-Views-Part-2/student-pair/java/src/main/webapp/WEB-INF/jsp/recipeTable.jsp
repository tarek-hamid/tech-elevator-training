<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Recipe Table View</title>
    <link rel="stylesheet" href="css/site.css" />
</head>
<body>
    <header>
        <h1>MVC Exercises - Views Part 2: Models</h1>        
    </header>
    <nav>
        <ul>
            <li><a href="recipeTiles">Tile Layout</a></li>
            <li><a href="recipeTable">Table Layout</a></li>
        </ul>
        
    </nav>
    <section id="main-content">
        <h1 id = "title">Recipes</h1>
        <img id = "pic1" src = "img/recipe0.jpg" alt="Roasted Broccoli">
        <img id = "pic2" src = "img/recipe1.jpg" alt="Green Rice">
        <img id = "pic3" src = "img/recipe2.jpg" alt="Pasta">

        <table id = "table">
            <tr>
                <th>Name</th>
                <c:forEach var="recipe" items="${requestScope.recipes}">
                    <th>${recipe.name}</th>
                </c:forEach>
            </tr>
            <tr>
                <th>Type</th>
                <c:forEach var="recipe" items="${requestScope.recipes}">
                    <th>${recipe.recipeType}</th>
                </c:forEach>
            </tr>
            <tr>
                <th>Cook Time</th>
                <c:forEach var="recipe" items="${requestScope.recipes}">
                    <th>${recipe.cookTimeInMinutes}</th>
                </c:forEach>
            </tr>
            <tr>
                <th>Ingredients</th>
                <c:forEach var="recipe" items="${requestScope.recipes}">
                    <th>${recipe.ingredients.size()}</th>
                </c:forEach>
            </tr>
            <tr>
                <th>Rating</th>
                <c:forEach var="recipe" items="${requestScope.recipes}">
                    <c:choose>
                        <c:when test="${recipe.averageRating <= 1.5}">
                            <th> <img class = "stars" src = "img/1-star.png" alt="1 Star"> </th>
                        </c:when>
                        <c:when test="${recipe.averageRating <= 2.5}">
                            <th><img class = "stars" src = "img/2-star.png" alt="2 Star"></th>
                        </c:when>
                        <c:when test="${recipe.averageRating <= 3.5}">
                            <th> <img class = "stars" src = "img/3-star.png" alt="3 Star"></th>
                        </c:when>
                        <c:when test="${recipe.averageRating <= 4.5}">
                            <th><img class = "stars" src = "img/4-star.png" alt="4 Star"></th>
                        </c:when>
                        <c:when test="${recipe.averageRating >4.5}">
                            <th><img class = "stars" src = "img/5-star.png" alt="5 Star"></th>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </tr>

        </table>

       <!-- Use the request attribute "recipes" (List<Recipe>) -->

    </section>
</body>
</html>