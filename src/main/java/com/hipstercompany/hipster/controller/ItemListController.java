package com.hipstercompany.hipster.controller;

import java.util.HashMap;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hipstercompany.hipster.service.ItemListService;

@Controller
@RequestMapping("/item/lists")
@SessionAttributes("id")
public class ItemListController {
	@Autowired
    private ItemListService listservice;
	
	
	@RequestMapping(value="/001",method=RequestMethod.GET)
	public String TopItemMain(Locale locale, Model model) {
		System.out.println("top main list");
		HashMap<String,Object> topmain = listservice.getTopMain();
		
		String[] pd_image_thumnail = (String[]) topmain.get("pd_image_thumnail");
		String[] pd_name = (String[]) topmain.get("pd_name");
		String[] pd_brand = (String[]) topmain.get("pd_brand");
		
		model.addAttribute("cursor_count",topmain.get("cursor_count"));
		model.addAttribute("pd_image_thumnail",pd_image_thumnail);
		model.addAttribute("pd_name",pd_name);
		model.addAttribute("pd_brand",pd_brand);
		
		
		System.out.println(pd_image_thumnail[0]);
		return "itemList";
	}
	
	@RequestMapping(value="/001001",method=RequestMethod.GET)
	public String TopShortSleeve(Locale locale, Model model) {
		System.out.println("top short sleeve list");
		
		return "detail";
	}
}