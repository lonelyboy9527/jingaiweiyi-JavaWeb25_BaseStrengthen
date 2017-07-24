package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void test1 () {
		//获得动态的代理对象 ------- 在运行时，在内存中动态的为Target创建一个虚拟的代理对象
		// objProxy是代理对象，根据参数确定是谁的代理对象 
		TargetInterface objProxy = (TargetInterface)Proxy.newProxyInstance(
				Target.class.getClassLoader(), 		//与目标对象相同的类加载器
				new Class[]{TargetInterface.class}, // 接口字节码的数组
			    new InvocationHandler() {
					//invoke：代表的是执行代理对象的方法 
					//method：代表目标对象的 方法字节码 对象
					//args：代表目标对象的相应的方法的参数
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("目标方法前的逻辑...");
						//执行目标对象的方法
						Object invoke = method.invoke(new Target(), args);
						System.out.println("目标方法后的逻辑...");
						
						return invoke;
					}
				});
		
		//执行
		objProxy.method1();
		
		String method2 = objProxy.method2();
		System.out.println(method2);
		
		
		
	} 
}
