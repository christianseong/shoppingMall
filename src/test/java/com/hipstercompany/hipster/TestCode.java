package com.hipstercompany.hipster;

import org.junit.Test;

import com.hipstercompany.hipster.util.Mem_Level;

public class TestCode {
	@Test
	public void testEnum() {
		String name =Mem_Level.Bronze.getName();
		int level = Mem_Level.Bronze.getLevel();
		System.out.println(name);
		System.out.println(level);
	}
}
