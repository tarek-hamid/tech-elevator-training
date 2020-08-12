package com.techelevator.controller;

import com.techelevator.model.FavoriteThings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/FavoriteThings")
public class FavoriteThingsController {

	@RequestMapping(path = "/Page1", method = RequestMethod.GET)
	public String getPage1() {
		return "page1";
	}

	@RequestMapping(path = "/Page1", method = RequestMethod.POST)
	public String processFavoriteColor(@RequestParam String favoriteColor, HttpSession session) {

		FavoriteThings application = new FavoriteThings();
		application.setColor(favoriteColor);

		session.setAttribute("favoriteThings", application);

		return "redirect:/FavoriteThings/Page2";
	}

	@RequestMapping(path = "/Page2", method = RequestMethod.GET)
	public String getPage2() {
		return "page2";
	}

	@RequestMapping(path = "/Page2", method = RequestMethod.POST)
	public String processFavoriteFood(@RequestParam String favoriteFood, HttpSession session) {

		FavoriteThings application = (FavoriteThings) session.getAttribute("favoriteThings");
		application.setFood(favoriteFood);

		session.setAttribute("favoriteThings", application);

		return "redirect:/FavoriteThings/Page3";
	}

	@RequestMapping(path = "/Page3", method = RequestMethod.GET)
	public String getPage3() {
		return "page3";
	}

	@RequestMapping(path = "/Page3", method = RequestMethod.POST)
	public String processFavoriteSeason(@RequestParam String favoriteSeason, HttpSession session) {

		FavoriteThings application = (FavoriteThings) session.getAttribute("favoriteThings");
		application.setSeason(favoriteSeason);

		session.setAttribute("favoriteThings", application);

		return "redirect:/FavoriteThings/Summary";
	}

	@RequestMapping(path = "/Summary", method = RequestMethod.GET)
	public String getSummary(HttpSession session) {
		return "summary";
	}

}
