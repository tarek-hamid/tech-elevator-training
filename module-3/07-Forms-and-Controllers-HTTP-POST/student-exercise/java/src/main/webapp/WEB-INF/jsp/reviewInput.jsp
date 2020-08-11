<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review Form</title>
    <link rel="stylesheet" href="site.css"></link>
</head>
<body>
<div id="main_content">
<h1>Please enter your review</h1>
<form action="surveyInput" method="POST">
    <div class="formGroup">
        <label for="username">Username: </label>
        <input type="text" name="username" id="username" required />
    </div>
    <div class="formGroup">
        <label for="rating">Rating: </label>
        <input type="text" name="rating" id="rating" required />
    </div>
    <div class="formGroup">
        <label for="title">Review title: </label>
        <input type="text" name="title" id="title" required />
    </div>
    <div class="formGroup">
        <label for="text">Review: </label>
        <input type="text" name="text" id="text" required />
    </div>
    </div>
    <div class="formGroup">
        <input type="submit" value="Submit" />
    </div>
</form>
</div>
</body>
</html>
