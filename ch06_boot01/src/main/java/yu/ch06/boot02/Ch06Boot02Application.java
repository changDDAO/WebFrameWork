package yu.ch06.boot02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Ch06Boot02Application {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new AnnotationConfigApplicationContext(Config4.class);
		TV tv = (TV)factory.getBean("tv2");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();
	}
}
