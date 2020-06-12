package com.hello.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.hello.filters.RequestIdThreadLocal;

@Aspect
@Component
public class TraceAspect {
	
	 @Before("within(com.hello.controller.*) || within(com.hello.service.*) || within(com.hello.dao.*)")
	public void startAProcess(JoinPoint pjp) throws Throwable {
			System.out.print("RequestId:" +RequestIdThreadLocal.getThreadLocal().get()+" | Method Name:" + pjp.getSignature().getName());


	}
}
