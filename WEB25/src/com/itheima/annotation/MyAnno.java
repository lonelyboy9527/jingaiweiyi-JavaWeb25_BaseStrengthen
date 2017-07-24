package com.itheima.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
	
	//注解的属性 
	String name();
	
	int age() default 28;
	
	//当注解只有一个属性且为 value时候，使用注解的时候可以省略 value=
	//String value();
	
	//String[] value();
	
		
}
