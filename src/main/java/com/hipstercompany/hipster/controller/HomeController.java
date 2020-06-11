package com.hipstercompany.hipster.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/",method=RequestMethod.GET)
		public String home(Locale locale, Model model) {
			return "home";
		}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@RequestParam("code")String code, Model model) {
		model.addAttribute("code", code);
		System.out.println("code : "+code);
		return "login";
	}
}
