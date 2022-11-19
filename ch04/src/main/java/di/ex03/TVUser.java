package di.ex03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new AnnotationConfigApplicationContext(Config.class);
		TV tv = (TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();
	}
}
