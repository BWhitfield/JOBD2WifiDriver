package util;

public class Conversion implements IConversion {

	public int hexToDecimal(String hex) {
		return Integer.parseInt(hex, 16);
	}
}
