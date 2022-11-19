package di.ex06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("classpath:config6.xml");
		TV tv = (TV)factory.getBean("tv2");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();
	}
}
