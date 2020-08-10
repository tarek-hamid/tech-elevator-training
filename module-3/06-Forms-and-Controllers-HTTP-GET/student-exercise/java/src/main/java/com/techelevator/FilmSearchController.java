package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping("/searchFilmForm")
    public String showFilmSearchForm() {
        return "filmList";
    }

    @RequestMapping("/searchFilm")
    public String searchFilms(@RequestParam int minimumLength,
                              @RequestParam int maximumLength,
                              @RequestParam String genre,
                              ModelMap modelMap) {
        List<Film> filmList = filmDao.getFilmsBetween(genre, minimumLength, maximumLength);
        modelMap.put("searchFilmResults", filmList);
        return "filmList";
    }
}