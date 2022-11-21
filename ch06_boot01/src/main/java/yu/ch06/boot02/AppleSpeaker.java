package yu.ch06.boot02;

public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("AppleSpeaker 객체 생성");
	}
	
	public void volumeUp() {
		System.out.println("AppleSpeaker: volume up");
	}

	public void volumeDown() {
		System.out.println("AppleSpeaker: volume down");
	}
}
