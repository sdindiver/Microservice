package com.concatenate.aspects;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.concatenate.filters.RequestIdThreadLocal;

@Aspect
@Component
public class TraceAspect {
	
	 @Before("within(com.concatenate.controller.*) || within(com.concatenate.service.*) || within(com.concatenate.dao.*)")
	public void startAProcess(JoinPoint pjp) throws Throwable {
			System.out.print("RequestId" + RequestIdThreadLocal.getThreadLocal().get() + "| Method Name:" + pjp.getSignature().getName());
	}
}
