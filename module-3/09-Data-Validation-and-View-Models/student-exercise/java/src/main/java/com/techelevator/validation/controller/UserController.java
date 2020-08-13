package com.techelevator.validation.controller;

import com.techelevator.validation.model.Login;
import com.techelevator.validation.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
	// GET: /
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}

	// Add the following Controller Actions

	// GET: /register
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String showRegisterForm(ModelMap modelHolder) {
		if (!modelHolder.containsAttribute("registration")) {
			modelHolder.put("registration", new Registration());
		}
		return "register";
	}

	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String processLogin(@Valid @ModelAttribute Registration registration, BindingResult result,
							   RedirectAttributes flash) {

		flash.addFlashAttribute("registration", registration);

		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "registration", result);
			return "redirect:/register";
		}

		return "register_confirmation";
	}

	// GET: /login
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLoginForm(ModelMap modelHolder) {
		if (!modelHolder.containsAttribute("login")) {
			modelHolder.put("login", new Login());
		}
		return "login";
	}

	// POST: /login
	// Validate the model and redirect to a confirmation page if validation is
	// successful. Return the login view (if validation fails).
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String processLogin(@Valid @ModelAttribute Login login, BindingResult result,
										 RedirectAttributes flash) {

		flash.addFlashAttribute("login", login);

		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "login", result);
			return "redirect:/login";
		}

		return "login_confirmation";
	}

	// GET: /confirmation
	// Return the confirmation view
}
