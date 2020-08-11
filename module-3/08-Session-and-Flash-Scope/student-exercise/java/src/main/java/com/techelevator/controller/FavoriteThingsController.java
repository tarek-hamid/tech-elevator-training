package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/FavoriteThings")
public class FavoriteThingsController {

	@RequestMapping(path = "/Page1", method = RequestMethod.GET)
	public String getPage1(ModelMap map) {
		return "page1";
	}

}
