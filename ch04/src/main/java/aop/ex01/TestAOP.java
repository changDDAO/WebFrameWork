package aop.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestAOP {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:configAOP5.xml");
		EmployeeManager manager = (EmployeeManager)ctx.getBean("employeeManager");
		
		manager.getEmployeeById(1);
		manager.createEmployee(new EmployeeVO());
		manager.deleteEmployee(100);
	}
}
