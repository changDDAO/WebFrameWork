package di.ex03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public SonySpeaker sony() {
		return new SonySpeaker();
	}
	
	@Bean
	public AppleSpeaker apple() {
		return new AppleSpeaker();
	}
	
	@Bean 
	SamsungTV tv() {
		return new SamsungTV(sony(), "75인치 QLED");
	}
	
	@Bean(name="tv2") 
	LgTV lgtv() {
		LgTV ltv = new LgTV();
		ltv.setSpeaker(apple());
		ltv.setModel("75인치 OLED");
		return ltv;
	}
}
