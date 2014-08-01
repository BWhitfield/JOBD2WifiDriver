package logic;

import main.Maps;

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

	public String airIntakeTemp(String cleanEcuHex) {
		double computedValue = (hexToDecimal(cleanEcuHex) * 1.8) + 32;
		return round(computedValue);
	}

	public String pids1_20(String cleanEcuHex) {
		//get the first 8 - BE3FB813
		String hex = "BE3FB813";
		for (char c : hex.toCharArray()) {
//			Maps.HexBinaryMap[c];
		}
		//loop through them
		//convert to an array of bools
		//return list of pids that have bool yes
		return String.valueOf(hexToDecimal(cleanEcuHex));
	}

	private int hexToDecimal(String cleanEcuHex) {
		return Integer.parseInt(cleanEcuHex, 16);
	}
	
	private String round(double computedValue) {
		double roundedVal = (double) Math.round(computedValue * 100) / 100;
		return String.valueOf(roundedVal);
	}



}
