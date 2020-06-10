package com.hipstercompany.hipster.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hipstercompany.hipster.member.Member;
import com.hipstercompany.hipster.service.MemberService;

@Controller
public class MemberController {
	//자동 주입 받음
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/resources/html/hipster/memJoin", method=RequestMethod.POST)
	public String memJoin(Model model , HttpServletRequest request) {
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memMail = request.getParameter("memMail");
		String memPhone1 = request.getParameter("memPhone1");
		
		service.memberRegister(memId, memPw, memMail, memPhone1);
		
		model.addAttribute("memId",memId);
		model.addAttribute("memPw",memPw);
		model.addAttribute("memMail",memMail);
		model.addAttribute("memPhone",memPhone1);
		
		return "memJoinOK";
		
	}
	
	@RequestMapping(value="/resources/html/hipster/memLogin",method= RequestMethod.POST)
	public String memLogin(Model model , HttpServletRequest request) {
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		Member member = service.memberSearch(memId, memPw);
		
		try {
			model.addAttribute("memId", member.getMemId());
			model.addAttribute("memPw", member.getMemPw());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "memLoginOK";
	}
	
}
