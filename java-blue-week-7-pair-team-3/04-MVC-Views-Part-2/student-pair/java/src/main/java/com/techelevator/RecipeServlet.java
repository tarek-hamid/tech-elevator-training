package com.techelevator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RecipeController recipes = new RecipeController();
        recipes.displayRecipeTable(req);


        /* This line adds a request attribute with the name "studentList"
         * that contains our list of student names. This will later be
         * used by the View (i.e. JSP) to display student names in HTML */

        /* This line forwards the request to the JSP */
        this.getServletContext().getRequestDispatcher("/WEB-INF/nameList.jsp").forward(req, resp);
    }
}
