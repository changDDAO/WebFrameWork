package di.ex06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TVUserAnnotation {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new AnnotationConfigApplicationContext(Config6.class);
		TV tv = (TV)factory.getBean("tv2");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();
	}
}
