package logic;

public class EcuMath implements IEcuMath {

	public String rpm(int rawVal) {
		return round(rawVal / 4.0);
	}

	public String airIntakeTemp(int rawVal) {
		return round((rawVal * 1.8) + 32);
	}
	
	public String timingAdvance(int rawVal) {
		return round((double) ((rawVal - 128) / 2));
	}

	public String fuelPressure(int rawVal) {
		return round((double) (rawVal * 3));
	}

	public String load(int rawVal) {
		return round((rawVal * 100) / 255.0);
	}
	
	public String maf(int rawVal) {
		return round(rawVal / 100.0);
	}

	private String round(double computedValue) {
		return String.valueOf((double) Math.round(computedValue * 100) / 100);
	}
}
