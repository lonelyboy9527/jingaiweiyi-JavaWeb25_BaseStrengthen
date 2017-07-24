package com.itheima.annotation;

public class MyAnnoTest {
	
	@SuppressWarnings("all")
	@MyAnno(name = "zhangsan")
	//@MyAnno({"xxx", "yyy"})
	public void show(String str) {
		System.out.println("show running...");
	}
}
