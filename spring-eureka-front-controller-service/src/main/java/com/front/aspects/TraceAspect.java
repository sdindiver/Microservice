package com.front.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.front.filter.RequestIdThreadLocal;

@Aspect
@Component
public class TraceAspect {
	
	 @Before("within(com.front.controller.*) || within(com.front.service.*) || within(com.front.dao.*)")
	public void startAProcess(JoinPoint pjp) throws Throwable {
			System.out.print("RequestId" + RequestIdThreadLocal.getThreadLocal().get() + "| Method Name:" + pjp.getSignature().getName());


	}
}
