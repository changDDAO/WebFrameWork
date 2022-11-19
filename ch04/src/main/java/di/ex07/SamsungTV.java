package di.ex07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("tv")
@PropertySource("classpath:label.properties")
public class SamsungTV implements TV {
	private Speaker speaker;
	private String model;
	
	public SamsungTV() { System.out.println("SamsungTV(1) 객체 생성"); }
	
	@Autowired
	public SamsungTV(@Qualifier("sony") Speaker speaker, @Value("${modelValue1}") String model) {
		System.out.println("SamsungTV(2) 객체 생성");
		this.speaker = speaker;
		this.model = model;
	}
	
	public void powerOn() {
		System.out.println("삼성 TV: powerOn" + ", model = " + model);
	}

	public void powerOff() {
		System.out.println("삼성 TV: powerOff");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
