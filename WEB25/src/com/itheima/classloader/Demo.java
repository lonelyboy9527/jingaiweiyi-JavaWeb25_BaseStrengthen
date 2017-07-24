package com.itheima.classloader;

public class Demo {
	public static void main(String[] args) {
		
		//获得demo字节码文件的类加载器
		Class clazz = Demo.class; //获得demo的字节码对象
		ClassLoader classLoader = clazz.getClassLoader(); //获得加载demo.class文件的 类加载器
		// getResource的参数路口相对classes(src)
		String path = classLoader.getResource("com/itheima/classloader/jdbc.properties").getPath(); //获得classes(src)下的任何资源
		
		//classLoader.getResourceAsStream(""); //获取资源并且转成流
		
		System.out.println(path);
	}
}
