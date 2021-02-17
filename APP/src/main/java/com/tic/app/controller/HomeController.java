package com.tic.app.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "index";
	}
	
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String news(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "news";
	}
	
	@RequestMapping(value = "/homeController", method = RequestMethod.GET)
	public String homeController(@RequestParam(value="homeControl", required = false)String homeControl, Model model) {
		
		String returnPage = "";
		
		System.out.println("homeControl :: " + homeControl);
		
		if(homeControl == "LOGIN") {
			return "login";
		} else if (homeControl == "JOIN") {
			return "join";
		} else if (homeControl == "GUEST") {
			//TODO session processing.
			return "redirect:/news";
		}
		
		System.out.println("RETURN PAGE :: "+returnPage);
		
		return "error";
	}
}
