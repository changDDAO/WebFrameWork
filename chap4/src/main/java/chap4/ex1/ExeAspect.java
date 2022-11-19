package chap4.ex1;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExeAspect  {
	
	@SuppressWarnings("finally")
	public Object measure(ProceedingJoinPoint pjp) throws Throwable{
		Object result = null;
		Object value = null;
		 
		try {
		long startTime = System.nanoTime();
		value = pjp.proceed();
		long endTime = System.nanoTime();
		result = endTime-startTime;
		System.out.printf("%s.%s(%s) 실행 시간 = %d ns\n",pjp.getTarget().getClass().getSimpleName(),
		pjp.getSignature().getName(),Arrays.toString(pjp.getArgs()),result);
				
		
		
		

		
		}
		catch(Throwable throwable) {
			throwable.printStackTrace();
		}
		finally {
			return value;
		}
		
		
		
	}

}
