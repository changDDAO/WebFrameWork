package di.ex06;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "di.ex06")
public class Config6 {
	@Resource(name="sony")
	Speaker speaker1;
	@Resource(name="apple")
	Speaker speaker2;
	
	@Bean 
	SamsungTV tv() {
		return new SamsungTV(speaker1, "75인치 QLED");
	}
	
	@Bean(name="tv2") 
	LgTV lgtv() {
		LgTV ltv = new LgTV();
		ltv.setSpeaker(speaker2);
		ltv.setModel("75인치 OLED");
		return ltv;
	}
}
