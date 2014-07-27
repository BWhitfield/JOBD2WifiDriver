package logic;

public class EcuMath implements IEcuMath {

	public String rpm(String cleanEcuHex) {
		int decVal = Integer.parseInt(cleanEcuHex, 16);
		double computedValue = decVal / 4.0;
		double roundedVal = (double) Math.round(computedValue * 100) / 100;
		return String.valueOf(roundedVal);
	}

	public String load(String cleanEcuHex) {
		int decVal = Integer.parseInt(cleanEcuHex, 16);
		double computedValue = (decVal * 100) / 255.0;
		double roundedVal = (double) Math.round(computedValue * 100) / 100;
		return String.valueOf(roundedVal);
	}

	public String maf(String cleanEcuHex) {
		int decVal = Integer.parseInt(cleanEcuHex, 16);
		double computedValue = decVal / 100.0;
		double roundedVal = (double) Math.round(computedValue * 100) / 100;
		return String.valueOf(roundedVal);
	}

}
