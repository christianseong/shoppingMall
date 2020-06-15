package com.hipstercompany.hipster.controller;

import java.io.IOException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hipstercompany.hipster.service.KakaoAPIService;

@Controller
@SessionAttributes("id")
@RequestMapping
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	static String code ="";

	@Autowired
    private KakaoAPIService kakao;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
		public String home(Locale locale, Model model) {
			System.out.println("home");
			return "home";
		}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String logincheck(@RequestParam("code")String code, Model model) throws IOException {
		
			String access_token = kakao.getAccessToken(code);
			kakao.addUser(access_token);
		
			model.addAttribute("id",access_token);
			return "home";
		
	}
	
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String loginOK(@RequestParam("code")String access_token) {
	
		System.out.println("logout");
		System.out.println(access_token);
		
		return "memJoin";
	}
	
	
	

	
	@RequestMapping(value="/sessionTest",method=RequestMethod.GET)
	public String sessionCheck(Model model) throws Exception{
	
		String access_Token = "kakaoToken";
	
		model.addAttribute("id",access_Token);
		model.addAttribute("className",this.getClass());
		
		
		return "memJoinOK";
	}

	
}
