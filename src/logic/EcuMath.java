package logic;

public class EcuMath implements IEcuMath {

	public String rpm(String cleanEcuHex) {
		if (cleanEcuHex != null && !cleanEcuHex.isEmpty()){
			int decVal = Integer.parseInt(cleanEcuHex, 16);
			double computedValue = decVal / 4.0;
			double roundedVal = (double)Math.round(computedValue * 100) / 100;
			return String.valueOf(roundedVal);
		}
		return "";
	}

	public String load(String cleanEcuHex) {
		if (cleanEcuHex != null && !cleanEcuHex.isEmpty()){
			int decVal = Integer.parseInt(cleanEcuHex, 16);
			double computedValue = (decVal * 100) / 255.0;
			double roundedVal = (double)Math.round(computedValue * 100) / 100;
			return String.valueOf(roundedVal);
		}
		return "";
	}

	public String maf(String cleanEcuHex) {
		if (cleanEcuHex != null && !cleanEcuHex.isEmpty()){
			int decVal = Integer.parseInt(cleanEcuHex, 16);
			double computedValue = decVal / 100.0;
			double roundedVal = (double)Math.round(computedValue * 100) / 100;
			return String.valueOf(roundedVal);
		}
		return "";
	}

}
