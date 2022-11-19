package aop.ex01;

import org.aspectj.lang.JoinPoint;

public class EmployeeCRUDTransactionAspect {
	public void getEmployeeById(JoinPoint joinPoint) {
		System.out.println("transaction : " + joinPoint.getSignature().getName());
	}
}
