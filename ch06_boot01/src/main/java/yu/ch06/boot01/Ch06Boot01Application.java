package yu.ch06.boot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Ch06Boot01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext factory = SpringApplication.run(Ch06Boot01Application.class, args);
		TV tv = (TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();
	}

}
