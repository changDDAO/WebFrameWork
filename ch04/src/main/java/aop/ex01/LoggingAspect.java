package aop.ex01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Pointcut("execution(* aop.ex01.EmployeeManager.*(..))")
	private void loggingOp() {}
	
	@Before("loggingOp()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("logBefore() : " + joinPoint.getSignature().getName());
	}
	
	@Before("execution(* aop.ex01.*Impl.get*(..))")
	public void logBeforeGetter(JoinPoint joinPoint) {
		System.out.println("logBeforeGetter() : " + joinPoint.getSignature().getName());
	}
}
