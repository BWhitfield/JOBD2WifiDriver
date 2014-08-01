package logic;

import main.Maps;

public class EcuMath implements IEcuMath {

	public String rpm(int rawVal) {
		double computedValue = rawVal / 4.0;
		return round(computedValue);
	}

	public String airIntakeTemp(int rawVal) {
		double computedValue = (rawVal * 1.8) + 32;
		return round(computedValue);
	}
	
	public String timingAdvance(int rawVal) {
		double computedValue = (rawVal - 128) / 2;
		return round(computedValue);
	}

	public String fuelPressure(int rawVal) {
		double computedValue = rawVal * 3;
		return round(computedValue);
	}

	public String load(int rawVal) {
		double computedValue = (rawVal * 100) / 255.0;
		return round(computedValue);
	}
	
	public String maf(int rawVal) {
		double computedValue = rawVal / 100.0;
		return round(computedValue);
	}

	public String rpm(String cleanEcuHex) {
		return null;
	}

	public String airIntakeTemp(String cleanEcuHex) {
		return null;
	}

	public String timingAdvance(String cleanEcuHex) {
		return null;
	}


	public String fuelPressure(String cleanEcuHex) {
		return null;
	}


	public String load(String cleanEcuHex) {
		return null;
	}

	public String maf(String cleanEcuHex) {
		return null;
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
