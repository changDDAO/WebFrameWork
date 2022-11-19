package chap4.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestAOP {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ex1/config.xml");
		Calculator c1 = (Calculator)ctx.getBean("loopCalc");
		Calculator c2 = (Calculator)ctx.getBean("recurCalc");
		System.out.println(c2.factorial(20));
		System.out.println(c1.factorial(20));
		System.out.println(c2.fibo(20));
		System.out.println(c1.fibo(20));	
	}
}
