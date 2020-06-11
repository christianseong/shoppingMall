package com.hipstercompany.hipster.controller;

import java.io.IOException;
import java.util.HashMap;
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
	public String login(@RequestParam("code")String code, Model model) throws IOException {
		String access_Token = kakao.getAccessToken(code);
		
        //System.out.println("controller access_token : " + access_Token);
        //model.addAttribute("access_token",access_Token);
		
		HashMap<String,Object> userInfo = kakao.getUserInfo(access_Token);
		System.out.println(userInfo.get("email"));
		System.out.println(userInfo.get("thumbnail_image"));
		System.out.println(userInfo.get("profile_image"));
		//¹Ù²ñ
		if(userInfo.get("email")!=null) {
			model.addAttribute("userId",userInfo.get("email"));
			model.addAttribute("thumbnail_image",userInfo.get("thumbnail_image"));
			model.addAttribute("profile_image",userInfo.get("profile_image"));
		}
		return "login";
	}
}
