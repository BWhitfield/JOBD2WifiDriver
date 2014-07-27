package logic;

public class EcuMath implements IEcuMath {

	public String rpm(String cleanEcuHex) {
		double computedValue = hexToDecimal(cleanEcuHex) / 4.0;
		return round(computedValue);
	}

	public String load(String cleanEcuHex) {
		double computedValue = (hexToDecimal(cleanEcuHex) * 100) / 255.0;
		return round(computedValue);
	}

	public String maf(String cleanEcuHex) {
		double computedValue = hexToDecimal(cleanEcuHex) / 100.0;
		return round(computedValue);
	}

	public String fuelPressure(String cleanEcuHex) {
		double computedValue = hexToDecimal(cleanEcuHex) * 3;
		return round(computedValue);
	}

	public String timingAdvance(String cleanEcuHex) {
		double computedValue = (hexToDecimal(cleanEcuHex) - 128) / 2;
		return round(computedValue);
	}

	private int hexToDecimal(String cleanEcuHex) {
		return Integer.parseInt(cleanEcuHex, 16);
	}
	
	private String round(double computedValue) {
		double roundedVal = (double) Math.round(computedValue * 100) / 100;
		return String.valueOf(roundedVal);
	}


}
