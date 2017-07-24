package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest2 {
	public static void main(String[] args) {
		
		final Target target = new Target();
		
		//动态的创建代理对像
		
		TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() {
					@Override
					//被执行几次？--- 看代理对象调用方法几次
					//代理对象调用接口的相应方法，都是调用invoke
					/**
					 * proxy：指代理对象
					 * method：代表目标方法的字节码对象
					 * args：代表是调用方法时的参数列表
					 * */
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						// 方法的字节码对象通过 发射调用方法
						Object invoke = method.invoke(target, args); //目标对象的相应的方法
						
						// return返回值给代理对象
						return invoke;
					}
				});
		proxy.method1(); // 调用invoke---Method：目标对象的method1方法  args:null  返回值 null
		String method2 = proxy.method2(); // 调用invoke---Method：目标对象的method2方法  args:null 返回值 String
		int method3 = proxy.method3(100); // 调用invoke ---Method：目标对象的method3方法  args: Object[]{100} 返回值int
		
		System.out.println(method2);
		System.out.println(method3);
	}
}
