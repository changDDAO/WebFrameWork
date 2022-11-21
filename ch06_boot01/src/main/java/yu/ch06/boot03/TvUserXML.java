package yu.ch06.boot03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserXML {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("classpath:config3.xml");
		TV tv = (TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();
	}
}
