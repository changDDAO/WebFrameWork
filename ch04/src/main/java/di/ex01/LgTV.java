package di.ex01;

public class LgTV implements TV {
	public void powerOn() {
		System.out.println("LG TV: powerOn");
	}

	public void powerOff() {
		System.out.println("LG TV: powerOff");
	}

	public void volumeUp() {
		System.out.println("LG TV: volumeUp");
	}

	public void volumeDown() {
		System.out.println("LG TV: volumeDown");
	}
}
