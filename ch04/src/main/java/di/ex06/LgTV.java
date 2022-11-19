package di.ex06;

import javax.annotation.Resource;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class LgTV implements TV {
	
	private Speaker speaker;
	private String model;
	
	@Resource(name="apple")
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public void powerOn() {
		System.out.println("LG TV: powerOn" + ", model = " + model);
	}

	public void powerOff() {
		System.out.println("LG TV: powerOff");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
