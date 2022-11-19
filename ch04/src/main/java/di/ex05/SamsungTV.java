package di.ex05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SamsungTV implements TV {
	private Speaker speaker;
	private String model;
	
	public SamsungTV() { System.out.println("SamsungTV(1) 객체 생성"); }
	
	@Autowired
	public SamsungTV(@Qualifier("sony") Speaker speaker, String model) {
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
