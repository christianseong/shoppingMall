package com.hipstercompany.hipster.util;

public enum Mem_Level {
	Bronze(1),Silver(2),Gold(3),Platinum(4),Diamond(5),Master(6);

	
	private int mem_level;
	
	
	
	Mem_Level(int mem_level) {
		this.mem_level = mem_level;
	}
	
	public String getName() {
		return name();
	}
	
	public int getLevel() {
		return mem_level;
	}
	
}
