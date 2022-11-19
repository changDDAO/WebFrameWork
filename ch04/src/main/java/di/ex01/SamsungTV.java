package di.ex01;

public class SamsungTV implements TV {
	public void powerOn() {
		System.out.println("삼성 TV: powerOn");
	}

	public void powerOff() {
		System.out.println("삼성 TV: powerOff");
	}

	public void volumeUp() {
		System.out.println("삼성 TV: volumeUp");
	}

	public void volumeDown() {
		System.out.println("삼성 TV: volumeDown");
	}

}
