package yu.ch06.boot02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:config4.xml")
public class Config4 {

	@Bean
	public SonySpeaker sony() {
		return new SonySpeaker();
	}

	@Bean 
	SamsungTV tv() {
		return new SamsungTV(sony(), "75인치 QLED");
	}
}
