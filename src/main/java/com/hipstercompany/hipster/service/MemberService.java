package com.hipstercompany.hipster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hipstercompany.hipster.dao.MemberDao;
import com.hipstercompany.hipster.member.Member;

@Service
public class MemberService implements IMemberService{
	@Autowired
	MemberDao dao;
	
	@Override
	public void memberRegister(String memId, String memPw, String memMail, String memPhone1)
	{
		System.out.println("memberRegister()");
		System.out.println("memId : "+memId);
		System.out.println("memPw : "+memPw);
		System.out.println("memMail : "+memMail);
		System.out.println("memPhone : "+memPhone1);
		
		dao.memberInsert(memId, memPw, memMail, memPhone1);
		
	}

	@Override
	public Member memberSearch(String memId, String memPw) {
		System.out.println("memberSearch()");
		System.out.println("memId :"+memId);
		System.out.println("memPw :"+memPw);
		
		Member member = dao.memberSelect(memId, memPw);
		
		return member;
	}
}
