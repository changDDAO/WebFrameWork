package yu.ch06.boot01;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component("tv2")
@PropertySource("classpath:label.properties")
public class LgTV implements TV {
	
	private Speaker speaker;
	private String model;
	
	@Resource(name="apple")
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setModel(@Value("${modelValue2}") String model) {
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
