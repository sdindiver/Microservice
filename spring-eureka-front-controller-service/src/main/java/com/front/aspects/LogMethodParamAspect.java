package com.front.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogMethodParamAspect {
	
	 @Before("@annotation(LogMethodParam)")
	public void startAProcess(JoinPoint pjp) throws Throwable {
			Object[] signatureArgs = pjp.getArgs();
			for (Object signatureArg : signatureArgs) {
				System.out.print("Method Name:" + pjp.getSignature().getName() + " AND " + "Arg: " + signatureArg);
			}

	}
}
