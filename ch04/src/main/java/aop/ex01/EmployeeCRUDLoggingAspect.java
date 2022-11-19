package aop.ex01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class EmployeeCRUDLoggingAspect {
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("logBefore() : " + joinPoint.getSignature().getName());
	}
	
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("logAfter() : " + joinPoint.getSignature().getName());
	}
	
	public void logAfterReturning(Object retVal) throws Throwable {
		System.out.println("logAfterReturning() : " + retVal);
	}
	
	public void logAfterThrowing(Exception ex) throws Throwable {
		System.out.println("logAfterThrowing() : " + ex);
	}
	
	public void logAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("logAround() - Before method call");
		pjp.proceed();
		System.out.println(pjp.getSignature().getName());
		System.out.println("logAround() - After method call");
	}
}
