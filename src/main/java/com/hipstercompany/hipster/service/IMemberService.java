package com.hipstercompany.hipster.service;

import com.hipstercompany.hipster.member.Member;

public interface IMemberService {
	void memberRegister(String memId, String memPw, String memMail, String memPhone1);
	
	Member memberSearch(String memId, String memPw);
}
