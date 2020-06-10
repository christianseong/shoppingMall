package com.hipstercompany.hipster.dao;

import com.hipstercompany.hipster.member.Member;

public interface IMemberDao {
 void memberInsert(String memId, String memPw, String memMail, String memPhone1);
 Member memberSelect(String memId , String memPw);
}
