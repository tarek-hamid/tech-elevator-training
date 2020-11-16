<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Recipe List View</title>
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
        <div id = "tiles">
        <c:forEach var="recipe" items="${requestScope.recipes}">
            <div id = "table-mini">
                <h2 id = "name">${recipe.name}</h2>
                <c:choose>
                    <c:when test="${recipe.averageRating <= 1.5}">
                        <img id = "rating" class = "starsTiles" src = "img/1-star.png" alt="1 Star">
                    </c:when>
                    <c:when test="${recipe.averageRating <= 2.5}">
                        <img id = "rating"  class = "starsTiles" src = "img/2-star.png" alt="2 Star">
                    </c:when>
                    <c:when test="${recipe.averageRating <= 3.5}">
                        <img id = "rating" class = "starsTiles" src = "img/3-star.png" alt="3 Star">
                    </c:when>
                    <c:when test="${recipe.averageRating <= 4.5}">
                        <img id = "rating" class = "starsTiles" src = "img/4-star.png" alt="4 Star">
                    </c:when>
                    <c:when test="${recipe.averageRating > 4.5}">
                        <img id = "rating" class = "starsTiles" src = "img/5-star.png" alt="5 Star">
                    </c:when>
                </c:choose>
                <h2 id = "ingredients">${recipe.ingredients.size()} ingredients</h2>
            </div>
        </c:forEach>
        </div>

       <!-- Use the request attribute "recipes" (List<Recipe>) -->

    </section>
</body>
</html>