package yu.ch06.boot03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config3 {
	@Bean
	public SonySpeaker sony() {
		return new SonySpeaker();
	}
	
	@Bean 
	SamsungTV tv() {
		return new SamsungTV(sony(), "75인치 QLED");
	}
}
