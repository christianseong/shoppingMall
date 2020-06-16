package com.hipstercompany.hipster.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/product")
@SessionAttributes("id")
public class ProductController {
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("detail");
		
		return "detail";
	}
}
