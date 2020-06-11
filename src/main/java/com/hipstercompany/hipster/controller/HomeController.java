package com.hipstercompany.hipster.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hipstercompany.hipster.service.KakaoAPIService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
    private KakaoAPIService kakao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
		public String home(Locale locale, Model model) {
			return "home";
		}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@RequestParam("code")String code, Model model) {
		String access_Token = kakao.getAccessToken(code);
        System.out.println("controller access_token : " + access_Token);
		return "login";
	}
}
