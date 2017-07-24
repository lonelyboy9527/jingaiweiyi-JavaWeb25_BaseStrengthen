package com.itheima.annotation;

import java.util.ArrayList;
import java.util.List;
//可以放置 @SuppressWarnings({ "rawtypes", "unused" })
public class AnnoDemo {
	//可以放置 @SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {
		
		//压制警告 
		@SuppressWarnings({ "rawtypes", "unused" })
		List list = new ArrayList(); 
		
		
		show();
		show("哈哈");
	}
	
	//定义方法过时
	@Deprecated
	public static void show() {
		
	}
	
	public static void show(String name) {
		System.out.println(name);
	}
	
	//帮助开发人员检查是否覆盖父类的方法是否正确
	@Override
	public String toString() {
		return super.toString();
	}
}
